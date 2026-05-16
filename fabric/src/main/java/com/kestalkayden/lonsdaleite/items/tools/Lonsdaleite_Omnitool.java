package com.kestalkayden.lonsdaleite.items.tools;

import com.kestalkayden.lonsdaleite.materials.LonsdaleiteToolMaterials;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class Lonsdaleite_Omnitool extends Item {
    private final ToolMaterial material;

    public Lonsdaleite_Omnitool(ToolMaterial material, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties.durability(material.durability()));
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

    public boolean isSuitableFor(BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE) ||
               state.is(BlockTags.MINEABLE_WITH_AXE) ||
               state.is(BlockTags.MINEABLE_WITH_SHOVEL) ||
               state.is(BlockTags.MINEABLE_WITH_HOE) ||
               state.is(BlockTags.SWORD_EFFICIENT);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!level.isClientSide() && state.getDestroySpeed(level, pos) != 0.0F) {
            stack.hurtAndBreak(1, miner, miner.getEquipmentSlotForItem(stack));
        }
        return true;
    }

    public int getEnchantability() {
        return LonsdaleiteToolMaterials.getEnchantability(this.material);
    }
}
