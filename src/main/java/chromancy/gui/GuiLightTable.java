package chromancy.gui;

import org.lwjgl.opengl.GL11;

import chromancy.gui.ContainerLightTable.State;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiLightTable extends GuiContainer{
	
	public ContainerLightTable container;
	private final String blockName;
	
	private static final ResourceLocation lightGuiTextures = new ResourceLocation("chromancy:textures/gui/lightTableGui.png");
	private InventoryLightTableResult tile;
	
	public GuiLightTable(InventoryPlayer inventory, World world, String theBlockName, int x, int y, int z){
		super(new ContainerLightTable(inventory, world, x, y, z));
		blockName = theBlockName;
		
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
