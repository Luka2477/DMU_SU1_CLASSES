package opgave5.gui;

import opgave5.application.controller.Controller;
import opgave5.application.model.Player;
import opgave5.application.model.SpawnPoint;

public class MiniGame {

    public static void main(String[] args) {
        SpawnPoint sp = Controller.createSpawnPoint();
        Player p1 = new Player("Lukas", "Medic", 0);
        Player p2 = new Player("Omar", "Sniper", 0);

        sp.initWeapon("M4", 30, 180);

        Controller.pickUpWeapon(p1, sp, "M4", 30, 180);
        Controller.shoot(p1, p2);
        Controller.shoot(p1, p2);
        Controller.shoot(p1, p2);
        Controller.shoot(p1, p2);
        Controller.shoot(p2, p1);
    }
}
