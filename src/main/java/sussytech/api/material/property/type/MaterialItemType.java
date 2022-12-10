package sussytech.api.material.property.type;

import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import sussytech.api.material.Material;

/**
 * Represents a type of item a material can have
 */
public interface MaterialItemType extends MaterialFormType {

    /**
     * @return how many units this item type is worth
     */
    long amount();

    /**
     * @param material the material to create settings for
     * @return the item settings for the material
     */
    @NotNull QuiltItemSettings createSettings(@NotNull Material material);
}
