package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.gz.irails.irails_registry.IrailsTags;

import java.util.concurrent.CompletableFuture;

public class IrailsItemTagProvider extends TagProvider<Item> {
    public IrailsItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> lookupFuture) {
        super(output, RegistryKeys.ITEM, lookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(IrailsTags.WOOD_STICKS)
                .addOptional(getItemId(Items.STICK));
    }

    protected Identifier getItemId(Item item) {
        return Registries.ITEM.getId(item);
    }
}
