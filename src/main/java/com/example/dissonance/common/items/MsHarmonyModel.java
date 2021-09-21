package com.example.dissonance.common.items;

import com.example.dissonance.Dissonance;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class MsHarmonyModel extends SwordItem {

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(stack, world, list, flag);
        list.add(new StringTextComponent("Peak elegance"));
    }

    public static IItemTier MsHarmonyTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return -1;
        }

        @Override
        public float getEfficiency() {
            return 1;
        }

        @Override
        public float getAttackDamage() {
            return 55.f;
        }

        @Override
        public int getHarvestLevel() {
            return 25;
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
    public MsHarmonyModel() {
        super(MsHarmonyTier, (int) MsHarmonyTier.getAttackDamage(), 16, new Properties()
                .group(Dissonance.DISSONANCE)
                .maxStackSize(1)
                .isImmuneToFire()
                .rarity(Rarity.RARE)
        );
    }
}
