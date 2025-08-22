package com.kestalkayden.lonsdaleite.materials;

import com.kestalkayden.lonsdaleite.Lonsdaleite;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public class LonsdaleiteToolMaterials {
    
    // ToolMaterial constructor: TagKey<Block>, int durability, float miningSpeed, float attackDamage, int enchantability, TagKey<Item> repairItems
    public static final ToolMaterial LONSDALEITE = new ToolMaterial(
        BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
        1750,
        8.2F,
        3.0F,
        15,
        ItemTags.DIAMOND_TOOL_MATERIALS // Using a placeholder - we'll need to create custom tags
    );
    
    public static final ToolMaterial PERFECT_LONSDALEITE = new ToolMaterial(
        BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
        2350,
        9.0F,
        4.0F,
        20,
        ItemTags.NETHERITE_TOOL_MATERIALS // Using a placeholder - we'll need to create custom tags
    );
    
    // Helper methods to get attack damage values for our custom materials
    public static float getAttackDamage(ToolMaterial material) {
        if (material == LONSDALEITE) {
            return 3.0F;
        } else if (material == PERFECT_LONSDALEITE) {
            return 4.0F;
        }
        return 0.0F; // Default for unknown materials
    }
    
    public static float getMiningSpeed(ToolMaterial material) {
        if (material == LONSDALEITE) {
            return 8.2F;
        } else if (material == PERFECT_LONSDALEITE) {
            return 9.0F;
        }
        return 1.0F; // Default for unknown materials
    }
    
    // Helper method to get enchantability values for our custom materials
    public static int getEnchantability(ToolMaterial material) {
        if (material == LONSDALEITE) {
            return 15;
        } else if (material == PERFECT_LONSDALEITE) {
            return 20;
        }
        return 0; // Default for unknown materials
    }
}