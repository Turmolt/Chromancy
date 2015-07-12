package chromancy.core.items;

import net.minecraft.item.Item;
import chromancy.core.ChromancyCore;

public class LightCrystal extends Item {
	
	public LightCrystal(int MaxPower, String name){		
		maxStackSize = 1;
		this.setMaxDamage(20);								
		setCreativeTab(ChromancyCore.chromancyTab);
		setUnlocalizedName(name);
		setTextureName("chromancy:" + name);
	}
}
