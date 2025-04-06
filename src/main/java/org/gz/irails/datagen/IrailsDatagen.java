package org.gz.irails.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class IrailsDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator gen) {
		FabricDataGenerator.Pack pack = gen.createPack();
		pack.addProvider(IrailsRecipeProvider::new);
		pack.addProvider(IrailsModelProvider::new);
		pack.addProvider(IrailsBlockTagProvider::new);
		pack.addProvider(IrailsItemTagProvider::new);
		pack.addProvider(IrailsLangProvider::new);
	}
}
