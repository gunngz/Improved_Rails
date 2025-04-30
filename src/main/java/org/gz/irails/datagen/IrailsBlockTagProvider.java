package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import org.gz.irails.irails_registry.IrailsBlocks;
import org.gz.irails.irails_registry.IrailsTags;

import java.util.concurrent.CompletableFuture;

public class IrailsBlockTagProvider extends TagProvider<Block> {
    public IrailsBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookupFuture) {
        super(output, RegistryKeys.BLOCK, lookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(IrailsTags.ALWAYS_POWERED_RAILS)
                .addOptional(getBlockId(IrailsBlocks.ALWAYS_POWERED_TURNABLE_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_ALWAYS_POWERED_TURNABLE_RAIL))
                .addOptional(getBlockId(IrailsBlocks.ALWAYS_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.POWERED_RAIL_WITH_REDSTONE))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_ALWAYS_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_ALWAYS_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_POWERED_RAIL_WITH_REDSTONE));

        getOrCreateTagBuilder(IrailsTags.POWERED_TURNABLE_RAILS)
                .addOptional(getBlockId(IrailsBlocks.POWERED_TURNABLE_RAIL))
                .addOptional(getBlockId(IrailsBlocks.ALWAYS_POWERED_TURNABLE_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_POWERED_TURNABLE_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_ALWAYS_POWERED_TURNABLE_RAIL));

        getOrCreateTagBuilder(IrailsTags.POWERED_RAILS)
                .addTag(IrailsTags.POWERED_TURNABLE_RAILS)
                .addTag(IrailsTags.ALWAYS_POWERED_RAILS)
                .addOptional(getBlockId(Blocks.POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_POWERED_RAIL_WITH_REDSTONE))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_POWERED_RAIL))
                .addOptional(getBlockId(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL));

        getOrCreateTagBuilder(IrailsTags.ACTIVATOR_RAILS)
                .addOptional(getBlockId(Blocks.ACTIVATOR_RAIL))
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
                .addOptional(getBlockId(IrailsBlocks.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_ALWAYS_POWERED_TURNABLE_RAIL))
                .addOptional(getBlockId(IrailsBlocks.UNDERWATER_POWERED_TURNABLE_RAIL));

        getOrCreateTagBuilder(BlockTags.RAILS)
                .addTag(IrailsTags.ACTIVATOR_RAILS)
                .addTag(IrailsTags.POWERED_RAILS)
                .addTag(IrailsTags.UNDERWATER_RAILS);
    }

    protected Identifier getBlockId(Block block) {
        return Registries.BLOCK.getId(block);
    }
}
