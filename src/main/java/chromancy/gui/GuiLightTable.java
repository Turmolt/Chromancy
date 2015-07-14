package chromancy.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import chromancy.core.tileEntity.LightTableTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiLightTable extends GuiContainer{
	
	public ContainerLightTable container;

	public LightTableTileEntity lightTableTE;
	
	private static final ResourceLocation lightGuiTextures = new ResourceLocation("chromancy:textures/gui/lightTableGui.png");
	private InventoryLightTableResult tile;
	
	public GuiLightTable(InventoryPlayer inventory, LightTableTileEntity entity){
		super(new ContainerLightTable(inventory, entity));
		
		this.lightTableTE = entity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int v1, int v2){
		
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Light Table"), 100, 5, 0x000000);
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float v1, int v2, int v3) {
		
		GL11.glColor4f(1f, 1f, 1f, 1f);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(lightGuiTextures);
		
		drawTexturedModalRect(guiLeft,guiTop,0,0,xSize,ySize);
		
		
	}

}
