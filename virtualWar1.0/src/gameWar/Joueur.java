package gameWar;

public class Joueur {

	public static void jouer (Plateau p, int equipe) {
		boolean ok=false;
		int num=0;
		System.out.println(p.toString(equipe, 0));
		while (!ok) {
			System.out.println("Quelle Robot voulez vous jouer ??");
			num = 0;
			while (num <=0 || num > 5) {
				if (num > 5) {
					System.out.println("Vous ne possedez que 5 Robots !");
				}
				num=gameController.EntrerInt.entrerInt();
			}
			if (p.getRobot(equipe, num)==null)
				System.out.println("Ce Robot est d�truit, choisissez en un autre.");
			else 
				ok=true;
		}
		System.out.print(p.toString(equipe, num));
		System.out.println(p.getRobot(equipe, num).toString());
		String rep=gameController.EntrerAction.entrerAction();
		if (rep.equals("deplacer")) {
			Action a = new Deplacement(p.getRobot(equipe, num));
			a.agit();
		}
		else if (rep.equals("attaquer"))
			if (!p.getRobot(equipe, num).getType().equals("Piegeur")) {
				Action a = new Tir(p.getRobot(equipe, num));
				a.agit();
			} else {
				Action a = new Mine(p.getRobot(equipe, num));
				a.agit();
			}
		if (p.getRobot(equipe, num).getEnergie()<=0)
			p.retirerRobot(p.getRobot(equipe, num).getCoordonnee().getX(), p.getRobot(equipe, num).getCoordonnee().getY(), p.getRobot(equipe, num));
	}
	
	public static void creerRobots(Plateau p, int equipe) {
		for (int i=1; i<=5; i++){
			System.out.println("Joueur "+equipe+", cr�ation du robot numero "+i+" voulez-vous un tireur ou un piegeur ?");
			String rep=gameController.EntrerRobot.entrerRobot();
			if (rep.equals("tireur"))
				p.placerRobot(new Tireur(new Vue(equipe, p), equipe, i, "Joueur"));
			else if (rep.equals("piegeur"))
				p.placerRobot(new Piegeur(new Vue(equipe, p), equipe, i, "Joueur"));
			else if (rep.equals("char"))
				p.placerRobot(new Char(new Vue(equipe, p), equipe, i, "Joueur"));
		}
	}
}
