package sussytech.lib.material.property;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sussytech.SussyIdentifier;
import sussytech.api.material.Material;
import sussytech.api.material.property.MaterialProperty;
import sussytech.api.material.property.MaterialPropertyKey;
import sussytech.api.material.property.type.MaterialBlockType;
import sussytech.lib.block.MaterialBlock;

import java.util.Collection;
import java.util.Map;

public final class BlockProperty implements MaterialProperty<BlockProperty> {

    public static final MaterialPropertyKey<BlockProperty> KEY = new MaterialPropertyKey<>(SussyIdentifier.of("block_property"), BlockProperty.class);

    private final Map<MaterialBlockType, Block> blocks = new Object2ObjectOpenHashMap<>();

    public @Nullable Block getBlock(@NotNull MaterialBlockType type) {
        return blocks.get(type);
    }

    public void setBlock(@NotNull MaterialBlockType type, @NotNull Block block) {
        this.blocks.put(type, block);
    }

    /**
     * @return all the item types in this property
     */
    public @NotNull Collection<MaterialBlockType> getBlockTypes() {
        return this.blocks.keySet();
    }

    /**
     * @return all the items in this property
     */
    public @NotNull Collection<Block> getBlocks() {
        return this.blocks.values();
    }

    @Override
    public @NotNull MaterialPropertyKey<BlockProperty> getKey() {
        return KEY;
    }

    @Override
    public void registerContents(@NotNull Material material) {
        for (MaterialBlockType type : getBlockTypes()) {
            Block block = getBlock(type);
            if (block == null || block == Blocks.AIR) {
                block = new MaterialBlock(type.createSettings(material), type, material);

                Identifier identifier = createBlockIdentifier(type, material);

                Registry.register(Registry.BLOCK, identifier, block);
                this.blocks.put(type, block);

                //TODO register tags to the blocks
            }
        }
    }

    /**
     * @param type     the block type
     * @param material the material
     * @return the name for the block
     */
    private @NotNull Identifier createBlockIdentifier(@NotNull MaterialBlockType type, @NotNull Material material) {
        return new Identifier(material.getIdentifier().getNamespace(),
                type.name() + "." + material.getIdentifier().getPath());
    }
}
