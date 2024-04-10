package net.jason13.examplemod.methods;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BlockMethods {
  public static boolean compareBlockToBlock(Block pBlock0, Block pBlock1) {
    if (pBlock0 == null || pBlock1 == null) {
      return false;
    }
    return pBlock0.equals(pBlock1);
  }
  public static boolean compareBlockToItem(Block pBlock, Item pItem) {
    if (pBlock == null || pItem == null) {
      return false;
    }
    Block toCompare = Block.byItem(pItem);
    return compareBlockToBlock(pBlock, toCompare);
  }
  public static boolean compareBlockToItemStack(Block pBlock, ItemStack pItemStack) {
    if (pBlock == null || pItemStack == null) {
      return false;
    }
    Item toCompare = pItemStack.getItem();
    return compareBlockToItem(pBlock, toCompare);
  }
  public static boolean compareBlockToBlockState(Block pBlock, BlockState pBlockState) {
    if (pBlock == null || pBlockState == null) {
      return false;
    }
    Block toCompare = pBlockState.getBlock();
    return compareBlockToBlock(pBlock, toCompare);
  }
  public static boolean compareBlockToLevelPosition(Block pBlock, Level pLevel, BlockPos pBlockPos) {
    if (pBlock == null || pLevel == null || pBlockPos == null) {
      return false;
    }
    BlockState toCompare = pLevel.getBlockState(pBlockPos);
    return compareBlockToBlockState(pBlock, toCompare);
  }
}
