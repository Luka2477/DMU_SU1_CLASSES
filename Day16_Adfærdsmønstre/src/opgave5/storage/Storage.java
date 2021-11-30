package opgave5.storage;

import opgave5.application.model.SpawnPoint;

import java.util.ArrayList;

public abstract class Storage {

    private static ArrayList<SpawnPoint> spawnPoints = new ArrayList<>();

    public static void addSpawnPoint (SpawnPoint spawnPoint) {
        Storage.spawnPoints.add(spawnPoint);
    }

}
