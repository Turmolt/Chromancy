package chromancy.core.items;

import chromancy.core.ChromancyCore;
import net.minecraft.item.Item;

public class PrismShard extends Item{
	
	public PrismShard()
	{
		maxStackSize = 64;
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName("prismShard");
		setTextureName("chromancy:prismShard");
	}
}
