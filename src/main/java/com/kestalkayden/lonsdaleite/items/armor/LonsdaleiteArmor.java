package com.kestalkayden.lonsdaleite.items.armor;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.Map;

public class LonsdaleiteArmor extends Item {
    private final EquipmentType equipmentType;
    private final RegistryEntry<ArmorMaterial> material;

    public LonsdaleiteArmor(RegistryEntry<ArmorMaterial> material, EquipmentType type, Item.Settings settings) {
        super(settings
            .maxDamage(getDurabilityForType(material.value(), type))  // Set durability based on material and type
            .component(DataComponentTypes.ATTRIBUTE_MODIFIERS, createAttributeModifiers(material, type))
            .component(DataComponentTypes.EQUIPPABLE, createEquippableComponent(material, type))
            .enchantable(getEnchantability(material)));
        this.material = material;
        this.equipmentType = type;
    }

    private static AttributeModifiersComponent createAttributeModifiers(RegistryEntry<ArmorMaterial> material, EquipmentType type) {
        AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
        
        // Add armor protection based on material and type
        int protection = material.value().defense().get(type);
        if (protection > 0) {
            builder.add(EntityAttributes.ARMOR, 
                new EntityAttributeModifier(Identifier.of("armor.defense"), protection, EntityAttributeModifier.Operation.ADD_VALUE),
                getAttributeModifierSlot(type));
        }

        // Add armor toughness if the material provides it
        float toughness = material.value().toughness();
        if (toughness > 0) {
            builder.add(EntityAttributes.ARMOR_TOUGHNESS,
                new EntityAttributeModifier(Identifier.of("armor.toughness"), toughness, EntityAttributeModifier.Operation.ADD_VALUE),
                getAttributeModifierSlot(type));
        }

        // Add knockback resistance if the material provides it
        float knockbackResistance = material.value().knockbackResistance();
        if (knockbackResistance > 0) {
            builder.add(EntityAttributes.KNOCKBACK_RESISTANCE,
                new EntityAttributeModifier(Identifier.of("armor.knockback_resistance"), knockbackResistance, EntityAttributeModifier.Operation.ADD_VALUE),
                getAttributeModifierSlot(type));
        }

        return builder.build();
    }

    private static EquippableComponent createEquippableComponent(RegistryEntry<ArmorMaterial> material, EquipmentType type) {
        return EquippableComponent.builder(getEquipmentSlot(type))
            .equipSound(material.value().equipSound())
            .build();
    }

    private static AttributeModifierSlot getAttributeModifierSlot(EquipmentType type) {
        return switch (type) {
            case HELMET -> AttributeModifierSlot.HEAD;
            case CHESTPLATE -> AttributeModifierSlot.CHEST;
            case LEGGINGS -> AttributeModifierSlot.LEGS;
            case BOOTS -> AttributeModifierSlot.FEET;
            default -> throw new IllegalArgumentException("Invalid equipment type for armor: " + type);
        };
    }

    private static net.minecraft.entity.EquipmentSlot getEquipmentSlot(EquipmentType type) {
        return switch (type) {
            case HELMET -> net.minecraft.entity.EquipmentSlot.HEAD;
            case CHESTPLATE -> net.minecraft.entity.EquipmentSlot.CHEST;
            case LEGGINGS -> net.minecraft.entity.EquipmentSlot.LEGS;
            case BOOTS -> net.minecraft.entity.EquipmentSlot.FEET;
            default -> throw new IllegalArgumentException("Invalid equipment type for armor: " + type);
        };
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public RegistryEntry<ArmorMaterial> getMaterial() {
        return material;
    }

    private static int getDurabilityForType(ArmorMaterial material, EquipmentType type) {
        // Calculate durability based on material base durability and equipment type multipliers
        int baseDurability = material.durability();
        return switch (type) {
            case HELMET -> baseDurability * 11;
            case CHESTPLATE -> baseDurability * 16;
            case LEGGINGS -> baseDurability * 15;
            case BOOTS -> baseDurability * 13;
            default -> baseDurability * 10;  // fallback
        };
    }

    private static int getEnchantability(RegistryEntry<ArmorMaterial> material) {
        // Since we can't access enchantability() directly, get it from our materials class
        if (material == com.kestalkayden.lonsdaleite.materials.LonsdaleiteArmorMaterials.LONSDALEITE_ENTRY) {
            return 15;
        } else if (material == com.kestalkayden.lonsdaleite.materials.LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE_ENTRY) {
            return 18;
        }
        return 15; // fallback
    }
}