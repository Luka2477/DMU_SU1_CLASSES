package opgave1.model;

import java.util.ArrayList;

public class Konto {

	private int nr;

	private ArrayList<Transaktion> transaktioner;

	private KontoType kontoType;

	private Tilstand tilstand;

	public Konto(KontoType kontoType) {

		this.kontoType = kontoType;
		this.nr = this.kontoType.getKonti().size() + 1;
		kontoType.addKonto(this);
		this.tilstand = Tilstand.AABEN;
		transaktioner = new ArrayList<>();
	}

	public int getNr() {
		return this.nr;
	}

	public Transaktion haevEllerIndsaetBeloeb(double beloeb) {
		Transaktion transaktion;
		if (this.tilstand == Tilstand.AABEN || beloeb > 0) {
			transaktion = new Transaktion(beloeb);
			transaktioner.add(transaktion);
			if (beregnSaldo() < 0) {
				tilstand = Tilstand.OVERTRUKKET;
			} else {
				this.tilstand = Tilstand.AABEN;
			}
		} else {
			throw new RuntimeException("Du forsoeger at haeve paa en overtrukket konto!");
		}

		return transaktion;
	}

	public double beregnSaldo() {
		double saldo = 0;
		for (Transaktion transaktion : transaktioner) {
			saldo += transaktion.getBeloeb();
		}
		return saldo;

	}

	public void setTilstand (Tilstand tilstand) {
		this.tilstand = tilstand;
	}

	public Tilstand getTilstand () {
		return this.tilstand;
	}

	@Override
	public String toString() {
		return "Saldo konto nr. " + getNr() + " er " + beregnSaldo();
	}
}
