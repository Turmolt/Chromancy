package chromancy.core.tileEntity;

import chromancy.core.blocks.BlockPrismOre;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LADTileEntity extends TileEntity{

	private static int ticks = 0;
	
	
	public void updateEntity()
	{
		
		//Change flag to true when the table is processing things on its own. it forces the data to be saved
		boolean flag = false;
		if(this.worldObj != null)
			if(!this.worldObj.isRemote)
			{
				if(ticks == 0)
				{
					boolean air = false;
					int highestWorldY = worldObj.getHeightValue(this.xCoord, this.zCoord);
					if(this.yCoord == (highestWorldY-1) &&((worldObj.getCelestialAngle(0) < .25) || (worldObj.getCelestialAngle(0) > .75)) && (worldObj.getRainStrength(0) < 0.25)){
						int y = this.yCoord - 1;
						int totalSpace = 0;
						air = true;
						while(air){
							Block blockCheck = worldObj.getBlock(this.xCoord, y, this.zCoord);
							if(blockCheck.isAir(worldObj, this.xCoord, y, this.zCoord)){
								totalSpace += 1;
							}
							else{
								System.out.println(totalSpace);
								air = false;
							}
							y--; 

					//Do cool things here
					
					}
					ticks = 5;
				}
			}
		
		if(flag)
			this.markDirty();
		
		if(ticks > 0)
			ticks-=1;
		
	}
	

}
}
