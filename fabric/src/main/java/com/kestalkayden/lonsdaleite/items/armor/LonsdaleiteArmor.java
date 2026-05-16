package com.kestalkayden.lonsdaleite.items.armor;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

public class LonsdaleiteArmor extends Item {
    public LonsdaleiteArmor(ArmorMaterial material, ArmorType type, Item.Properties properties) {
        super(properties.humanoidArmor(material, type));
    }
}
