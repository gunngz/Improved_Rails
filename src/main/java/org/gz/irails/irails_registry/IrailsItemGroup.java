package org.gz.irails.irails_registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class IrailsItemGroup {
    public static void registerRtsItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(itemGroup -> {
            itemGroup.addAfter(Items.POWERED_RAIL, IrailsItems.ALWAYS_POWERED_RAIL);
            itemGroup.addAfter(IrailsItems.ALWAYS_POWERED_RAIL, IrailsItems.POWERED_RAIL_WITH_REDSTONE);
            itemGroup.addAfter(Items.ACTIVATOR_RAIL, IrailsItems.ACTIVATOR_RAIL_WITH_DETECTOR);

            itemGroup.addAfter(IrailsItems.ACTIVATOR_RAIL_WITH_DETECTOR, IrailsItems.UNDERWATER_RAIL);
            itemGroup.addAfter(IrailsItems.UNDERWATER_RAIL, IrailsItems.UNDERWATER_POWERED_RAIL);
            itemGroup.addAfter(IrailsItems.UNDERWATER_POWERED_RAIL, IrailsItems.UNDERWATER_ALWAYS_POWERED_RAIL);
            itemGroup.addAfter(IrailsItems.UNDERWATER_ALWAYS_POWERED_RAIL, IrailsItems.UNDERWATER_DETECTOR_RAIL);
            itemGroup.addAfter(IrailsItems.UNDERWATER_DETECTOR_RAIL, IrailsItems.UNDERWATER_ACTIVATOR_RAIL);
            itemGroup.addAfter(IrailsItems.UNDERWATER_ACTIVATOR_RAIL, IrailsItems.UNDERWATER_POWERED_RAIL_WITH_REDSTONE);
            itemGroup.addAfter(IrailsItems.UNDERWATER_POWERED_RAIL_WITH_REDSTONE, IrailsItems.UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR);

            itemGroup.addAfter(IrailsItems.UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR, IrailsItems.LIGHT_POWERED_RAIL);
            itemGroup.addAfter(IrailsItems.LIGHT_POWERED_RAIL, IrailsItems.LIGHT_ALWAYS_POWERED_RAIL);
            itemGroup.addAfter(IrailsItems.LIGHT_ALWAYS_POWERED_RAIL, IrailsItems.LIGHT_POWERED_RAIL_WITH_REDSTONE);
            itemGroup.addAfter(IrailsItems.LIGHT_POWERED_RAIL_WITH_REDSTONE, IrailsItems.LIGHT_UNDERWATER_POWERED_RAIL);
            itemGroup.addAfter(IrailsItems.LIGHT_UNDERWATER_POWERED_RAIL, IrailsItems.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL);
            itemGroup.addAfter(IrailsItems.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL, IrailsItems.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE);

            itemGroup.addAfter(IrailsItems.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE, IrailsItems.UNDERWATER_WAND);
            itemGroup.addAfter(IrailsItems.UNDERWATER_WAND, IrailsItems.LIGHT_WAND);
        });
    }
}
