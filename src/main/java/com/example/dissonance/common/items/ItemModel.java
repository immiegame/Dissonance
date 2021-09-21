package com.example.dissonance.common.items;

import com.example.dissonance.Dissonance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemModel extends Item {

    public ItemModel() {
        super(new Properties().group(Dissonance.DISSONANCE).isImmuneToFire());
    }
}
