package chromancy.core.lightEnergy;

import net.minecraft.item.ItemStack;

/**
 * Created by Sam on 7/27/2015.
 * based on code by King Lemming
 */
public interface ILightItem {

    /**
     * Adds energy to a container item. Returns the quantity of energy that was accepted. This should always return 0 if the item cannot be externally charged.
     *
     * @param container
     *            ItemStack to be charged.
     * @param maxReceive
     *            Maximum amount of energy to be sent into the item.
     * @param simulate
     *            If TRUE, the charge will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) received by the item.
     */
    int receiveLight(ItemStack container, int maxReceive, boolean simulate);

    /**
     * Removes energy from a container item. Returns the quantity of energy that was removed. This should always return 0 if the item cannot be externally
     * discharged.
     *
     * @param container
     *            ItemStack to be discharged.
     * @param maxExtract
     *            Maximum amount of energy to be extracted from the item.
     * @param simulate
     *            If TRUE, the discharge will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) extracted from the item.
     */
    int extractLight(ItemStack container, int maxExtract, boolean simulate);

    /**
     * Get the amount of energy currently stored in the container item.
     */
    int getLightStored(ItemStack container);

    /**
     * Get the max amount of energy that can be stored in the container item.
     */
    int getMaxLightStored(ItemStack container);



}
