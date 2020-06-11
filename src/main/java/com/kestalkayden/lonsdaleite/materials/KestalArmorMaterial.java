package com.kestalkayden.lonsdaleite.materials;
import com.kestalkayden.lonsdaleite.Lonsdaleite;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

import java.util.function.Supplier;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public enum KestalArmorMaterial implements ArmorMaterial {
    LONSDALEITE("lonsdaleite", 60, new int[]{5,10,12,4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, 2.00f, () -> {
        return Ingredient.ofItems(Lonsdaleite.REFINED_LONSDALEITE);
    });

    private static final int[] baseDurability = {13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorValues;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final Lazy<Ingredient> repairIngredient;
    private final float knockbackResist;

    KestalArmorMaterial(String name, int durabilityMultiplier, int[] armorValueArr, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResist, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorValues = armorValueArr;
        this.enchantability = enchantability;
        this.equipSound = soundEvent;
        this.toughness = toughness;
        this.repairIngredient = new Lazy(repairIngredient);
        this.knockbackResist = knockbackResist;
    }
 
    public int getDurability(EquipmentSlot equipmentSlot_1) {
        return baseDurability[equipmentSlot_1.getEntitySlotId()] * this.durabilityMultiplier;
    }
 
    public int getProtectionAmount(EquipmentSlot equipmentSlot_1) {
        return this.armorValues[equipmentSlot_1.getEntitySlotId()];
    }
 
    public int getEnchantability() {
        return this.enchantability;
    }
 
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }
 
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
 
    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }
 
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResist;
    }
}
