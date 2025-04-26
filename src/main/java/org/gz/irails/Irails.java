package org.gz.irails;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.gz.irails.irails_registry.IrailsBlocks;
import org.gz.irails.irails_registry.IrailsItemGroup;
import org.gz.irails.irails_registry.IrailsItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Irails implements ModInitializer {
	public static final String MOD_ID = "irails";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		IrailsBlocks.registerRtsBlocks();
		IrailsItems.registerRtsItems();
		IrailsItemGroup.registerRtsItemGroup();
	}

	public static boolean isClient() {
		return FabricLoader.getInstance().getEnvironmentType().equals(EnvType.CLIENT);
	}
}