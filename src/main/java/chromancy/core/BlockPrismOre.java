package chromancy.core;

import chromancy.core.help.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPrismOre extends Block {

	public BlockPrismOre(){
		
		super(Material.rock);
		setBlockName("prismOre");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ChromancyCore.chromancyTab);
		setStepSound(soundTypeGlass);
		setHardness(2.0f);
		setResistance(5.0f);
		setLightLevel(1.0f);
		setHarvestLevel("pickaxe",0);
	}
}
