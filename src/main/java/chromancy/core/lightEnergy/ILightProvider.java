package chromancy.core.lightEnergy;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Sam on 7/27/2015.
 * based on code by King Lemming
 */
public interface ILightProvider extends ILightConnection {
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
    int extractLight(ForgeDirection from, int maxExtract, boolean simulate);

    /**
     * Returns the amount of energy currently stored.
     */
    int getLightStored(ForgeDirection from);

    /**
     * Returns the maximum amount of energy that can be stored.
     */
    int getMaxLightStored(ForgeDirection from);
}
