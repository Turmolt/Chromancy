package chromancy.generation;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class ChromancyWorld {
	
	public static void mainRegistry(){
		
		initWorldGen();
		
	}
	
	public static void initWorldGen(){
		registerWorldGen(new WorldGenChromancy(), 1)
	}
	
	public static void registerWorldGen(IWorldGenerator worldGenClass, int weightedProbability){
		GameRegistry.registerWorldGenerator(worldGenClass, weightedProbability);
	}
}
