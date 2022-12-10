package sussytech.api.material.property.type;

import org.jetbrains.annotations.NotNull;
import sussytech.api.material.Material;

/**
 * Base interface for a form of a material
 */
public interface MaterialFormType {

    /**
     * @return the name of the type
     */
    @NotNull String name();

    /**
     * @param material the material to get a tag for
     * @return a tag for this type and the material
     */
    default @NotNull String getTagName(@NotNull Material material) {
        return material.getIdentifier().getPath() + "_" + name() + "s";
    }
}
