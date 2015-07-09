package chromancy.core.items;

import chromancy.core.ChromancyCore;
import net.minecraft.item.Item;

public class VioletLumingot extends Item {

	public VioletLumingot()
	{
		maxStackSize = 64;
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName("violetLumingot");
		setTextureName("chromancy:violetLumingot");
	}
}
