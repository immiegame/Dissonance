package com.example.dissonance.common.potions;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.world.Explosion;

public class FlatulenceEffect extends Effect {
    public FlatulenceEffect() {
        super(EffectType.BENEFICIAL, 10379856);
    }

    public void performEffect(LivingEntity entity, int amplifier) {
        entity.getEntityWorld().createExplosion(null, entity.getPosX(), entity.getPosY(), entity.getPosZ(), amplifier, Explosion.Mode.NONE);
        entity.setMotion(0,1,0);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 5 == 0;
    }

}


