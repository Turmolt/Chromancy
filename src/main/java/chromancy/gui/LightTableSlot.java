package chromancy.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class LightTableSlot extends Slot{

	 @SideOnly(Side.CLIENT)
	    protected ResourceLocation texture;
	
	public LightTableSlot(IInventory p1, int p2, int p3, int p4) {
		super(p1, p2, p3, p4);
		
	}
	
  /**
  * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
  */
	@Override
    public boolean isItemValid(ItemStack p1)
    {
        return (p1.getDisplayName().contains("Focus"));
    }
	
    /**
     * if par2 has more items than par1, onCrafting(item,countIncrease) is called
     */
    public void onSlotChange(ItemStack p1, ItemStack p2)
    {
        if (p1 != null && p2 != null)
        {
            if (p1.getItem() == p2.getItem())
            {
                int i = p2.stackSize - p1.stackSize;

                if (i > 0)
                {
                    this.onCrafting(p1, i);
                }
            }
        }
    }
	
	
	
	
}
