package opgave5.application.controller;

import opgave5.application.model.Player;
import opgave5.application.model.SpawnPoint;
import opgave5.storage.Storage;

public abstract class Controller {

    public static SpawnPoint createSpawnPoint () {
        SpawnPoint spawnPoint = new SpawnPoint();
        Storage.addSpawnPoint(spawnPoint);
        return spawnPoint;
    }

    public static void pickUpWeapon (Player player, SpawnPoint spawnPoint, String type, int clipCapacity, int ammoLeft) {
        player.pickUpWeapon(spawnPoint.getWeapon());
        spawnPoint.weaponPickedUp(type, clipCapacity, ammoLeft);
    }

    public static void shoot (Player shooter, Player target) {
        if (shooter.getHeldWeapon() != null) {
            System.out.printf("%s shot %s for %d health points!%n", shooter.getName(), target.getName(), shooter.shoot(target));
        } else {
            System.out.printf("%s tried shooting %s, but doesn't have a weapon!%n", shooter.getName(), target.getName());
        }
    }
}
