package com.intijir.gildedingot.blocks;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Properties().group(GildedIngot.TAB));
    }
}
