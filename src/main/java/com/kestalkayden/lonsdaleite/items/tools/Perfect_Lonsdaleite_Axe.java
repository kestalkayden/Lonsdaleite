package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Perfect_Lonsdaleite_Axe extends Item {
    public Perfect_Lonsdaleite_Axe(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, miner.getPreferredEquipmentSlot(stack));
        }
        return true;
    }
}