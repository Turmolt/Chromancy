package chromancy.gui;

import org.lwjgl.opengl.GL11;

import chromancy.core.help.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.PlaySoundEvent;

public class ChromancyBook extends GuiScreen {
	
	String image = "textures/gui/ChromancyBook_Light.png";
	
	boolean DarkLight = true;
	
	int guiWidth = 256;
	int guiHeight = 158;

	int tabWidth = 20;
	int tabHeight = 20;
	
	int LightTab = 160;
	int RedTab = 160;
	int OrangeTab = 160;
	int YellowTab = 160;
	int GreenTab = 160;
	int BlueTab = 160;
	int IndigoTab = 160;
	int VioletTab = 160;
	int DarkTab = 160;
	int SpellTab = 160;
	int CraftingTab = 160;
	int Slot1 = 200;
	int Clicked = 0;
	
	GuiButton tabButton;
	
	@Override
	public void drawScreen(int x, int y, float ticks){
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		getTab();
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, image));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		drawTexturedModalRect(guiX, guiY, 0, LightTab, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + tabHeight + 1, 20, RedTab, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 2) + 2, 40, OrangeTab, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 3) + 3, 60, YellowTab, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 4) + 4, 80, GreenTab, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 5) + 5, 100, BlueTab, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 6) + 6, 120, IndigoTab, tabWidth, tabHeight);
		drawTexturedModalRect(guiX, guiY + (tabHeight * 7) + 7, 140, VioletTab, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 240, guiY, 180, SpellTab, tabWidth, tabHeight);
		drawTexturedModalRect(guiX + 240, guiY + tabHeight + 1, 200, CraftingTab, tabWidth, tabHeight);
		drawTexturedModalRect(200, guiY + tabHeight, 0, Slot1, tabWidth, tabHeight);
		if(DarkLight){
			drawTexturedModalRect(guiX + 240, guiY + (tabHeight * 7) + 7, 160, DarkTab, tabWidth, tabHeight);
		}
		//fontRendererObj.drawString("Chromancy", guiX + 10, guiY + 10, 0xFFFFFF);
		
		super.drawScreen(x, y, ticks);
	
	}
	
	/*
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
	*/
	
	
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
	
	public void getTab(){
		switch(Clicked){
		case 1:
			LightTab = 180;
			RedTab = 160;
			OrangeTab = 160;
			YellowTab = 160;
			GreenTab = 160;
			BlueTab = 160;
			IndigoTab = 160;
			VioletTab = 160;
			DarkTab = 160;
			image = "textures/gui/ChromancyBook_Light.png";
			break;
		case 2:
			LightTab = 160;
			RedTab = 180;
			OrangeTab = 160;
			YellowTab = 160;
			GreenTab = 160;
			BlueTab = 160;
			IndigoTab = 160;
			VioletTab = 160;
			DarkTab = 160;
			image = "textures/gui/ChromancyBook_Red.png";
			break;
		case 3:
			LightTab = 160;
			RedTab = 160;
			OrangeTab = 180;
			YellowTab = 160;
			GreenTab = 160;
			BlueTab = 160;
			IndigoTab = 160;
			VioletTab = 160;
			DarkTab = 160;
			image = "textures/gui/ChromancyBook_Orange.png";
			break;
		case 4:
			LightTab = 160;
			RedTab = 160;
			OrangeTab = 160;
			YellowTab = 180;
			GreenTab = 160;
			BlueTab = 160;
			IndigoTab = 160;
			VioletTab = 160;
			DarkTab = 160;
			image = "textures/gui/ChromancyBook_Yellow.png";
			break;
		case 5:
			LightTab = 160;
			RedTab = 160;
			OrangeTab = 160;
			YellowTab = 160;
			GreenTab = 180;
			BlueTab = 160;
			IndigoTab = 160;
			VioletTab = 160;
			DarkTab = 160;
			image = "textures/gui/ChromancyBook_Green.png";
			break;
		case 6:
			LightTab = 160;
			RedTab = 160;
			OrangeTab = 160;
			YellowTab = 160;
			GreenTab = 160;
			BlueTab = 180;
			IndigoTab = 160;
			VioletTab = 160;
			DarkTab = 160;
			image = "textures/gui/ChromancyBook_Blue.png";
			break;
		case 7:
			LightTab = 160;
			RedTab = 160;
			OrangeTab = 160;
			YellowTab = 160;
			GreenTab = 160;
			BlueTab = 160;
			IndigoTab = 180;
			VioletTab = 160;
			DarkTab = 160;
			image = "textures/gui/ChromancyBook_Indigo.png";
			break;
		case 8:
			LightTab = 160;
			RedTab = 160;
			OrangeTab = 160;
			YellowTab = 160;
			GreenTab = 160;
			BlueTab = 160;
			IndigoTab = 160;
			VioletTab = 180;
			DarkTab = 160;
			image = "textures/gui/ChromancyBook_Violet.png";
			break;
		case 9:
			LightTab = 160;
			RedTab = 160;
			OrangeTab = 160;
			YellowTab = 160;
			GreenTab = 160;
			BlueTab = 160;
			IndigoTab = 160;
			VioletTab = 160;
			DarkTab = 180;
			image = "textures/gui/ChromancyBook_Black.png";
			break;
		case 10:
			SpellTab = 180;
			CraftingTab = 160;
			break;
		case 11:
			SpellTab = 160;
			CraftingTab = 180;
			break;
			
		}
	}
	
}

