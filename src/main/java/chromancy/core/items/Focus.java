package chromancy.core.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
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
	
	public static int nrg;
	public static int ticks = 0;
	
	public Focus(int StackSize, String focusType)
	{
		maxStackSize = StackSize;								
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName(focusType);
		setTextureName("chromancy:" + focusType);
		icons = new IIcon[3];
		nrg = 100;
		this.setMaxDamage(nrg);
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
	
    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }
	
	
	/**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack p1, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_)
    {
        int j = this.getMaxItemUseDuration(p1) - p_77615_4_;

        ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p1, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = true;

        if (flag)
        {
        	
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityArrow(p_77615_2_, p_77615_3_, 1.0f * 2.0F);

            entityarrow.setIsCritical(true);
            
            if(color == Color.RED)
            	entityarrow.setFire(100);
            


            entityarrow.setDamage(entityarrow.getDamage() + (double)6 * 0.5D + 0.5D);
            

            entityarrow.setKnockbackStrength(6);


            p_77615_2_.playSoundAtEntity(p_77615_3_, "fire.fire", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (!p_77615_2_.isRemote)
            {
                p_77615_2_.spawnEntityInWorld(entityarrow);
            }
            if(ticks == 0)
            {
            	if(nrg>0)
            		nrg -= 5;
            	else
            		nrg = 100;
            	ticks = 2;
            
            	p1.setItemDamage(100-nrg);
            }

        }

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
			{
				ArrowNockEvent event = new ArrowNockEvent(p3, p1);
		        MinecraftForge.EVENT_BUS.post(event);
		        if (event.isCanceled())
		        {
		            return event.result;
		        }
		
		        if (p3.capabilities.isCreativeMode || p3.inventory.hasItem(Items.arrow))
		        {
		            p3.setItemInUse(p1, this.getMaxItemUseDuration(p1));
		        }
		
		        return p1;
		}
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
