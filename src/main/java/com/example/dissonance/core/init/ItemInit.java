package com.example.dissonance.core.init;


import com.example.dissonance.Dissonance;
import com.example.dissonance.common.items.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Dissonance.MOD_ID);

    public static final RegistryObject<Item> HARMONY_INGOT = ITEMS.register("harmony_ingot", ItemModel::new);
    public static final RegistryObject<Item> HARMONY_NUGGET = ITEMS.register("harmony_nugget", ItemModel::new);
    public static final RegistryObject<Item> DISSONANT_NUGGET = ITEMS.register("dissonant_nugget", ItemModel::new);
    public static final RegistryObject<Item> DISSONANT_INGOT = ITEMS.register("dissonant_ingot", ItemModel::new);
    public static final RegistryObject<Item> MR_STICK = ITEMS.register("mr_stick", ItemModel::new);
    public static final RegistryObject<Item> UNSTABLE_CURRENCY = ITEMS.register("unstable_currency", ItemModel::new);
    public static final RegistryObject<Item> FIRST_HARMONY_FRAGMENT = ITEMS.register("first_harmony_fragment", ItemModel::new);
    public static final RegistryObject<Item> SECOND_HARMONY_FRAGMENT = ITEMS.register("second_harmony_fragment", ItemModel::new);
    public static final RegistryObject<Item> THIRD_HARMONY_FRAGMENT = ITEMS.register("third_harmony_fragment", ItemModel::new);
    public static final RegistryObject<Item> FOURTH_HARMONY_FRAGMENT = ITEMS.register("fourth_harmony_fragment", ItemModel::new);
    public static final RegistryObject<Item> FIFTH_HARMONY_FRAGMENT = ITEMS.register("fifth_harmony_fragment", ItemModel::new);
    public static final RegistryObject<Item> SIXTH_HARMONY_FRAGMENT = ITEMS.register("sixth_harmony_fragment", ItemModel::new);
    public static final RegistryObject<Item> SEVENTH_HARMONY_FRAGMENT = ITEMS.register("seventh_harmony_fragment", ItemModel::new);
    public static final RegistryObject<Item> EIGHTH_HARMONY_FRAGMENT = ITEMS.register("eighth_harmony_fragment", ItemModel::new);
    public static final RegistryObject<Item> DISSONANCE_STAR = ITEMS.register("dissonance_star", ItemModel::new);

    public static final RegistryObject<Item> PRIMARY_UNNECESSARY_COMPLEXITY = ITEMS.register("primary_unnecessary_complexity", ItemModel::new);
    public static final RegistryObject<Item> SECONDARY_UNNECESSARY_COMPLEXITY = ITEMS.register("secondary_unnecessary_complexity", ItemModel::new);
    public static final RegistryObject<Item> TERTIARY_UNNECESSARY_COMPLEXITY = ITEMS.register("tertiary_unnecessary_complexity", ItemModel::new);
    public static final RegistryObject<Item> QUATERNARY_UNNECESSARY_COMPLEXITY = ITEMS.register("quaternary_unnecessary_complexity", ItemModel::new);
    public static final RegistryObject<Item> QUINARY_UNNECESSARY_COMPLEXITY = ITEMS.register("quinary_unnecessary_complexity", ItemModel::new);
    public static final RegistryObject<Item> SENARY_UNNECESSARY_COMPLEXITY = ITEMS.register("senary_unnecessary_complexity", ItemModel::new);
    public static final RegistryObject<Item> SEPTENARY_UNNECESSARY_COMPLEXITY = ITEMS.register("septenary_unnecessary_complexity", ItemModel::new);
    public static final RegistryObject<Item> OCTONARY_UNNECESSARY_COMPLEXITY = ITEMS.register("octonary_unnecessary_complexity", ItemModel::new);
    public static final RegistryObject<Item> NONARY_UNNECESSARY_COMPLEXITY = ITEMS.register("nonary_unnecessary_complexity", ItemModel::new);
    public static final RegistryObject<Item> DENARY_UNNECESSARY_COMPLEXITY = ITEMS.register("denary_unnecessary_complexity", ItemModel::new);
    public static final RegistryObject<Item> ELEVENARY_UNNECESSARY_COMPLEXITY = ITEMS.register("elevenary_unnecessary_complexity", ItemModel::new);
    public static final RegistryObject<Item> DUODENARY_UNNECESSARY_COMPLEXITY = ITEMS.register("duodenary_unnecessary_complexity", ItemModel::new);

    public static final RegistryObject<Item> HARMONY_HYPER_PICKAXE = ITEMS.register("harmony_hyper_pickaxe", HarmonyHyperPickaxeModel::new);
    public static final RegistryObject<Item> MS_HARMONY = ITEMS.register("ms_harmony", MsHarmonyModel::new);
    public static final RegistryObject<Item> DISSONANT_DESTRUCTION_PICKAXE = ITEMS.register("dissonant_destruction_pickaxe", DissonantDestructionPickaxeModel::new);
    public static final RegistryObject<Item> THE_MIGHTY_POINTY_STICK = ITEMS.register("the_mighty_pointy_stick", MightyPointyStickModel::new);
    public static final RegistryObject<Item> HONUNGOS = ITEMS.register("honungos", HonungosModel::new);

    public static final RegistryObject<Item> GRANPES = ITEMS.register("granpes", GranpesModel::new);

    public static final RegistryObject<BlockItem> HARMONY_BLOCK = ITEMS.register("harmony_block", () -> new BlockItem(BlockInit.HARMONY_BLOCK.get(), new Item.Properties().group(Dissonance.DISSONANCE).isImmuneToFire()));
    public static final RegistryObject<BlockItem> DISSONANT_BLOCK = ITEMS.register("dissonant_block", () -> new BlockItem(BlockInit.DISSONANT_BLOCK.get(), new Item.Properties().group(Dissonance.DISSONANCE).isImmuneToFire()));




}

