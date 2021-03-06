package chromancy.core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import chromancy.core.blocks.BlockPrismOre;
import chromancy.core.blocks.LightAmplificationDevice;
import chromancy.core.blocks.LightTable;
import chromancy.core.blocks.LightTable;
import chromancy.core.help.Reference;
import chromancy.core.help.RegisterHelper;
import chromancy.core.items.BasicItem;
import chromancy.core.items.ChromancyBookItem;
import chromancy.core.items.LightCrystal;
import chromancy.core.items.Lumingot;
import chromancy.core.tileEntity.LADTileEntity;
import chromancy.core.tileEntity.LightTableTileEntity;
import chromancy.core.items.Focus;
import chromancy.generation.ChromancyWorld;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
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
	
	//enumerate guis
	public enum GUIID
	{
		LIGHTTABLE, PRISMTABLE							//gui names go here
	}
	
	//Creating the creative tab
	public static CreativeTabs chromancyTab = new CreativeTabs("Chromancy"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return Item.getItemFromBlock(prismOre);
		}
		
	};
	
	@SidedProxy(clientSide = "chromancy.core.ClientProxy", serverSide = "chromancy.core.ServerProxy")
	public static ServerProxy proxy;
	
	
	//Declare Blocks
	public static Block prismOre;
	public static Block lightTable;
	public static Block lightAmplificationDevice;
	
	//Crafting table Block
	public static Block chromancyCraftingTable;
	
	//Declare Items
	public static Item essenceOfPureLight;
	public static Item basicPrism;
	public static Item prismDust;
	public static Item prismShard;
	public static Item prismCore;
	public static Item paleLumingot;
	public static Item blueLumingot;
	public static Item redLumingot;
	public static Item yellowLumingot;
	public static Item indigoLumingot;
	public static Item violetLumingot;
	public static Item orangeLumingot;
	public static Item greenLumingot;
	public static Item creativeFocus;
	public static Item lens;
	public static Item chromancyBookItem;
	
	//Declare energy related items
	public static Item lightStorageCrystal;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// World Generation
		ChromancyWorld.mainRegistry();
		
		// Initialize and register Blocks here
		prismOre = new BlockPrismOre();
		lightTable = new LightTable();
		lightAmplificationDevice = new LightAmplificationDevice();

		RegisterHelper.registerBlock(prismOre);
		RegisterHelper.registerBlock(lightTable);
		RegisterHelper.registerBlock(lightAmplificationDevice);
		
		// Initialize and register Items here
		essenceOfPureLight = new BasicItem(64, "essenceOfPureLight");
		basicPrism = new BasicItem(64, "basicPrism");
		prismDust = new BasicItem(64, "prismDust");
		prismShard = new BasicItem(64, "prismShard");
		prismCore = new BasicItem(64, "prismCore");
		paleLumingot = new Lumingot(64, "paleLumingot");
		blueLumingot = new Lumingot(64, "blueLumingot");
		redLumingot = new Lumingot(64, "redLumingot");
		orangeLumingot = new Lumingot(64, "orangeLumingot");
		yellowLumingot = new Lumingot(64, "yellowLumingot");
		greenLumingot = new Lumingot(64, "greenLumingot");
		indigoLumingot = new Lumingot(64, "indigoLumingot");
		violetLumingot = new Lumingot(64, "violetLumingot");
		creativeFocus = new Focus("creativeFocus", 100);
		lens = new BasicItem(64, "lens");
		chromancyBookItem = new ChromancyBookItem(1, "chromancyBookItem");
		
		
		RegisterHelper.registerItem(chromancyBookItem);
		RegisterHelper.registerItem(basicPrism);
		RegisterHelper.registerItem(essenceOfPureLight);
		RegisterHelper.registerItem(prismDust);
		RegisterHelper.registerItem(prismShard);
		RegisterHelper.registerItem(prismCore);
		RegisterHelper.registerItem(paleLumingot);
		RegisterHelper.registerItem(blueLumingot);
		RegisterHelper.registerItem(redLumingot);
		RegisterHelper.registerItem(yellowLumingot);
		RegisterHelper.registerItem(violetLumingot);
		RegisterHelper.registerItem(indigoLumingot);
		RegisterHelper.registerItem(greenLumingot);
		RegisterHelper.registerItem(orangeLumingot);
		RegisterHelper.registerItem(creativeFocus);
		RegisterHelper.registerItem(lens);
		
		// Initialize and register energy containing items here
		lightStorageCrystal = new LightCrystal(124012, "lightStorageCrystal");
		
		RegisterHelper.registerItem(lightStorageCrystal);
		
		proxy.registerRenderThings();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Smelting
		RegisterHelper.addSmelting(prismDust, prismShard, 10);
		
		//Crafting
		GameRegistry.addRecipe(new ItemStack(prismCore), " x ","x x"," x ",'x', prismShard);
		GameRegistry.addRecipe(new ItemStack(basicPrism), "xx ","xx ","xx ",'x', prismShard);
		GameRegistry.addRecipe(new ItemStack(paleLumingot), "xxx","xxx", 'x', prismShard);
		GameRegistry.addRecipe(new ItemStack(lens), "###","#x#","###", '#', Blocks.glass_pane, 'x', prismShard);
		GameRegistry.addRecipe(new ItemStack(lightAmplificationDevice), "#x#","#o#","#x#", '#', Items.iron_ingot, 'o', Blocks.planks, 'x', lens);
		GameRegistry.addRecipe(new ItemStack(lightTable), "www","xxx","xxx",'w', Blocks.planks, 'x', prismShard);

		//Tile Entity
		GameRegistry.registerTileEntity(LightTableTileEntity.class, "LightTable");
		GameRegistry.registerTileEntity(LADTileEntity.class, "LADTileEntity");
	
		
		proxy.registerNetwork();
		
		
		
		
		

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}

}
