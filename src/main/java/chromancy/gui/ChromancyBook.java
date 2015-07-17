package chromancy.gui;

import org.lwjgl.opengl.GL11;

import chromancy.core.help.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.PlaySoundEvent;

public class ChromancyBook extends GuiScreen {
	
	String image = "textures/gui/ChromancyBook_Light.png";
	
	boolean DarkLight = false;
	
	int guiWidth = 256;
	int guiHeight = 173;

	int tabWidth = 22;
	int tabHeight = 18;
	
	int tab1v = 176;
	int tab2v = 176;
	int tab3v = 176;
	int tab4v = 176;
	int tab5v = 176;
	int tab6v = 176;
	int tab7v = 176;
	int tab8v = 176;
	int tab9v = 176;
	
	int Clicked = 0;
	
	GuiButton tabButton;
	
	@Override
	public void drawScreen(int x, int y, float ticks){
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		switch(Clicked){
		case 1:
			tab1v = 194;
			tab2v = 176;
			tab3v = 176;
			tab4v = 176;
			tab5v = 176;
			tab6v = 176;
			tab7v = 176;
			tab8v = 176;
			tab9v = 176;
			image = "textures/gui/ChromancyBook_Light.png";
			break;
		case 2:
			tab1v = 176;
			tab2v = 194;
			tab3v = 176;
			tab4v = 176;
			tab5v = 176;
			tab6v = 176;
			tab7v = 176;
			tab8v = 176;
			tab9v = 176;
			image = "textures/gui/ChromancyBook_Red.png";
			break;
		case 3:
			tab1v = 176;
			tab2v = 176;
			tab3v = 194;
			tab4v = 176;
			tab5v = 176;
			tab6v = 176;
			tab7v = 176;
			tab8v = 176;
			tab9v = 176;
			image = "textures/gui/ChromancyBook_Orange.png";
			break;
		case 4:
			tab1v = 176;
			tab2v = 176;
			tab3v = 176;
			tab4v = 194;
			tab5v = 176;
			tab6v = 176;
			tab7v = 176;
			tab8v = 176;
			tab9v = 176;
			image = "textures/gui/ChromancyBook_Yellow.png";
			break;
		case 5:
			tab1v = 176;
			tab2v = 176;
			tab3v = 176;
			tab4v = 176;
			tab5v = 194;
			tab6v = 176;
			tab7v = 176;
			tab8v = 176;
			tab9v = 176;
			image = "textures/gui/ChromancyBook_Green.png";
			break;
		case 6:
			tab1v = 176;
			tab2v = 176;
			tab3v = 176;
			tab4v = 176;
			tab5v = 176;
			tab6v = 194;
			tab7v = 176;
			tab8v = 176;
			tab9v = 176;
			image = "textures/gui/ChromancyBook_Blue.png";
			break;
		case 7:
			tab1v = 176;
			tab2v = 176;
			tab3v = 176;
			tab4v = 176;
			tab5v = 176;
			tab6v = 176;
			tab7v = 194;
			tab8v = 176;
			tab9v = 176;
			image = "textures/gui/ChromancyBook_Indigo.png";
			break;
		case 8:
			tab1v = 176;
			tab2v = 176;
			tab3v = 176;
			tab4v = 176;
			tab5v = 176;
			tab6v = 176;
			tab7v = 176;
			tab8v = 194;
			tab9v = 176;
			image = "textures/gui/ChromancyBook_Violet.png";
			break;
		case 9:
			tab1v = 176;
			tab2v = 176;
			tab3v = 176;
			tab4v = 176;
			tab5v = 176;
			tab6v = 176;
			tab7v = 176;
			tab8v = 176;
			tab9v = 194;
			image = "textures/gui/ChromancyBook_Black.png";
			break;
			
		}
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, image));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		drawTexturedModalRect(guiX + 12, guiY + 18, 0, tab1v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 12, guiY + 18 + tabHeight + 1, 21, tab2v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 12, guiY + 18 + (tabHeight * 2) + 2, 42, tab3v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 12, guiY + 18 + (tabHeight * 3) + 3, 63, tab4v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 12, guiY + 18 + (tabHeight * 4) + 4, 84, tab5v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 12, guiY + 18 + (tabHeight * 5) + 5, 105, tab6v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 12, guiY + 18 + (tabHeight * 6) + 6, 126, tab7v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 12, guiY + 18 + (tabHeight * 7) + 7, 147, tab8v, tabWidth, tabHeight);
		if(DarkLight){
			drawTexturedModalRect(guiX + 240, guiY + 18 + (tabHeight * 7) + 7, 168, tab9v, tabWidth, tabHeight);
		}
		//fontRendererObj.drawString("Chromancy", guiX + 10, guiY + 10, 0xFFFFFF);
		
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
		
		if(guiX + 12 < x && x < guiX + 12 + tabWidth && guiY + tabHeight < y && y < guiY + tabHeight * 2){
			Clicked = 1;
		}
		if(guiX + 12 < x && x < guiX + 12 + tabWidth && guiY + tabHeight * 2 < y && y < guiY + tabHeight * 3){
			Clicked = 2;
		}
		if(guiX + 12 < x && x < guiX + 12 + tabWidth && guiY + tabHeight * 3 < y && y < guiY + tabHeight * 4){
			Clicked = 3;
		}
		if(guiX + 12 < x && x < guiX + 12 + tabWidth && guiY + tabHeight * 4 < y && y < guiY + tabHeight * 5){
			Clicked = 4;
		}
		if(guiX + 12 < x && x < guiX + 12 + tabWidth && guiY + tabHeight * 5 < y && y < guiY + tabHeight * 6){
			Clicked = 5;
		}
		if(guiX + 12 < x && x < guiX + 12 + tabWidth && guiY + tabHeight * 6 < y && y < guiY + tabHeight * 7){
			Clicked = 6;
		}
		if(guiX + 12 < x && x < guiX + 12 + tabWidth && guiY + tabHeight * 7 < y && y < guiY + tabHeight * 8){
			Clicked = 7;
		}
		if(guiX + 12 < x && x < guiX + 12 + tabWidth && guiY + tabHeight * 8 < y && y < guiY + tabHeight * 9){
			Clicked = 8;
		}
		if(guiX + 240 < x && x < guiX + 240 + tabWidth && guiY + tabHeight * 8 < y && y < guiY + tabHeight * 9 && DarkLight){
			Clicked = 9;
		}
		
	}
	
}

