package chromancy.core;

import chromancy.gui.GuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ServerProxy {
	public void registerRenderThings()
	{
		
	}
	
	public int addArmor(String armor)
	{
		return 0;
	}
	
	public void registerNetwork()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(ChromancyCore.instance, new GuiHandler());
	}
}
