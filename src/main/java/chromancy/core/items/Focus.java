package chromancy.core.items;

import java.util.List;

import ibxm.Player;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.command.ICommandSender;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import chromancy.core.ChromancyCore;
import chromancy.core.help.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Focus extends Item{
	
	
	public String[] Colors = {"creative","red","orange","green","yellow","blue","indigo","violet"};
	
	public enum Color{
		CREATIVE, RED, BLUE, ORANGE, YELLOW, GREEN, INDIGO, VIOLET, PALE
	}
	
	public static Color color;
	public boolean isCreative = false;
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public int energy;
	public int maxEnergy;
	public int ticks = 0;
	public int tocks = 0;
	public boolean recharging;
	public int incEnergy;
	
	public Focus(String focusType, int max)
	{
		maxStackSize = 1;								
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName(focusType);
		setTextureName("chromancy:" + focusType);
		icons = new IIcon[8];
		this.energy = 0;
		this.maxEnergy = max;
		this.setMaxDamage(maxEnergy);
		this.recharging = false;

		switch(focusType){
			case "creativeFocus":
				color = Color.CREATIVE;
				isCreative = true;
				break;
			case "redFocus":
				color = Color.RED;
				isCreative = false;
				break;
			case "orangeFocus":
				color = Color.ORANGE;
				isCreative = false;
				break;
			case "yellowFocus":
				color = Color.YELLOW;
				isCreative = false;
				break;
			case "greenFocus":
				color = Color.GREEN;
				isCreative = false;
				break;
			case "blueFocus":
				color = Color.BLUE;
				isCreative = false;
				break;
			case "indigoFocus":
				color = Color.INDIGO;
				isCreative = false;
				break;
			case "violetFocus":
				color = Color.VIOLET;
				isCreative = false;
				break;
			default:
				break;

		}

			
			
	}

	
    // This is a fun method which allows us to run some code when our item is
    // shown in a creative tab. I am going to use it to add all the brain 
    // types.
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List itemList) 
    {
        // This creates a loop with a counter. It will go through once for
        // every listing in brainTypes,  and gives us a number associated 
        // with each listing.
        for (int pos = 0; pos < 8; pos++) 
        {
            // This creates a new ItemStack instance. The item parameter 
            // supplied is this item.
            ItemStack focusStack = new ItemStack(item);
            // By default, a new ItemStack does not have any nbt compound data. 
            // We need to give it some.
            focusStack.setTagCompound(new NBTTagCompound());
            // Now we set the type of the item, brainType is the key, and 
            // brainTypes[pos] is grabbing a
            // entry from the brainTypes array.
            focusStack.getTagCompound().setString("focusType", Colors[pos]);
            // And this adds it to the itemList, which is a list of all items
            // in the creative tab.
            itemList.add(focusStack);
        }
    }
    // This method allows us to have different language translation keys for 
    // each item we add.
    @Override
    public String getUnlocalizedName(ItemStack stack) 
    {
        // This makes sure that the stack has a tag compound. This is how data 
        // is stored on items.
        if (stack.hasTagCompound()) 
        {
            // This is the object holding all of the item data.
            NBTTagCompound itemData = stack.getTagCompound();
            // This checks to see if the item has data stored under the 
            // brainType key.
            if (itemData.hasKey("focusType"))
            {
                // This retrieves data from the brainType key and uses it in
                // the return value
                return "item." + itemData.getString("focusType") + "Focus";
            }
        }
        // This will be used if the item is obtained without nbt data on it.
        return "item.nullFocus";
     }
	

    
    public void rechargeEnergy(int rate)
    {
    		this.recharging=true;
    		this.incEnergy = rate;
    }
	
	
	/**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    
    public void onPlayerStoppedUsing(ItemStack p1, World world, EntityPlayer p_77615_3_, int p_77615_4_)
    {
    	
    	int j = this.getMaxItemUseDuration(p1) - p_77615_4_;

    	//Create new projectile event
    	if(!world.isRemote)
    	{
    		ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p1, j);
    		MinecraftForge.EVENT_BUS.post(event);
    		if (event.isCanceled())
    		{
    			return;
    		}
    		j = event.charge;

    		boolean flag = true;
    		boolean fire = false;

    		if (flag)
    		{

    			float f = (float)j / 20.0F;
    			f = (f * f + f * 2.0F) / 3.0F;



    			if (f > 1.0F)
    			{
    				f = 1.0F;
    			}

    			//reduce energy by 5 if projectile is fired. if not enough energy, return
    			if(this.tocks == 0)
    			{
    				if(this.energy>0)
    				{
    					fire = true;
    					this.energy -= 5;
    				}
    				else if(this.energy <= 0)
    				{
    					System.out.println("Out of Energy");
    					this.energy=0;
    					return;
    				}
    				if (this.recharging)
    					this.recharging = false;
    				this.tocks = 2;
    				System.out.println(this.energy + " " + this.maxEnergy);


    				p1.setItemDamage(this.energy);
    			}

    			//Has arrow been set to fire?
    			if(fire)
    			{
    				fire = false;
    				EntityArrow entityarrow = new EntityArrow(world, p_77615_3_, 1.0f * 2.0F);

    				entityarrow.setIsCritical(true);

    				if(color == Color.RED)
    					entityarrow.setFire(100);



    				entityarrow.setDamage(entityarrow.getDamage() + (double)6 * 0.5D + 0.5D);


    				entityarrow.setKnockbackStrength(6);


    				world.playSoundAtEntity(p_77615_3_, "fire.fire", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
    				System.out.println("GG");
    				world.spawnEntityInWorld(entityarrow);
    				System.out.println("FIRE!");

    			}



    		}
    	}
        

    }
 
    
    /**
     * Queries the percentage of the 'Durability' bar that should be drawn.
     *
     * @param stack The current ItemStack
     * @return 1.0 for 100% 0 for 0%
     */
    @Override
    public double getDurabilityForDisplay(ItemStack stack)
    {
        return (1.0-((double)this.energy) /((double) this.maxEnergy));
    }
    
    //Display icons
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		icons[0] = icon.registerIcon(Reference.MODID + ":creativeFocus");
		icons[1] = icon.registerIcon(Reference.MODID + ":redFocus");
		icons[2] = icon.registerIcon(Reference.MODID + ":orangeFocus");
		icons[3] = icon.registerIcon(Reference.MODID + ":yellowFocus");
		icons[4] = icon.registerIcon(Reference.MODID + ":greenFocus");
		icons[5] = icon.registerIcon(Reference.MODID + ":blueFocus");
		icons[6] = icon.registerIcon(Reference.MODID + ":indigoFocus");
		icons[7] = icon.registerIcon(Reference.MODID + ":violetFocus");
	}
	   
    /**
     * Determines if the durability bar should be rendered for this item.
     * Defaults to vanilla stack.isDamaged behavior.
     * But modders can use this for any data they wish.
     *
     * @param stack The current Item Stack
     * @return True if it should render the 'durability' bar.
     */
    @Override
    public boolean showDurabilityBar(ItemStack stack)
    {
        return true;
    }
    
    //When the item is right clicked.
	@Override
	public ItemStack onItemRightClick(ItemStack p1, World p2, EntityPlayer p3)
	{
		
		if(this.ticks == 0){
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
//					switch(this.color){
//						case CREATIVE:
//							this.color = Color.RED;
//							System.out.println("To Red");
//							break;
//						case RED:
//							this.color = Color.BLUE;
//							System.out.println("To Blue");
//							break;
//						case BLUE:
//							this.color = Color.CREATIVE;
//							System.out.println("To Creative");
//							break;
//						default:
//							System.out.println("oops");
//							break;
//					}

				}
			}
			this.ticks=5;
		}
		return p1;
	}
	
	public void onUpdate(ItemStack stack, World currentWorld, Entity currentPlayer, int p_77663_4_, boolean p_77663_5_) {
		//tick/tock goes down by 1 per tick. for use as in game timer
		if(this.ticks > 0)
			this.ticks-=1;
		if(this.tocks>0)
			this.tocks-=1;
		
		//also checks for this.recharging so my function works too
		if(this.energy < this.maxEnergy)
			if(CanSeeSun(stack, currentPlayer, currentWorld) || this.recharging){
				if(this.energy<this.maxEnergy)
					this.energy+=incEnergy;
				else if(this.energy>this.maxEnergy)
				{
					this.energy=this.maxEnergy;
					this.recharging=false; 
				}
				else if (this.energy==this.maxEnergy)
				{
					System.out.println("full");
					this.recharging = false;
				}
			}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
		switch(getType(stack)){
        case "creative":
        	return icons[0];
        case "red":
        	return icons[1];
        case "orange":
        	return icons[2];
        case "yellow":
       		return icons[3];
       	case "green":
       		return icons[4];
       	case "blue":
       		return icons[5];
       	case "indigo":
       		return icons[6];
       	case "violet":
       		return icons[7];
    	default:
    		return icons[0];
    	}
    }
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass)
    {
		switch(getType(stack)){
        case "creative":
        	return icons[0];
        case "red":
        	return icons[1];
        case "orange":
        	return icons[2];
        case "yellow":
       		return icons[3];
       	case "green":
       		return icons[4];
       	case "blue":
       		return icons[5];
       	case "indigo":
       		return icons[6];
       	case "violet":
       		return icons[7];
    	default:
    		return icons[0];
    	}
		
		
    }
	
	public String getType(ItemStack stack)
	{
		
		
		if (stack.hasTagCompound()) 
        {
            // This is the object holding all of the item data.
            NBTTagCompound itemData = stack.getTagCompound();
            // This checks to see if the item has data stored under the 
            // brainType key.
            if (itemData.hasKey("focusType"))
            {
            	return itemData.getString("focusType");
            }
        }
		return "Null";
		
		
		
	}
	
	 /**
     * Returns the icon index of the stack given as argument.
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack stack)
    {
            switch(getType(stack)){
	            case "creative":
	            	return icons[0];
	            case "red":
	            	return icons[1];
	            case "orange":
	            	return icons[2];
	            case "yellow":
	           		return icons[3];
	           	case "green":
	           		return icons[4];
	           	case "blue":
	           		return icons[5];
	           	case "indigo":
	           		return icons[6];
	           	case "violet":
	           		return icons[7];
            	default:
            		return icons[0];
            	}
    }
	@SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }
	
	// Check to see if player is on top world block and sun is out
	public static boolean CanSeeSun(ItemStack stack, Entity currentPlayer, World world){
		//added energy < maxEnergy so it doesnt try to charge when full
		//also added !recharging so that if it is recharging using my method it wont also charge using yours at the same time
		Focus f = (Focus)stack.getItem();
		if(f.energy < f.maxEnergy&&!f.recharging && ((world.getCelestialAngle(0) < .25) ||
				(world.getCelestialAngle(0) > .75)) && (world.getRainStrength(0) < 0.25))
		{
			//set charge rate
			f.incEnergy=1;
			ChunkCoordinates playerCoord = ((ICommandSender) currentPlayer).getPlayerCoordinates();

			int x = playerCoord.posX;
			int y = playerCoord.posY;
			int z = playerCoord.posZ;
			int highestWorldY = world.getHeightValue(x, z);
		
			return  (y > highestWorldY);
		}
		else
			return false;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean isAdvanced)
	{
		tooltip.add(StatCollector.translateToLocal("focus.tooltip"));
	}
	
    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }
    
}
