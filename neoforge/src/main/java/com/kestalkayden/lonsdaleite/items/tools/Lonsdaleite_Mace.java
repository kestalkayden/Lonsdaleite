package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class Lonsdaleite_Mace extends MaceItem {
    public Lonsdaleite_Mace(Item.Properties properties) {
        super(properties);
    }

    // Stronger melee than the vanilla mace (+7 base vs +5); keeps the vanilla -3.4 swing and the fall-distance smash attack.
    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
            .add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 7.0, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND)
            .add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_ID, -3.4, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND)
            .build();
    }
}
