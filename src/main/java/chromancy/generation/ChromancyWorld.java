package chromancy.generation;

public class ChromancyWorld {
	
	public static void mainRegistry(){
		
		initWorldGen();
		
	}
	
	public static initWorldGen(){
		registerWorldGen(new WorldGenChromancy(), 1)
	}
	
}
