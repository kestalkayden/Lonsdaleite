package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;

public class Lonsdaleite_War_Axe extends Item {
    public Lonsdaleite_War_Axe(ToolMaterial material, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, attacker.getEquipmentSlotForItem(stack));
    }
}
