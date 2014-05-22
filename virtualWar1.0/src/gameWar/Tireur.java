package gameWar;


public class Tireur extends Robot{
	
	private int coutAction=2;
	private int coutDep=1;
	private int degatTir=3;
	private String type = "Tireur";
	private int deplacement = 1;
	private boolean diagonal=true;
	private int portee = 1;
	
	public Tireur (Vue vue, int equipe, int num, String typeJoueur) {
		super(vue, equipe, num, typeJoueur);
		this.setEnergie(40);
	}

	public boolean peutTirer() {
		return false;
	}
	
	public int getCoutAction() {
		return this.coutAction;
	}

	public int getCoutDep() {
		return this.coutDep;
	}

	public int getDegatMine() {
		return 0;
	}

	public int getDegatTir() {
		return this.degatTir;
	}

	public String getType() {
		return this.type;
	}

	public int getDeplacement() {
		return this.deplacement;
	}
	
	public boolean getDiagonal() {
		return this.diagonal;
	}
	
	public int getPortee() {
		return this.portee;
	}
	
	public String toString() {
		String e = "";
		String c = "";
		if (this.getEnergie()<10)
			e=" "+this.getEnergie();
		else
			e=""+this.getEnergie();
		if (this.getCoutDep()<10)
			c=" "+this.getCoutDep();
		else
			c=""+this.getCoutDep();
		return    "+-------------------------+\n"
				+ "|        TIREUR           |\n"
				+ "+-------------------------+\n"
				+ "| Equipe num : "+this.getEquipe()+"          |\n"
				+ "| Robot num : "+this.getNum()+"           |\n"
				+ "+-------------------------+\n"
				+ "| Energie : "+e+"            |\n"
				+ "| Déplacement :"+this.deplacement+"          |\n"
				+ "| Cout d'action : "+this.coutAction+"       |\n"
				+ "| Cout de deplacement : "+c+"|\n"
				+ "| Degats : "+this.degatTir+"              |\n"
				+ "|                         |\n"
				+ "+-------------------------+\n";
	}
	
}
