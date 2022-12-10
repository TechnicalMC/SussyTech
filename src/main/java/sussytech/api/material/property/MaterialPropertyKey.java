package sussytech.api.material.property;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * A key for storing and retrieving an {@link MaterialProperty}
 *
 * @param identifier the identifier for the key
 * @param type       the class of the corresponding property
 * @param <T>        the corresponding property's class
 */
public record MaterialPropertyKey<T extends MaterialProperty<T>>(@NotNull Identifier identifier,
                                                                 @NotNull Class<T> type) {

    /**
     * Cast a property to the proper type
     *
     * @param property the property to cast
     * @return the property cast to the key's corresponding property
     */
    public @Nullable T cast(@Nullable MaterialProperty<?> property) {
        return this.type.cast(property);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialPropertyKey<?> that = (MaterialPropertyKey<?>) o;
        return identifier.equals(that.identifier) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, type);
    }

    @Override
    public @NotNull String toString() {
        return "MaterialPropertyKey{" + "identifier=" + identifier + ", type=" + type + '}';
    }
}
