package sussytech.lib.material.property;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.fluid.Fluid;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sussytech.SussyIdentifier;
import sussytech.api.material.Material;
import sussytech.api.material.property.MaterialProperty;
import sussytech.api.material.property.MaterialPropertyKey;
import sussytech.api.material.property.type.MaterialFluidType;

import java.util.Collection;
import java.util.Map;

@SuppressWarnings("unused")
public final class FluidProperty implements MaterialProperty<FluidProperty> {

    public static final MaterialPropertyKey<FluidProperty> KEY = new MaterialPropertyKey<>(SussyIdentifier.of("fluid_property"), FluidProperty.class);

    private final Map<MaterialFluidType, Fluid> fluids = new Object2ObjectOpenHashMap<>();

    /**
     * @param type the fluid type of the fluid
     * @return the fluid for the type
     */
    public @Nullable Fluid getFluid(@NotNull MaterialFluidType type) {
        return fluids.get(type);
    }

    //TODO Quilt Fluid Impl
//    /**
//     * @param type the fluid type of the item
//     * @return the FluidStack for the FluidType with a quantity of 1
//     */
//    public @Nullable FluidStack getStack(@NotNull MaterialFluidType type) {
//        return getStack(type, 1);
//    }
//
//    /**
//     * @param type   the fluid type of the item
//     * @param amount the amount of items in the stack
//     * @return the FluidStack for the FluidType
//     */
//    public @Nullable FluidStack getStack(@NotNull MaterialFluidType type, int amount) {
//        Fluid fluid = getFluid(type);
//        if (fluid == null || fluid == Fluids.EMPTY) return FluidStack.EMPTY;
//        return new FluidStack(fluid, amount);
//    }

    /**
     * Set a fluid for the FluidType
     *
     * @param type  the FluidTYpe to map to
     * @param fluid the fluid corresponding to the FluidType
     */
    public void setFluid(@NotNull MaterialFluidType type, @NotNull Fluid fluid) {
        this.fluids.put(type, fluid);
    }

    /**
     * @return all the fluid types in this property
     */
    public @NotNull Collection<MaterialFluidType> getFluidTypes() {
        return this.fluids.keySet();
    }

    /**
     * @return all the fluids in this property
     */
    public @NotNull Collection<Fluid> getFluids() {
        return this.fluids.values();
    }

    @Override
    public @NotNull MaterialPropertyKey<FluidProperty> getKey() {
        return KEY;
    }

    @Override
    public void registerContents(@NotNull Material material) {
        //TODO Quilt Fluid Impl
    }
}
