package chromancy.core.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import chromancy.core.ChromancyCore;
import chromancy.core.help.Reference;

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
	

	//Specify what is dropped
	public Item getItemDropped(int metadeta, Random random, int fortune){
		return ChromancyCore.prismDust;
	}
	
	
	/**
	 * 100% Chance to drop at least one Prism dust
	 * 50% Chance to drop a second Prism dust
	 * 10% Chance to drop a third Prism dust
	 */
	public int quantityDropped(Random rand){
		int num = 1;
		float r = rand.nextFloat();
		if(r <= 0.5f){
			num+=1;
			if(r<=0.1f)
				num+=1;
		}
		return num;
		
		
	}
}
