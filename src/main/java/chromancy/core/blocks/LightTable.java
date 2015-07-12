package chromancy.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import chromancy.core.ChromancyCore;
import chromancy.core.help.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



//Here we go...
public class LightTable extends Block{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] Faces;
	
	
	public LightTable()
	{
		super(Material.wood);
		setBlockName("lightTable");
		setCreativeTab(ChromancyCore.chromancyTab);
		setStepSound(soundTypeWood);
		setHardness(55.0f);
		setResistance(5.0f);
		setLightLevel(1.0f);
		setHarvestLevel("axe",0);
		Faces = new IIcon[5];
		
		
		
	}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		Faces[0] = icon.registerIcon(Reference.MODID + ":ltSide");
		Faces[1] = icon.registerIcon(Reference.MODID + ":ltTop");
		Faces[2] = icon.registerIcon(Reference.MODID + ":ltSide");
		Faces[3] = icon.registerIcon(Reference.MODID + ":ltBot");
		Faces[4] = icon.registerIcon(Reference.MODID + ":ltSide");
	}
	
	
	public boolean onBlockActivated(World parWorld, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c)
	{
		if(!player.isSneaking()){
			System.out.println("butts");
			player.openGui(ChromancyCore.instance,ChromancyCore.GUIID.LIGHTTABLE.ordinal(), parWorld, x, y, z);
			return true;
		}
		else
		{
			System.out.print("Hullo");
			return false;
	
		}
	}
	
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		if(side==1)
			return Faces[side];
		else if(side == 0)
			return Faces[3];
		else
			return Faces[0];
		
	}
	
	
	
}
