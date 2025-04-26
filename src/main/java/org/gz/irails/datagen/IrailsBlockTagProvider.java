package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.gz.irails.Irails;
import org.gz.irails.irails_registry.IrailsBlocks;
import org.gz.irails.irails_registry.IrailsTags;

public class IrailsBlockTagProvider extends FabricTagProvider<Block> {
    protected IrailsBlockTagProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator, Registry.BLOCK, Irails.MOD_ID);
    }

    protected Identifier getBlockId(Block block) {
        return Registry.BLOCK.getId(block);
    }

    @Override
    protected void generateTags() {
        getOrCreateTagBuilder(IrailsTags.POWERED_RAILS)
                .addOptional(getBlockId(IrailsBlocks.ALWAYS_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.POWERED_RAIL_WITH_REDSTONE))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_POWERED_RAIL_WITH_REDSTONE))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_ALWAYS_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_ALWAYS_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_POWERED_RAIL_WITH_REDSTONE));

        getOrCreateTagBuilder(IrailsTags.ACTIVATOR_RAILS)
                .addOptional(getBlockId(IrailsBlocks.ACTIVATOR_RAIL_WITH_DETECTOR))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL));

        getOrCreateTagBuilder(IrailsTags.UNDERWATER_RAILS)
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_ALWAYS_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_DETECTOR_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_POWERED_RAIL_WITH_REDSTONE))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE));


        getOrCreateTagBuilder(BlockTags.RAILS)
                .addTag(IrailsTags.ACTIVATOR_RAILS)
                .addTag(IrailsTags.POWERED_RAILS)
                .addTag(IrailsTags.UNDERWATER_RAILS);
    }
}
