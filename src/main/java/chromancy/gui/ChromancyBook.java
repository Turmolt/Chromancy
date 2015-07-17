package chromancy.gui;

import org.lwjgl.opengl.GL11;

import chromancy.core.help.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ChromancyBook extends GuiScreen {
	
	int guiWidth = 256;
	int guiHeight = 173;

	int tabWidth = 22;
	int tabHeight = 19;
	
	int tab1v = 176;
	int tab2v = 176;
	
	boolean Clicked1 = false;
	boolean Clicked2 = false;
	
	GuiButton tabButton;
	
	@Override
	public void drawScreen(int x, int y, float ticks){
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/ChromancyBook_00.png" ));
		if(Clicked1){
			tab1v = 214;
		}else{
			tab1v = 176;
		}
		if(Clicked2){
			tab2v = 214;
		}else{
			tab2v = 176;
		}
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		drawTexturedModalRect(guiX + 12, guiY + 20, 0, tab1v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 12, guiY + 20 + tabHeight + 1, 0, tab2v, tabWidth, tabHeight);
		fontRendererObj.drawString("Chromancy", guiX + 10, guiY + 10, 0xFFFFFF);
		
		super.drawScreen(x, y, ticks);
	
	}
	
	@Override
	public void initGui(){
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		
		buttonList.clear();
		//buttonList.add(tabButton = new GuiButton(0, guiX + 12, guiY + 20, tabWidth, tabHeight, "Tab"));
		super.initGui();
	}

	
	@Override
	protected void actionPerformed(GuiButton button) {
		
		switch(button.id){
		case 0:
			button.displayString = "bat";
		}
		super.actionPerformed(button);
	}
	
	
	@Override
	protected void mouseClicked(int x, int y, int button){
		super.mouseClicked(x,y,button);
		
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		System.out.println("Clicked");
		
		if(guiX + 12 < x && x < guiX + 12 + tabWidth && guiY + tabHeight < y && y < guiY + tabHeight * 2){
			System.out.println("Clicked1");
			Clicked1 = true;
			Clicked2 = false;
		}
		if(guiX + 12 < x && x < guiX + 12 + tabWidth && guiY + tabHeight * 2 < y && y < guiY + tabHeight * 3){
			System.out.println("Clicked2");
			Clicked1 = false;
			Clicked2 = true;
		}
		
	}
	
}

