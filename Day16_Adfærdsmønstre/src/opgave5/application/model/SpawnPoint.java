package opgave5.application.model;

import java.util.Timer;
import java.util.TimerTask;

public class SpawnPoint {

    private Weapon weapon;
    private Timer nextWeaponTimer;

    public SpawnPoint() {}

    public Weapon getWeapon() {
        return this.weapon;
    }

    public Timer getNextWeaponTimer() {
        return this.nextWeaponTimer;
    }

    public void initWeapon (String type, int clipCapacity, int ammoLeft) {
        this.createWeapon(type, clipCapacity, ammoLeft);
    }

    private void newWeapon (String type, int clipCapacity, int ammoLeft) {
        final SpawnPoint finalThis = this;

        this.nextWeaponTimer = new Timer();
        this.nextWeaponTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                finalThis.createWeapon(type, clipCapacity, ammoLeft);
                finalThis.nextWeaponTimer.cancel();
            }
        }, 2000);
    }

    private void createWeapon (String type, int clipCapacity, int ammoLeft) {
        this.weapon = new Weapon(type, clipCapacity, ammoLeft);
        System.out.printf("New %s spawned!%n", type);
    }

    public void weaponPickedUp (String type, int clipCapacity, int ammoLeft) {
        this.weapon = null;
        this.newWeapon(type, clipCapacity, ammoLeft);
    }

}
