package org.gz.irails.irails_registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.gz.irails.Irails;
import org.gz.irails.irails_registry.irails_customs.AlwaysPoweredRail;
import org.gz.irails.irails_registry.irails_customs.PoweredRailWithRedstone;

import java.util.function.Function;

public class IrailsBlocks {
    public static final Block ALWAYS_POWERED_RAIL = cutout(register("always_powered_rail", AlwaysPoweredRail::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL)));
    public static final Block POWERED_RAIL_WITH_REDSTONE = cutout(register("powered_rail_with_redstone", PoweredRailWithRedstone::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL)));
    public static final Block ACTIVATOR_RAIL_WITH_DETECTOR = cutout(register("activator_rail_with_detector", DetectorRailBlock::new, AbstractBlock.Settings.copy(Blocks.ACTIVATOR_RAIL)));

    public static final Block LIGHT_POWERED_RAIL = cutout(register("light_powered_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15)));
    public static final Block LIGHT_ALWAYS_POWERED_RAIL = cutout(register("light_always_powered_rail", AlwaysPoweredRail::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15)));
    public static final Block LIGHT_POWERED_RAIL_WITH_REDSTONE = cutout(register("light_powered_rail_with_redstone", PoweredRailWithRedstone::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15)));

    public static final Block UNDERWATER_RAIL = cutout(register("underwater_rail", RailBlock::new, AbstractBlock.Settings.copy(Blocks.RAIL)));
    public static final Block UNDERWATER_POWERED_RAIL = cutout(register("underwater_powered_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL)));
    public static final Block UNDERWATER_ALWAYS_POWERED_RAIL = cutout(register("underwater_always_powered_rail", AlwaysPoweredRail::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL)));
    public static final Block UNDERWATER_DETECTOR_RAIL = cutout(register("underwater_detector_rail", DetectorRailBlock::new, AbstractBlock.Settings.copy(Blocks.DETECTOR_RAIL)));
    public static final Block UNDERWATER_ACTIVATOR_RAIL = cutout(register("underwater_activator_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.ACTIVATOR_RAIL)));
    public static final Block UNDERWATER_POWERED_RAIL_WITH_REDSTONE = cutout(register("underwater_powered_rail_with_redstone", PoweredRailWithRedstone::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL)));
    public static final Block UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR = cutout(register("underwater_activator_rail_with_detector", DetectorRailBlock::new, AbstractBlock.Settings.copy(Blocks.ACTIVATOR_RAIL)));

    public static final Block LIGHT_UNDERWATER_POWERED_RAIL = cutout(register("light_underwater_powered_rail", PoweredRailBlock::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15)));
    public static final Block LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL = cutout(register("light_underwater_always_powered_rail", AlwaysPoweredRail::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15)));
    public static final Block LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE = cutout(register("light_underwater_powered_rail_with_redstone", PoweredRailWithRedstone::new, AbstractBlock.Settings.copy(Blocks.POWERED_RAIL).luminance(state -> 15)));



    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        return Registry.register(Registry.BLOCK, new Identifier(Irails.MOD_ID, name), blockFactory.apply(settings));
    }

    private static Block cutout(Block block) {
        if (Irails.isClient())
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        return block;
    }

    public static void registerRtsBlocks() {
        Irails.LOGGER.info("Registering Irails Blocks for " + Irails.MOD_ID);
    }
}
