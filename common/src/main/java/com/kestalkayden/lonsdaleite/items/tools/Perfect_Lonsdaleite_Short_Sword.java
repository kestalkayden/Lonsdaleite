package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

// 1.21.1: SwordItem(Tier, Properties) forces default sword stats, so to keep this weapon's
// bespoke attack damage/speed we extend Item and apply the custom attributes ourselves
// (via SwordItem.createAttributes), plus the tier's durability, enchantability and sword
// tool component. hurtEnemy returns boolean here (void is 1.21.5+).
public class Perfect_Lonsdaleite_Short_Sword extends Item {
    private final int enchantmentValue;

    public Perfect_Lonsdaleite_Short_Sword(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties
            .durability(tier.getUses())
            .attributes(SwordItem.createAttributes(tier, attackDamage, attackSpeed))
            .component(DataComponents.TOOL, tier.createToolProperties(BlockTags.SWORD_EFFICIENT)));
        this.enchantmentValue = tier.getEnchantmentValue();
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, attacker.getEquipmentSlotForItem(stack));
        return true;
    }
}
