package sussytech.api.material.property.type;

import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import sussytech.api.material.Material;

/**
 * Represents a type of block a material can have
 */
public interface MaterialBlockType extends MaterialFormType {

    /**
     * @return the item type corresponding to the block
     */
    @NotNull MaterialItemType itemType();

    /**
     * @param material the material to create settings for
     * @return the item settings for the material
     */
    @NotNull QuiltBlockSettings createSettings(@NotNull Material material);
}
