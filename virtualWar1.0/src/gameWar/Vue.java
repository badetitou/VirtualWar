package gameWar;

public class Vue {

	Plateau plateau;
	int equipe;
	
	public Vue () {
		
	}
	
	public Vue (int equipe, Plateau p) {
		this.plateau=p;
		this.equipe=equipe;
	}
	
	public void poserRobot(Robot r) {
		this.plateau.placerRobot(r);
	}
	
	public boolean estOK(Coordonnee c) {
		return c.getX() >= 0 && c.getX() < Plateau.HAUTEUR && c.getY() >=0 && c.getY() < Plateau.LARGEUR;
	}
	
	public boolean estBase(Coordonnee c) {
		return this.plateau.estBase(c.getX(), c.getY()) != 0;
	}
	
	public boolean estMine (Coordonnee c) {
		return this.plateau.estMine(c.getX(), c.getY()) != 0;
	}
	
	public boolean estLibre (Coordonnee c) {
		return plateau.getRobot(c.getX(), c.getY())==null;
		
	}
	
	public void libere (Coordonnee c) {
		this.plateau.setLibre(c.getX(), c.getY());
	}

}
