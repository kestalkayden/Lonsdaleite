package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class Perfect_Lonsdaleite_Hoe extends Item {
    public Perfect_Lonsdaleite_Hoe(ToolMaterial material, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!level.isClientSide() && state.getDestroySpeed(level, pos) != 0.0F) {
            stack.hurtAndBreak(1, miner, miner.getEquipmentSlotForItem(stack));
        }
        return true;
    }
}
