package sussytech.api.material;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.jetbrains.annotations.NotNull;
import sussytech.SussyIdentifier;
import sussytech.api.SussyAPI;
import sussytech.api.material.property.MaterialProperty;

import java.util.*;

/**
 * Builder for materials
 *
 * @param <T> the type of builder
 */
public abstract class AbstractMaterialBuilder<T extends AbstractMaterialBuilder<T>> {

    protected final Set<MaterialProperty<?>> properties = new ObjectOpenHashSet<>();
    protected final Set<MaterialFlag> flags = new ObjectOpenHashSet<>();
    protected final List<String> tooltips = new ArrayList<>();

    protected final Identifier identifier;

    protected String formula = "";
    protected Rarity rarity = Rarity.COMMON;

    /**
     * Create a material builder using the current loading mod
     *
     * @param path the path/name of the material
     */
    public AbstractMaterialBuilder(@NotNull String path) {
        //TODO current loading mod
        this(SussyIdentifier.of(path));
    }

    /**
     * @param namespace the namespace of the material
     * @param path      the path/name of the material
     */
    public AbstractMaterialBuilder(@NotNull String namespace, @NotNull String path) {
        this(new Identifier(namespace, path));
    }

    /**
     * @param identifier the identifier of the material
     */
    public AbstractMaterialBuilder(@NotNull Identifier identifier) {
        this.identifier = identifier;
    }

    /**
     * @param formula the formula for the material
     * @return this
     */
    public @NotNull T formula(@NotNull String formula) {
        this.formula = formula;
        return cast(this);
    }

    /**
     * @param rarity the rarity for the material
     * @return this
     */
    public @NotNull T rarity(@NotNull Rarity rarity) {
        this.rarity = rarity;
        return cast(this);
    }

    /**
     * @param flag the flag to add to the material
     * @return this
     */
    public @NotNull T flag(@NotNull MaterialFlag flag) {
        this.flags.add(flag);
        return cast(this);
    }

    /**
     * @param flags the flags to add to the material
     * @return this
     */
    public @NotNull T flags(@NotNull MaterialFlag... flags) {
        return flags(Arrays.asList(flags));
    }

    /**
     * @param flags the flags to add to the material
     * @return this
     */
    public @NotNull T flags(@NotNull Collection<MaterialFlag> flags) {
        this.flags.addAll(flags);
        return cast(this);
    }

    /**
     * @param property the property to add to the material
     * @return this
     */
    public @NotNull T property(@NotNull MaterialProperty<?> property) {
        this.properties.add(property);
        return cast(this);
    }

    /**
     * @param tooltips the tooltips to add to the material
     * @return this
     */
    public @NotNull T tooltips(@NotNull String... tooltips) {
        return tooltips(Arrays.asList(tooltips));
    }

    /**
     * @param tooltips the tooltips to add to the material
     * @return this
     */
    public @NotNull T tooltips(@NotNull Collection<String> tooltips) {
        this.tooltips.addAll(tooltips);
        return cast(this);
    }

    /**
     * @return the material constructed with no extra modification
     */
    protected abstract @NotNull Material construct();

    protected abstract T cast(AbstractMaterialBuilder<T> self);

    /**
     * @return the fully built material
     */
    public @NotNull Material build() {
        Material material = construct();
        material.setFormula(this.formula);
        material.setRarity(rarity);

        properties.forEach(material::setProperty);
        material.addFlags(flags);
        material.setToolTips(this.tooltips);

        Registry.register(SussyAPI.MATERIAL_REGISTRY, material.getIdentifier(), material);
        return material;
    }
}
