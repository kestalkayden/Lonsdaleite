package com.kestalkayden.lonsdaleite.items.tools;

import com.kestalkayden.lonsdaleite.materials.LonsdaleiteToolMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class Perfect_Lonsdaleite_Short_Sword extends Item {
    private final ToolMaterial material;

    public Perfect_Lonsdaleite_Short_Sword(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(settings);
        this.material = material;
    }

    public int getEnchantability() {
        return LonsdaleiteToolMaterials.getEnchantability(this.material);
    }
}
