package com.example.dissonance.common.items;

import com.example.dissonance.Dissonance;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class GranpesModel extends Item {

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(stack, world, list, flag);
        list.add(new StringTextComponent("Very satiating!"));
    }


    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity) {
            //entityLiving.addPotionEffect(new EffectInstance(Effects.SATURATION, 12000, 1));

            if(!((PlayerEntity) entityLiving).isCreative()) {
                stack.shrink(1);
            }
        }
        return(stack);
    }

    public GranpesModel() {
        super(new Properties()
                .group(Dissonance.DISSONANCE)
                .isImmuneToFire()
                .rarity(Rarity.EPIC)
                .food(new Food.Builder()
                        .setAlwaysEdible()
                        .fastToEat()
                        .hunger(20)
                        .saturation(400.0f)
                        .build())
        );
    }
}
