package com.kestalkayden.lonsdaleite.blocks;

import java.util.function.Consumer;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

/**
 * Block item for the wardframe with a short functional tooltip. The "doorway"
 * wording is deliberate: tooltip text is searchable in JEI/EMI, so players
 * typing "door" still discover the block (none of those mods are required -
 * the tooltip and the minecraft:doors item tag are plain vanilla data).
 */
public class Lonsdaleite_Wardframe_Item extends BlockItem {

    public Lonsdaleite_Wardframe_Item(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display,
                                Consumer<Component> output, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, output, flag);
        output.accept(Component.translatable("block.lonsdaleite.lonsdaleite_wardframe.tooltip.pass").withStyle(ChatFormatting.GRAY));
        output.accept(Component.translatable("block.lonsdaleite.lonsdaleite_wardframe.tooltip.merge").withStyle(ChatFormatting.GRAY));
    }
}
