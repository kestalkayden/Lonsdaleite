package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

// 1.21.1: PickaxeItem(Tier, Properties) supplies mining, durability, enchantability and
// repair from the tier. attackDamage/attackSpeed are accepted for call-site parity but the
// pickaxe keeps the standard pickaxe attack profile (the 4-arg tool ctors are 1.21.4+).
public class Perfect_Lonsdaleite_Pickaxe extends PickaxeItem {
    public Perfect_Lonsdaleite_Pickaxe(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, properties);
    }
}
