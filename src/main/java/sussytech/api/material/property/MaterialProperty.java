package sussytech.api.material.property;

import org.jetbrains.annotations.NotNull;
import sussytech.api.material.Material;

/**
 * A complex property for a material
 */
public interface MaterialProperty<T extends MaterialProperty<T>> {

    /**
     * @return the key corresponding to this property
     */
    @NotNull MaterialPropertyKey<T> getKey();

    /**
     * Register the contents of this property
     *
     * @param material the material to register for
     */
    default void registerContents(@NotNull Material material) {/**/}

    /**
     * Register the contents of this property after {@link MaterialProperty#registerContents(Material)} is performed
     * for all properties.
     *
     * @param material the material to register for
     */
    default void registerContentsPost(@NotNull Material material) {/**/}
}
