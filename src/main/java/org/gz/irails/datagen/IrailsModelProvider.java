package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import org.gz.irails.irails_registry.IrailsBlocks;
import org.gz.irails.irails_registry.IrailsItems;

public class IrailsModelProvider extends FabricModelProvider {
    public IrailsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) {
        gen.registerStraightRail(IrailsBlocks.ACTIVATOR_RAIL_WITH_DETECTOR);
        gen.registerStraightRail(IrailsBlocks.ALWAYS_POWERED_RAIL);
        gen.registerStraightRail(IrailsBlocks.POWERED_RAIL_WITH_REDSTONE);

        gen.registerTurnableRail(IrailsBlocks.UNDERWATER_RAIL);
        gen.registerStraightRail(IrailsBlocks.UNDERWATER_POWERED_RAIL);
        gen.registerStraightRail(IrailsBlocks.UNDERWATER_ALWAYS_POWERED_RAIL);
        gen.registerStraightRail(IrailsBlocks.UNDERWATER_DETECTOR_RAIL);
        gen.registerStraightRail(IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL);
        gen.registerStraightRail(IrailsBlocks.UNDERWATER_POWERED_RAIL_WITH_REDSTONE);
        gen.registerStraightRail(IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR);

        gen.registerStraightRail(IrailsBlocks.LIGHT_POWERED_RAIL);
        gen.registerStraightRail(IrailsBlocks.LIGHT_ALWAYS_POWERED_RAIL);
        gen.registerStraightRail(IrailsBlocks.LIGHT_POWERED_RAIL_WITH_REDSTONE);

        gen.registerStraightRail(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL);
        gen.registerStraightRail(IrailsBlocks.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL);
        gen.registerStraightRail(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator gen) {
        gen.register(IrailsItems.LIGHT_WAND, Models.HANDHELD);
        gen.register(IrailsItems.UNDERWATER_WAND, Models.HANDHELD);
    }
}
