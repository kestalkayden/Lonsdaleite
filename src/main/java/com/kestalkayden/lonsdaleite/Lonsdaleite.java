package com.kestalkayden.lonsdaleite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kestalkayden.lonsdaleite.items.armor.LonsdaleiteArmor;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Axe;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Hoe;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Omnitool;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Pickaxe;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Short_Sword;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Shovel;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Sword;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_War_Axe;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Axe;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Hoe;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Omnitool;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Pickaxe;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Short_Sword;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Shovel;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Sword;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_War_Axe;
import com.kestalkayden.lonsdaleite.materials.LonsdaleiteArmorMaterial;
import com.kestalkayden.lonsdaleite.materials.LonsdaleiteToolMaterial;

public class Lonsdaleite implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("lonsdaleite");

	// RAW STATES OF LONSDALEITE
    public static final Item RAW_LONSDALEITE = new Item(new FabricItemSettings());
    public static final Item PREPARED_LONSDALEITE = new Item(new FabricItemSettings());
    public static final Item REFINED_LONSDALEITE = new Item(new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE = new Item(new FabricItemSettings());

    // Tools
    public static final Item LONSDALEITE_AXE = new Lonsdaleite_Axe(LonsdaleiteToolMaterial.LONSDALEITE, 5, -3.0F, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_AXE = new Perfect_Lonsdaleite_Axe(LonsdaleiteToolMaterial.PERFECT_LONSDALEITE, 5, -3.0F,new Item.Settings());
    public static final Item LONSDALEITE_HOE = new Lonsdaleite_Hoe(LonsdaleiteToolMaterial.LONSDALEITE, -3, 0.0f, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_HOE = new Perfect_Lonsdaleite_Hoe(LonsdaleiteToolMaterial.PERFECT_LONSDALEITE, -3, 0.0f, new FabricItemSettings());
    public static final Item LONSDALEITE_PICKAXE = new Lonsdaleite_Pickaxe(LonsdaleiteToolMaterial.LONSDALEITE, 1, -2.8F, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_PICKAXE = new Perfect_Lonsdaleite_Pickaxe(LonsdaleiteToolMaterial.PERFECT_LONSDALEITE, 1, -2.8F, new FabricItemSettings());
    public static final Item LONSDALEITE_SHOVEL = new Lonsdaleite_Shovel(LonsdaleiteToolMaterial.LONSDALEITE, 1.5F, -3.0F, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_SHOVEL = new Perfect_Lonsdaleite_Shovel(LonsdaleiteToolMaterial.PERFECT_LONSDALEITE, 1.5F, -3.0F, new FabricItemSettings());
    public static final Item LONSDALEITE_OMNITOOL = new Lonsdaleite_Omnitool(LonsdaleiteToolMaterial.LONSDALEITE, 1, -3.0f, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_OMNITOOL = new Perfect_Lonsdaleite_Omnitool(LonsdaleiteToolMaterial.PERFECT_LONSDALEITE, 1, -3.0f, new FabricItemSettings());

    // Weapons
    public static final Item LONSDALEITE_SWORD = new Lonsdaleite_Sword(LonsdaleiteToolMaterial.LONSDALEITE, 4, -2.4F, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_SWORD = new Perfect_Lonsdaleite_Sword(LonsdaleiteToolMaterial.PERFECT_LONSDALEITE, 5, -2.4F, new FabricItemSettings());
    public static final Item LONSDALEITE_SHORT_SWORD = new Lonsdaleite_Short_Sword(LonsdaleiteToolMaterial.LONSDALEITE, -1, -0.5F, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_SHORT_SWORD = new Perfect_Lonsdaleite_Short_Sword(LonsdaleiteToolMaterial.PERFECT_LONSDALEITE, 0, -0.5F, new FabricItemSettings());
    public static final Item LONSDALEITE_WAR_AXE = new Lonsdaleite_War_Axe(LonsdaleiteToolMaterial.LONSDALEITE, 6, -3.2F, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_WAR_AXE = new Perfect_Lonsdaleite_War_Axe(LonsdaleiteToolMaterial.PERFECT_LONSDALEITE, 7, -3.2F, new FabricItemSettings());

    // Armor
    public static final Item LONSDALEITE_HELMET = new LonsdaleiteArmor(LonsdaleiteArmorMaterial.LONSDALEITE, ArmorItem.Type.HELMET, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_HELMET = new LonsdaleiteArmor(LonsdaleiteArmorMaterial.PERFECT_LONSDALEITE, ArmorItem.Type.HELMET, new FabricItemSettings());
    public static final Item LONSDALEITE_CHEST = new LonsdaleiteArmor(LonsdaleiteArmorMaterial.LONSDALEITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_CHEST = new LonsdaleiteArmor(LonsdaleiteArmorMaterial.PERFECT_LONSDALEITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings());
    public static final Item LONSDALEITE_LEGGINGS = new LonsdaleiteArmor(LonsdaleiteArmorMaterial.LONSDALEITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_LEGGINGS = new LonsdaleiteArmor(LonsdaleiteArmorMaterial.PERFECT_LONSDALEITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings());
    public static final Item LONSDALEITE_BOOTS = new LonsdaleiteArmor(LonsdaleiteArmorMaterial.LONSDALEITE, ArmorItem.Type.BOOTS, new FabricItemSettings());
    public static final Item PERFECT_LONSDALEITE_BOOTS = new LonsdaleiteArmor(LonsdaleiteArmorMaterial.PERFECT_LONSDALEITE, ArmorItem.Type.BOOTS, new FabricItemSettings());


	@Override
    public void onInitialize() {
		LOGGER.info("Initializing Lonsedaleite Mod");

		Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "raw_lonsdaleite"), RAW_LONSDALEITE);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "prepared_lonsdaleite"), PREPARED_LONSDALEITE);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "refined_lonsdaleite"), REFINED_LONSDALEITE);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite"), PERFECT_LONSDALEITE);		
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
			content.addAfter(Items.RAW_GOLD, RAW_LONSDALEITE);
			content.addAfter(Lonsdaleite.RAW_LONSDALEITE, PREPARED_LONSDALEITE);
			content.addAfter(Lonsdaleite.PREPARED_LONSDALEITE, REFINED_LONSDALEITE);
			content.addAfter(Lonsdaleite.REFINED_LONSDALEITE, PERFECT_LONSDALEITE);
		});

        // Lonsdaleite Tools
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_omnitool"), LONSDALEITE_OMNITOOL);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_pickaxe"), LONSDALEITE_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_shovel"), LONSDALEITE_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_axe"), LONSDALEITE_AXE);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_hoe"), LONSDALEITE_HOE);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_pickaxe"), PERFECT_LONSDALEITE_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_shovel"), PERFECT_LONSDALEITE_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_axe"), PERFECT_LONSDALEITE_AXE);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_hoe"), PERFECT_LONSDALEITE_HOE);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_omnitool"), PERFECT_LONSDALEITE_OMNITOOL);		

		// Lonsdaleite Weapons
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_sword"), LONSDALEITE_SWORD);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_short_sword"), LONSDALEITE_SHORT_SWORD);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_war_axe"), LONSDALEITE_WAR_AXE);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_sword"), PERFECT_LONSDALEITE_SWORD);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_war_axe"), PERFECT_LONSDALEITE_WAR_AXE);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_short_sword"), PERFECT_LONSDALEITE_SHORT_SWORD);

		// Lonsdaleite Armor
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_helmet"), LONSDALEITE_HELMET);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_chest"), LONSDALEITE_CHEST);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_leggings"), LONSDALEITE_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "lonsdaleite_boots"), LONSDALEITE_BOOTS);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_helmet"), PERFECT_LONSDALEITE_HELMET);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_chest"), PERFECT_LONSDALEITE_CHEST);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_leggings"), PERFECT_LONSDALEITE_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_boots"), PERFECT_LONSDALEITE_BOOTS);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.addAfter(Items.NETHERITE_HOE, LONSDALEITE_PICKAXE);
			content.addAfter(Items.NETHERITE_HOE, LONSDALEITE_SHOVEL);
			content.addAfter(Items.NETHERITE_HOE, LONSDALEITE_AXE);
			content.addAfter(Items.NETHERITE_HOE, LONSDALEITE_HOE);
			content.addAfter(Items.NETHERITE_HOE, LONSDALEITE_OMNITOOL);
			content.addAfter(Lonsdaleite.LONSDALEITE_PICKAXE, PERFECT_LONSDALEITE_PICKAXE);
			content.addAfter(Lonsdaleite.LONSDALEITE_PICKAXE, PERFECT_LONSDALEITE_SHOVEL);
			content.addAfter(Lonsdaleite.LONSDALEITE_PICKAXE, PERFECT_LONSDALEITE_AXE);
			content.addAfter(Lonsdaleite.LONSDALEITE_PICKAXE, PERFECT_LONSDALEITE_HOE);
			content.addAfter(Lonsdaleite.LONSDALEITE_PICKAXE, PERFECT_LONSDALEITE_OMNITOOL);			
		});

		// Lonsdaleite Weapons
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
			content.addAfter(Items.NETHERITE_AXE, LONSDALEITE_SHORT_SWORD);
			content.addAfter(Lonsdaleite.LONSDALEITE_SHORT_SWORD, LONSDALEITE_SWORD);
			content.addAfter(Lonsdaleite.LONSDALEITE_SWORD, LONSDALEITE_WAR_AXE);
			content.addAfter(Lonsdaleite.LONSDALEITE_WAR_AXE, PERFECT_LONSDALEITE_SHORT_SWORD);
			content.addAfter(Lonsdaleite.PERFECT_LONSDALEITE_SHORT_SWORD, PERFECT_LONSDALEITE_SWORD);
			content.addAfter(Lonsdaleite.PERFECT_LONSDALEITE_SWORD, PERFECT_LONSDALEITE_WAR_AXE);
		});

        // Lonsdaleite Armor
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.NETHERITE_BOOTS, LONSDALEITE_HELMET);
            content.addAfter(Lonsdaleite.LONSDALEITE_HELMET, LONSDALEITE_CHEST);
            content.addAfter(Lonsdaleite.LONSDALEITE_CHEST, LONSDALEITE_LEGGINGS);
            content.addAfter(Lonsdaleite.LONSDALEITE_LEGGINGS, LONSDALEITE_BOOTS);
            content.addAfter(Lonsdaleite.LONSDALEITE_BOOTS, PERFECT_LONSDALEITE_HELMET);
            content.addAfter(Lonsdaleite.PERFECT_LONSDALEITE_HELMET, PERFECT_LONSDALEITE_CHEST);
            content.addAfter(Lonsdaleite.PERFECT_LONSDALEITE_CHEST, PERFECT_LONSDALEITE_LEGGINGS);
            content.addAfter(Lonsdaleite.PERFECT_LONSDALEITE_LEGGINGS, PERFECT_LONSDALEITE_BOOTS);
        });
	}
}
