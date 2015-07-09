package chromancy.core.items;

import chromancy.core.ChromancyCore;
import net.minecraft.item.Item;

public class BlueLumingot extends Item {
	
	public BlueLumingot()
	{
		maxStackSize = 64;
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName("blueLumingot");
		setTextureName("chromancy:blueLumingot");
	}

}
