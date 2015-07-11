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
	
	/**@Override
	public void drawScreen(int p1, int p2, float p3)
	{
		super.drawScreen(p1,p2,p3);
	}**/
	
	@Override
	protected void drawGuiContainerForegroundLayer(int v1, int v2){
		
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Light Table"), 100, 5, 0x000000);
		
		/**GL11.glDisable(GL11.GL_LIGHTING);
		
		fontRendererObj.drawString(blockName, xSize/2-fontRendererObj.getStringWidth(blockName)/2+1,5,4210752);
		fontRendererObj.drawString(I18n.format("container.inventory"), 6,ySize-96+2,4210752);
		
		String string = container.resultString;
		if(string!=null)
		{
			State msgType = container.craftState;
			EnumChatFormatting format = EnumChatFormatting.GREEN;
			EnumChatFormatting shadowFormat = EnumChatFormatting.DARK_GRAY;
			if(msgType==ContainerLightTable.State.ERROR)
			{
				format = EnumChatFormatting.WHITE;
				shadowFormat = EnumChatFormatting.DARK_RED;
			}
			fontRendererObj.drawString(shadowFormat + string + EnumChatFormatting.RESET,  6+1, ySize - 95+2 - fontRendererObj.FONT_HEIGHT, 0);
		}
		GL11.glEnable(GL11.GL_LIGHTING);
		**/
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float v1, int v2, int v3) {
		
		GL11.glColor4f(1f, 1f, 1f, 1f);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(lightGuiTextures);
		
		drawTexturedModalRect(guiLeft,guiTop,0,0,xSize,ySize);
		
		
		/**
		GL11.glPushMatrix();
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		
		this.mc.getTextureManager().bindTexture(lightGuiTextures);
		int k = width/2 - xSize/2;
		int l = height/2 - ySize / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
		GL11.glPopMatrix();
		**/
		
	}

}
