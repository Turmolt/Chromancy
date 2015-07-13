package chromancy.core.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import chromancy.core.items.Focus;
import chromancy.core.items.Focus.Color;

public class LightTableTileEntity extends TileEntity implements ISidedInventory{
	
	private String localizedName;
	
	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{2,1};
	private static final int[] slots_side = new int[]{1};
	
	private ItemStack[] slots = new ItemStack[11];
	
	public static boolean working = false;
	
	public void setGuiDisplayName(String displayName){
		this.localizedName = displayName;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return this.slots.length;
	}
	

	public void openInventory() {
		// TODO Auto-generated method stub
		setInventorySlotContents(0,this.slots[0]);
	}


	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canInsertItem(int p1, ItemStack itemStack, int p_102007_3_) {
		return this.isItemValidForSlot(p1, itemStack);
	}

	@Override
	public boolean canExtractItem(int p1, ItemStack itemStack, int p3) {
		return p3 != 0 || p1 != 1 || itemStack.getItem() == Items.bucket;
	}
	
	@Override
	public ItemStack getStackInSlot(int var1) {
		return this.slots[var1];
	}
	
	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		if(this.slots[var1] != null){
			ItemStack itemstack;
			
			if(this.slots[var1].stackSize <= var2 ){
				itemstack = this.slots[var1];
				this.slots[var1] = null;
				return itemstack;
			}else{
				itemstack = this.slots[var1].splitStack(var2);
				
				if(this.slots[var1].stackSize == 0) {
					this.slots[var1] = null;
				}
				
				return itemstack;
			}
		}else{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if(this.slots[i]!= null) {
			ItemStack itemstack = this.slots[i];
			this.slots[i] = null;
			return itemstack;
		}
		return null;
	}

	
	
	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		if(itemstack!=null)
		{
			this.slots[i] = itemstack;
			System.out.println("Slot: " + i);
			if(itemstack.getDisplayName().contains("Focus") && i == 0)
			{
				System.out.println("Focus!!!!");
				Focus f = (Focus) itemstack.getItem();
				if(f.color == Color.BLUE)
					System.out.println("Blue In Crafting");
				else if(f.color == Color.RED)
					System.out.println("Red In Crafting");
				else if(f.color == Color.CREATIVE)
					System.out.println("Creative In Crafting");
				f.setDamage(itemstack, 0);
				f.nrg = 100;
			}
			
			
			working = true;
			}
		
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return this.hasCustomInventoryName() ? this.localizedName : "container.lightTable";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return this.localizedName != null && this.localizedName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}



	@Override
	public boolean isItemValidForSlot(int p1, ItemStack itemStack) {
		if(p1 == 0)
			return itemStack.getDisplayName().contains("Focus");
		else if (p1==10)
			return false;
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p1) {
		return p1 == 0 ? slots_bottom : (p1==1? slots_top : slots_side);
	}

	public void updateEntity()
	{
		//Change flag to true when the table is processing things on its own. it forces the data to be saved
		boolean flag = false;
		if (this.working)
		{
			//update while working
			flag = true;
			this.working = false;
		}
		if(!this.worldObj.isRemote)
		{
			//update processes
		}
		if(flag)
			this.markDirty();
		
	}
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];
		
		for(int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
			byte b = compound.getByte("Slot");
			
			if(b >= 0 && b < this.slots.length) {
				this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
			}
		}
		
		
		if(nbt.hasKey("CustomName")) {
			this.localizedName = nbt.getString("CustomName");
		}
	}
	
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		
		NBTTagList list = new NBTTagList();
		
		for (int i = 0; i < this.slots.length; i++) {
			if(this.slots[i] != null) {
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte)i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}
		
		nbt.setTag("Items", list);
		
		if (this.hasCustomInventoryName()) {
			nbt.setString("CustomName", this.localizedName);
		}
	}

}
