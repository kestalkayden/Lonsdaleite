package com.kestalkayden.lonsdaleite.items.tools;

import com.kestalkayden.lonsdaleite.materials.LonsdaleiteToolMaterials;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.BlockTransformer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.BlockTransformers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;

/**
 * The Lonsdaleite Omnitool acts as pickaxe, axe, shovel, hoe and sword at once. Both tiers share
 * this class; the tier difference (Perfect = the re-hardened, higher-stat material) lives entirely
 * in the {@link ToolMaterial} passed in. Durability is applied by the {@code .pickaxe(...)} builder
 * at registration, and mining durability loss is handled by the base {@code Item.mineBlock} via the
 * Tool component's {@code damagePerBlock}, so no override is needed here.
 */
public class Lonsdaleite_Omnitool extends Item {
    private final ToolMaterial material;

    public Lonsdaleite_Omnitool(ToolMaterial material, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties);
        this.material = material;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return Items.NETHERITE_PICKAXE.isCorrectToolForDrops(stack, state) ||
               Items.NETHERITE_AXE.isCorrectToolForDrops(stack, state) ||
               Items.NETHERITE_SHOVEL.isCorrectToolForDrops(stack, state) ||
               Items.NETHERITE_HOE.isCorrectToolForDrops(stack, state) ||
               Items.NETHERITE_SWORD.isCorrectToolForDrops(stack, state);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE) ||
            state.is(BlockTags.MINEABLE_WITH_AXE) ||
            state.is(BlockTags.MINEABLE_WITH_SHOVEL) ||
            state.is(BlockTags.MINEABLE_WITH_HOE) ||
            state.is(BlockTags.SWORD_EFFICIENT)) {
            return LonsdaleiteToolMaterials.getMiningSpeed(this.material);
        }
        return 1.0F;
    }

    /**
     * Runs the vanilla axe/hoe/shovel right-click behaviors in turn so the omnitool strips logs,
     * scrapes/de-waxes copper, tills, makes paths and douses campfires like the dedicated tools.
     *
     * <p>Since 26.3 those behaviors are data: each vanilla tool carries a
     * {@code minecraft:block_transformer} component pointing at a registry entry
     * ({@link BlockTransformers#AXE}, {@link BlockTransformers#HOE}, {@link BlockTransformers#SHOVEL}),
     * and {@code Item.useOn} reads that component off the <em>held</em> stack. Delegating to
     * {@code Items.NETHERITE_AXE.useOn(context)} therefore no longer works — it would look for a
     * transformer on the omnitool and find none — so this looks the three transformers up directly
     * and applies them the way {@code Item.useOn} does. That keeps the behavior data-driven (other
     * mods' / datapacks' additions to those transformers are picked up) and, as before, the
     * transformer damages the stack from the context, so it is the omnitool that takes durability.
     *
     * <p>On the dirt family both till (hoe) and path (shovel) apply, so till wins by default and
     * sneaking flips the priority to make a path instead.
     */
    @Override
    public InteractionResult useOn(UseOnContext context) {
        HolderLookup.RegistryLookup<BlockTransformer> transformers =
            context.getLevel().registryAccess().lookupOrThrow(Registries.BLOCK_TRANSFORMER);
        InteractionResult result = transform(transformers, BlockTransformers.AXE, context);
        if (result.consumesAction()) {
            return result;
        }
        ResourceKey<BlockTransformer> first = context.isSecondaryUseActive() ? BlockTransformers.SHOVEL : BlockTransformers.HOE;
        ResourceKey<BlockTransformer> second = context.isSecondaryUseActive() ? BlockTransformers.HOE : BlockTransformers.SHOVEL;
        result = transform(transformers, first, context);
        if (result.consumesAction()) {
            return result;
        }
        result = transform(transformers, second, context);
        if (result.consumesAction()) {
            return result;
        }
        return super.useOn(context);
    }

    private static InteractionResult transform(HolderLookup.RegistryLookup<BlockTransformer> transformers,
                                               ResourceKey<BlockTransformer> key, UseOnContext context) {
        return transformers.get(key)
            .map(holder -> holder.value().transformBlock(context))
            .orElse(InteractionResult.PASS);
    }
}
