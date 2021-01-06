package com.kestalkayden.lonsdaleite;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import com.kestalkayden.lonsdaleite.materials.KestalArmorMaterial;
import com.kestalkayden.lonsdaleite.materials.KestalToolMaterial;
import com.kestalkayden.lonsdaleite.items.armor.Lonsdaleite_Armor;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Axe;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Hoe;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Pickaxe;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Short_Sword;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Omnitool;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Shovel;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Sword;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Axe;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Hoe;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Omnitool;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Pickaxe;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Short_Sword;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Shovel;
import com.kestalkayden.lonsdaleite.items.tools.Perfect_Lonsdaleite_Sword;

public class Lonsdaleite implements ModInitializer {

    // Item Group
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier("lonsdaleite", "item_group"),
            () -> new ItemStack(Lonsdaleite.REFINED_LONSDALEITE));
    // Ores / Gem
    public static final Item RAW_LONSDALEITE = new Item(new Item.Settings().group(Lonsdaleite.ITEM_GROUP));
    public static final Item PREPARED_LONSDALEITE = new Item(new Item.Settings().group(Lonsdaleite.ITEM_GROUP));
    public static final Item REFINED_LONSDALEITE = new Item(new Item.Settings().group(Lonsdaleite.ITEM_GROUP));    
    public static final Item PERFECT_LONSDALEITE = new Item(new Item.Settings().group(Lonsdaleite.ITEM_GROUP));


    // Tools
    public static final Item LONSDALEITE_PICKAXE = new Lonsdaleite_Pickaxe(KestalToolMaterial.LONSDALEITE, 2, -2.6F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_SHOVEL = new Lonsdaleite_Shovel(KestalToolMaterial.LONSDALEITE, 2, -2.7F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_AXE = new Lonsdaleite_Axe(KestalToolMaterial.LONSDALEITE, 7, -2.5F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_SWORD = new Lonsdaleite_Sword(KestalToolMaterial.LONSDALEITE, 6, -2.0F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_SHORT_SWORD = new Lonsdaleite_Short_Sword(KestalToolMaterial.LONSDALEITE, 3, -1.1F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_HOE = new Lonsdaleite_Hoe(KestalToolMaterial.LONSDALEITE, 1, -1.5f, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_OMNITOOL = new Lonsdaleite_Omnitool(KestalToolMaterial.LONSDALEITE, 3, -1.5f, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));

    public static final Item PERFECT_LONSDALEITE_PICKAXE = new Perfect_Lonsdaleite_Pickaxe(KestalToolMaterial.PERFECT_LONSDALEITE, 2, -2.4F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item PERFECT_LONSDALEITE_SHOVEL = new Perfect_Lonsdaleite_Shovel(KestalToolMaterial.PERFECT_LONSDALEITE, 2, -2.5F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item PERFECT_LONSDALEITE_AXE = new Perfect_Lonsdaleite_Axe(KestalToolMaterial.PERFECT_LONSDALEITE, 7, -2.3F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item PERFECT_LONSDALEITE_SWORD = new Perfect_Lonsdaleite_Sword(KestalToolMaterial.PERFECT_LONSDALEITE, 6, -1.8F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item PERFECT_LONSDALEITE_SHORT_SWORD = new Perfect_Lonsdaleite_Short_Sword(KestalToolMaterial.PERFECT_LONSDALEITE, 3, -1.0F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item PERFECT_LONSDALEITE_HOE = new Perfect_Lonsdaleite_Hoe(KestalToolMaterial.PERFECT_LONSDALEITE, 1, -1.2f, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item PERFECT_LONSDALEITE_OMNITOOL = new Perfect_Lonsdaleite_Omnitool(KestalToolMaterial.PERFECT_LONSDALEITE, 3, -1.2f, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));

    // Armor
    public static final Item LONSDALEITE_HELMET = new Lonsdaleite_Armor(KestalArmorMaterial.LONSDALEITE, EquipmentSlot.HEAD, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_CHEST = new Lonsdaleite_Armor(KestalArmorMaterial.LONSDALEITE, EquipmentSlot.CHEST, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_LEGGINGS = new Lonsdaleite_Armor(KestalArmorMaterial.LONSDALEITE, EquipmentSlot.LEGS, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_BOOTS = new Lonsdaleite_Armor(KestalArmorMaterial.LONSDALEITE, EquipmentSlot.FEET, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));

    public static final Item PERFECT_LONSDALEITE_HELMET = new Lonsdaleite_Armor(KestalArmorMaterial.PERFECT_LONSDALEITE, EquipmentSlot.HEAD, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item PERFECT_LONSDALEITE_CHEST = new Lonsdaleite_Armor(KestalArmorMaterial.PERFECT_LONSDALEITE, EquipmentSlot.CHEST, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item PERFECT_LONSDALEITE_LEGGINGS = new Lonsdaleite_Armor(KestalArmorMaterial.PERFECT_LONSDALEITE, EquipmentSlot.LEGS, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item PERFECT_LONSDALEITE_BOOTS = new Lonsdaleite_Armor(KestalArmorMaterial.PERFECT_LONSDALEITE, EquipmentSlot.FEET, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));


    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "raw_lonsdaleite"), RAW_LONSDALEITE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "prepared_lonsdaleite"), PREPARED_LONSDALEITE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "refined_lonsdaleite"), REFINED_LONSDALEITE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite"), PERFECT_LONSDALEITE);

        // Tools
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_omnitool"), LONSDALEITE_OMNITOOL);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_pickaxe"), LONSDALEITE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_shovel"), LONSDALEITE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_axe"), LONSDALEITE_AXE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_hoe"), LONSDALEITE_HOE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_sword"), LONSDALEITE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_short_sword"), LONSDALEITE_SHORT_SWORD);


        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_pickaxe"), PERFECT_LONSDALEITE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_shovel"), PERFECT_LONSDALEITE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_axe"), PERFECT_LONSDALEITE_AXE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_hoe"), PERFECT_LONSDALEITE_HOE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_sword"), PERFECT_LONSDALEITE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_short_sword"), PERFECT_LONSDALEITE_SHORT_SWORD);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_omnitool"), PERFECT_LONSDALEITE_OMNITOOL);

        // Armour
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_helmet"), LONSDALEITE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_chest"), LONSDALEITE_CHEST);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_leggings"), LONSDALEITE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_boots"), LONSDALEITE_BOOTS);
        
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_helmet"), PERFECT_LONSDALEITE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_chest"), PERFECT_LONSDALEITE_CHEST);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_leggings"), PERFECT_LONSDALEITE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "perfect_lonsdaleite_boots"), PERFECT_LONSDALEITE_BOOTS);
    }
    
}
