package opgave5.application.model;

public class Weapon {

    private String type;
    private int clipCapacity;
    private int ammoLeft;
    private int ammoLeftInClip;

    public Weapon(String type, int clipCapacity, int ammoLeft) {
        this.type = type;
        this.clipCapacity = clipCapacity;
        this.ammoLeft = ammoLeft;

        this.ammoLeftInClip = this.clipCapacity;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getClipCapacity() {
        return this.clipCapacity;
    }

    public void setClipCapacity(int clipCapacity) {
        this.clipCapacity = clipCapacity;
    }

    public int getAmmoLeft() {
        return this.ammoLeft;
    }

    public void setAmmoLeft(int ammoLeft) {
        this.ammoLeft = ammoLeft;
    }

    public int getAmmoLeftInClip() {
        return this.ammoLeftInClip;
    }

    public void shoot () {
        this.ammoLeftInClip--;
    }

    public int reload () {
        if (this.ammoLeft >= this.clipCapacity) {
            this.ammoLeft -= this.clipCapacity;
            this.ammoLeftInClip = this.clipCapacity;
        } else {
            this.ammoLeftInClip = this.ammoLeft;
            this.ammoLeft = 0;
        }
        return this.ammoLeft;
    }
}
