package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import org.gz.irails.irails_registry.IrailsBlocks;
import org.gz.irails.irails_registry.IrailsItems;

public class IrailsLangProvider extends FabricLanguageProvider {
    protected IrailsLangProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateTranslations(TranslationBuilder gen) {
        gen.add(IrailsBlocks.ALWAYS_POWERED_RAIL, "Always Powered Rail");
        gen.add(IrailsBlocks.POWERED_RAIL_WITH_REDSTONE, "Powered Rail with Redstone");
        gen.add(IrailsBlocks.ACTIVATOR_RAIL_WITH_DETECTOR, "Activator Rail with Detector");

        gen.add(IrailsBlocks.UNDERWATER_RAIL, "Underwater Rail");
        gen.add(IrailsBlocks.UNDERWATER_POWERED_RAIL, "Underwater Powered Rail");
        gen.add(IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL, "Underwater Activator Rail");
        gen.add(IrailsBlocks.UNDERWATER_ALWAYS_POWERED_RAIL, "Underwater Always Powered Rail");
        gen.add(IrailsBlocks.UNDERWATER_DETECTOR_RAIL, "Underwater Detector Rail");
        gen.add(IrailsBlocks.UNDERWATER_POWERED_RAIL_WITH_REDSTONE, "Underwater Powered Rail with Redstone");
        gen.add(IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR, "Underwater Activator Rail with Detector");

        gen.add(IrailsBlocks.LIGHT_POWERED_RAIL, "Light Powered Rail");
        gen.add(IrailsBlocks.LIGHT_ALWAYS_POWERED_RAIL, "Light Always Powered Rail");
        gen.add(IrailsBlocks.LIGHT_POWERED_RAIL_WITH_REDSTONE, "Light Powered Rail with Redstone");

        gen.add(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL, "Light Underwater Powered Rail");
        gen.add(IrailsBlocks.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL, "Light Underwater Always Powered Rail");
        gen.add(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE, "Light Underwater Powered Rail with Redstone");

        gen.add(IrailsItems.LIGHT_WAND, "Light Wand");
        gen.add(IrailsItems.UNDERWATER_WAND, "Underwater Wand");

        gen.add("text.irails.light_wand.tooltip1", "Right click on a rail to change it to a light rail.");
        gen.add("text.irails.light_wand.tooltip2", "(Requires a coal in inventory)");

        gen.add("text.irails.underwater_wand.tooltip1", "Right click on a rail to change it to an underwater rail.");
        gen.add("text.irails.underwater_wand.tooltip2", "(Requires a prismarine shard in inventory)");

        gen.add("text.irails.light_wand.no_coal", "You need a coal in your inventory to use this wand.");
        gen.add("text.irails.light_wand.no_corresponding_underwater_rail", "No corresponding underwater rail found.");
        gen.add("text.irails.underwater_wand.no_prismarine_shard", "You need a prismarine shard in your inventory to use this wand.");
        gen.add("text.irails.underwater_wand.no_corresponding_underwater_rail", "No corresponding underwater rail found.");
    }
}
