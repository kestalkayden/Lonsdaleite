package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class Perfect_Lonsdaleite_Sword extends Item {
    public Perfect_Lonsdaleite_Sword(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(settings);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, attacker.getPreferredEquipmentSlot(stack));
    }
}