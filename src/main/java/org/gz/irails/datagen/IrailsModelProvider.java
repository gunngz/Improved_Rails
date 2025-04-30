package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
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

        registerPoweredTurnableRail(gen, IrailsBlocks.POWERED_TURNABLE_RAIL);
        registerPoweredTurnableRail(gen, IrailsBlocks.UNDERWATER_POWERED_TURNABLE_RAIL);
        registerPoweredTurnableRail(gen, IrailsBlocks.ALWAYS_POWERED_TURNABLE_RAIL);
        registerPoweredTurnableRail(gen, IrailsBlocks.UNDERWATER_ALWAYS_POWERED_TURNABLE_RAIL);

        gen.registerStraightRail(IrailsBlocks.LIGHT_POWERED_RAIL);
        gen.registerStraightRail(IrailsBlocks.LIGHT_ALWAYS_POWERED_RAIL);
        gen.registerStraightRail(IrailsBlocks.LIGHT_POWERED_RAIL_WITH_REDSTONE);
        gen.registerStraightRail(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL);
        gen.registerStraightRail(IrailsBlocks.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL);
        gen.registerStraightRail(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE);

    }

    private void registerPoweredTurnableRail(BlockStateModelGenerator gen, Block rail) {
        TextureMap originalT = TextureMap.rail(rail);
        TextureMap cornerT = TextureMap.rail(TextureMap.getSubId(rail, "_corner"));
        TextureMap onT = TextureMap.rail(TextureMap.getSubId(rail, "_on"));
        TextureMap cornerOnT = TextureMap.rail(TextureMap.getSubId(rail, "_corner_on"));
        Identifier flatI = Models.RAIL_FLAT.upload(rail, originalT, gen.modelCollector);
        Identifier curvedI = Models.RAIL_CURVED.upload(rail, cornerT, gen.modelCollector);
        Identifier flatOnI = Models.RAIL_FLAT.upload(rail, "_on", onT, gen.modelCollector);
        Identifier curvedOnI = Models.RAIL_CURVED.upload(rail, "_on", cornerOnT, gen.modelCollector);
        Identifier raisedNEI = Models.TEMPLATE_RAIL_RAISED_NE.upload(rail, originalT, gen.modelCollector);
        Identifier raisedNEOnI = Models.TEMPLATE_RAIL_RAISED_NE.upload(rail, "_on", onT, gen.modelCollector);
        Identifier raisedSWI = Models.TEMPLATE_RAIL_RAISED_SW.upload(rail, originalT, gen.modelCollector);
        Identifier raisedSWOnI = Models.TEMPLATE_RAIL_RAISED_SW.upload(rail, "_on", onT, gen.modelCollector);
        gen.registerItemModel(rail);
        gen.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(rail).coordinate(
                        BlockStateVariantMap.create(Properties.POWERED, Properties.RAIL_SHAPE).register((on, shape) -> switch (shape) {
                            case NORTH_SOUTH ->
                                    BlockStateVariant.create().put(VariantSettings.MODEL, on ? flatOnI : flatI);
                            case EAST_WEST ->
                                    BlockStateVariant.create().put(VariantSettings.MODEL, on ? flatOnI : flatI).put(VariantSettings.Y, VariantSettings.Rotation.R90);
                            case NORTH_EAST ->
                                    BlockStateVariant.create().put(VariantSettings.MODEL, on ? curvedOnI : curvedI).put(VariantSettings.Y, VariantSettings.Rotation.R270);
                            case NORTH_WEST ->
                                    BlockStateVariant.create().put(VariantSettings.MODEL, on ? curvedOnI : curvedI).put(VariantSettings.Y, VariantSettings.Rotation.R180);
                            case SOUTH_EAST ->
                                    BlockStateVariant.create().put(VariantSettings.MODEL, on ? curvedOnI : curvedI);
                            case SOUTH_WEST ->
                                    BlockStateVariant.create().put(VariantSettings.MODEL, on ? curvedOnI : curvedI).put(VariantSettings.Y, VariantSettings.Rotation.R90);
                            case ASCENDING_EAST ->
                                    BlockStateVariant.create().put(VariantSettings.MODEL, on ? raisedNEOnI : raisedNEI).put(VariantSettings.Y, VariantSettings.Rotation.R90);
                            case ASCENDING_WEST ->
                                    BlockStateVariant.create().put(VariantSettings.MODEL, on ? raisedSWOnI : raisedSWI).put(VariantSettings.Y, VariantSettings.Rotation.R90);
                            case ASCENDING_NORTH ->
                                    BlockStateVariant.create().put(VariantSettings.MODEL, on ? raisedNEOnI : raisedNEI);
                            case ASCENDING_SOUTH ->
                                    BlockStateVariant.create().put(VariantSettings.MODEL, on ? raisedSWOnI : raisedSWI);
                        })
                )
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator gen) {
        gen.register(IrailsItems.LIGHT_WAND, Models.HANDHELD);
        gen.register(IrailsItems.UNDERWATER_WAND, Models.HANDHELD);
    }
}
