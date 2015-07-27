package chromancy.core.lightEnergy;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Sam on 7/27/2015.
 * based on code by King Lemming
 */
public interface ILightReciever extends ILightConnection{
    /**
     * Add energy to an IEnergyReceiver, internal distribution is left entirely to the IEnergyReceiver.
     *
     * @param from
     *            Orientation the energy is received from.
     * @param maxReceive
     *            Maximum amount of energy to receive.
     * @param simulate
     *            If TRUE, the charge will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) received.
     */
    int receiveLight(ForgeDirection from, int maxReceive, boolean simulate);

    /**
     * Returns the amount of energy currently stored.
     */
    int getLightStored(ForgeDirection from);

    /**
     * Returns the maximum amount of energy that can be stored.
     */
    int getMaxLightStored(ForgeDirection from);
}
