package com.kestalkayden.lonsdaleite.materials;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import com.kestalkayden.lonsdaleite.Lonsdaleite;

import java.util.Map;

public class LonsdaleiteArmorMaterials {
    
    // Registry entries for our armor materials (these will be set during registration)
    public static RegistryEntry<ArmorMaterial> LONSDALEITE_ENTRY;
    public static RegistryEntry<ArmorMaterial> PERFECT_LONSDALEITE_ENTRY;
    
    // ArmorMaterial constructor: durability, defense values, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, equipmentAsset
    public static final ArmorMaterial LONSDALEITE = new ArmorMaterial(
        37,  // Base durability (will be multiplied by equipment type: helmet=11, chestplate=16, leggings=15, boots=13)
        Map.of(  // Defense values per equipment type
            EquipmentType.HELMET, 3,
            EquipmentType.CHESTPLATE, 8,
            EquipmentType.LEGGINGS, 6,
            EquipmentType.BOOTS, 3
        ),
        15,  // Enchantability
        SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,  // Equip sound
        2.0F,  // Toughness
        0.0F,  // Knockback resistance
        ItemTags.REPAIRS_DIAMOND_ARMOR,  // Repair ingredient tag
        null  // Equipment asset (null for basic implementation)
    );
    
    public static final ArmorMaterial PERFECT_LONSDALEITE = new ArmorMaterial(
        43,  // Higher base durability
        Map.of(  // Higher defense values
            EquipmentType.HELMET, 3,
            EquipmentType.CHESTPLATE, 8,
            EquipmentType.LEGGINGS, 6,
            EquipmentType.BOOTS, 3
        ),
        18,  // Higher enchantability
        SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,  // Netherite equip sound
        3.0F,  // Higher toughness
        0.1F,  // Some knockback resistance
        ItemTags.REPAIRS_NETHERITE_ARMOR,  // Repair ingredient tag
        null  // Equipment asset (null for basic implementation)
    );
    
    public static void registerArmorMaterials() {
        // For now, create the registry entries directly from the materials
        // In 1.21.8, armor materials might not need explicit registry registration
        LONSDALEITE_ENTRY = RegistryEntry.of(LONSDALEITE);
        PERFECT_LONSDALEITE_ENTRY = RegistryEntry.of(PERFECT_LONSDALEITE);
    }
    
    // Helper method to get durability for a specific equipment type
    public static int getDurabilityForType(ArmorMaterial material, EquipmentType type) {
        return switch (type) {
            case HELMET -> material.durability() * 11;
            case CHESTPLATE -> material.durability() * 16;
            case LEGGINGS -> material.durability() * 15;
            case BOOTS -> material.durability() * 13;
            default -> material.durability();
        };
    }
}