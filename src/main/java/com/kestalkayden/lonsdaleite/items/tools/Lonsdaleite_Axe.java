package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import com.kestalkayden.lonsdaleite.materials.LonsdaleiteToolMaterials;

public class Lonsdaleite_Axe extends Item {

    public Lonsdaleite_Axe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(settings.component(DataComponentTypes.ATTRIBUTE_MODIFIERS,
            AttributeModifiersComponent.builder()
                .add(EntityAttributes.ATTACK_DAMAGE, 
                    new EntityAttributeModifier(Identifier.of("base_attack_damage"), attackDamage, EntityAttributeModifier.Operation.ADD_VALUE),
                    net.minecraft.component.type.AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.ATTACK_SPEED,
                    new EntityAttributeModifier(Identifier.of("base_attack_speed"), attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                    net.minecraft.component.type.AttributeModifierSlot.MAINHAND)
                .build()));
    }

}
