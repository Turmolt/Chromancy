package chromancy.core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import chromancy.core.help.Reference;
import chromancy.core.help.RegisterHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class ChromancyCore {
	
	@Instance(value = Reference.MODID)
	public static ChromancyCore instance;
	
	
	//Creating the creative tab
	public static CreativeTabs chromancyTab = new CreativeTabs("Chromancy"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return Item.getItemFromBlock(prismOre);
		}
		
	};
	
	//Declare Blocks
	public static Block prismOre;
	
	//Declare Items
	public static Item prismDust;
	public static Item prismShard;
	public static Item prismCore;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Initialize and register blocks here
		prismOre = new BlockPrismOre();
		prismDust = new PrismDust();
		prismShard = new PrismShard();
		prismCore = new PrismCore();
		
		RegisterHelper.registerBlock(prismOre);
		RegisterHelper.registerItem(prismDust);
		RegisterHelper.registerItem(prismShard);
		RegisterHelper.registerItem(prismCore);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Smelting
		RegisterHelper.addSmelting(prismDust, prismShard, 10);
		
		//Crafting
		GameRegistry.addRecipe(new ItemStack(prismCore), " x ","x x"," x ",'x', prismShard);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}

}
