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
		setCreativeTab(CreativeTabs.tabBlock);
	}
}
