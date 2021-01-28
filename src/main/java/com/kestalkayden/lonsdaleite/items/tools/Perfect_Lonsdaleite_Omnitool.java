package com.kestalkayden.lonsdaleite.items.tools;

import com.kestalkayden.lonsdaleite.Lonsdaleite;
import com.kestalkayden.lonsdaleite.materials.KestalToolMaterial;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class Perfect_Lonsdaleite_Omnitool extends PickaxeItem {

    public Perfect_Lonsdaleite_Omnitool(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean isEffectiveOn(BlockState state) {
        return Lonsdaleite.PERFECT_LONSDALEITE_AXE.isEffectiveOn(state) || Lonsdaleite.PERFECT_LONSDALEITE_SWORD.isEffectiveOn(state) || Lonsdaleite.PERFECT_LONSDALEITE_PICKAXE.isEffectiveOn(state) || Lonsdaleite.PERFECT_LONSDALEITE_SHOVEL.isEffectiveOn(state);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return KestalToolMaterial.PERFECT_LONSDALEITE.getMiningSpeedMultiplier();
    }

}
