package chromancy.gui;



import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import chromancy.core.tileentity.LightTableTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerLightTable extends Container{
	
    public static enum State
    {
        ERROR, READY
    }

    
    private LightTableTileEntity lightTableTE;
    public int color;
    public IInventory craftResult;
    
    /**public InventoryCrafting craftMatrix;
    public InventoryCrafting focusSlot;
    public LightTableRecipeHandler recipeHandler;
    private final World worldObj;
    public InventoryPlayer playerInventory;
    public String resultString = "lighttable.result.ready";
    public State craftState = State.READY;
    public int x;
    public int y;
    public int z;
    **/
    public ContainerLightTable(InventoryPlayer inventory, LightTableTileEntity tileEntity)
    {
    	this.lightTableTE = tileEntity;
    	
    	
    
    	this.addSlotToContainer(new SlotCrafting(inventory.player, tileEntity, tileEntity, 10, 137, 35));
    	
    	for(int i=0;i<3;i++)
    	{
    		for(int k=0;k<3;k++)
    		{
    			this.addSlotToContainer(new Slot(tileEntity, k + i * 3 + 1, 41+k*18,18+i*18));
    		}
    	}
    	
    	this.addSlotToContainer(new Slot(tileEntity,0,13,12));
    	
    	for (int i=0;i<3;i++)
    	{
    		for(int k=0;k<9;k++)
    		{
    			this.addSlotToContainer(new Slot(inventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
    		}
    	}
    	
    	for(int i = 0;i<9;i++)
    	{
    		this.addSlotToContainer(new Slot(inventory, i, 8+i*18,142));
    	}
    	
    }
    
    public void addCraftingToCrafters(ICrafting crafting)
    {
    	super.addCraftingToCrafters(crafting);
    }

    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int newValue)
    {
    	
    }
    
    
    
    public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
		}

	}
    	
    /**public ContainerLightTable(InventoryPlayer inventory, World world, int px, int py, int pz)
    {
    	x=px;
    	y=py;
    	z=pz;
    	worldObj = world;
    	craftMatrix  = new InventoryCrafting(this, 3, 3);
    	focusSlot = new InventoryCrafting(this,1,1);
    	craftResult  = new InventoryCraftResult();
    	
    	this.addSlotToContainer(new SlotCrafting(inventory.player, craftMatrix, craftResult, 0, 137, 35));
    	
    	for(int i=0;i<3;i++)
    	{
    		for(int k=0;k<3;k++)
    		{
    			this.addSlotToContainer(new Slot(craftMatrix, k + i * 3, 41+k*18,18+i*18));
    		}
    	}
    	
    	this.addSlotToContainer(new Slot(focusSlot,0,13,12));
    	
    	for (int i=0;i<3;i++)
    	{
    		for(int k=0;k<9;k++)
    		{
    			this.addSlotToContainer(new Slot(inventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
    		}
    	}
    	
    	for(int i = 0;i<9;i++)
    	{
    		this.addSlotToContainer(new Slot(inventory, i, 8+i*18,142));
    	}
    	
    	
    	
    	
    	onCraftMatrixChanged(craftMatrix);
    	
    
    }**/
    

    
   /* public void onCraftMatrixChanged(IInventory inv)
    {
    	//craftResult.setInventorySlotContents(0, LightTableRecipeHandler.getInstance().findMatchingRecipe(craftMatrix,worldObj));
    }
*/
    public boolean canInteractWith(EntityPlayer p1)
    {
        return true;
    }
    
    
    /**
     * Called when the container is closed.
     */
    /**
    public void onContainerClosed(EntityPlayer p1)
    {
        super.onContainerClosed(p1);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    p1.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }
    
    public boolean canInteractWith(EntityPlayer p1)
    {
        return this.worldObj.getBlock(this.x, this.y, this.z) != ChromancyCore.lightTable ? false : p1.getDistanceSq((double)this.x + 0.5D, (double)this.y + 0.5D, (double)this.z + 0.5D) <= 64.0D;
    }
    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (p_82846_2_ >= 10 && p_82846_2_ < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (p_82846_2_ >= 37 && p_82846_2_ < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }


    

	/**
	public boolean canMergeSlot(ItemStack parItemStack, Slot parSlot)
	{
		return !parSlot.inventory.equals(craftResult);
	}

	@Override
	public Slot getSlot(int parSlotIndex)
	{
	    if(parSlotIndex >= inventorySlots.size())
	    parSlotIndex = inventorySlots.size() - 1;
	    return super.getSlot(parSlotIndex);
	}
	**/

}
