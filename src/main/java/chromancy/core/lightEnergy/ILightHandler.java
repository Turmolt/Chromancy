package chromancy.core.lightEnergy;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Sam on 7/27/2015.
 * based on code by King Lemming
 */
public interface ILightHandler extends ILightProvider, ILightReciever {
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
    @Override
    int receiveLight(ForgeDirection from, int maxReceive, boolean simulate);

    /**
     * Remove energy from an IEnergyProvider, internal distribution is left entirely to the IEnergyProvider.
     *
     * @param from
     *            Orientation the energy is extracted from.
     * @param maxExtract
     *            Maximum amount of energy to extract.
     * @param simulate
     *            If TRUE, the extraction will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) extracted.
     */
    @Override
    int extractLight(ForgeDirection from, int maxExtract, boolean simulate);


    /**
     * Returns the amount of energy currently stored.
     */
    @Override
    int getLightStored(ForgeDirection from);

    /**
     * Returns the maximum amount of energy that can be stored.
     */
    @Override
    int getMaxLightStored(ForgeDirection from);
}
