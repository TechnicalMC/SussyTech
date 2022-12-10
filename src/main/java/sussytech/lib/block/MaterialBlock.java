package sussytech.lib.block;

import net.minecraft.block.Block;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import sussytech.api.material.Material;
import sussytech.api.material.property.type.MaterialBlockType;

public class MaterialBlock extends Block {

    private final MaterialBlockType type;
    private final Material material;

    public MaterialBlock(@NotNull Settings settings, @NotNull MaterialBlockType type, @NotNull Material material) {
        super(settings);
        this.type = type;
        this.material = material;
    }

    @Override
    public MutableText getName() {
        return Text.translatable("block.material." + this.type.name(),
                Text.translatable(this.material.getTranslationKey()));
    }
}
