package chromancy.core.lightEnergy;



import net.minecraft.nbt.NBTTagCompound;
/**
 * Create one of these in any device that is used to store light.
 *
 * @author Sam on 7/26/2015.
 * based on code by King Lemming
 */
public class LightStorage implements ILightStorage {

    protected int light;
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;

    public LightStorage(int capacity) {

        this(capacity, capacity, capacity);
    }

    public LightStorage(int capacity, int maxTransfer) {

        this(capacity, maxTransfer, maxTransfer);
    }

    public LightStorage(int capacity, int maxReceive, int maxExtract) {

        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
    }

    public LightStorage readFromNBT(NBTTagCompound nbt) {

        this.light = nbt.getInteger("light");

        if (light > capacity) {
            light = capacity;
        }
        return this;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

        if (light < 0) {
            light = 0;
        }
        nbt.setInteger("light", light);
        return nbt;
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;

        if (light > capacity) {
            light = capacity;
        }
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

    public int getMaxReceive() {

        return maxReceive;
    }

    public int getMaxExtract() {

        return maxExtract;
    }

    /**
     * This function is included to allow for server -&gt; client sync. Do not call this externally to the containing Tile Entity, as not all IlightHandlers
     * are guaranteed to have it.
     *
     * @param light set amount of light that is stored
     */
    public void setLightStored(int light) {

        this.light = light;

        if (this.light > capacity) {
            this.light = capacity;
        } else if (this.light < 0) {
            this.light = 0;
        }
    }

    /**
     * This function is included to allow the containing tile to directly and efficiently modify the light contained in the lightStorage. Do not rely on this
     * externally, as not all IlightHandlers are guaranteed to have it.
     *
     * @param light add this to current light stored
     */
    public void modifyLightStored(int light) {

        this.light += light;

        if (this.light > capacity) {
            this.light = capacity;
        } else if (this.light < 0) {
            this.light = 0;
        }
    }

    /* IlightStorage */
    @Override
    public int receiveLight(int maxReceive, boolean simulate) {

        int lightReceived = Math.min(capacity - light, Math.min(this.maxReceive, maxReceive));

        if (!simulate) {
            light += lightReceived;
        }
        return lightReceived;
    }

    @Override
    public int extractLight(int maxExtract, boolean simulate) {

        int lightExtracted = Math.min(light, Math.min(this.maxExtract, maxExtract));

        if (!simulate) {
            light -= lightExtracted;
        }
        return lightExtracted;
    }

    @Override
    public int getLightStored() {

        return light;
    }

    @Override
    public int getMaxLightStored() {

        return capacity;
    }




}
