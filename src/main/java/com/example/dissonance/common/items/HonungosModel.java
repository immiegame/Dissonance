package com.example.dissonance.common.items;

import com.example.dissonance.Dissonance;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MovingPistonBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class HonungosModel extends PickaxeItem {

    public boolean isOP;

    public void setIsOP(boolean bool){
        isOP = bool;
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(stack, world, list, flag);
        String ToggleOPText = "God mode is ";
        ToggleOPText += isOP ? "Enabled" : "Disabled";
        list.add(new StringTextComponent(ToggleOPText));
        list.add(new StringTextComponent(""));
        list.add(new StringTextComponent("  The Mighty Pointy Stick"));
        list.add(new StringTextComponent("+ Dissonant Destruction Pickaxe"));
        list.add(new StringTextComponent("==============================="));
        list.add(new StringTextComponent("  Honungos!!!!!!!"));
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
        player.abilities.disableDamage = false;
        player.sendPlayerAbilities();
        return true;
    }

    private void setPlayerOP(PlayerEntity player) {
        if (!player.isCreative() && !player.isSpectator()) {
            player.abilities.allowFlying = isOP;
            player.abilities.disableDamage = isOP;
            if(isOP == false) {
                player.abilities.isFlying = false;
            }
            player.sendPlayerAbilities();

            if(isOP) {
                player.getFoodStats().addStats(20,20);
                player.setHealth((player).getMaxHealth());
            }
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.onKillCommand();
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    public static IItemTier HonungosTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return -1;
        }

        @Override
        public float getEfficiency() {
            return 10000;
        }

        @Override
        public float getAttackDamage() {
            return 100000F;
        }

        @Override
        public int getHarvestLevel() {
            return 30;
        }

        @Override
        public int getEnchantability() {
            return 100;
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
                String chatPrint = "God mode is ";
                chatPrint += isOP ? "Enabled" : "Disabled";
                ((PlayerEntity)entityLiving).sendMessage((ITextComponent)new StringTextComponent(chatPrint), entityLiving.getUniqueID());
            }
        }
        return(stack);
    }

    public HonungosModel() {
        super(HonungosTier, HonungosTier.getMaxUses(), 16, new Properties()
                .group(Dissonance.DISSONANCE)
                .maxStackSize(1)
                .isImmuneToFire()
                .addToolType(ToolType.PICKAXE, HonungosTier.getHarvestLevel())
                .addToolType(ToolType.SHOVEL, HonungosTier.getHarvestLevel())
                .addToolType(ToolType.AXE, HonungosTier.getHarvestLevel())
                .addToolType(ToolType.HOE, HonungosTier.getHarvestLevel())
                .rarity(Rarity.EPIC)
                .food(new Food.Builder()
                        .setAlwaysEdible()
                        .fastToEat()
                        .build())
        );

        setIsOP(true);
    }
}
