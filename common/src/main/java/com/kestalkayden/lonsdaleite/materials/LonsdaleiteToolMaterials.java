package com.kestalkayden.lonsdaleite.materials;

import com.kestalkayden.lonsdaleite.LonsdaleiteCommon;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

/**
 * 1.21.1 tool materials. The {@code ToolMaterial} record is a 1.21.2+ addition, so here the
 * materials are plain {@link Tier} instances (durability, mining speed, attack bonus,
 * enchantability and repair ingredient), which the concrete tool items read directly.
 */
public class LonsdaleiteToolMaterials {

    public static final TagKey<Item> REPAIRS_LONSDALEITE_TOOLS = TagKey.create(
        Registries.ITEM,
        ResourceLocation.fromNamespaceAndPath(LonsdaleiteCommon.MOD_ID, "repairs_lonsdaleite_tools"));

    public static final TagKey<Item> REPAIRS_PERFECT_LONSDALEITE_TOOLS = TagKey.create(
        Registries.ITEM,
        ResourceLocation.fromNamespaceAndPath(LonsdaleiteCommon.MOD_ID, "repairs_perfect_lonsdaleite_tools"));

    public static final Tier LONSDALEITE = tier(2800, 8.2F, 3.0F, 15, REPAIRS_LONSDALEITE_TOOLS);
    public static final Tier PERFECT_LONSDALEITE = tier(3800, 9.0F, 4.0F, 20, REPAIRS_PERFECT_LONSDALEITE_TOOLS);

    private static Tier tier(int uses, float speed, float attackBonus, int enchant, TagKey<Item> repair) {
        return new Tier() {
            @Override public int getUses() { return uses; }
            @Override public float getSpeed() { return speed; }
            @Override public float getAttackDamageBonus() { return attackBonus; }
            @Override public TagKey<Block> getIncorrectBlocksForDrops() { return BlockTags.INCORRECT_FOR_NETHERITE_TOOL; }
            @Override public int getEnchantmentValue() { return enchant; }
            @Override public Ingredient getRepairIngredient() { return Ingredient.of(repair); }
        };
    }

    /** Mining speed for the omnitool, which mines every tool category at the material's speed. */
    public static float getMiningSpeed(Tier material) {
        return material.getSpeed();
    }
}
