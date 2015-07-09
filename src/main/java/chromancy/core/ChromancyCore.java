package chromancy.core;

import net.minecraft.block.Block;
import chromancy.core.help.Reference;
import chromancy.core.help.RegisterHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class ChromancyCore {
	
	public static Block prismOre;
	
	//Comment
	@EventHandler
	public void preinit(FMLInitializationEvent event)
	{
		prismOre = new BlockPrismOre();
		
		RegisterHelper.registerBlock(prismOre);
	}

}
