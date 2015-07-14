package chromancy.core.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import chromancy.core.ChromancyCore;
import chromancy.core.help.Reference;
import chromancy.core.tileEntity.LightTableTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;




public class LightTable extends BlockContainer{
	
	
	@SideOnly(Side.CLIENT)
	private IIcon[] Faces;
	
	private static boolean keepInventory;
	
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
	@Override
	public TileEntity createNewTileEntity(World p1, int p2) {
		
		return new LightTableTileEntity();
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
	
	public static void updateLightTableState(boolean active, World world, int pX, int pY, int pZ)
	{
		int i = world.getBlockMetadata(pX,pY,pZ);
		
		TileEntity tileEntity = world.getTileEntity(pX,pY,pZ);
		keepInventory = true;
		if(active)
		{
			world.setBlock(pX,pY,pZ, ChromancyCore.lightTable);
		} else {
			world.setBlock(pX, pY, pZ, ChromancyCore.lightTable);
		}
		
		keepInventory = false;
		
		world.setBlockMetadataWithNotify(pX, pY, pZ, i, 2);
		
		if(tileEntity != null)
		{
			tileEntity.validate();
			world.setTileEntity(pX, pY, pZ, tileEntity);
		}
	}
	
}
