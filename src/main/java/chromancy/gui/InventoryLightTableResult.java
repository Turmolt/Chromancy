package chromancy.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class InventoryLightTableResult implements IInventory{

	private final ItemStack[] stackResult = new ItemStack[1];
	private ContainerLightTable eventHandler;
	
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int p1) {
		// TODO Auto-generated method stub
		return stackResult[p1];
	}

	@Override
	public ItemStack decrStackSize(int p1, int p2) {
		// TODO Auto-generated method stub
		if(stackResult[p1] != null)
		{
			ItemStack itemstack = stackResult[p1];
			stackResult[p1] = null;
			return itemstack;
		}
		else
			return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p1) {
		// TODO Auto-generated method stub
		if(stackResult[p1]!=null)
		{
			ItemStack itemstack = stackResult[p1];
			stackResult[p1] = null;
			return itemstack;
		}
		else
			return null;
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p1) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int p1, ItemStack p2) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO Auto-generated method stub
		
	}
	

}
