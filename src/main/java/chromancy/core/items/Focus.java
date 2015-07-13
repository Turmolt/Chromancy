package chromancy.core.items;

import javax.swing.Icon;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import chromancy.core.ChromancyCore;
import chromancy.core.help.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Focus extends Item{
	
	
	public static enum Color{
		CREATIVE, RED, BLUE, ORANGE, YELLOW, GREEN, INDIGO, VIOLET, PALE
	}
	
	public static Color color;
	public boolean isCreative = false;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public static int ticks = 0;
	
	public Focus(int StackSize, String focusType)
	{
		maxStackSize = StackSize;								
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName(focusType);
		setTextureName("chromancy:" + focusType);
		icons = new IIcon[3];
		if(focusType == "creativeFocus")
		{
			color = Color.CREATIVE;
			isCreative = true;
		}
		else if(focusType == "redFocus")
			color = Color.RED;
		else if(focusType == "orangeFocus")
			color = Color.ORANGE;
		else if(focusType == "yellowFocus")
			color = Color.YELLOW;
		else if(focusType == "greenFocus")
			color = Color.GREEN;
		else if(focusType == "blueFocus")
			color = Color.BLUE;
		else if(focusType == "indigoFocus")
			color = Color.INDIGO;
		else if(focusType == "violetFocus")
			color = Color.VIOLET;
		
			
			
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		icons[0] = icon.registerIcon(Reference.MODID + ":creativeFocus");
		icons[1] = icon.registerIcon(Reference.MODID + ":redFocus");
		icons[2] = icon.registerIcon(Reference.MODID + ":blueFocus");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack p1, World p2, EntityPlayer p3)
	{
		if(ticks == 0){
			if(!p3.isSneaking())
				System.out.println("Prism Use");
			else
			{
				if(isCreative)
				{
					switch(this.color){
						case CREATIVE:
							this.color = Color.RED;
							System.out.println("To Red");
							break;
						case RED:
							this.color = Color.BLUE;
							System.out.println("To Blue");
							break;
						case BLUE:
							this.color = Color.CREATIVE;
							System.out.println("To Creative");
							break;
						default:
							System.out.println("oops");
							break;
					}
			
				}
			}
			ticks=5;
		}
		return p1;
	}
	
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
		if(ticks > 0)
			ticks-=1;
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
		switch(this.color){
			case CREATIVE:
				return icons[0];
			case RED:
				return icons[1];
			case BLUE:
				return icons[2];
			default:
				break;
		}
        return getIcon(stack, renderPass);
    }
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass)
    {
		
		switch(color){
		case CREATIVE:
			return icons[0];
		case RED:
			return icons[1];
		case BLUE:
			return icons[2];
		default:
			break;
	}
    return icons[0];
		
		
    }
	
	 /**
     * Returns the icon index of the stack given as argument.
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack p_77650_1_)
    {
    	switch(color){
    		case CREATIVE:
    			return icons[0];
    		case RED:
    			return icons[1];
    		case BLUE:
    			return icons[2];
    		default:
    			break;
    	}
        return icons[0];
    }
	@SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }
	
}
