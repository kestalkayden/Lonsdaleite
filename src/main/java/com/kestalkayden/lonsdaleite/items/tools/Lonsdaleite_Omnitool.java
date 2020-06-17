package com.kestalkayden.lonsdaleite.items.tools;

import com.kestalkayden.lonsdaleite.Lonsdaleite;
import com.kestalkayden.lonsdaleite.materials.KestalToolMaterial;

import net.minecraft.block.BlockState;
import net.minecraft.item.*;

public class Lonsdaleite_Omnitool extends PickaxeItem {
    public Lonsdaleite_Omnitool(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    
	@Override
	public boolean isEffectiveOn(BlockState state) {
		return Lonsdaleite.LONSDALEITE_AXE.isEffectiveOn(state) || Lonsdaleite.LONSDALEITE_SWORD.isEffectiveOn(state)
				|| Lonsdaleite.LONSDALEITE_PICKAXE.isEffectiveOn(state) || Lonsdaleite.LONSDALEITE_SHOVEL.isEffectiveOn(state)
				|| Items.SHEARS.isEffectiveOn(state);
    }
    
    @Override
	public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return KestalToolMaterial.LONSDALEITE.getMiningSpeedMultiplier();
    }
}
