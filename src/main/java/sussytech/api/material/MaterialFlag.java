package sussytech.api.material;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import sussytech.SussyIdentifier;

/**
 * Simple boolean data for a material
 */
public record MaterialFlag(@NotNull Identifier identifier) {

    public MaterialFlag(@NotNull String name) {
        //TODO current loading mod
        this(SussyIdentifier.of(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialFlag that = (MaterialFlag) o;
        return identifier.equals(that.identifier);
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    public @NotNull String toString() {
        return "MaterialFlag{" + "identifier=" + identifier + '}';
    }
}
