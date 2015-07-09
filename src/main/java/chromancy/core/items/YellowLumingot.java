package chromancy.core.items;

import chromancy.core.ChromancyCore;
import net.minecraft.item.Item;

public class YellowLumingot extends Item {

	public YellowLumingot()
	{
		maxStackSize = 64;
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName("yellowLumingot");
		setTextureName("chromancy:yellowLumingot");
	}
}
