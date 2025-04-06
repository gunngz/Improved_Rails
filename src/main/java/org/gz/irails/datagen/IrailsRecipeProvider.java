package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import org.gz.irails.irails_registry.IrailsItems;
import org.gz.irails.irails_registry.IrailsTags;

import java.util.function.Consumer;

public class IrailsRecipeProvider extends FabricRecipeProvider {
    public IrailsRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerRegularRails(exporter);
        offerUnderwaterRails(exporter);
    }

    private static void offerUnderwaterRails(Consumer<RecipeJsonProvider> exporter) {
        offerAddPrismarine(exporter, Items.RAIL, IrailsItems.UNDERWATER_RAIL);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, IrailsItems.UNDERWATER_RAIL, 6)
                .input('I', Items.IRON_INGOT)
                .input('P', IrailsTags.WOOD_STICKS)
                .input('R', Items.PRISMARINE_SHARD)
                .pattern("I I")
                .pattern("IPI")
                .pattern("IRI")
                .group("rails")
                .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                .offerTo(exporter, "underwater_rail");

        offerAddPrismarine(exporter, Items.POWERED_RAIL, IrailsItems.UNDERWATER_POWERED_RAIL);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, IrailsItems.UNDERWATER_POWERED_RAIL, 6)
                .input('I', Items.GOLD_INGOT)
                .input('P', IrailsTags.WOOD_STICKS)
                .input('R', Items.PRISMARINE_SHARD)
                .input('K', Items.REDSTONE)
                .pattern("IRI")
                .pattern("IPI")
                .pattern("IKI")
                .group("rails")
                .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                .offerTo(exporter, "underwater_powered_rail");

        offerAddPrismarine(exporter, Items.DETECTOR_RAIL, IrailsItems.UNDERWATER_DETECTOR_RAIL);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, IrailsItems.UNDERWATER_DETECTOR_RAIL, 6)
                .input('I', Items.IRON_INGOT)
                .input('P', Items.STONE_PRESSURE_PLATE)
                .input('R', Items.PRISMARINE_SHARD)
                .input('K', Items.REDSTONE)
                .pattern("IRI")
                .pattern("IPI")
                .pattern("IKI")
                .group("rails")
                .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                .offerTo(exporter, "underwater_detector_rail");

        offerAddPrismarine(exporter, Items.ACTIVATOR_RAIL, IrailsItems.UNDERWATER_ACTIVATOR_RAIL);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, IrailsItems.UNDERWATER_ACTIVATOR_RAIL, 6)
                .input('I', Items.IRON_INGOT)
                .input('T', Items.REDSTONE_TORCH)
                .input('R', Items.PRISMARINE_SHARD)
                .input('W', IrailsTags.WOOD_STICKS)
                .pattern("IRI")
                .pattern("ITI")
                .pattern("IWI")
                .group("rails")
                .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                .offerTo(exporter, "underwater_activator_rail");

        offerAddPrismarine(exporter, IrailsItems.ALWAYS_POWERED_RAIL, IrailsItems.UNDERWATER_ALWAYS_POWERED_RAIL);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, IrailsItems.UNDERWATER_ALWAYS_POWERED_RAIL, 6)
                .input('I', Items.GOLD_INGOT)
                .input('P', IrailsTags.WOOD_STICKS)
                .input('R', Items.PRISMARINE_SHARD)
                .input('K', Items.REDSTONE)
                .pattern("IRI")
                .pattern("IPI")
                .pattern("IKI")
                .group("rails")
                .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                .offerTo(exporter, "underwater_always_powered_rail");

        offerAddPrismarine(exporter, IrailsItems.POWERED_RAIL_WITH_REDSTONE, IrailsItems.UNDERWATER_POWERED_RAIL_WITH_REDSTONE);

        offerAddPrismarine(exporter, IrailsItems.ACTIVATOR_RAIL_WITH_DETECTOR, IrailsItems.UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR);
    }

    private static void offerRegularRails(Consumer<RecipeJsonProvider> exporter) {
        offerRailsConvertion(exporter, Items.POWERED_RAIL, IrailsItems.ALWAYS_POWERED_RAIL);
        offerRailsConvertion(exporter, IrailsItems.ALWAYS_POWERED_RAIL, Items.POWERED_RAIL);

        offerAddRedstone(exporter, IrailsItems.ALWAYS_POWERED_RAIL, IrailsItems.POWERED_RAIL_WITH_REDSTONE);
        offerAddRedstone(exporter, Items.POWERED_RAIL, IrailsItems.POWERED_RAIL_WITH_REDSTONE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, IrailsItems.POWERED_RAIL_WITH_REDSTONE, 6)
                .input('I', Items.GOLD_INGOT)
                .input('P', IrailsTags.WOOD_STICKS)
                .input('R', Items.REDSTONE)
                .pattern("IRI")
                .pattern("IPI")
                .pattern("IRI")
                .group("rails")
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, "powered_rail_with_redstone");

        offerAddRedstone(exporter, Items.DETECTOR_RAIL, IrailsItems.ACTIVATOR_RAIL_WITH_DETECTOR);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, IrailsItems.ACTIVATOR_RAIL_WITH_DETECTOR, 6)
                .input('I', Items.IRON_INGOT)
                .input('P', Items.STONE_PRESSURE_PLATE)
                .input('R', Items.REDSTONE)
                .pattern("IRI")
                .pattern("IPI")
                .pattern("IRI")
                .group("rails")
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, "activator_rail_with_detector");
    }

    private static void offerAddRedstone(Consumer<RecipeJsonProvider> exporter, Item in, Item out) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, out, 1)
                .input(in)
                .input(Items.REDSTONE)
                .group("rails")
                .criterion(hasItem(in), conditionsFromItem(in))
                .offerTo(exporter, convertBetween(out, in));
    }

    private static void offerAddPrismarine(Consumer<RecipeJsonProvider> exporter, Item in, Item out) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, out, 1)
                .input(in)
                .input(Items.PRISMARINE_SHARD)
                .group("rails")
                .criterion(hasItem(in), conditionsFromItem(in))
                .offerTo(exporter, convertBetween(out, in));
    }

    private static void offerRailsConvertion(Consumer<RecipeJsonProvider> exporter, Item out, Item in) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, out, 1)
                .input(in)
                .group("rails")
                .criterion(hasItem(in), conditionsFromItem(in))
                .offerTo(exporter, convertBetween(out, in));
    }
}
