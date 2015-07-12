package chromancy.gui;

import chromancy.core.ChromancyCore;
import chromancy.core.tileentity.LightTableTileEntity;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(ID==ChromancyCore.GUIID.LIGHTTABLE.ordinal())
			return new ContainerLightTable(player.inventory,(LightTableTileEntity)entity);
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(ID==ChromancyCore.GUIID.LIGHTTABLE.ordinal())
			return new GuiLightTable(player.inventory, (LightTableTileEntity)entity);
		return null;
	}
}
