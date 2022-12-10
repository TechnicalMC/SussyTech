package sussytech.lib.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import sussytech.api.material.Material;
import sussytech.api.material.property.type.MaterialItemType;

public class MaterialItem extends Item {

    private final MaterialItemType itemType;
    private final Material material;

    public MaterialItem(@NotNull Settings settings, @NotNull MaterialItemType itemType, @NotNull Material material) {
        super(settings);
        this.itemType = itemType;
        this.material = material;
    }

    @Override
    public Text getName(ItemStack stack) {
        return getName();
    }

    @Override
    public Text getName() {
        return Text.translatable("item.material." + this.itemType.name(),
                Text.translatable(this.material.getTranslationKey()));
    }
}
