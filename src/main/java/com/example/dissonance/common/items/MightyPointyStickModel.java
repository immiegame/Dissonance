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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class MightyPointyStickModel extends SwordItem {

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
        player.abilities.disableDamage = false;
        player.sendPlayerAbilities();
        return true;
    }

    private void setPlayerOP(PlayerEntity player) {
        if (!player.isCreative() && !player.isSpectator()) {
            player.abilities.disableDamage = isOP;
            player.sendPlayerAbilities();
            if(isOP) {
                player.setHealth((player).getMaxHealth());
            }
        }
    }


    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(stack, world, list, flag);
        String ToggleOPText = "Mighty mode is ";
        ToggleOPText += isOP ? "Enabled" : "Disabled";
        list.add(new StringTextComponent(ToggleOPText));
        list.add(new StringTextComponent("I don't really know what to write here..."));
        list.add(new StringTextComponent("Does /kill on whatever you hit"));
        list.add(new StringTextComponent("Consuming toggles Mighty mode (unkillable)"));
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {

        return super.onItemUse(context);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.onKillCommand();
        return super.hitEntity(stack, target, attacker);
    }

    public static IItemTier MightyTier = new IItemTier() {
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
            return 9999F;
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
                String chatPrint = "Mighty mode is ";
                chatPrint += isOP ? "Enabled" : "Disabled";
                ((PlayerEntity)entityLiving).sendMessage((ITextComponent)new StringTextComponent(chatPrint), entityLiving.getUniqueID());
            }
        }
        return(stack);
    }

    public MightyPointyStickModel () {
        super(MightyTier, (int) MightyTier.getAttackDamage(), 16, new Properties()
                .group(Dissonance.DISSONANCE)
                .maxStackSize(1)
                .isImmuneToFire()
                .rarity(Rarity.EPIC)
                .food(new Food.Builder()
                        .setAlwaysEdible()
                        .fastToEat()
                        .build())
        );

        setIsOP(true);
    }
}
