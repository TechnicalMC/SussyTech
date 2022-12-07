package sussytech.api.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sussytech.SussyTech;
import sussytech.api.inventories.NCrateInventory;

public class NCrateEntity extends BlockEntity implements NCrateInventory {
    private DefaultedList<ItemStack> items;

    public NCrateEntity(BlockPos pos, BlockState state) {
        super(SussyTech.NCRATE_ENTITY, pos, state);
    }

    public void setStorageSize(int storageSize) {
        this.items = DefaultedList.ofSize(storageSize, ItemStack.EMPTY);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, this.items);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.items);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.items;
    }
}
