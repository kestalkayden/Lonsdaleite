package com.kestalkayden.lonsdaleite.items.tools;

import com.kestalkayden.lonsdaleite.materials.LonsdaleiteToolMaterials;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Perfect_Lonsdaleite_Omnitool extends Item {
    private final ToolMaterial material;

    public Perfect_Lonsdaleite_Omnitool(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(settings.maxDamage(material.durability()));
        this.material = material;
    }

    @Override
    public boolean isCorrectForDrops(ItemStack stack, BlockState state) {
        return Items.NETHERITE_PICKAXE.isCorrectForDrops(stack, state) ||
               Items.NETHERITE_AXE.isCorrectForDrops(stack, state) ||
               Items.NETHERITE_SHOVEL.isCorrectForDrops(stack, state) ||
               Items.NETHERITE_HOE.isCorrectForDrops(stack, state) ||
               Items.NETHERITE_SWORD.isCorrectForDrops(stack, state);
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        if (state.isIn(BlockTags.PICKAXE_MINEABLE) ||
            state.isIn(BlockTags.AXE_MINEABLE) ||
            state.isIn(BlockTags.SHOVEL_MINEABLE) ||
            state.isIn(BlockTags.HOE_MINEABLE) ||
            state.isIn(BlockTags.SWORD_EFFICIENT)) {
            return LonsdaleiteToolMaterials.getMiningSpeed(this.material);
        }
        return 1.0F;
    }

    public boolean isSuitableFor(BlockState state) {
        return state.isIn(BlockTags.PICKAXE_MINEABLE) ||
               state.isIn(BlockTags.AXE_MINEABLE) ||
               state.isIn(BlockTags.SHOVEL_MINEABLE) ||
               state.isIn(BlockTags.HOE_MINEABLE) ||
               state.isIn(BlockTags.SWORD_EFFICIENT);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, miner.getPreferredEquipmentSlot(stack));
        }
        return true;
    }

    public int getEnchantability() {
        return LonsdaleiteToolMaterials.getEnchantability(this.material);
    }
}
