package com.kestalkayden.lonsdaleite.items.tools;

import com.kestalkayden.lonsdaleite.materials.LonsdaleiteToolMaterials;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

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
     * Delegating to the vanilla items keeps the behavior correct and picks up other mods' blocks;
     * each call reads the held stack from the context, so it is the omnitool that takes durability.
     *
     * <p>On the dirt family both till (hoe) and path (shovel) apply, so till wins by default and
     * sneaking flips the priority to make a path instead.
     */
    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult result = Items.NETHERITE_AXE.useOn(context);
        if (result.consumesAction()) {
            return result;
        }
        Item first = context.isSecondaryUseActive() ? Items.NETHERITE_SHOVEL : Items.NETHERITE_HOE;
        Item second = context.isSecondaryUseActive() ? Items.NETHERITE_HOE : Items.NETHERITE_SHOVEL;
        result = first.useOn(context);
        if (result.consumesAction()) {
            return result;
        }
        result = second.useOn(context);
        if (result.consumesAction()) {
            return result;
        }
        return super.useOn(context);
    }

    /**
     * NeoForge gates tool right-click interactions behind {@code canPerformAction}, so the omnitool
     * must advertise the axe/shovel/hoe abilities for the delegated {@link #useOn} to take effect.
     */
    @Override
    public boolean canPerformAction(ItemInstance stack, ItemAbility action) {
        return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(action)
            || ItemAbilities.DEFAULT_SHOVEL_ACTIONS.contains(action)
            || ItemAbilities.DEFAULT_HOE_ACTIONS.contains(action);
    }
}
