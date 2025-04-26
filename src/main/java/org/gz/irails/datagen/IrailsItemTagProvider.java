package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.gz.irails.Irails;
import org.gz.irails.irails_registry.IrailsTags;

public class IrailsItemTagProvider extends FabricTagProvider<Item> {


    protected IrailsItemTagProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator, Registry.ITEM, Irails.MOD_ID);
    }

    protected Identifier getItemId(Item item) {
        return Registry.ITEM.getId(item);
    }

    @Override
    protected void generateTags() {
        getOrCreateTagBuilder(IrailsTags.WOOD_STICKS)
                .addOptional(getItemId(Items.STICK));
    }
}
