package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;

// 1.21.4: SwordItem still exists as a concrete class (removed in 1.21.5), so the custom
// weapons extend it directly; it supplies attack attributes + durability-on-hit from the
// material, replacing the 1.21.5+ Properties.sword() helper.
public class Lonsdaleite_Short_Sword extends SwordItem {
    public Lonsdaleite_Short_Sword(ToolMaterial material, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }
}
