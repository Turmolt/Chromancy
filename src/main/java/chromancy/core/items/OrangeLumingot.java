package chromancy.core.items;

import chromancy.core.ChromancyCore;
import net.minecraft.item.Item;

public class OrangeLumingot extends Item {
	
	public OrangeLumingot()
	{
		maxStackSize = 64;
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName("orangeLumingot");
		setTextureName("chromancy:orangeLumingot");
	}

}
