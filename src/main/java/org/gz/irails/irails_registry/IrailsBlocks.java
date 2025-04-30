package org.gz.irails.irails_registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.gz.irails.Irails;
import org.gz.irails.irails_registry.irails_customs.PoweredRailWithRedstone;
import org.gz.irails.irails_registry.irails_customs.PoweredTurnableRail;

import java.util.function.Function;

public class IrailsBlocks {
    public static final Block ALWAYS_POWERED_RAIL = register("always_powered_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL));
    public static final Block POWERED_RAIL_WITH_REDSTONE = register("powered_rail_with_redstone", PoweredRailWithRedstone::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL));
    public static final Block ACTIVATOR_RAIL_WITH_DETECTOR = register("activator_rail_with_detector", DetectorRailBlock::new, AbstractBlock.Settings.copy(Blocks.ACTIVATOR_RAIL));

    public static final Block POWERED_TURNABLE_RAIL = register("powered_turnable_rail", PoweredTurnableRail::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL));
    public static final Block ALWAYS_POWERED_TURNABLE_RAIL = register("always_powered_turnable_rail", PoweredTurnableRail::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL));

    public static final Block LIGHT_POWERED_RAIL = register("light_powered_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15));
    public static final Block LIGHT_ALWAYS_POWERED_RAIL = register("light_always_powered_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15));
    public static final Block LIGHT_POWERED_RAIL_WITH_REDSTONE = register("light_powered_rail_with_redstone", PoweredRailWithRedstone::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15));

    public static final Block UNDERWATER_RAIL = register("underwater_rail", RailBlock::new, AbstractBlock.Settings.copy(Blocks.RAIL));
    public static final Block UNDERWATER_POWERED_RAIL = register("underwater_powered_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL));
    public static final Block UNDERWATER_ALWAYS_POWERED_RAIL = register("underwater_always_powered_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL));
    public static final Block UNDERWATER_DETECTOR_RAIL = register("underwater_detector_rail", DetectorRailBlock::new, AbstractBlock.Settings.copy(Blocks.DETECTOR_RAIL));
    public static final Block UNDERWATER_ACTIVATOR_RAIL = register("underwater_activator_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.ACTIVATOR_RAIL));
    public static final Block UNDERWATER_POWERED_RAIL_WITH_REDSTONE = register("underwater_powered_rail_with_redstone", PoweredRailWithRedstone::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL));
    public static final Block UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR = register("underwater_activator_rail_with_detector", DetectorRailBlock::new, AbstractBlock.Settings.copy(Blocks.ACTIVATOR_RAIL));

    public static final Block UNDERWATER_POWERED_TURNABLE_RAIL = register("underwater_powered_turnable_rail", PoweredTurnableRail::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL));
    public static final Block UNDERWATER_ALWAYS_POWERED_TURNABLE_RAIL = register("underwater_always_powered_turnable_rail", PoweredTurnableRail::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL));

    public static final Block LIGHT_UNDERWATER_POWERED_RAIL = register("light_underwater_powered_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15));
    public static final Block LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL = register("light_underwater_always_powered_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15));
    public static final Block LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE = register("light_underwater_powered_rail_with_redstone", PoweredRailWithRedstone::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15));



    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        Block block = blockFactory.apply(settings);
        if (Irails.isClient() && block instanceof AbstractRailBlock) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        }
        return Registry.register(Registries.BLOCK, Identifier.of(Irails.MOD_ID, name), block);
    }

    public static void registerRtsBlocks() {
        Irails.LOGGER.info("Registering Irails Blocks for " + Irails.MOD_ID);
    }
}
