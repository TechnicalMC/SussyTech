package sussytech.api;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.registry.Registry;
import sussytech.SussyIdentifier;
import sussytech.api.material.Material;

public final class SussyAPI {

    private SussyAPI() {/**/}

    /**
     * Registry for all Materials
     */
    public static Registry<Material> MATERIAL_REGISTRY = FabricRegistryBuilder.createSimple(Material.class, SussyIdentifier.of("material"))
            .buildAndRegister();
}
