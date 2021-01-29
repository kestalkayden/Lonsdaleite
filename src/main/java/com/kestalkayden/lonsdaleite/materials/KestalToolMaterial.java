package com.kestalkayden.lonsdaleite.materials;
import com.google.common.base.Supplier;
import com.kestalkayden.lonsdaleite.Lonsdaleite;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum KestalToolMaterial implements ToolMaterial {
	LONSDALEITE(
	    3,
        1750,
        8.2F,
        3.0F,
        15,
        () -> Ingredient.ofItems(Lonsdaleite.REFINED_LONSDALEITE)
    ),
    PERFECT_LONSDALEITE(
        4,
        2350,
        9.0F,
        4.0F,
        20,
        () -> Ingredient.ofItems(Lonsdaleite.REFINED_LONSDALEITE)
    );

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;
 
    KestalToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }
 
    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }
 
    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }
 
    @Override
    public int getEnchantability() {
        return this.enchantability;
    }
 
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }
}
