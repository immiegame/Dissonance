package com.example.dissonance.core.init;

import com.example.dissonance.Dissonance;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Dissonance.MOD_ID);

    public static final RegistryObject<Block> HARMONY_BLOCK = BLOCKS.register("harmony_block",
            () -> new Block(AbstractBlock.Properties
                    .create(Material.IRON, MaterialColor.QUARTZ)
                    .hardnessAndResistance(50f, 1000f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(3)
                    .sound(SoundType.METAL)
            ));

    public static final RegistryObject<Block> DISSONANT_BLOCK = BLOCKS.register("dissonant_block",
            () -> new Block(AbstractBlock.Properties
                    .create(Material.IRON, MaterialColor.QUARTZ)
                    .hardnessAndResistance(75f, 1000f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(5)
                    .sound(SoundType.METAL)
            ));
}
