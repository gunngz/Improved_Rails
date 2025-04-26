package org.gz.irails.irails_registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.gz.irails.Irails;

public class IrailsTags {
    public static final TagKey<Block> POWERED_RAILS = TagKey.of(Registry.BLOCK_KEY, new Identifier(Irails.MOD_ID, "powered_rails"));
    public static final TagKey<Block> ACTIVATOR_RAILS = TagKey.of(Registry.BLOCK_KEY, new Identifier(Irails.MOD_ID, "activator_rails"));
    public static final TagKey<Block> UNDERWATER_RAILS = TagKey.of(Registry.BLOCK_KEY, new Identifier(Irails.MOD_ID, "underwater_rails"));

    public static final TagKey<Item> WOOD_STICKS = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "wood_sticks"));
}
