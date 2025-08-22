package com.kestalkayden.lonsdaleite.items.tools;

import com.kestalkayden.lonsdaleite.materials.LonsdaleiteToolMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class Lonsdaleite_Sword extends Item {
    private final ToolMaterial material;

    public Lonsdaleite_Sword(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(settings);
        this.material = material;
    }

    public int getEnchantability() {
        return LonsdaleiteToolMaterials.getEnchantability(this.material);
    }
}