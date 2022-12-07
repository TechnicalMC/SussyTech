package sussytech;

import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sussytech.api.blocks.NCrate;
import sussytech.api.entities.NCrateEntity;

public class SussyTech implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("SussyTech");

    public static final NCrate WOODEN_CRATE = new NCrate(QuiltBlockSettings.of(Material.WOOD), 9);

    public static final BlockEntityType<NCrateEntity> NCRATE_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier("sussytech", "ncrate_entity"),
            QuiltBlockEntityTypeBuilder.create(NCrateEntity::new, WOODEN_CRATE).build()
    );

    @Override
    public void onInitialize(@NotNull ModContainer mod) {
        LOGGER.info("Beginning Initialization...");

        Registry.register(Registry.BLOCK, new Identifier("sussytech", "wooden_crate"), WOODEN_CRATE);
        Registry.register(Registry.ITEM, new Identifier("sussytech", "wooden_crate"), new BlockItem(WOODEN_CRATE, new QuiltItemSettings().group(ItemGroup.MISC)));
    }
}
