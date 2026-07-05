package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ToolMaterial;

// 1.21.4: PickaxeItem is a concrete class (removed in 1.21.5); it applies mining
// behaviour + durability from the material, replacing the Properties.pickaxe() helper.
public class Perfect_Lonsdaleite_Pickaxe extends PickaxeItem {
    public Perfect_Lonsdaleite_Pickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }
}
