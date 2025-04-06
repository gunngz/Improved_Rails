package org.gz.irails.irails_registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.gz.irails.Irails;

public class IrailsTags {
    public static final TagKey<Block> POWERED_RAILS = TagKey.of(RegistryKeys.BLOCK, new Identifier(Irails.MOD_ID, "powered_rails"));
    public static final TagKey<Block> ACTIVATOR_RAILS = TagKey.of(RegistryKeys.BLOCK, new Identifier(Irails.MOD_ID, "activator_rails"));
    public static final TagKey<Block> UNDERWATER_RAILS = TagKey.of(RegistryKeys.BLOCK, new Identifier(Irails.MOD_ID, "underwater_rails"));

    public static final TagKey<Item> WOOD_STICKS = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "wood_sticks"));
}
