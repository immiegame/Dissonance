package com.example.dissonance.common.items;

import com.example.dissonance.Dissonance;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class HarmonyHyperPickaxeModel extends PickaxeItem {

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(stack, world, list, flag);
        list.add(new StringTextComponent("Happy Paxel :)"));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    public static IItemTier HarmonyTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return -1;
        }

        @Override
        public float getEfficiency() {
            return 90;
        }

        @Override
        public float getAttackDamage() {
            return 30;
        }

        @Override
        public int getHarvestLevel() {
            return 20;
        }

        @Override
        public int getEnchantability() {
            return 35;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return null;
        }
    };

    public HarmonyHyperPickaxeModel() {
        super(HarmonyTier, HarmonyTier.getMaxUses(), 16, new Properties()
                .group(Dissonance.DISSONANCE)
                .maxStackSize(1)
                .isImmuneToFire()
                .addToolType(ToolType.PICKAXE, HarmonyTier.getHarvestLevel())
                .addToolType(ToolType.SHOVEL, HarmonyTier.getHarvestLevel())
                .addToolType(ToolType.AXE, HarmonyTier.getHarvestLevel())
                .addToolType(ToolType.HOE, HarmonyTier.getHarvestLevel())
                .rarity(Rarity.RARE)
        );
    }
}
