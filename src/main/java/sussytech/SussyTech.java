package sussytech;

import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sussytech.api.SussyAPI;
import sussytech.common.material.Materials;
import sussytech.lib.material.property.BlockProperty;
import sussytech.lib.material.property.ItemProperty;

import java.util.Objects;

public class SussyTech implements ModInitializer {

    public static final String MODID = "sussytech";

    public static final Logger LOGGER = LoggerFactory.getLogger("SussyTech");

    @Override
    public void onInitialize(@NotNull ModContainer mod) {
        // register materials
        Materials.registerMaterials();
        LOGGER.info("Registering materials...");

        LOGGER.info("Material registered:");
        SussyAPI.MATERIAL_REGISTRY.forEach(e -> LOGGER.info("  {}", e.toString()));

        // register property contents
        LOGGER.info("Registering material properties...");
        Materials.registerPropertyContents();

        LOGGER.info("MaterialItems registered:");
        SussyAPI.MATERIAL_REGISTRY.stream()
                .map(m -> m.getProperty(ItemProperty.KEY))
                .filter(Objects::nonNull)
                .flatMap(p -> p.getItems().stream())
                .forEach(e -> LOGGER.info("  {}", e.getTranslationKey()));

        LOGGER.info("MaterialBlocks registered:");
        SussyAPI.MATERIAL_REGISTRY.stream()
                .map(m -> m.getProperty(BlockProperty.KEY))
                .filter(Objects::nonNull)
                .flatMap(p -> p.getBlocks().stream())
                .forEach(e -> LOGGER.info("  {}", e.getTranslationKey()));
    }
}
