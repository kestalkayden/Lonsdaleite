package com.kestalkayden.lonsdaleite;

import java.util.function.Supplier;

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

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Lonsdaleite.MOD_ID)
public class Lonsdaleite {
    public static final String MOD_ID = "lonsdaleite";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    // Raw materials
    public static final DeferredItem<Item> RAW_LONSDALEITE      = ITEMS.registerSimpleItem("raw_lonsdaleite");
    public static final DeferredItem<Item> PREPARED_LONSDALEITE = ITEMS.registerSimpleItem("prepared_lonsdaleite");
    public static final DeferredItem<Item> REFINED_LONSDALEITE  = ITEMS.registerSimpleItem("refined_lonsdaleite");
    public static final DeferredItem<Item> PERFECT_LONSDALEITE  = ITEMS.registerSimpleItem("perfect_lonsdaleite");

    // Mining tools
    public static final DeferredItem<Lonsdaleite_Pickaxe>         LONSDALEITE_PICKAXE         = ITEMS.registerItem("lonsdaleite_pickaxe",         p -> new Lonsdaleite_Pickaxe(LonsdaleiteToolMaterials.LONSDALEITE, 5, -2.8F, p.pickaxe(LonsdaleiteToolMaterials.LONSDALEITE, 5, -2.8F).enchantable(15)));
    public static final DeferredItem<Perfect_Lonsdaleite_Pickaxe> PERFECT_LONSDALEITE_PICKAXE = ITEMS.registerItem("perfect_lonsdaleite_pickaxe", p -> new Perfect_Lonsdaleite_Pickaxe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 7, -2.7F, p.pickaxe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 7, -2.7F).enchantable(20)));
    public static final DeferredItem<Lonsdaleite_Axe>             LONSDALEITE_AXE             = ITEMS.registerItem("lonsdaleite_axe",             p -> new Lonsdaleite_Axe(LonsdaleiteToolMaterials.LONSDALEITE, 8, -3.0F, p.axe(LonsdaleiteToolMaterials.LONSDALEITE, 8, -3.0F).enchantable(15)));
    public static final DeferredItem<Perfect_Lonsdaleite_Axe>     PERFECT_LONSDALEITE_AXE     = ITEMS.registerItem("perfect_lonsdaleite_axe",     p -> new Perfect_Lonsdaleite_Axe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 11, -2.9F, p.axe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 11, -2.9F).enchantable(20)));
    public static final DeferredItem<Lonsdaleite_Shovel>          LONSDALEITE_SHOVEL          = ITEMS.registerItem("lonsdaleite_shovel",          p -> new Lonsdaleite_Shovel(LonsdaleiteToolMaterials.LONSDALEITE, 4, -3.0F, p.shovel(LonsdaleiteToolMaterials.LONSDALEITE, 4, -3.0F).enchantable(15)));
    public static final DeferredItem<Perfect_Lonsdaleite_Shovel>  PERFECT_LONSDALEITE_SHOVEL  = ITEMS.registerItem("perfect_lonsdaleite_shovel",  p -> new Perfect_Lonsdaleite_Shovel(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 6, -2.9F, p.shovel(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 6, -2.9F).enchantable(20)));
    public static final DeferredItem<Lonsdaleite_Hoe>             LONSDALEITE_HOE             = ITEMS.registerItem("lonsdaleite_hoe",             p -> new Lonsdaleite_Hoe(LonsdaleiteToolMaterials.LONSDALEITE, 2, 0.0F, p.hoe(LonsdaleiteToolMaterials.LONSDALEITE, 2, 0.0F).enchantable(15)));
    public static final DeferredItem<Perfect_Lonsdaleite_Hoe>     PERFECT_LONSDALEITE_HOE     = ITEMS.registerItem("perfect_lonsdaleite_hoe",     p -> new Perfect_Lonsdaleite_Hoe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 3, 0.2F, p.hoe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 3, 0.2F).enchantable(20)));
    public static final DeferredItem<Lonsdaleite_Omnitool>        LONSDALEITE_OMNITOOL        = ITEMS.registerItem("lonsdaleite_omnitool",        p -> new Lonsdaleite_Omnitool(LonsdaleiteToolMaterials.LONSDALEITE, 3, -2.9F, p.pickaxe(LonsdaleiteToolMaterials.LONSDALEITE, 3, -2.9F).enchantable(15)));
    public static final DeferredItem<Perfect_Lonsdaleite_Omnitool> PERFECT_LONSDALEITE_OMNITOOL = ITEMS.registerItem("perfect_lonsdaleite_omnitool", p -> new Perfect_Lonsdaleite_Omnitool(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 5, -2.8F, p.pickaxe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 5, -2.8F).enchantable(20)));

    // Weapons
    public static final DeferredItem<Lonsdaleite_Sword>             LONSDALEITE_SWORD             = ITEMS.registerItem("lonsdaleite_sword",             p -> new Lonsdaleite_Sword(LonsdaleiteToolMaterials.LONSDALEITE, 6, -2.8F, p.sword(LonsdaleiteToolMaterials.LONSDALEITE, 6, -2.8F).enchantable(15)));
    public static final DeferredItem<Perfect_Lonsdaleite_Sword>     PERFECT_LONSDALEITE_SWORD     = ITEMS.registerItem("perfect_lonsdaleite_sword",     p -> new Perfect_Lonsdaleite_Sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 8, -2.7F, p.sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 8, -2.7F).enchantable(20)));
    public static final DeferredItem<Lonsdaleite_Short_Sword>       LONSDALEITE_SHORT_SWORD       = ITEMS.registerItem("lonsdaleite_short_sword",       p -> new Lonsdaleite_Short_Sword(LonsdaleiteToolMaterials.LONSDALEITE, 1, -0.7F, p.sword(LonsdaleiteToolMaterials.LONSDALEITE, 1, -0.7F).enchantable(15)));
    public static final DeferredItem<Perfect_Lonsdaleite_Short_Sword> PERFECT_LONSDALEITE_SHORT_SWORD = ITEMS.registerItem("perfect_lonsdaleite_short_sword", p -> new Perfect_Lonsdaleite_Short_Sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 2, -0.4F, p.sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 2, -0.4F).enchantable(20)));
    public static final DeferredItem<Lonsdaleite_War_Axe>           LONSDALEITE_WAR_AXE           = ITEMS.registerItem("lonsdaleite_war_axe",           p -> new Lonsdaleite_War_Axe(LonsdaleiteToolMaterials.LONSDALEITE, 9, -3.9F, p.sword(LonsdaleiteToolMaterials.LONSDALEITE, 9, -3.9F).enchantable(15)));
    public static final DeferredItem<Perfect_Lonsdaleite_War_Axe>   PERFECT_LONSDALEITE_WAR_AXE   = ITEMS.registerItem("perfect_lonsdaleite_war_axe",   p -> new Perfect_Lonsdaleite_War_Axe(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 13, -3.7F, p.sword(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 13, -3.7F).enchantable(20)));

    // Spears — plain Item; spear() sets durability/repair/enchant from the material + kinetic & piercing components
    public static final DeferredItem<Item> LONSDALEITE_SPEAR         = ITEMS.registerItem("lonsdaleite_spear",         p -> new Item(p.spear(LonsdaleiteToolMaterials.LONSDALEITE, 1.15F, 1.25F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F)));
    public static final DeferredItem<Item> PERFECT_LONSDALEITE_SPEAR = ITEMS.registerItem("perfect_lonsdaleite_spear", p -> new Item(p.spear(LonsdaleiteToolMaterials.PERFECT_LONSDALEITE, 1.15F, 1.35F, 0.4F, 2.5F, 9.0F, 5.5F, 5.1F, 8.75F, 4.6F)));

    // Mace — Lonsdaleite_Mace (vanilla smash attack); stronger melee (+7 base vs vanilla +5), gem-tier durability, breeze-rod handle, repairs with Perfect gems
    public static final DeferredItem<Lonsdaleite_Mace> LONSDALEITE_MACE = ITEMS.registerItem("lonsdaleite_mace",          p -> new Lonsdaleite_Mace(p.rarity(Rarity.EPIC).durability(2640).component(DataComponents.TOOL, MaceItem.createToolProperties()).repairable(LonsdaleiteToolMaterials.REPAIRS_PERFECT_LONSDALEITE_TOOLS).attributes(Lonsdaleite_Mace.createAttributes()).enchantable(20).component(DataComponents.WEAPON, new Weapon(1))));

    // Armor
    public static final DeferredItem<LonsdaleiteArmor> LONSDALEITE_HELMET             = ITEMS.registerItem("lonsdaleite_helmet",             p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE, ArmorType.HELMET, p));
    public static final DeferredItem<LonsdaleiteArmor> LONSDALEITE_CHESTPLATE         = ITEMS.registerItem("lonsdaleite_chestplate",         p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE, ArmorType.CHESTPLATE, p));
    public static final DeferredItem<LonsdaleiteArmor> LONSDALEITE_LEGGINGS           = ITEMS.registerItem("lonsdaleite_leggings",           p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE, ArmorType.LEGGINGS, p));
    public static final DeferredItem<LonsdaleiteArmor> LONSDALEITE_BOOTS              = ITEMS.registerItem("lonsdaleite_boots",              p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.LONSDALEITE, ArmorType.BOOTS, p));
    public static final DeferredItem<LonsdaleiteArmor> PERFECT_LONSDALEITE_HELMET     = ITEMS.registerItem("perfect_lonsdaleite_helmet",     p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE, ArmorType.HELMET, p));
    public static final DeferredItem<LonsdaleiteArmor> PERFECT_LONSDALEITE_CHESTPLATE = ITEMS.registerItem("perfect_lonsdaleite_chestplate", p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE, ArmorType.CHESTPLATE, p));
    public static final DeferredItem<LonsdaleiteArmor> PERFECT_LONSDALEITE_LEGGINGS   = ITEMS.registerItem("perfect_lonsdaleite_leggings",   p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE, ArmorType.LEGGINGS, p));
    public static final DeferredItem<LonsdaleiteArmor> PERFECT_LONSDALEITE_BOOTS      = ITEMS.registerItem("perfect_lonsdaleite_boots",      p -> new LonsdaleiteArmor(LonsdaleiteArmorMaterials.PERFECT_LONSDALEITE, ArmorType.BOOTS, p));

    // Custom creative tab
    public static final Supplier<CreativeModeTab> LONSDALEITE_TAB = TABS.register("lonsdaleite", () ->
        CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.lonsdaleite.item_group"))
            .icon(() -> new ItemStack(REFINED_LONSDALEITE.get()))
            .displayItems((displayContext, entries) -> {
                entries.accept(RAW_LONSDALEITE.get());
                entries.accept(PREPARED_LONSDALEITE.get());
                entries.accept(REFINED_LONSDALEITE.get());
                entries.accept(PERFECT_LONSDALEITE.get());
                entries.accept(LONSDALEITE_PICKAXE.get());
                entries.accept(PERFECT_LONSDALEITE_PICKAXE.get());
                entries.accept(LONSDALEITE_AXE.get());
                entries.accept(PERFECT_LONSDALEITE_AXE.get());
                entries.accept(LONSDALEITE_SHOVEL.get());
                entries.accept(PERFECT_LONSDALEITE_SHOVEL.get());
                entries.accept(LONSDALEITE_HOE.get());
                entries.accept(PERFECT_LONSDALEITE_HOE.get());
                entries.accept(LONSDALEITE_OMNITOOL.get());
                entries.accept(PERFECT_LONSDALEITE_OMNITOOL.get());
                entries.accept(LONSDALEITE_SHORT_SWORD.get());
                entries.accept(PERFECT_LONSDALEITE_SHORT_SWORD.get());
                entries.accept(LONSDALEITE_SWORD.get());
                entries.accept(PERFECT_LONSDALEITE_SWORD.get());
                entries.accept(LONSDALEITE_WAR_AXE.get());
                entries.accept(PERFECT_LONSDALEITE_WAR_AXE.get());
                entries.accept(LONSDALEITE_SPEAR.get());
                entries.accept(PERFECT_LONSDALEITE_SPEAR.get());
                entries.accept(LONSDALEITE_MACE.get());
                entries.accept(LONSDALEITE_HELMET.get());
                entries.accept(LONSDALEITE_CHESTPLATE.get());
                entries.accept(LONSDALEITE_LEGGINGS.get());
                entries.accept(LONSDALEITE_BOOTS.get());
                entries.accept(PERFECT_LONSDALEITE_HELMET.get());
                entries.accept(PERFECT_LONSDALEITE_CHESTPLATE.get());
                entries.accept(PERFECT_LONSDALEITE_LEGGINGS.get());
                entries.accept(PERFECT_LONSDALEITE_BOOTS.get());
            })
            .build());

    public Lonsdaleite(IEventBus modBus) {
        LOGGER.info("Initializing Lonsdaleite Mod");
        ITEMS.register(modBus);
        TABS.register(modBus);
        modBus.addListener(Lonsdaleite::onBuildCreativeTabs);
    }

    private static void onBuildCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.insertAfter(new ItemStack(Items.RAW_GOLD), new ItemStack(RAW_LONSDALEITE.get()),     CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(RAW_LONSDALEITE.get()),     new ItemStack(PREPARED_LONSDALEITE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(PREPARED_LONSDALEITE.get()), new ItemStack(REFINED_LONSDALEITE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(new ItemStack(REFINED_LONSDALEITE.get()), new ItemStack(PERFECT_LONSDALEITE.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        } else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            ItemStack anchor = new ItemStack(Items.NETHERITE_HOE);
            for (DeferredItem<? extends Item> entry : new DeferredItem[] {
                LONSDALEITE_PICKAXE, PERFECT_LONSDALEITE_PICKAXE,
                LONSDALEITE_AXE,     PERFECT_LONSDALEITE_AXE,
                LONSDALEITE_SHOVEL,  PERFECT_LONSDALEITE_SHOVEL,
                LONSDALEITE_HOE,     PERFECT_LONSDALEITE_HOE,
                LONSDALEITE_OMNITOOL, PERFECT_LONSDALEITE_OMNITOOL
            }) {
                ItemStack stack = new ItemStack(entry.get());
                event.insertAfter(anchor, stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                anchor = stack;
            }
        } else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            ItemStack anchor = new ItemStack(Items.NETHERITE_AXE);
            for (DeferredItem<? extends Item> entry : new DeferredItem[] {
                LONSDALEITE_SHORT_SWORD, PERFECT_LONSDALEITE_SHORT_SWORD,
                LONSDALEITE_SWORD,       PERFECT_LONSDALEITE_SWORD,
                LONSDALEITE_WAR_AXE,     PERFECT_LONSDALEITE_WAR_AXE,
                LONSDALEITE_SPEAR,       PERFECT_LONSDALEITE_SPEAR,
                LONSDALEITE_MACE
            }) {
                ItemStack stack = new ItemStack(entry.get());
                event.insertAfter(anchor, stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                anchor = stack;
            }
            ItemStack armorAnchor = new ItemStack(Items.NETHERITE_BOOTS);
            for (DeferredItem<? extends Item> entry : new DeferredItem[] {
                LONSDALEITE_HELMET,     LONSDALEITE_CHESTPLATE,
                LONSDALEITE_LEGGINGS,   LONSDALEITE_BOOTS,
                PERFECT_LONSDALEITE_HELMET,     PERFECT_LONSDALEITE_CHESTPLATE,
                PERFECT_LONSDALEITE_LEGGINGS,   PERFECT_LONSDALEITE_BOOTS
            }) {
                ItemStack stack = new ItemStack(entry.get());
                event.insertAfter(armorAnchor, stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                armorAnchor = stack;
            }
        }
    }
}
