package com.kestalkayden.lonsdaleite.materials;

import java.util.List;
import java.util.Map;

import com.kestalkayden.lonsdaleite.LonsdaleiteCommon;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * 1.21.1 armor materials. Pre-1.21.2 there is no equipment-asset system, so an {@link ArmorMaterial}
 * carries its defense map, enchantability, equip sound, repair ingredient, texture layers, toughness
 * and knockback resistance directly, and is handed to {@link ArmorItem} as a {@link Holder}. Both
 * tiers share the single "lonsdaleite" armor texture (models/armor/lonsdaleite_layer_1/2.png).
 */
public class LonsdaleiteArmorMaterials {

    private static final Map<ArmorItem.Type, Integer> DEFENSE = Map.of(
        ArmorItem.Type.HELMET, 3,
        ArmorItem.Type.CHESTPLATE, 8,
        ArmorItem.Type.LEGGINGS, 6,
        ArmorItem.Type.BOOTS, 3);

    private static final List<ArmorMaterial.Layer> LAYERS = List.of(
        new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(LonsdaleiteCommon.MOD_ID, "lonsdaleite")));

    public static final Holder<ArmorMaterial> LONSDALEITE = Holder.direct(new ArmorMaterial(
        DEFENSE, 15, SoundEvents.ARMOR_EQUIP_DIAMOND,
        () -> Ingredient.of(LonsdaleiteToolMaterials.REPAIRS_LONSDALEITE_TOOLS),
        LAYERS, 2.0F, 0.0F));

    public static final Holder<ArmorMaterial> PERFECT_LONSDALEITE = Holder.direct(new ArmorMaterial(
        DEFENSE, 18, SoundEvents.ARMOR_EQUIP_NETHERITE,
        () -> Ingredient.of(LonsdaleiteToolMaterials.REPAIRS_PERFECT_LONSDALEITE_TOOLS),
        LAYERS, 3.0F, 0.1F));
}
