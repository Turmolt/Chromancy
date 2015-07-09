package chromancy.core.items;

import chromancy.core.ChromancyCore;
import net.minecraft.item.Item;

public class GreenLumingot extends Item {
	
	public GreenLumingot()
	{
		maxStackSize = 64;
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName("greenLumingot");
		setTextureName("chromancy:greenLumingot");
	}

}