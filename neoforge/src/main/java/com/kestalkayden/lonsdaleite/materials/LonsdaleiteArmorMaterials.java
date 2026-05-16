package com.kestalkayden.lonsdaleite.materials;

import java.util.Map;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class LonsdaleiteArmorMaterials {

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
        ItemTags.REPAIRS_DIAMOND_ARMOR,
        EquipmentAssets.DIAMOND
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
        ItemTags.REPAIRS_NETHERITE_ARMOR,
        EquipmentAssets.NETHERITE
    );
}
