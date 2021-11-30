package opgave5.application.model;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    private String name;
    private String classType;
    private int ammo;
    private Weapon heldWeapon;
    private int health = 100;

    private ArrayList<Weapon> weapons = new ArrayList<>();

    public Player(String name, String classType, int ammo) {
        this.name = name;
        this.classType = classType;
        this.ammo = ammo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassType() {
        return this.classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getAmmo() {
        return this.ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public Weapon getHeldWeapon () {
        return this.heldWeapon;
    }

    public void setHeldWeapon (Weapon weapon) {
        this.heldWeapon = weapon;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void removeHealth (int health) {
        this.health -= health;
    }

    public boolean pickUpWeapon (Weapon weapon) {
        if (this.weapons.size() < 3) {
            this.weapons.add(weapon);
            this.heldWeapon = weapon;
            return true;
        } else {
            return false;
        }
    }

    public void dropWeapon (Weapon weapon) {
        this.weapons.remove(weapon);
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    public int shoot (Player target) {
        if (this.heldWeapon.getAmmoLeftInClip() != 0) {
            this.heldWeapon.shoot();

            boolean hit = Math.random() < 0.65;
            int hitPoints = 0;

            if (hit) {
                hitPoints = 30 + new Random().nextInt(10);
                target.removeHealth(hitPoints);
            }

            return hitPoints;
        }

        return 0;
    }

    public int reload () {
        return this.heldWeapon.reload();
    }

}
