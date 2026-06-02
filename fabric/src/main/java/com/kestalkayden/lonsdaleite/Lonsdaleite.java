package com.kestalkayden.lonsdaleite;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kestalkayden.lonsdaleite.items.armor.LonsdaleiteArmor;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Axe;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Hoe;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Mace;
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

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.item.equipment.ArmorType;

public class Lonsdaleite implements ModInitializer {
    public static final String MOD_ID = "lonsdaleite";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Raw materials
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

    // Spears
    public static Item LONSDALEITE_SPEAR;
    public static Item PERFECT_LONSDALEITE_SPEAR;

    // Mace
    public static Item LONSDALEITE_MACE;

    // Armor
    public static Item LONSDALEITE_HELMET;
    public static Item LONSDALEITE_CHESTPLATE;
    public static Item LONSDALEITE_LEGGINGS;
    public static Item LONSDALEITE_BOOTS;
    public static Item PERFECT_LONSDALEITE_HELMET;
    public static Item PERFECT_LONSDALEITE_CHESTPLATE;
    public static Item PERFECT_LONSDALEITE_LEGGINGS;
    public static Item PERFECT_LONSDALEITE_BOOTS;

    public static CreativeModeTab LONSDALEITE_TAB;

    private static <T extends Item> T register(String name, Function<Item.Properties, T> factory) {
        Identifier id = Identifier.fromNamespaceAndPath(MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        T item = factory.apply(new Item.Properties().setId(key));
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Lonsdaleite Mod");

        // Raw materials
        RAW_LONSDALEITE       = register("raw_lonsdaleite", Item::new);
        PREPARED_LONSDALEITE  = register("prepared_lonsdaleite", Item::new);
        REFINED_LONSDALEITE   = register("refined_lonsdaleite", Item::new);
        PERFECT_LONSDALEITE   = register("perfect_lonsdaleite", Item::new);

        // Mining tools — use Item.Properties.pickaxe/axe/shovel/hoe helpers
        LONSDALEITE_PICKAXE = register("lonsdaleite_pickaxe", p ->
            new Lonsdaleite_Pickaxe(LonsdaleiteToolMaterials.LONSDALEITE, 5, -2.8F,
                p.pickaxe(LonsdaleiteToolMaterials.LONSDALEITE, 5, -2.8F).enchantable(15)));
        PERFECT_LONSDALEITE_PICKAXE = register("perfect_lonsdaleite_pickaxe", p ->
            new Perfect_Lonsdaleite_Pickaxe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 7, -2.7F,
                p.pickaxe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 7, -2.7F).enchantable(20)));
        LONSDALEITE_AXE = register("lonsdaleite_axe", p ->
            new Lonsdaleite_Axe(LonsdaleiteToolMaterials.LONSDALEITE, 8, -3.0F,
                p.axe(LonsdaleiteToolMaterials.LONSDALEITE, 8, -3.0F).enchantable(15)));
        PERFECT_LONSDALEITE_AXE = register("perfect_lonsdaleite_axe", p ->
            new Perfect_Lonsdaleite_Axe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 11, -2.9F,
                p.axe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 11, -2.9F).enchantable(20)));
        LONSDALEITE_SHOVEL = register("lonsdaleite_shovel", p ->
            new Lonsdaleite_Shovel(LonsdaleiteToolMaterials.LONSDALEITE, 4, -3.0F,
                p.shovel(LonsdaleiteToolMaterials.LONSDALEITE, 4, -3.0F).enchantable(15)));
        PERFECT_LONSDALEITE_SHOVEL = register("perfect_lonsdaleite_shovel", p ->
            new Perfect_Lonsdaleite_Shovel(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 6, -2.9F,
                p.shovel(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 6, -2.9F).enchantable(20)));
        LONSDALEITE_HOE = register("lonsdaleite_hoe", p ->
            new Lonsdaleite_Hoe(LonsdaleiteToolMaterials.LONSDALEITE, 2, 0.0F,
                p.hoe(LonsdaleiteToolMaterials.LONSDALEITE, 2, 0.0F).enchantable(15)));
        PERFECT_LONSDALEITE_HOE = register("perfect_lonsdaleite_hoe", p ->
            new Perfect_Lonsdaleite_Hoe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 3, 0.2F,
                p.hoe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 3, 0.2F).enchantable(20)));
        LONSDALEITE_OMNITOOL = register("lonsdaleite_omnitool", p ->
            new Lonsdaleite_Omnitool(LonsdaleiteToolMaterials.LONSDALEITE, 3, -2.9F,
                p.pickaxe(LonsdaleiteToolMaterials.LONSDALEITE, 3, -2.9F).enchantable(15)));
        PERFECT_LONSDALEITE_OMNITOOL = register("perfect_lonsdaleite_omnitool", p ->
            new Perfect_Lonsdaleite_Omnitool(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 5, -2.8F,
                p.pickaxe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 5, -2.8F).enchantable(20)));

        // Weapons — use Item.Properties.sword helper
        LONSDALEITE_SWORD = register("lonsdaleite_sword", p ->
            new Lonsdaleite_Sword(LonsdaleiteToolMaterials.LONSDALEITE, 6, -2.8F,
                p.sword(LonsdaleiteToolMaterials.LONSDALEITE, 6, -2.8F).enchantable(15)));
        PERFECT_LONSDALEITE_SWORD = register("perfect_lonsdaleite_sword", p ->
            new Perfect_Lonsdaleite_Sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 8, -2.7F,
                p.sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 8, -2.7F).enchantable(20)));
        LONSDALEITE_SHORT_SWORD = register("lonsdaleite_short_sword", p ->
            new Lonsdaleite_Short_Sword(LonsdaleiteToolMaterials.LONSDALEITE, 1, -0.7F,
                p.sword(LonsdaleiteToolMaterials.LONSDALEITE, 1, -0.7F).enchantable(15)));
        PERFECT_LONSDALEITE_SHORT_SWORD = register("perfect_lonsdaleite_short_sword", p ->
            new Perfect_Lonsdaleite_Short_Sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 2, -0.4F,
                p.sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 2, -0.4F).enchantable(20)));
        LONSDALEITE_WAR_AXE = register("lonsdaleite_war_axe", p ->
            new Lonsdaleite_War_Axe(LonsdaleiteToolMaterials.LONSDALEITE, 9, -3.9F,
                p.sword(LonsdaleiteToolMaterials.LONSDALEITE, 9, -3.9F).enchantable(15)));
        PERFECT_LONSDALEITE_WAR_AXE = register("perfect_lonsdaleite_war_axe", p ->
            new Perfect_Lonsdaleite_War_Axe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 13, -3.7F,
                p.sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 13, -3.7F).enchantable(20)));

        // Spears — plain Item; spear() sets durability/repair/enchant from the material + kinetic & piercing components
        LONSDALEITE_SPEAR = register("lonsdaleite_spear", p ->
            new Item(p.spear(LonsdaleiteToolMaterials.LONSDALEITE, 1.15F, 1.25F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F)));
        PERFECT_LONSDALEITE_SPEAR = register("perfect_lonsdaleite_spear", p ->
            new Item(p.spear(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 1.15F, 1.35F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F)));

        // Mace — Lonsdaleite_Mace (vanilla smash attack); stronger melee (+7 base vs vanilla +5), gem-tier durability, breeze-rod handle, repairs with Perfect gems
        LONSDALEITE_MACE = register("lonsdaleite_mace", p ->
            new Lonsdaleite_Mace(p.rarity(Rarity.EPIC)
                .durability(2640)
                .component(DataComponents.TOOL, MaceItem.createToolProperties())
                .repairable(LonsdaleiteToolMaterials.REPAIRS_PERFECT_LONSDALEITE_TOOLS)
                .attributes(Lonsdaleite_Mace.createAttributes())
                .enchantable(20)
                .component(DataComponents.WEAPON, new Weapon(1))));

        // Armor — use Item.Properties.humanoidArmor helper
        LONSDALEITE_HELMET     = register("lonsdaleite_helmet",     p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE, ArmorType.HELMET, p));
        LONSDALEITE_CHESTPLATE = register("lonsdaleite_chestplate", p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE, ArmorType.CHESTPLATE, p));
        LONSDALEITE_LEGGINGS   = register("lonsdaleite_leggings",   p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE, ArmorType.LEGGINGS, p));
        LONSDALEITE_BOOTS      = register("lonsdaleite_boots",      p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE, ArmorType.BOOTS, p));
        PERFECT_LONSDALEITE_HELMET     = register("perfect_lonsdaleite_helmet",     p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE, ArmorType.HELMET, p));
        PERFECT_LONSDALEITE_CHESTPLATE = register("perfect_lonsdaleite_chestplate", p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE, ArmorType.CHESTPLATE, p));
        PERFECT_LONSDALEITE_LEGGINGS   = register("perfect_lonsdaleite_leggings",   p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE, ArmorType.LEGGINGS, p));
        PERFECT_LONSDALEITE_BOOTS      = register("perfect_lonsdaleite_boots",      p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE, ArmorType.BOOTS, p));

        // Custom creative tab
        ResourceKey<CreativeModeTab> tabKey = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MOD_ID, "lonsdaleite"));
        LONSDALEITE_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, tabKey,
            FabricCreativeModeTab.builder()
                .icon(() -> new ItemStack(REFINED_LONSDALEITE))
                .title(Component.translatable("itemGroup.lonsdaleite.item_group"))
                .displayItems((displayContext, entries) -> {
                    entries.accept(RAW_LONSDALEITE);
                    entries.accept(PREPARED_LONSDALEITE);
                    entries.accept(REFINED_LONSDALEITE);
                    entries.accept(PERFECT_LONSDALEITE);

                    entries.accept(LONSDALEITE_PICKAXE);
                    entries.accept(PERFECT_LONSDALEITE_PICKAXE);
                    entries.accept(LONSDALEITE_AXE);
                    entries.accept(PERFECT_LONSDALEITE_AXE);
                    entries.accept(LONSDALEITE_SHOVEL);
                    entries.accept(PERFECT_LONSDALEITE_SHOVEL);
                    entries.accept(LONSDALEITE_HOE);
                    entries.accept(PERFECT_LONSDALEITE_HOE);
                    entries.accept(LONSDALEITE_OMNITOOL);
                    entries.accept(PERFECT_LONSDALEITE_OMNITOOL);

                    entries.accept(LONSDALEITE_SHORT_SWORD);
                    entries.accept(PERFECT_LONSDALEITE_SHORT_SWORD);
                    entries.accept(LONSDALEITE_SWORD);
                    entries.accept(PERFECT_LONSDALEITE_SWORD);
                    entries.accept(LONSDALEITE_WAR_AXE);
                    entries.accept(PERFECT_LONSDALEITE_WAR_AXE);

                    entries.accept(LONSDALEITE_SPEAR);
                    entries.accept(PERFECT_LONSDALEITE_SPEAR);
                    entries.accept(LONSDALEITE_MACE);

                    entries.accept(LONSDALEITE_HELMET);
                    entries.accept(LONSDALEITE_CHESTPLATE);
                    entries.accept(LONSDALEITE_LEGGINGS);
                    entries.accept(LONSDALEITE_BOOTS);
                    entries.accept(PERFECT_LONSDALEITE_HELMET);
                    entries.accept(PERFECT_LONSDALEITE_CHESTPLATE);
                    entries.accept(PERFECT_LONSDALEITE_LEGGINGS);
                    entries.accept(PERFECT_LONSDALEITE_BOOTS);
                })
                .build());

        // Inject into vanilla Ingredients tab after RAW_GOLD
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.insertAfter(Items.RAW_GOLD,
                new ItemStack(RAW_LONSDALEITE),
                new ItemStack(PREPARED_LONSDALEITE),
                new ItemStack(REFINED_LONSDALEITE),
                new ItemStack(PERFECT_LONSDALEITE));
        });

        // Inject tools after Netherite Hoe in the Tools tab
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.insertAfter(Items.NETHERITE_HOE,
                new ItemStack(LONSDALEITE_PICKAXE),
                new ItemStack(PERFECT_LONSDALEITE_PICKAXE),
                new ItemStack(LONSDALEITE_AXE),
                new ItemStack(PERFECT_LONSDALEITE_AXE),
                new ItemStack(LONSDALEITE_SHOVEL),
                new ItemStack(PERFECT_LONSDALEITE_SHOVEL),
                new ItemStack(LONSDALEITE_HOE),
                new ItemStack(PERFECT_LONSDALEITE_HOE),
                new ItemStack(LONSDALEITE_OMNITOOL),
                new ItemStack(PERFECT_LONSDALEITE_OMNITOOL));
        });

        // Inject weapons + armor after the Netherite group in the Combat tab
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.insertAfter(Items.NETHERITE_AXE,
                new ItemStack(LONSDALEITE_SHORT_SWORD),
                new ItemStack(PERFECT_LONSDALEITE_SHORT_SWORD),
                new ItemStack(LONSDALEITE_SWORD),
                new ItemStack(PERFECT_LONSDALEITE_SWORD),
                new ItemStack(LONSDALEITE_WAR_AXE),
                new ItemStack(PERFECT_LONSDALEITE_WAR_AXE),
                new ItemStack(LONSDALEITE_SPEAR),
                new ItemStack(PERFECT_LONSDALEITE_SPEAR),
                new ItemStack(LONSDALEITE_MACE));
            output.insertAfter(Items.NETHERITE_BOOTS,
                new ItemStack(LONSDALEITE_HELMET),
                new ItemStack(LONSDALEITE_CHESTPLATE),
                new ItemStack(LONSDALEITE_LEGGINGS),
                new ItemStack(LONSDALEITE_BOOTS),
                new ItemStack(PERFECT_LONSDALEITE_HELMET),
                new ItemStack(PERFECT_LONSDALEITE_CHESTPLATE),
                new ItemStack(PERFECT_LONSDALEITE_LEGGINGS),
                new ItemStack(PERFECT_LONSDALEITE_BOOTS));
        });
    }
}
