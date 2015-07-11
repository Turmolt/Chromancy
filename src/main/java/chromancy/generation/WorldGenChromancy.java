package chromancy.generation;

import java.util.Random;

import chromancy.core.ChromancyCore;
import chromancy.core.blocks.*;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenChromancy implements IWorldGenerator {
	
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		
		switch(world.provider.dimensionId){
		case -1:
			generateNether(world, rand, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, rand, chunkX * 16, chunkZ * 16);
		}
		
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
		for(int i = 0; i < 100; i++){
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(64);
			int randPosZ = chunkZ + rand.nextInt(16);
			
			
			// Integer of amount of blocks in each vein, currently 10
			(new WorldGenMinable(ChromancyCore.prismOre, 10)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
		
	}

	private void generateNether(World world, Random rand, int i, int j) {
		
		
	}

}
