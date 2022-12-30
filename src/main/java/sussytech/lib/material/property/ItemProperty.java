package sussytech.lib.material.property;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sussytech.SussyIdentifier;
import sussytech.api.material.Material;
import sussytech.api.material.property.MaterialProperty;
import sussytech.api.material.property.MaterialPropertyKey;
import sussytech.api.material.property.type.MaterialBlockType;
import sussytech.api.material.property.type.MaterialItemType;
import sussytech.lib.item.MaterialItem;

import java.util.Collection;
import java.util.Map;

public final class ItemProperty implements MaterialProperty<ItemProperty> {

    public static final MaterialPropertyKey<ItemProperty> KEY = new MaterialPropertyKey<>(SussyIdentifier.of("item_property"), ItemProperty.class);

    private final Map<MaterialItemType, Item> items = new Object2ObjectOpenHashMap<>();

    /**
     * @param type the item type of the item
     * @return the item for the ItemType
     */
    public @Nullable Item getItem(@NotNull MaterialItemType type) {
        return items.get(type);
    }

    /**
     * @param type the item type of the item
     * @return the ItemStack for the ItemType with a quantity of 1
     */
    public @NotNull ItemStack getStack(@NotNull MaterialItemType type) {
        return getStack(type, 1);
    }

    /**
     * @param type   the item type of the item
     * @param amount the amount of items in the stack
     * @return the ItemStack for the ItemType
     */
    public @NotNull ItemStack getStack(@NotNull MaterialItemType type, int amount) {
        Item item = getItem(type);
        if (item == null || item == Items.AIR) return ItemStack.EMPTY;
        return new ItemStack(item, amount);
    }

    /**
     * Set an item for the ItemType
     *
     * @param type the ItemType to map to
     * @param item the item corresponding to the ItemType
     */
    public void setItem(@NotNull MaterialItemType type, @NotNull Item item) {
        this.items.put(type, item);
    }

    /**
     * @return all the item types in this property
     */
    public @NotNull Collection<MaterialItemType> getItemTypes() {
        return this.items.keySet();
    }

    /**
     * @return all the items in this property
     */
    public @NotNull Collection<Item> getItems() {
        return this.items.values();
    }

    @Override
    public @NotNull MaterialPropertyKey<ItemProperty> getKey() {
        return KEY;
    }

    @Override
    public void registerContents(@NotNull Material material) {
        for (MaterialItemType type : getItemTypes()) {
            Item item = getItem(type);
            if (item == null || item == Items.AIR) {
                item = new MaterialItem(type.createSettings(material), type, material);

                Identifier identifier = createItemIdentifier(type, material);

                Registry.register(Registries.ITEM, identifier, item);
                this.items.put(type, item);

                //TODO register tags to the items
            }
        }
    }

    @Override
    public void registerContentsPost(@NotNull Material material) {
        // BlockItem registration
        BlockProperty property = material.getProperty(BlockProperty.KEY);
        if (property == null) return;

        for (MaterialBlockType type : property.getBlockTypes()) {
            Block block = property.getBlock(type);
            if (block == null || block == Blocks.AIR) continue;
            MaterialItemType itemType = type.itemType();

            Identifier identifier = createItemIdentifier(itemType, material);
            BlockItem blockItem = new BlockItem(block, itemType.createSettings(material));

            Registry.register(Registries.ITEM, identifier, blockItem);
            this.items.put(itemType, blockItem);

            //TODO register tags to the items
        }
    }

    /**
     * @param type     the item type
     * @param material the material
     * @return the name for the item
     */
    private static @NotNull Identifier createItemIdentifier(@NotNull MaterialItemType type, @NotNull Material material) {
        return new Identifier(material.getIdentifier().getNamespace(), type.name() + "." + material.getIdentifier().getPath());
    }
}
