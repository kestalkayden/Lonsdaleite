package com.kestalkayden.lonsdaleite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EnchantableComponent;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.registry.Registries;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kestalkayden.lonsdaleite.items.armor.LonsdaleiteArmor;
import com.kestalkayden.lonsdaleite.materials.LonsdaleiteArmorMaterials;
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
import com.kestalkayden.lonsdaleite.materials.LonsdaleiteArmorMaterials;
import com.kestalkayden.lonsdaleite.materials.LonsdaleiteToolMaterials;

public class Lonsdaleite implements ModInitializer {
    public static final String MOD_ID = "lonsdaleite";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Custom item group (will be initialized after items)
    public static ItemGroup LONSDALEITE_ITEM_GROUP;


	// RAW STATES OF LONSDALEITE
    public static Item RAW_LONSDALEITE;
    public static Item PREPARED_LONSDALEITE;
    public static Item REFINED_LONSDALEITE;
    public static Item PERFECT_LONSDALEITE;

    // Tools
    public static Item LONSDALEITE_AXE;
    public static Item PERFECT_LONSDALEITE_AXE;
    public static Item LONSDALEITE_HOE;
    public static Item PERFECT_LONSDALEITE_HOE;
    public static Item LONSDALEITE_PICKAXE;
    public static Item PERFECT_LONSDALEITE_PICKAXE;
    public static Item LONSDALEITE_SHOVEL;
    public static Item PERFECT_LONSDALEITE_SHOVEL;
    public static Item LONSDALEITE_OMNITOOL;
    public static Item PERFECT_LONSDALEITE_OMNITOOL;

    // Weapons
    public static Item LONSDALEITE_SWORD;
    public static Item PERFECT_LONSDALEITE_SWORD;
    public static Item LONSDALEITE_SHORT_SWORD;
    public static Item PERFECT_LONSDALEITE_SHORT_SWORD;
    public static Item LONSDALEITE_WAR_AXE;
    public static Item PERFECT_LONSDALEITE_WAR_AXE;

    // Armor
    public static Item LONSDALEITE_HELMET;
    public static Item LONSDALEITE_CHESTPLATE;
    public static Item LONSDALEITE_LEGGINGS;
    public static Item LONSDALEITE_BOOTS;
    public static Item PERFECT_LONSDALEITE_HELMET;
    public static Item PERFECT_LONSDALEITE_CHESTPLATE;
    public static Item PERFECT_LONSDALEITE_LEGGINGS;
    public static Item PERFECT_LONSDALEITE_BOOTS;
    
    // Helper method to register items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }
    
    // Helper method to create item settings with registry key
    private static Item.Settings createItemSettings(String name) {
        Identifier itemId = Identifier.of(MOD_ID, name);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, itemId);
        return new Item.Settings().registryKey(itemKey);
    }
    
    // Helper method to create item settings with registry key and enchantability
    private static Item.Settings createItemSettings(String name, int enchantability) {
        Identifier itemId = Identifier.of(MOD_ID, name);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, itemId);
        return new Item.Settings().registryKey(itemKey)
            .component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(enchantability));
    }
    
    // Helper method to create tool settings with attack damage and speed
    private static Item.Settings createToolSettings(String name, int enchantability, int attackDamage, float attackSpeed) {
        Identifier itemId = Identifier.of(MOD_ID, name);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, itemId);
        return new Item.Settings().registryKey(itemKey)
            .component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(enchantability))
            .component(DataComponentTypes.ATTRIBUTE_MODIFIERS,
                AttributeModifiersComponent.builder()
                    .add(EntityAttributes.ATTACK_DAMAGE,
                        new EntityAttributeModifier(Identifier.of("base_attack_damage"), 
                            attackDamage, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND)
                    .add(EntityAttributes.ATTACK_SPEED,
                        new EntityAttributeModifier(Identifier.of("base_attack_speed"), 
                            attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND)
                    .build());
    }
    



	@Override
    public void onInitialize() {
		LOGGER.info("Initializing Lonsdaleite Mod");

        // Register armor materials first
        LonsdaleiteArmorMaterials.registerArmorMaterials();

        // Register raw materials
        RAW_LONSDALEITE = registerItem("raw_lonsdaleite", new Item(createItemSettings("raw_lonsdaleite")));
        PREPARED_LONSDALEITE = registerItem("prepared_lonsdaleite", new Item(createItemSettings("prepared_lonsdaleite")));
        REFINED_LONSDALEITE = registerItem("refined_lonsdaleite", new Item(createItemSettings("refined_lonsdaleite")));
        PERFECT_LONSDALEITE = registerItem("perfect_lonsdaleite", new Item(createItemSettings("perfect_lonsdaleite")));
        
        // Register tools  
        LONSDALEITE_AXE = registerItem("lonsdaleite_axe", new Lonsdaleite_Axe(LonsdaleiteToolMaterials.LONSDALEITE, 8, -3.0F, createToolSettings("lonsdaleite_axe", 15, 8, -3.0F)));
        PERFECT_LONSDALEITE_AXE = registerItem("perfect_lonsdaleite_axe", new Perfect_Lonsdaleite_Axe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 11, -2.9F, createToolSettings("perfect_lonsdaleite_axe", 20, 11, -2.9F)));
        LONSDALEITE_HOE = registerItem("lonsdaleite_hoe", new Lonsdaleite_Hoe(LonsdaleiteToolMaterials.LONSDALEITE, 2, 0.0F, createToolSettings("lonsdaleite_hoe", 15, 2, 0.0F)));
        PERFECT_LONSDALEITE_HOE = registerItem("perfect_lonsdaleite_hoe", new Perfect_Lonsdaleite_Hoe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 3, 0.2F, createToolSettings("perfect_lonsdaleite_hoe", 20, 3, 0.2F)));
        LONSDALEITE_PICKAXE = registerItem("lonsdaleite_pickaxe", new Lonsdaleite_Pickaxe(LonsdaleiteToolMaterials.LONSDALEITE, 5, -2.8F, createToolSettings("lonsdaleite_pickaxe", 15, 5, -2.8F)));
        PERFECT_LONSDALEITE_PICKAXE = registerItem("perfect_lonsdaleite_pickaxe", new Perfect_Lonsdaleite_Pickaxe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 7, -2.7F, createToolSettings("perfect_lonsdaleite_pickaxe", 20, 7, -2.7F)));
        LONSDALEITE_SHOVEL = registerItem("lonsdaleite_shovel", new Lonsdaleite_Shovel(LonsdaleiteToolMaterials.LONSDALEITE, 4, -3.0F, createToolSettings("lonsdaleite_shovel", 15, 4, -3.0F)));
        PERFECT_LONSDALEITE_SHOVEL = registerItem("perfect_lonsdaleite_shovel", new Perfect_Lonsdaleite_Shovel(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 6, -2.9F, createToolSettings("perfect_lonsdaleite_shovel", 20, 6, -2.9F)));
        LONSDALEITE_OMNITOOL = registerItem("lonsdaleite_omnitool", new Lonsdaleite_Omnitool(LonsdaleiteToolMaterials.LONSDALEITE, 3, -2.9F, createToolSettings("lonsdaleite_omnitool", 15, 3, -2.9F)));
        PERFECT_LONSDALEITE_OMNITOOL = registerItem("perfect_lonsdaleite_omnitool", new Perfect_Lonsdaleite_Omnitool(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 5, -2.8F, createToolSettings("perfect_lonsdaleite_omnitool", 20, 5, -2.8F)));
        
        // Register weapons
        LONSDALEITE_SWORD = registerItem("lonsdaleite_sword", new Lonsdaleite_Sword(LonsdaleiteToolMaterials.LONSDALEITE, 6, -2.4F, createToolSettings("lonsdaleite_sword", 15, 6, -2.4F)));
        PERFECT_LONSDALEITE_SWORD = registerItem("perfect_lonsdaleite_sword", new Perfect_Lonsdaleite_Sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 9, -2.3F, createToolSettings("perfect_lonsdaleite_sword", 20, 9, -2.3F)));
        LONSDALEITE_SHORT_SWORD = registerItem("lonsdaleite_short_sword", new Lonsdaleite_Short_Sword(LonsdaleiteToolMaterials.LONSDALEITE, 1, -0.7F, createToolSettings("lonsdaleite_short_sword", 15, 1, -0.7F)));
        PERFECT_LONSDALEITE_SHORT_SWORD = registerItem("perfect_lonsdaleite_short_sword", new Perfect_Lonsdaleite_Short_Sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 2, -0.4F, createToolSettings("perfect_lonsdaleite_short_sword", 20, 2, -0.4F)));
        LONSDALEITE_WAR_AXE = registerItem("lonsdaleite_war_axe", new Lonsdaleite_War_Axe(LonsdaleiteToolMaterials.LONSDALEITE, 9, -3.9F, createToolSettings("lonsdaleite_war_axe", 15, 9, -3.9F)));
        PERFECT_LONSDALEITE_WAR_AXE = registerItem("perfect_lonsdaleite_war_axe", new Perfect_Lonsdaleite_War_Axe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 13, -3.7F, createToolSettings("perfect_lonsdaleite_war_axe", 20, 13, -3.7F)));

        // Register armor items
        LONSDALEITE_HELMET = registerItem("lonsdaleite_helmet", 
            new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE_ENTRY, EquipmentType.HELMET, createItemSettings("lonsdaleite_helmet")));
        LONSDALEITE_CHESTPLATE = registerItem("lonsdaleite_chestplate", 
            new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE_ENTRY, EquipmentType.CHESTPLATE, createItemSettings("lonsdaleite_chestplate")));
        LONSDALEITE_LEGGINGS = registerItem("lonsdaleite_leggings", 
            new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE_ENTRY, EquipmentType.LEGGINGS, createItemSettings("lonsdaleite_leggings")));
        LONSDALEITE_BOOTS = registerItem("lonsdaleite_boots", 
            new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE_ENTRY, EquipmentType.BOOTS, createItemSettings("lonsdaleite_boots")));

        PERFECT_LONSDALEITE_HELMET = registerItem("perfect_lonsdaleite_helmet", 
            new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE_ENTRY, EquipmentType.HELMET, createItemSettings("perfect_lonsdaleite_helmet")));
        PERFECT_LONSDALEITE_CHESTPLATE = registerItem("perfect_lonsdaleite_chestplate", 
            new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE_ENTRY, EquipmentType.CHESTPLATE, createItemSettings("perfect_lonsdaleite_chestplate")));
        PERFECT_LONSDALEITE_LEGGINGS = registerItem("perfect_lonsdaleite_leggings", 
            new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE_ENTRY, EquipmentType.LEGGINGS, createItemSettings("perfect_lonsdaleite_leggings")));
        PERFECT_LONSDALEITE_BOOTS = registerItem("perfect_lonsdaleite_boots", 
            new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE_ENTRY, EquipmentType.BOOTS, createItemSettings("perfect_lonsdaleite_boots")));
		
		// Create and register custom item group
        LONSDALEITE_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, 
            Identifier.of(MOD_ID, "lonsdaleite"), 
            FabricItemGroup.builder()
                .icon(() -> new ItemStack(REFINED_LONSDALEITE))
                .displayName(Text.translatable("itemGroup.lonsdaleite.item_group"))
                .entries((displayContext, entries) -> {
                    // Raw materials
                    entries.add(RAW_LONSDALEITE);
                    entries.add(PREPARED_LONSDALEITE);
                    entries.add(REFINED_LONSDALEITE);
                    entries.add(PERFECT_LONSDALEITE);
                    
                    // Tools
                    entries.add(LONSDALEITE_PICKAXE);
                    entries.add(PERFECT_LONSDALEITE_PICKAXE);
                    entries.add(LONSDALEITE_AXE);
                    entries.add(PERFECT_LONSDALEITE_AXE);
                    entries.add(LONSDALEITE_SHOVEL);
                    entries.add(PERFECT_LONSDALEITE_SHOVEL);
                    entries.add(LONSDALEITE_HOE);
                    entries.add(PERFECT_LONSDALEITE_HOE);
                    entries.add(LONSDALEITE_OMNITOOL);
                    entries.add(PERFECT_LONSDALEITE_OMNITOOL);
                    
                    // Weapons
                    entries.add(LONSDALEITE_SHORT_SWORD);
                    entries.add(PERFECT_LONSDALEITE_SHORT_SWORD);
                    entries.add(LONSDALEITE_SWORD);
                    entries.add(PERFECT_LONSDALEITE_SWORD);
                    entries.add(LONSDALEITE_WAR_AXE);
                    entries.add(PERFECT_LONSDALEITE_WAR_AXE);
                    
                    // Armor
                    entries.add(LONSDALEITE_HELMET);
                    entries.add(LONSDALEITE_CHESTPLATE);
                    entries.add(LONSDALEITE_LEGGINGS);
                    entries.add(LONSDALEITE_BOOTS);
                    entries.add(PERFECT_LONSDALEITE_HELMET);
                    entries.add(PERFECT_LONSDALEITE_CHESTPLATE);
                    entries.add(PERFECT_LONSDALEITE_LEGGINGS);
                    entries.add(PERFECT_LONSDALEITE_BOOTS);
                })
                .build());
		
		// Add items to creative tabs
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
			content.addAfter(Items.RAW_GOLD, RAW_LONSDALEITE);
			content.addAfter(RAW_LONSDALEITE, PREPARED_LONSDALEITE);
			content.addAfter(PREPARED_LONSDALEITE, REFINED_LONSDALEITE);
			content.addAfter(REFINED_LONSDALEITE, PERFECT_LONSDALEITE);
		});


		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.addAfter(Items.NETHERITE_HOE, LONSDALEITE_PICKAXE);
			content.addAfter(Items.NETHERITE_HOE, LONSDALEITE_SHOVEL);
			content.addAfter(Items.NETHERITE_HOE, LONSDALEITE_AXE);
			content.addAfter(Items.NETHERITE_HOE, LONSDALEITE_HOE);
			content.addAfter(Items.NETHERITE_HOE, LONSDALEITE_OMNITOOL);
			content.addAfter(LONSDALEITE_PICKAXE, PERFECT_LONSDALEITE_PICKAXE);
			content.addAfter(LONSDALEITE_PICKAXE, PERFECT_LONSDALEITE_SHOVEL);
			content.addAfter(LONSDALEITE_PICKAXE, PERFECT_LONSDALEITE_AXE);
			content.addAfter(LONSDALEITE_PICKAXE, PERFECT_LONSDALEITE_HOE);
			content.addAfter(LONSDALEITE_PICKAXE, PERFECT_LONSDALEITE_OMNITOOL);			
		});

		// Lonsdaleite Weapons
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
			content.addAfter(Items.NETHERITE_AXE, LONSDALEITE_SHORT_SWORD);
			content.addAfter(LONSDALEITE_SHORT_SWORD, LONSDALEITE_SWORD);
			content.addAfter(LONSDALEITE_SWORD, LONSDALEITE_WAR_AXE);
			content.addAfter(LONSDALEITE_WAR_AXE, PERFECT_LONSDALEITE_SHORT_SWORD);
			content.addAfter(PERFECT_LONSDALEITE_SHORT_SWORD, PERFECT_LONSDALEITE_SWORD);
			content.addAfter(PERFECT_LONSDALEITE_SWORD, PERFECT_LONSDALEITE_WAR_AXE);
		});

        // Add armor to creative tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.NETHERITE_BOOTS, LONSDALEITE_HELMET);
            content.addAfter(LONSDALEITE_HELMET, LONSDALEITE_CHESTPLATE);
            content.addAfter(LONSDALEITE_CHESTPLATE, LONSDALEITE_LEGGINGS);
            content.addAfter(LONSDALEITE_LEGGINGS, LONSDALEITE_BOOTS);
            content.addAfter(LONSDALEITE_BOOTS, PERFECT_LONSDALEITE_HELMET);
            content.addAfter(PERFECT_LONSDALEITE_HELMET, PERFECT_LONSDALEITE_CHESTPLATE);
            content.addAfter(PERFECT_LONSDALEITE_CHESTPLATE, PERFECT_LONSDALEITE_LEGGINGS);
            content.addAfter(PERFECT_LONSDALEITE_LEGGINGS, PERFECT_LONSDALEITE_BOOTS);
        });
	}
}
