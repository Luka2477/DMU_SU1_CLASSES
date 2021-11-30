package opgave1.model;

import opgave1.service.Service;

public class TilstandeTest {

	public static void main(String[] args) {

		KontoType kontotype = Service.createKontoType("Ungdomskonto",
				"En kontotype til unge under 25, som for at beskytte du unge ikke tillader at der haeves paa en konto med saldo under 0");

		Konto k1 = Service.createKonto(kontotype);

		Service.haevEllerIndsaetBeloeb(k1, 100);

		// tilfoej flere transaktioner og se hvad der sker

		Service.haevEllerIndsaetBeloeb(k1, 200);
		System.out.println(k1);
		Service.haevEllerIndsaetBeloeb(k1, -400);
		System.out.println(k1);
		Service.haevEllerIndsaetBeloeb(k1, 500);
		System.out.println(k1);

		Service.lukKonto(k1);
		Service.haevEllerIndsaetBeloeb(k1, 200);
	}
}
