package sussytech;

import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SussyTech implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("SussyTech");

    @Override
    public void onInitialize(@NotNull ModContainer mod) {
        LOGGER.info("Beginning Initialization...");
    }
}
