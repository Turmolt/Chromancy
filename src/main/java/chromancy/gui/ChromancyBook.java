package chromancy.gui;

import org.lwjgl.opengl.GL11;

import chromancy.core.help.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.PlaySoundEvent;

public class ChromancyBook extends GuiScreen {
	
	String image = "textures/gui/ChromancyBook_01.png";
	
	boolean DarkLight = true;
	
	int guiWidth = 256;
	int guiHeight = 158;

	int tabWidth = 20;
	int tabHeight = 20;
	
	int tab1v = 160;
	int tab2v = 160;
	int tab3v = 160;
	int tab4v = 160;
	int tab5v = 160;
	int tab6v = 160;
	int tab7v = 160;
	int tab8v = 160;
	int tab9v = 160;
	int tab10v = 160;
	int tab11v = 160;
	
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
			tab1v = 180;
			tab2v = 160;
			tab3v = 160;
			tab4v = 160;
			tab5v = 160;
			tab6v = 160;
			tab7v = 160;
			tab8v = 160;
			tab9v = 160;
			image = "textures/gui/ChromancyBook_01.png";
			break;
		case 2:
			tab1v = 160;
			tab2v = 180;
			tab3v = 160;
			tab4v = 160;
			tab5v = 160;
			tab6v = 160;
			tab7v = 160;
			tab8v = 160;
			tab9v = 160;
			image = "textures/gui/ChromancyBook_01.png";
			break;
		case 3:
			tab1v = 160;
			tab2v = 160;
			tab3v = 180;
			tab4v = 160;
			tab5v = 160;
			tab6v = 160;
			tab7v = 160;
			tab8v = 160;
			tab9v = 160;
			image = "textures/gui/ChromancyBook_01.png";
			break;
		case 4:
			tab1v = 160;
			tab2v = 160;
			tab3v = 160;
			tab4v = 180;
			tab5v = 160;
			tab6v = 160;
			tab7v = 160;
			tab8v = 160;
			tab9v = 160;
			image = "textures/gui/ChromancyBook_Yellow.png";
			break;
		case 5:
			tab1v = 160;
			tab2v = 160;
			tab3v = 160;
			tab4v = 160;
			tab5v = 180;
			tab6v = 160;
			tab7v = 160;
			tab8v = 160;
			tab9v = 160;
			image = "textures/gui/ChromancyBook_01.png";
			break;
		case 6:
			tab1v = 160;
			tab2v = 160;
			tab3v = 160;
			tab4v = 160;
			tab5v = 160;
			tab6v = 180;
			tab7v = 160;
			tab8v = 160;
			tab9v = 160;
			image = "textures/gui/ChromancyBook_01.png";
			break;
		case 7:
			tab1v = 160;
			tab2v = 160;
			tab3v = 160;
			tab4v = 160;
			tab5v = 160;
			tab6v = 160;
			tab7v = 180;
			tab8v = 160;
			tab9v = 160;
			image = "textures/gui/ChromancyBook_01.png";
			break;
		case 8:
			tab1v = 160;
			tab2v = 160;
			tab3v = 160;
			tab4v = 160;
			tab5v = 160;
			tab6v = 160;
			tab7v = 160;
			tab8v = 180;
			tab9v = 160;
			image = "textures/gui/ChromancyBook_01.png";
			break;
		case 9:
			tab1v = 160;
			tab2v = 160;
			tab3v = 160;
			tab4v = 160;
			tab5v = 160;
			tab6v = 160;
			tab7v = 160;
			tab8v = 160;
			tab9v = 180;
			image = "textures/gui/ChromancyBook_01.png";
			break;
		case 10:
			tab10v = 180;
			tab11v = 160;
			image = "textures/gui/ChromancyBook_01.png";
			break;
		case 11:
			tab10v = 160;
			tab11v = 180;
			image = "textures/gui/ChromancyBook_01.png";
			break;
			
		}
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, image));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		drawTexturedModalRect(guiX, guiY, 0, tab1v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + tabHeight + 1, 20, tab2v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 2) + 2, 40, tab3v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 3) + 3, 60, tab4v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 4) + 4, 80, tab5v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 5) + 5, 100, tab6v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 6) + 6, 120, tab7v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 7) + 7, 140, tab8v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 240, guiY, 180, tab10v, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 240, guiY + tabHeight + 1, 200, tab11v, tabWidth, tabHeight);
		if(DarkLight){
			drawTexturedModalRect(guiX + 240, guiY + (tabHeight * 7) + 7, 160, tab9v, tabWidth, tabHeight);
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
		
		if(guiX < x && x < guiX + tabWidth && guiY < y && y < guiY + tabHeight){
			Clicked = 1;
			System.out.println("Button 1");
		}
		if(guiX < x && x < guiX + tabWidth && guiY + tabHeight < y && y < guiY + tabHeight * 2){
			Clicked = 2;
		}
		if(guiX < x && x < guiX  + tabWidth && guiY + tabHeight * 2 < y && y < guiY + tabHeight * 3){
			Clicked = 3;
		}
		if(guiX < x && x < guiX + tabWidth && guiY + tabHeight * 3 < y && y < guiY + tabHeight * 4){
			Clicked = 4;
		}
		if(guiX< x && x < guiX + tabWidth && guiY + tabHeight * 4 < y && y < guiY + tabHeight * 5){
			Clicked = 5;
		}
		if(guiX < x && x < guiX + tabWidth && guiY + tabHeight * 5 < y && y < guiY + tabHeight * 6){
			Clicked = 6;
		}
		if(guiX < x && x < guiX + tabWidth && guiY + tabHeight * 6 < y && y < guiY + tabHeight * 7){
			Clicked = 7;
		}
		if(guiX < x && x < guiX + tabWidth && guiY + tabHeight * 7 < y && y < guiY + tabHeight * 8){
			Clicked = 8;
		}
		if(guiX + 240 < x && x < guiX + 240 + tabWidth && guiY + tabHeight * 7 < y && y < guiY + tabHeight * 8 && DarkLight){
			Clicked = 9;
		}
		if(guiX + 240 < x && x < guiX + 240 + tabWidth && guiY< y && y < guiY  + tabHeight){
			Clicked = 10;
		}
		if(guiX + 240 < x && x < guiX + 240 + tabWidth && guiY + tabHeight < y && y < guiY + tabHeight * 2){
			Clicked = 11;
		}
		
	}
	
}

