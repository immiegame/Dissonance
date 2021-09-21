package com.example.dissonance.common.items;

import com.example.dissonance.Dissonance;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.List;

public class DissonantDestructionPickaxeModel extends PickaxeItem {

    public boolean isOP;

    public void setIsOP(boolean bool){
        isOP = bool;
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (entityIn instanceof PlayerEntity) {
            setPlayerOP((PlayerEntity) entityIn);
        }
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
        player.abilities.allowFlying = false;
        player.abilities.isFlying = false;
        player.sendPlayerAbilities();
        return true;
    }

    private void setPlayerOP(PlayerEntity player) {
        if (!player.isCreative() && !player.isSpectator()) {
            player.abilities.allowFlying = isOP;
            if(isOP == false) {
                player.abilities.isFlying = false;
            }
            player.sendPlayerAbilities();
            if(isOP) {
                player.getFoodStats().addStats(20,20);
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(stack, world, list, flag);
        String ToggleOPText = "Utility mode is ";
        ToggleOPText += isOP ? "Enabled" : "Disabled";
        list.add(new StringTextComponent(ToggleOPText));
        list.add(new StringTextComponent("honungos"));
        list.add(new StringTextComponent("Consuming toggles Utility mode (flight and no hunger)"));

    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    public static IItemTier DissonantTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return -1;
        }

        @Override
        public float getEfficiency() {
            return 9999;
        }

        @Override
        public float getAttackDamage() {
            return 111.f;
        }

        @Override
        public int getHarvestLevel() {
            return 25;
        }

        @Override
        public int getEnchantability() {
            return 50;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return null;
        }
    };

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity) {
            if(!world.isRemote()) {
                setIsOP(isOP ? false : true);
                String chatPrint = "Utility mode is ";
                chatPrint += isOP ? "Enabled" : "Disabled";
                ((PlayerEntity)entityLiving).sendMessage((ITextComponent)new StringTextComponent(chatPrint), entityLiving.getUniqueID());
            }
        }
        return(stack);
    }

    public DissonantDestructionPickaxeModel() {
        super(DissonantTier, DissonantTier.getMaxUses(), 16, new Properties()
                .group(Dissonance.DISSONANCE)
                .maxStackSize(1)
                .isImmuneToFire()
                .addToolType(ToolType.PICKAXE, DissonantTier.getHarvestLevel())
                .addToolType(ToolType.SHOVEL, DissonantTier.getHarvestLevel())
                .addToolType(ToolType.AXE, DissonantTier.getHarvestLevel())
                .addToolType(ToolType.HOE, DissonantTier.getHarvestLevel())
                .rarity(Rarity.EPIC)
                .food(new Food.Builder()
                        .setAlwaysEdible()
                        .fastToEat()
                        .build())
        );

        setIsOP(true);
    }
}
