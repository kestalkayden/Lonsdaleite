package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;

public class Lonsdaleite_Short_Sword extends Item {
    public Lonsdaleite_Short_Sword(ToolMaterial material, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, attacker.getEquipmentSlotForItem(stack));
    }
}
