package chromancy.gui;



import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import chromancy.core.tileEntity.LightTableTileEntity;
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
    	
    	this.addSlotToContainer(new LightTableSlot(tileEntity,0,13,12));
    	
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
    


    public boolean canInteractWith(EntityPlayer p1)
    {
        return true;
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

}
