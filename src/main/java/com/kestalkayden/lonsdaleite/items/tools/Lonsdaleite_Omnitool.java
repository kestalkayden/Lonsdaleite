package com.kestalkayden.lonsdaleite.items.tools;

import com.kestalkayden.lonsdaleite.materials.KestalToolMaterial;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class Lonsdaleite_Omnitool extends PickaxeItem {

    public Lonsdaleite_Omnitool(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean isEffectiveOn(BlockState state) {
        return true;
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return KestalToolMaterial.LONSDALEITE.getMiningSpeedMultiplier();
    }

}
