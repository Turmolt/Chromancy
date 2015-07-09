package chromancy.core.items;

import chromancy.core.ChromancyCore;
import net.minecraft.item.Item;

public class Lumingot extends Item{

	public Lumingot(int StackSize, String name){
		maxStackSize = StackSize;
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName(name);
		setTextureName("chromancy:" + name);
	}
}
