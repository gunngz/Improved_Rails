package org.gz.irails.irails_registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.gz.irails.Irails;
import org.gz.irails.irails_registry.irails_customs.LightWand;
import org.gz.irails.irails_registry.irails_customs.UnderwaterWand;

import java.util.function.BiFunction;
import java.util.function.Function;

public class IrailsItems {
    public static final Item UNDERWATER_WAND = register("underwater_wand", UnderwaterWand::new, new Item.Settings());
    public static final Item LIGHT_WAND = register("light_wand", LightWand::new, new Item.Settings());

    public static final Item ALWAYS_POWERED_RAIL = registerBlockItem("always_powered_rail", BlockItem::new, IrailsBlocks.ALWAYS_POWERED_RAIL, new Item.Settings());
    public static final Item POWERED_RAIL_WITH_REDSTONE = registerBlockItem("powered_rail_with_redstone", BlockItem::new, IrailsBlocks.POWERED_RAIL_WITH_REDSTONE,new Item.Settings());
    public static final Item ACTIVATOR_RAIL_WITH_DETECTOR = registerBlockItem("activator_rail_with_detector", BlockItem::new, IrailsBlocks.ACTIVATOR_RAIL_WITH_DETECTOR, new Item.Settings());

    public static final Item LIGHT_POWERED_RAIL = registerBlockItem("light_powered_rail", BlockItem::new, IrailsBlocks.LIGHT_POWERED_RAIL, new Item.Settings());
    public static final Item LIGHT_ALWAYS_POWERED_RAIL = registerBlockItem("light_always_powered_rail", BlockItem::new, IrailsBlocks.LIGHT_ALWAYS_POWERED_RAIL, new Item.Settings());
    public static final Item LIGHT_POWERED_RAIL_WITH_REDSTONE = registerBlockItem("light_powered_rail_with_redstone", BlockItem::new, IrailsBlocks.LIGHT_POWERED_RAIL_WITH_REDSTONE, new Item.Settings());

    public static final Item UNDERWATER_RAIL = registerBlockItem("underwater_rail", BlockItem::new, IrailsBlocks.UNDERWATER_RAIL, new Item.Settings());
    public static final Item UNDERWATER_POWERED_RAIL = registerBlockItem("underwater_powered_rail", BlockItem::new, IrailsBlocks.UNDERWATER_POWERED_RAIL, new Item.Settings());
    public static final Item UNDERWATER_ALWAYS_POWERED_RAIL = registerBlockItem("underwater_always_powered_rail", BlockItem::new, IrailsBlocks.UNDERWATER_ALWAYS_POWERED_RAIL, new Item.Settings());
    public static final Item UNDERWATER_DETECTOR_RAIL = registerBlockItem("underwater_detector_rail", BlockItem::new, IrailsBlocks.UNDERWATER_DETECTOR_RAIL, new Item.Settings());
    public static final Item UNDERWATER_ACTIVATOR_RAIL = registerBlockItem("underwater_activator_rail", BlockItem::new, IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL, new Item.Settings());
    public static final Item UNDERWATER_POWERED_RAIL_WITH_REDSTONE = registerBlockItem("underwater_powered_rail_with_redstone", BlockItem::new, IrailsBlocks.UNDERWATER_POWERED_RAIL_WITH_REDSTONE, new Item.Settings());
    public static final Item UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR = registerBlockItem("underwater_activator_rail_with_detector", BlockItem::new, IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR, new Item.Settings());

    public static final Item LIGHT_UNDERWATER_POWERED_RAIL = registerBlockItem("light_underwater_powered_rail", BlockItem::new, IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL, new Item.Settings());
    public static final Item LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL = registerBlockItem("light_underwater_always_powered_rail", BlockItem::new, IrailsBlocks.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL, new Item.Settings());
    public static final Item LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE = registerBlockItem("light_underwater_powered_rail_with_redstone", BlockItem::new, IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE, new Item.Settings());


    private static Item register(String name, Function<Item.Settings, Item> blockFactory, Item.Settings settings) {
        return Registry.register(Registries.ITEM, Identifier.of(Irails.MOD_ID, name), blockFactory.apply(settings));
    }

    private static Item registerBlockItem(String name, BiFunction<Block, Item.Settings, Item> blockFactory, Block block, Item.Settings settings) {
        return Registry.register(Registries.ITEM, Identifier.of(Irails.MOD_ID, name), blockFactory.apply(block, settings));
    }

    public static void registerRtsItems() {
        Irails.LOGGER.info("Registering Irails Items for " + Irails.MOD_ID);
    }
}
