package com.kestalkayden.lonsdaleite.materials;

import com.kestalkayden.lonsdaleite.LonsdaleiteCommon;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class LonsdaleiteToolMaterials {

    public static final TagKey<Item> REPAIRS_LONSDALEITE_TOOLS = TagKey.create(
        Registries.ITEM,
        Identifier.fromNamespaceAndPath(LonsdaleiteCommon.MOD_ID, "repairs_lonsdaleite_tools"));

    public static final TagKey<Item> REPAIRS_PERFECT_LONSDALEITE_TOOLS = TagKey.create(
        Registries.ITEM,
        Identifier.fromNamespaceAndPath(LonsdaleiteCommon.MOD_ID, "repairs_perfect_lonsdaleite_tools"));

    public static final ToolMaterial LONSDALEITE = new ToolMaterial(
        ToolMaterial.NETHERITE.incorrectBlocksForDrops(),
        2640,
        8.2F,
        3.0F,
        15,
        REPAIRS_LONSDALEITE_TOOLS
    );

    public static final ToolMaterial PERFECT_LONSDALEITE = new ToolMaterial(
        ToolMaterial.NETHERITE.incorrectBlocksForDrops(),
        2640,
        9.0F,
        4.0F,
        20,
        REPAIRS_PERFECT_LONSDALEITE_TOOLS
    );

    public static float getAttackDamage(ToolMaterial material) {
        if (material == LONSDALEITE) {
            return 3.0F;
        } else if (material == PERFECT_LONSDALEITE) {
            return 4.0F;
        }
        return 0.0F;
    }

    public static float getMiningSpeed(ToolMaterial material) {
        if (material == LONSDALEITE) {
            return 8.2F;
        } else if (material == PERFECT_LONSDALEITE) {
            return 9.0F;
        }
        return 1.0F;
    }

    public static int getEnchantability(ToolMaterial material) {
        if (material == LONSDALEITE) {
            return 15;
        } else if (material == PERFECT_LONSDALEITE) {
            return 20;
        }
        return 0;
    }
}
