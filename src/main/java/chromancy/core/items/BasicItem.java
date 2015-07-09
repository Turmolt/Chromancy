package chromancy.core.items;

import chromancy.core.ChromancyCore;
import net.minecraft.item.Item;

public class BasicItem extends Item {

	public BasicItem(int StackSize, String name){				//Pre: Integer stack size, String name of item
		maxStackSize = StackSize;								//Post: Create item with given stack size and unlocalized name
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName(name);
		setTextureName("chromancy:" + name);
	}
}


