package chromancy.core.items;

import chromancy.core.ChromancyCore;
import net.minecraft.item.Item;

public class IndigoLumingot extends Item {

	public IndigoLumingot()
	{
		maxStackSize = 64;
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName("indigoLumingot");
		setTextureName("chromancy:indigoLumingot");
	}
}
