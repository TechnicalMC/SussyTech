package sussytech.common.material;

import sussytech.api.SussyAPI;
import sussytech.api.material.Material;
import sussytech.api.material.property.MaterialProperty;
import sussytech.lib.material.MaterialBuilder;

import static sussytech.lib.material.BlockTypes.BLOCK;
import static sussytech.lib.material.BlockTypes.FRAME;
import static sussytech.lib.material.ItemTypes.*;

public final class Materials {

    public static Material IRON;

    public static void registerMaterials() {
        IRON = new MaterialBuilder("iron")
                .item(PLATE, ROD, LONG_ROD, BOLT, SCREW, GEAR)
                .block(BLOCK, FRAME)
                .formula("Fe")
                .build();
    }

    public static void registerPropertyContents() {
        for (Material material : SussyAPI.MATERIAL_REGISTRY) {
            for (MaterialProperty<?> property : material.getProperties()) {
                property.registerContents(material);
            }
            // for loops must be separate
            for (MaterialProperty<?> property : material.getProperties()) {
                property.registerContentsPost(material);
            }
        }
    }
}
