package chromancy.core.lightEnergy;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Sam on 7/27/2015.
 * based on code by King Lemming
 */
public interface ILightConnection {
    /**
     * Returns TRUE if the TileEntity can connect on a given side.
     */
    boolean canConnectLight(ForgeDirection from);
}
