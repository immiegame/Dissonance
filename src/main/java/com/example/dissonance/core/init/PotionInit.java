package com.example.dissonance.core.init;

import com.example.dissonance.Dissonance;
import com.example.dissonance.common.potions.FlatulenceEffect;
import net.minecraft.potion.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PotionInit {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Dissonance.MOD_ID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, Dissonance.MOD_ID);

    public static final RegistryObject<Effect> FLATULENCE_EFFECT = EFFECTS.register("flatulence", FlatulenceEffect::new);

    public static final RegistryObject<Potion> FLATULENCE_POTION = POTIONS.register("flatulence",
            () -> new Potion(new EffectInstance(FLATULENCE_EFFECT.get(), 200, 0)));


}
