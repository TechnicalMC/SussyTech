package sussytech.lib.material;

import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import sussytech.api.Constants;
import sussytech.api.material.Material;
import sussytech.api.material.property.type.MaterialItemType;

public record ItemTypeImpl(String name, long amount, boolean limitStackSize) implements MaterialItemType {

    public ItemTypeImpl(@NotNull String name, long amount) {
        this(name, amount, true);
    }

    @Override
    public @NotNull QuiltItemSettings createSettings(@NotNull Material material) {
        QuiltItemSettings settings = new QuiltItemSettings();

        if (limitStackSize) {
            long amount = MathHelper.clamp(64 * Constants.M / amount(), 1, 64);
            settings.maxCount((int) amount);
        }

        if (material.hasFlag(MaterialFlags.LAVA_PROOF)) settings.fireproof();
        return settings;
    }
}
