package com.kestalkayden.lonsdaleite;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import com.kestalkayden.lonsdaleite.materials.KestalToolMaterial;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Axe;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Hoe;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Pickaxe;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Shovel;
import com.kestalkayden.lonsdaleite.items.tools.Lonsdaleite_Sword;


public class Lonsdaleite implements ModInitializer {

    // Item Group
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier("lonsdaleite", "item_group"),
            () -> new ItemStack(Lonsdaleite.REFINED_LONSDALEITE));

    // Ores / Gem
    public static final Item RAW_LONSDALEITE = new Item(new Item.Settings().group(Lonsdaleite.ITEM_GROUP));
    public static final Item PREPARED_LONSDALEITE = new Item(new Item.Settings().group(Lonsdaleite.ITEM_GROUP));
    public static final Item REFINED_LONSDALEITE = new Item(new Item.Settings().group(Lonsdaleite.ITEM_GROUP));

    // Tools
    public static final Item LONSDALEITE_PICKAXE = new Lonsdaleite_Pickaxe(KestalToolMaterial.LONSDALEITE, 2, -2.6F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_SHOVEL = new Lonsdaleite_Shovel(KestalToolMaterial.LONSDALEITE, 2, -2.7F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_AXE = new Lonsdaleite_Axe(KestalToolMaterial.LONSDALEITE, 7, -2.7F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_SWORD = new Lonsdaleite_Sword(KestalToolMaterial.LONSDALEITE, 6, -2.0F, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));
    public static final Item LONSDALEITE_HOE = new Lonsdaleite_Hoe(KestalToolMaterial.LONSDALEITE, 1, -1.5f, (new Item.Settings()).group(Lonsdaleite.ITEM_GROUP));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "raw_lonsdaleite"), RAW_LONSDALEITE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "prepared_lonsdaleite"), PREPARED_LONSDALEITE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "refined_lonsdaleite"), REFINED_LONSDALEITE);

        // Tools
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_pickaxe"), LONSDALEITE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_shovel"), LONSDALEITE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_axe"), LONSDALEITE_AXE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_hoe"), LONSDALEITE_HOE);
        Registry.register(Registry.ITEM, new Identifier("lonsdaleite", "lonsdaleite_sword"), LONSDALEITE_SWORD);
    }
    
}
