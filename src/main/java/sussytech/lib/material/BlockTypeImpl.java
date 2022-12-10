package sussytech.lib.material;

import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import sussytech.api.material.Material;
import sussytech.api.material.property.type.MaterialBlockType;
import sussytech.api.material.property.type.MaterialItemType;

public record BlockTypeImpl(String name, MaterialItemType itemType) implements MaterialBlockType {

    @Override
    public @NotNull QuiltBlockSettings createSettings(@NotNull Material material) {
        net.minecraft.block.Material mcMaterial = net.minecraft.block.Material.METAL;

        //TODO hardness, etc by material data
        return QuiltBlockSettings.of(mcMaterial);
    }
}
