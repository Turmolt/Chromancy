package chromancy.core.items;

import chromancy.core.ChromancyCore;
import net.minecraft.item.Item;

public class PrismCore extends Item{
	
	public PrismCore()
	{
		maxStackSize = 64;
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName("prismCore");
		setTextureName("chromancy:prismCore");
	}
	
}
