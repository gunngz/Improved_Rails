package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import org.gz.irails.irails_registry.IrailsBlocks;
import org.gz.irails.irails_registry.IrailsBlocks;

public class IrailsLangProvider extends FabricLanguageProvider {
    protected IrailsLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
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

    }
}
