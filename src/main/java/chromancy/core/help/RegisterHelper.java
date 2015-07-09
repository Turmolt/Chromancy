package chromancy.core.help;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import chromancy.core.ChromancyCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper {
	
	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, Reference.MODID + "_" + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, Reference.MODID + "_" + item.getUnlocalizedName().substring(5));
	}
	
	public static void addSmelting(Item input, Item output, float experience)
	{
		GameRegistry.addSmelting(input, new ItemStack(output), experience);
	}
	
}
