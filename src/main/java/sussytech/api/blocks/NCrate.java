package sussytech.api.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import sussytech.api.entities.NCrateEntity;

public class NCrate extends Block implements BlockEntityProvider {
    private int storageSize;

    public NCrate(Settings settings, int storageSize) {
        super(settings);
        this.storageSize = storageSize;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        NCrateEntity entity = new NCrateEntity(pos, state);
        entity.setStorageSize(this.storageSize);
        return entity;
    }

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (world.isClient) return ActionResult.SUCCESS;
        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);

        if (!player.getStackInHand(hand).isEmpty()) {
            for (int i = 0; i < blockEntity.size(); i++) {
                if (blockEntity.getStack(i).isEmpty()) {
                    blockEntity.setStack(i, player.getStackInHand(hand).copy());
                    player.getStackInHand(hand).setCount(0);
                }
            }
        } else {
            for (int i = 0; i < blockEntity.size(); i++) {
                if (!blockEntity.getStack(i).isEmpty()) {
                    player.getInventory().offerOrDrop(blockEntity.getStack(i));
                    blockEntity.removeStack(i);
                    break;
                }
            }
        }

        return ActionResult.SUCCESS;
    }
}
