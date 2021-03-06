package gameController;
import gameWar.Constante;
import gameWar.Coordonnee;

import java.util.Scanner;

public class EntrerDirection {

	public static Coordonnee entrerDirection(boolean diagonal) {
		System.out.println("Entrez une direction");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (true) {
			String rep=sc.nextLine().toLowerCase();

			if (rep.equals("haut"))
				return Constante.HAUT;
			if (rep.equals("bas"))
				return Constante.BAS;
			if (rep.equals("droite"))
				return Constante.DROITE;
			if (rep.equals("gauche"))
				return Constante.GAUCHE;
			if (rep.equals("haut gauche") && diagonal)
				return Constante.HAUT.ajouter(Constante.GAUCHE);
			if (rep.equals("haut droite") && diagonal)
				return Constante.HAUT.ajouter(Constante.DROITE);
			if (rep.equals("bas droite") && diagonal)
				return Constante.BAS.ajouter(Constante.DROITE);
			if (rep.equals("bas gauche") && diagonal)
				return Constante.BAS.ajouter(Constante.GAUCHE);
			else
				System.out.println("Saisie incorrecte, veuillez recommencez.");
		}
	}
}
