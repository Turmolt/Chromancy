package chromancy.core.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import chromancy.core.ChromancyCore;
import chromancy.gui.ChromancyBook;

public class ChromancyBookItem extends Item {

	public ChromancyBookItem(int StackSize, String name){				//Pre: Integer stack size, String name of item
		maxStackSize = StackSize;								//Post: Create item with given stack size and unlocalized name
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName(name);
		setTextureName("chromancy:" + name);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
		
		if(!world.isRemote){
			Minecraft.getMinecraft().displayGuiScreen(new ChromancyBook());
		}
		return super.onItemRightClick(item, world, player);
		
	}
}
