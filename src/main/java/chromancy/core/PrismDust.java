package chromancy.core;

import net.minecraft.item.Item;


public class PrismDust extends Item{
	
	public PrismDust()
	{
		maxStackSize = 64;
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName("prismDust");
		setTextureName("chromancy:prismDust");
	}

}