package sussytech.lib.material;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sussytech.api.material.AbstractMaterialBuilder;
import sussytech.api.material.Material;
import sussytech.api.material.MaterialFlag;
import sussytech.api.material.property.MaterialProperty;
import sussytech.api.material.property.MaterialPropertyKey;

import java.util.*;

public final class MaterialImpl implements Material {

    private final Set<MaterialFlag> flags = new ObjectOpenHashSet<>();
    private final Map<MaterialPropertyKey<?>, MaterialProperty<?>> properties = new Object2ObjectOpenHashMap<>();

    private final Identifier identifier;

    private List<String> tooltips = new ArrayList<>();

    private Rarity rarity = Rarity.COMMON;
    private String formula = "";

    /**
     * Do not use! Use an {@link AbstractMaterialBuilder} to create new materials
     *
     * @param identifier the identifier for the material
     */
    MaterialImpl(Identifier identifier) {
        this.identifier = identifier;
    }

    @Override
    public @NotNull Identifier getIdentifier() {
        return this.identifier;
    }

    @Override
    public @NotNull Rarity getRarity() {
        return this.rarity;
    }

    @Override
    public void setRarity(@NotNull Rarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public @NotNull String getFormula() {
        return this.formula;
    }

    @Override
    public void setFormula(@NotNull String formula) {
        this.formula = formula;
    }

    @Override
    public @NotNull List<String> getTooltips() {
        return this.tooltips;
    }

    @Override
    public void setToolTips(List<String> toolTips) {
        this.tooltips = toolTips;
    }

    @Override
    public @NotNull Set<MaterialFlag> getFlags() {
        return this.flags;
    }

    @Override
    public void addFlag(@NotNull MaterialFlag flag) {
        this.flags.add(flag);
    }

    @Override
    public void addFlags(@NotNull Collection<MaterialFlag> flags) {
        this.flags.addAll(flags);
    }

    @Override
    public boolean removeFlag(@NotNull MaterialFlag flag) {
        return this.flags.remove(flag);
    }

    @Override
    public @NotNull Collection<MaterialProperty<?>> getProperties() {
        return this.properties.values();
    }

    @Override
    public void setProperty(@NotNull MaterialProperty<?> property) {
        this.properties.put(property.getKey(), property);
    }

    @Override
    public <T extends MaterialProperty<T>> @Nullable T getProperty(@NotNull MaterialPropertyKey<T> key) {
        return key.cast(this.properties.get(key));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialImpl material = (MaterialImpl) o;
        return flags.equals(material.flags) && properties.equals(material.properties) &&
                identifier.equals(material.identifier) && tooltips.equals(material.tooltips) &&
                rarity == material.rarity && formula.equals(material.formula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flags, properties, identifier, tooltips, rarity, formula);
    }

    @Override
    public @NotNull String toString() {
        return getTranslationKey();
    }
}
