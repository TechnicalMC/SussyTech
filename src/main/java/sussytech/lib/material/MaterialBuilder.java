package sussytech.lib.material;

import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import sussytech.api.material.AbstractMaterialBuilder;
import sussytech.api.material.Material;
import sussytech.api.material.property.type.MaterialBlockType;
import sussytech.api.material.property.type.MaterialFluidType;
import sussytech.api.material.property.type.MaterialItemType;
import sussytech.lib.material.property.BlockProperty;
import sussytech.lib.material.property.FluidProperty;
import sussytech.lib.material.property.ItemProperty;

import java.util.Arrays;
import java.util.Collection;

public class MaterialBuilder extends AbstractMaterialBuilder<MaterialBuilder> {

    public MaterialBuilder(@NotNull String path) {
        super(path);
    }

    @SuppressWarnings("unused")
    public MaterialBuilder(@NotNull String namespace, @NotNull String path) {
        super(namespace, path);
    }

    @SuppressWarnings("unused")
    public MaterialBuilder(@NotNull Identifier identifier) {
        super(identifier);
    }

    /**
     * Give the material an item
     *
     * @param type the type of item to add
     * @return this
     */
    public @NotNull MaterialBuilder item(@NotNull MaterialItemType type) {
        ItemProperty property = new ItemProperty();
        property.setItem(type, Items.AIR);
        return property(property);
    }

    /**
     * Give the material items
     *
     * @param types the types of item to add
     * @return this
     */
    public @NotNull MaterialBuilder item(@NotNull MaterialItemType... types) {
        return item(Arrays.asList(types));
    }

    /**
     * Give the material items
     *
     * @param types the types of item to add
     * @return this
     */
    public @NotNull MaterialBuilder item(@NotNull Collection<MaterialItemType> types) {
        ItemProperty property = new ItemProperty();
        types.forEach(type -> property.setItem(type, Items.AIR));
        return property(property);
    }

    /**
     * Give the material a fluid
     *
     * @param type the type of fluid to add
     * @return this
     */
    public @NotNull MaterialBuilder fluid(@NotNull MaterialFluidType type) {
        FluidProperty property = new FluidProperty();
        property.setFluid(type, Fluids.EMPTY);
        return property(property);
    }

    /**
     * Give the material fluids
     *
     * @param types the types of fluid to add
     * @return this
     */
    public @NotNull MaterialBuilder fluid(@NotNull MaterialFluidType... types) {
        return fluid(Arrays.asList(types));
    }

    /**
     * Give the material fluids
     *
     * @param types the types of fluids to add
     * @return this
     */
    public @NotNull MaterialBuilder fluid(@NotNull Collection<MaterialFluidType> types) {
        FluidProperty property = new FluidProperty();
        types.forEach(type -> property.setFluid(type, Fluids.EMPTY));
        return property(property);
    }

    /**
     * Give the material a block
     *
     * @param type the type of block to add
     * @return this
     */
    public @NotNull MaterialBuilder block(@NotNull MaterialBlockType type) {
        BlockProperty property = new BlockProperty();
        property.setBlock(type, Blocks.AIR);
        return property(property);
    }

    /**
     * Give the material blocks
     *
     * @param types the types of block to add
     * @return this
     */
    public @NotNull MaterialBuilder block(@NotNull MaterialBlockType... types) {
        return block(Arrays.asList(types));
    }

    /**
     * Give the material blocks
     *
     * @param types the types of block to add
     * @return this
     */
    public @NotNull MaterialBuilder block(@NotNull Collection<MaterialBlockType> types) {
        BlockProperty property = new BlockProperty();
        types.forEach(type -> property.setBlock(type, Blocks.AIR));
        return property(property);
    }

    @Override
    protected @NotNull Material construct() {
        return new MaterialImpl(this.identifier);
    }

    @Override
    protected MaterialBuilder cast(AbstractMaterialBuilder<MaterialBuilder> self) {
        return (MaterialBuilder) self;
    }
}
