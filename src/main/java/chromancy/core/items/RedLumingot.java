package chromancy.core.items;

import chromancy.core.ChromancyCore;
import net.minecraft.item.Item;

public class RedLumingot extends Item {
	
	public RedLumingot()
	{
		maxStackSize = 64;
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName("redLumingot");
		setTextureName("chromancy:redLumingot");
	}

}