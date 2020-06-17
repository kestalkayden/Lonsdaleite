package com.kestalkayden.lonsdaleite.items.tools;
import com.kestalkayden.lonsdaleite.materials.KestalToolMaterial;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ItemStack;

import net.minecraft.client.item.TooltipContext;
import java.util.List;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class Lonsdaleite_Shovel extends ShovelItem {

    public Lonsdaleite_Shovel(ToolMaterial material, float f, float attackSpeed, Settings settings) {
        super(material, f, attackSpeed, settings);
    }
    
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new LiteralText((KestalToolMaterial.LONSDALEITE.getDurability() - itemStack.getDamage()) +" Durability Left").formatted(Formatting.DARK_PURPLE));
    }
}
