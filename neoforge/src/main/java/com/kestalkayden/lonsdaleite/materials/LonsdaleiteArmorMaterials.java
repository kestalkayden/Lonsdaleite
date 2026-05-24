package com.kestalkayden.lonsdaleite.materials;

import java.util.Map;

import com.kestalkayden.lonsdaleite.Lonsdaleite;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class LonsdaleiteArmorMaterials {

    public static final ResourceKey<EquipmentAsset> LONSDALEITE_ASSET = ResourceKey.create(
        EquipmentAssets.ROOT_ID,
        Identifier.fromNamespaceAndPath(Lonsdaleite.MOD_ID, "lonsdaleite"));

    public static final ResourceKey<EquipmentAsset> PERFECT_LONSDALEITE_ASSET = ResourceKey.create(
        EquipmentAssets.ROOT_ID,
        Identifier.fromNamespaceAndPath(Lonsdaleite.MOD_ID, "perfect_lonsdaleite"));

    // ArmorMaterial(durability, defense map, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, assetId)
    public static final ArmorMaterial LONSDALEITE = new ArmorMaterial(
        37,
        Map.of(
            ArmorType.HELMET, 3,
            ArmorType.CHESTPLATE, 8,
            ArmorType.LEGGINGS, 6,
            ArmorType.BOOTS, 3
        ),
        15,
        SoundEvents.ARMOR_EQUIP_DIAMOND,
        2.0F,
        0.0F,
        LonsdaleiteToolMaterials.REPAIRS_LONSDALEITE_TOOLS,
        LONSDALEITE_ASSET
    );

    public static final ArmorMaterial PERFECT_LONSDALEITE = new ArmorMaterial(
        43,
        Map.of(
            ArmorType.HELMET, 3,
            ArmorType.CHESTPLATE, 8,
            ArmorType.LEGGINGS, 6,
            ArmorType.BOOTS, 3
        ),
        18,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        3.0F,
        0.1F,
        LonsdaleiteToolMaterials.REPAIRS_PERFECT_LONSDALEITE_TOOLS,
        PERFECT_LONSDALEITE_ASSET
    );
}
