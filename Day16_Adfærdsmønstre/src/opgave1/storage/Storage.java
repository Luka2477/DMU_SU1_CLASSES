package opgave1.storage;

import java.util.ArrayList;

import opgave1.model.KontoType;

public class Storage {

	private static ArrayList<KontoType> kontoTyper = new ArrayList<>();

	public static void addKontoType(KontoType kontoType) {
		if (!kontoTyper.contains(kontoType)) {
			kontoTyper.add(kontoType);
		}
	}

}
