package sussytech;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public final class SussyIdentifier {

    private SussyIdentifier() {/**/}

    /**
     * @param path the path for the identifier
     * @return an identifier with the SussyTech modid
     */
    public static @NotNull Identifier of(@NotNull String path) {
        return new Identifier(SussyTech.MODID, path);
    }
}
