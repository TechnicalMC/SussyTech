package sussytech.api.material;

import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sussytech.api.material.property.MaterialProperty;
import sussytech.api.material.property.MaterialPropertyKey;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * A material is an object containing various data about a Material, such as Iron or Gold
 */
public interface Material {

    /**
     * @return the identifier of the material
     */
    @NotNull Identifier getIdentifier();

    /**
     * Format: "modid.material.material_name"
     *
     * @return the key for translation
     */
    default @NotNull String getTranslationKey() {
        Identifier identifier = getIdentifier();
        return identifier.getNamespace() + ".material." + identifier.getPath();
    }

    /**
     * @return the rarity of the material
     */
    @NotNull Rarity getRarity();

    /**
     * @param rarity the rarity to set
     */
    void setRarity(@NotNull Rarity rarity);

    /**
     * @return the chemical formula of the material
     */
    @NotNull String getFormula();

    /**
     * @param formula the formula to set
     */
    void setFormula(@NotNull String formula);

    /**
     * @return the additional tooltips of the material
     */
    @NotNull List<String> getTooltips();

    /**
     * @param toolTips the tooltips to send
     */
    void setToolTips(List<String> toolTips);

    /**
     * @return the flags the material has
     */
    @NotNull Set<MaterialFlag> getFlags();

    /**
     * @param flag the flag to add
     */
    void addFlag(@NotNull MaterialFlag flag);

    /**
     * @param flags the flags to add
     */
    void addFlags(@NotNull Collection<MaterialFlag> flags);

    /**
     * @param flag the flag to check
     * @return if the material has the flag
     */
    default boolean hasFlag(@NotNull MaterialFlag flag) {
        return getFlags().contains(flag);
    }

    /**
     * @param flags the flags to check
     * @return if the material has all the flags
     */
    default boolean hasAllFlags(@NotNull MaterialFlag... flags) {
        return hasAllFlags(Arrays.asList(flags));
    }

    /**
     * @param flags the flags to check
     * @return if the material has all the flags
     */
    default boolean hasAllFlags(@NotNull Collection<MaterialFlag> flags) {
        return getFlags().containsAll(flags);
    }

    /**
     * @param flags the flags to check
     * @return if the material has any of the flags
     */
    default boolean hasAnyFlags(@NotNull MaterialFlag... flags) {
        return hasAnyFlags(Arrays.asList(flags));
    }

    /**
     * @param flags the flags to check
     * @return if the material has any of the flags
     */
    default boolean hasAnyFlags(@NotNull Collection<MaterialFlag> flags) {
        return getFlags().stream().anyMatch(flags::contains);
    }

    /**
     * @param flag the flag to remove
     * @return if the removal was successful
     */
    boolean removeFlag(@NotNull MaterialFlag flag);

    /**
     * @return the material's properties
     */
    @NotNull Collection<MaterialProperty<?>> getProperties();

    /**
     * @param property the property to set
     */
    void setProperty(@NotNull MaterialProperty<?> property);

    /**
     * @param key the key of the property
     * @return the material property corresponding to the key
     */
    <T extends MaterialProperty<T>> @Nullable T getProperty(@NotNull MaterialPropertyKey<T> key);
}
