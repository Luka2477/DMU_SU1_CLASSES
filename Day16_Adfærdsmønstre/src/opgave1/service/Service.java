package opgave1.service;

import opgave1.model.Konto;
import opgave1.model.KontoType;
import opgave1.model.Tilstand;
import opgave1.storage.Storage;

public class Service {

	public static KontoType createKontoType(String navn, String beskrivelse) {

		KontoType kontoType = new KontoType(navn, beskrivelse);
		Storage.addKontoType(kontoType);
		return kontoType;
	}

	public static Konto createKonto(KontoType kontoType) {
		Konto konto;

		konto = new Konto(kontoType);

		return konto;
	}

	public static void lukKonto (Konto konto) {
		if (konto.getTilstand() != Tilstand.OVERTRUKKET) {
			konto.setTilstand(Tilstand.LUKKET);
		} else {
			System.out.println("Du kan ikke lukke en overtrukket konto!");
		}
	}

	public static void haevEllerIndsaetBeloeb(Konto konto, int beloeb) {
		if (konto.getTilstand() == Tilstand.LUKKET) {
			System.out.println("Du prøver at hæve på en lukket konto!");
		} else {
			try {
				konto.haevEllerIndsaetBeloeb(beloeb);
			} catch (RuntimeException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

}
