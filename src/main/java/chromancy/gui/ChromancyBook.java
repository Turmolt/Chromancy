package chromancy.gui;

import org.lwjgl.opengl.GL11;

import chromancy.core.help.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ChromancyBook extends GuiScreen {
	
	int guiWidth = 256;
	int guiHeight = 256;
	
	@Override
	public void drawScreen(int x, int y, float ticks){
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/ChromancyBook_00.png" ));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		super.drawScreen(x, y, ticks);
		
	}
}
