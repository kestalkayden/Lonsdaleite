package com.kestalkayden.lonsdaleite.items.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

// 1.21.1: armor is an ArmorItem constructed from a Holder<ArmorMaterial> + ArmorItem.Type
// (the equipment-asset / Properties.humanoidArmor path is 1.21.2+).
public class LonsdaleiteArmor extends ArmorItem {
    public LonsdaleiteArmor(Holder<ArmorMaterial> material, ArmorItem.Type type, Item.Properties properties) {
        super(material, type, properties);
    }
}
