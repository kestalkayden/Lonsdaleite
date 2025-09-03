package com.kestalkayden.lonsdaleite.materials;

import net.minecraft.item.ToolMaterial;

public class LonsdaleiteToolMaterials {
    
    // Copy from ToolMaterial.NETHERITE to inherit proper mining levels and block tags
    public static final ToolMaterial LONSDALEITE = new ToolMaterial(
        ToolMaterial.NETHERITE.incorrectBlocksForDrops(),
        2640, // 30% more durability than Netherite (2031)
        8.2F,
        3.0F,
        15,
        ToolMaterial.NETHERITE.repairItems()
    );
    
    public static final ToolMaterial PERFECT_LONSDALEITE = new ToolMaterial(
        ToolMaterial.NETHERITE.incorrectBlocksForDrops(),
        2640,
        9.0F,
        4.0F,
        20,
        ToolMaterial.NETHERITE.repairItems()
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