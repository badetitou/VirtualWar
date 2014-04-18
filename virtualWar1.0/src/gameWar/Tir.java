package gameWar;

public class Tir extends Action{
	
	public Tir(Robot r, Coordonnee c) {
		super(r, c);
	}
	
	public void agit () {
		Plateau p = this.getRobot().getVue().plateau;
		Coordonnee newc = this.getRobot().getCoordonnee().ajouter(this.getDirection()); 
		if(this.getRobot().getVue().estOK(newc) && !this.getRobot().getVue().estLibre(newc)) {
			System.out.println("Vous avez touch� un robot ennemi !!");
			p.getRobot(newc.getX(), newc.getY()).subitDegats(this.getRobot().getDegatTir());
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
			if (p.getRobot(newc.getX(), newc.getY()).getEnergie()<=0) {
				System.out.println("Le robot ennemi est mort !!");
				p.setLibre(newc.getX(), newc.getY());
			}
		}
	}
}

