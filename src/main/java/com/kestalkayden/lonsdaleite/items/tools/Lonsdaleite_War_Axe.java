package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import com.kestalkayden.lonsdaleite.materials.LonsdaleiteToolMaterials;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.util.Identifier;

public class Lonsdaleite_War_Axe extends Item {

    public Lonsdaleite_War_Axe(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(settings.component(net.minecraft.component.DataComponentTypes.ATTRIBUTE_MODIFIERS,
            AttributeModifiersComponent.builder()
                .add(EntityAttributes.ATTACK_DAMAGE,
                    new EntityAttributeModifier(Identifier.of("base_attack_damage"), 
                        attackDamage + LonsdaleiteToolMaterials.getAttackDamage(material), EntityAttributeModifier.Operation.ADD_VALUE),
                    AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.ATTACK_SPEED,
                    new EntityAttributeModifier(Identifier.of("base_attack_speed"), 
                        attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                    AttributeModifierSlot.MAINHAND)
                .build()));
    }

}
