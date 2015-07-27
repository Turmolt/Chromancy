package chromancy.core.lightEnergy;


/**
 * A reference implementation can be found at {@link LightStorage}.
 *
 * Light Storage is the object that will hold the storage code for objects that will store light
 *
 *
 * @author Sam on 7/26/2015.
 * based on code by King Lemming
 */
public interface ILightStorage {

    /**
     * Adds light to storage. Returns the amount of light that was accepted.
     *
     * @param maxReceive = Max light that can be recieved
     *
     * @param simulate = Simulate the light being inserted.
     *
     * @return the amount of light that was accepted
     */
    int receiveLight(int maxReceive, boolean simulate);

    /**
     * Removes light from the storage. Returns quantity of light that was removed.
     *
     * @param maxExtract Extract rate
     *
     * @param simulate true = dont really do it
     *
     * @return Amount of light that was extracted from the storage.
     */
    int extractLight(int maxExtract, boolean simulate);

    /**
     * Returns the amount of light currently stored.
     */
    int getLightStored();

    /**
     * Returns the maximum amount of energy that can be stored.
     */
    int getMaxLightStored();



}
