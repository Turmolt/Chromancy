package chromancy.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import chromancy.core.ChromancyCore;
import chromancy.core.help.Reference;

public class LightAmplificationDevice extends Block {
	
	public IIcon[] icons = new IIcon[6];
	
	public LightAmplificationDevice() 
    { 
        super(Material.wood);
        setBlockName("lightAmplificationDevice");
        setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(ChromancyCore.chromancyTab);
        setHardness(2.0F);
        setResistance(6.0F);
        setStepSound(soundTypeGravel);
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
	
}
