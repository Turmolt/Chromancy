package chromancy.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import chromancy.core.ChromancyCore;
import chromancy.core.help.Reference;
import chromancy.core.tileEntity.LADTileEntity;

public class LightAmplificationDevice extends BlockContainer {
	
	public IIcon[] icons = new IIcon[6];
	
	public LightAmplificationDevice() 
    { 
        super(Material.wood);
        setBlockName("lightAmplificationDevice");
        setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(ChromancyCore.chromancyTab);
        setHardness(2.0F);
        setResistance(6.0F);
        setStepSound(soundTypeMetal);
        setHarvestLevel("pickaxe",0);

    }
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
	    for (int i = 0; i < 6; i ++) {
	        this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
	    }
	}

	@Override
	public IIcon getIcon(int side, int meta) {
	    return this.icons[side];
	}
	
	public static void updateLightAmplificationDeviceState(boolean active, World world, int pX, int pY, int pZ)
	{
		int i = world.getBlockMetadata(pX,pY,pZ);
		
		TileEntity tileEntity = world.getTileEntity(pX,pY,pZ);		
		world.setBlockMetadataWithNotify(pX, pY, pZ, i, 2);
		
		if(tileEntity != null)
		{
			tileEntity.validate();
			world.setTileEntity(pX, pY, pZ, tileEntity);
		}
		
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new LADTileEntity();
	}
	
	
	
}
