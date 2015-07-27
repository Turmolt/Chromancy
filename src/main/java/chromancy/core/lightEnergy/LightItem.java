package chromancy.core.lightEnergy;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Sam on 7/27/2015.
 * based on code by King Lemming
 */
public class LightItem extends Item implements ILightItem{
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;

    public LightItem() {

    }

    public LightItem(int capacity) {

        this(capacity, capacity, capacity);
    }

    public LightItem(int capacity, int maxTransfer) {

        this(capacity, maxTransfer, maxTransfer);
    }

    public LightItem(int capacity, int maxReceive, int maxExtract) {

        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
    }

    public LightItem setCapacity(int capacity) {

        this.capacity = capacity;
        return this;
    }

    public void setMaxTransfer(int maxTransfer) {

        setMaxReceive(maxTransfer);
        setMaxExtract(maxTransfer);
    }

    public void setMaxReceive(int maxReceive) {

        this.maxReceive = maxReceive;
    }

    public void setMaxExtract(int maxExtract) {

        this.maxExtract = maxExtract;
    }

    /* ILightContainerItem */
    @Override
    public int receiveLight(ItemStack container, int maxReceive, boolean simulate) {

        if (container.stackTagCompound == null) {
            container.stackTagCompound = new NBTTagCompound();
        }
        int light = container.stackTagCompound.getInteger("Light");
        int lightReceived = Math.min(capacity - light, Math.min(this.maxReceive, maxReceive));

        if (!simulate) {
            light += lightReceived;
            container.stackTagCompound.setInteger("Light", light);
        }
        return lightReceived;
    }

    @Override
    public int extractLight(ItemStack container, int maxExtract, boolean simulate) {

        if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Light")) {
            return 0;
        }
        int light = container.stackTagCompound.getInteger("Light");
        int lightExtracted = Math.min(light, Math.min(this.maxExtract, maxExtract));

        if (!simulate) {
            light -= lightExtracted;
            container.stackTagCompound.setInteger("Light", light);
        }
        return lightExtracted;
    }

    @Override
    public int getLightStored(ItemStack container) {

        if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Light")) {
            return 0;
        }
        return container.stackTagCompound.getInteger("Light");
    }

    @Override
    public int getMaxLightStored(ItemStack container) {

        return capacity;
    }
}
