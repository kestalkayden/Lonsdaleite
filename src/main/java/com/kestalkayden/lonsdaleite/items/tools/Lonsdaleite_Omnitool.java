package com.kestalkayden.lonsdaleite.items.tools;


import com.kestalkayden.lonsdaleite.materials.LonsdaleiteToolMaterials;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.util.Identifier;

public class Lonsdaleite_Omnitool extends Item {

    private final ToolMaterial material;

    public Lonsdaleite_Omnitool(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
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
        this.material = material;
    }
    
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return LonsdaleiteToolMaterials.getMiningSpeed(material);
    }
}
