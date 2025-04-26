package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class IrailsDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator gen) {
		gen.addProvider(IrailsRecipeProvider::new);
		gen.addProvider(IrailsModelProvider::new);
		gen.addProvider(IrailsBlockTagProvider::new);
		gen.addProvider(IrailsItemTagProvider::new);
		gen.addProvider(IrailsLangProvider::new);
	}
}
