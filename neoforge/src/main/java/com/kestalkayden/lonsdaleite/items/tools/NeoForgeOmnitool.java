package com.kestalkayden.lonsdaleite.items.tools;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

/**
 * NeoForge-only omnitool subclass. NeoForge gates tool right-click interactions behind
 * {@code canPerformAction}, so the omnitool must advertise the axe/shovel/hoe abilities for its
 * delegated {@link Lonsdaleite_Omnitool#useOn} to actually strip/scrape/wax/flatten/douse/till.
 * Fabric has no such gate and registers the plain {@link Lonsdaleite_Omnitool} directly.
 */
public class NeoForgeOmnitool extends Lonsdaleite_Omnitool {
    public NeoForgeOmnitool(ToolMaterial material, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean canPerformAction(ItemInstance stack, ItemAbility action) {
        return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(action)
            || ItemAbilities.DEFAULT_SHOVEL_ACTIONS.contains(action)
            || ItemAbilities.DEFAULT_HOE_ACTIONS.contains(action);
    }
}
