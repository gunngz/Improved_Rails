package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import org.gz.irails.irails_registry.IrailsItems;
import org.gz.irails.irails_registry.IrailsTags;

public class IrailsRecipeProvider extends FabricRecipeProvider {
    public IrailsRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerRegularRails(exporter);
        offerUnderwaterRails(exporter);
        offerLightRails(exporter);
        offerWands(exporter);
    }

    private void offerWands(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, IrailsItems.LIGHT_WAND)
                .input('C', Items.COAL_BLOCK)
                .input('P', IrailsTags.WOOD_STICKS)
                .pattern("  C")
                .pattern(" P ")
                .pattern("P  ")
                .group("wand")
                .criterion(hasItem(Items.COAL_BLOCK), conditionsFromItem(Items.COAL_BLOCK))
                .offerTo(exporter, "light_wand");

        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, IrailsItems.UNDERWATER_WAND)
                .input('C', Items.PRISMARINE_BRICKS)
                .input('P', IrailsTags.WOOD_STICKS)
                .pattern("  C")
                .pattern(" P ")
                .pattern("P  ")
                .group("wand")
                .criterion(hasItem(Items.PRISMARINE_BRICKS), conditionsFromItem(Items.PRISMARINE_BRICKS))
                .offerTo(exporter, "underwater_wand");
    }

    private void offerLightRails(RecipeExporter exporter) {
        offerAddCoal(exporter, Items.POWERED_RAIL, IrailsItems.LIGHT_POWERED_RAIL);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, IrailsItems.LIGHT_POWERED_RAIL, 6)
                .input('I', Items.GOLD_INGOT)
                .input('P', IrailsTags.WOOD_STICKS)
                .input('R', Items.REDSTONE)
                .input('C', ItemTags.COALS)
                .pattern("ICI")
                .pattern("IPI")
                .pattern("IRI")
                .group("rails")
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, "light_powered_rail");

        offerAddCoal(exporter, IrailsItems.ALWAYS_POWERED_RAIL, IrailsItems.LIGHT_ALWAYS_POWERED_RAIL);
        offerRailsConvertion(exporter, IrailsItems.LIGHT_POWERED_RAIL, IrailsItems.LIGHT_ALWAYS_POWERED_RAIL);

        offerAddCoal(exporter, IrailsItems.UNDERWATER_POWERED_RAIL, IrailsItems.LIGHT_UNDERWATER_POWERED_RAIL);

        offerAddCoal(exporter, IrailsItems.UNDERWATER_ALWAYS_POWERED_RAIL, IrailsItems.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL);
        offerRailsConvertion(exporter, IrailsItems.LIGHT_UNDERWATER_POWERED_RAIL, IrailsItems.LIGHT_UNDERWATER_ALWAYS_POWERED_RAIL);

        offerAddCoal(exporter, IrailsItems.UNDERWATER_POWERED_RAIL_WITH_REDSTONE, IrailsItems.LIGHT_UNDERWATER_POWERED_RAIL_WITH_REDSTONE);

        offerAddCoal(exporter, IrailsItems.POWERED_RAIL_WITH_REDSTONE, IrailsItems.LIGHT_POWERED_RAIL_WITH_REDSTONE);
    }

    private static void offerUnderwaterRails(RecipeExporter exporter) {
        offerAddPrismarine(exporter, Items.RAIL, IrailsItems.UNDERWATER_RAIL);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, IrailsItems.UNDERWATER_RAIL, 6)
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, IrailsItems.UNDERWATER_POWERED_RAIL, 6)
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, IrailsItems.UNDERWATER_DETECTOR_RAIL, 6)
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, IrailsItems.UNDERWATER_ACTIVATOR_RAIL, 6)
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
        offerRailsConvertion(exporter, IrailsItems.UNDERWATER_POWERED_RAIL, IrailsItems.UNDERWATER_ALWAYS_POWERED_RAIL);

        offerAddPrismarine(exporter, IrailsItems.POWERED_RAIL_WITH_REDSTONE, IrailsItems.UNDERWATER_POWERED_RAIL_WITH_REDSTONE);

        offerAddPrismarine(exporter, IrailsItems.ACTIVATOR_RAIL_WITH_DETECTOR, IrailsItems.UNDERWATER_ACTIVATOR_RAIL_WITH_DETECTOR);
    }

    private static void offerRegularRails(RecipeExporter exporter) {
        offerRailsConvertion(exporter, Items.POWERED_RAIL, IrailsItems.ALWAYS_POWERED_RAIL);
        offerRailsConvertion(exporter, IrailsItems.ALWAYS_POWERED_RAIL, Items.POWERED_RAIL);

        offerAddRedstone(exporter, IrailsItems.ALWAYS_POWERED_RAIL, IrailsItems.POWERED_RAIL_WITH_REDSTONE);
        offerAddRedstone(exporter, Items.POWERED_RAIL, IrailsItems.POWERED_RAIL_WITH_REDSTONE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, IrailsItems.POWERED_RAIL_WITH_REDSTONE, 6)
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
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, IrailsItems.ACTIVATOR_RAIL_WITH_DETECTOR, 6)
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

    private static void offerAddCoal(RecipeExporter exporter, Item in, Item out) {
        offerAddOneItem(ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, out, 1)
                .input(in), ItemTags.COALS, in, exporter, out);
    }

    private static void offerAddRedstone(RecipeExporter exporter, Item in, Item out) {
        offerAddOneItem(ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, out, 1)
                .input(in), Items.REDSTONE, in, exporter, out);
    }

    private static void offerAddOneItem(ShapelessRecipeJsonBuilder Builder, Item in1, Item in2, RecipeExporter exporter, Item out) {
        Builder.input(in1)
                .group("rails")
                .criterion(hasItem(in2), conditionsFromItem(in2))
                .offerTo(exporter, convertBetween(out, in2));
    }

    private static void offerAddOneItem(ShapelessRecipeJsonBuilder Builder, TagKey<Item> in1, Item in2, RecipeExporter exporter, Item out) {
        Builder.input(in1)
                .group("rails")
                .criterion(hasItem(in2), conditionsFromItem(in2))
                .offerTo(exporter, convertBetween(out, in2));
    }

    private static void offerAddPrismarine(RecipeExporter exporter, Item in, Item out) {
        offerAddOneItem(ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, out, 1)
                .input(in), Items.PRISMARINE_SHARD, in, exporter, out);
    }

    private static void offerRailsConvertion(RecipeExporter exporter, Item out, Item in) {
        offerAddOneItem(ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, out, 1), in, in, exporter, out);
    }
}
