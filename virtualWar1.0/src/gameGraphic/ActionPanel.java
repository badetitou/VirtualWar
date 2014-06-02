package gameGraphic;

import gameWar.Action;
import gameWar.Char;
import gameWar.Constante;
import gameWar.Coordonnee;
import gameWar.Deplacement;
import gameWar.Mine;
import gameWar.Piegeur;
import gameWar.Tir;
import gameWar.Tireur;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ActionPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ButtonGroup choixRobots;
	public static JRadioButton r1;
	public static JRadioButton r2;
	public static JRadioButton r3;
	public static JRadioButton r4;
	public static JRadioButton r5;

	ButtonGroup choixAction;
	JRadioButton miner;
	JRadioButton tirer;
	JRadioButton deplacer;

	ButtonGroup choixDirection;
	JRadioButton haut;
	JRadioButton bas;
	JRadioButton gauche;
	JRadioButton droite;
	JRadioButton basGauche;
	JRadioButton hautGauche;
	JRadioButton basDroite;
	JRadioButton hautDroite;

	private static int numEquipe=0;
	private int numRobot=0;

	public ActionPanel(int equipe){
		this.numEquipe=equipe;
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

		//RadioButton
		choixRobots = new ButtonGroup ();
		r1 = new JRadioButton("Robot 1");
		//r1.setSelected(true);
		r2 = new JRadioButton("Robot 2");
		r3 = new JRadioButton("Robot 3");
		r4 = new JRadioButton("Robot 4");
		r5 = new JRadioButton("Robot 5");
		final JPanel radioPanel = new JPanel(new GridLayout(0, 1));

		radioPanel.add(r1);
		radioPanel.add(r2);
		radioPanel.add(r3);
		radioPanel.add(r4);
		radioPanel.add(r5);

		choixRobots.add(r1);
		choixRobots.add(r2);
		choixRobots.add(r3);
		choixRobots.add(r4);
		choixRobots.add(r5);

		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		r5.addActionListener(this);



		choixAction = new ButtonGroup ();
		miner = new JRadioButton("Miner");
		//miner.setEnabled(false);
		tirer = new JRadioButton("Tirer");
		deplacer = new JRadioButton("D�placer");
		JPanel radioPanel2 = new JPanel(new GridLayout(0, 1));
		radioPanel2.add(miner);
		radioPanel2.add(tirer);
		radioPanel2.add(deplacer);
		choixAction.add(miner);
		choixAction.add(tirer);
		choixAction.add(deplacer);

		miner.addActionListener(this);
		tirer.addActionListener(this);
		deplacer.addActionListener(this);


		choixDirection = new ButtonGroup();
		haut=new JRadioButton("Haut");
		//haut.setSelected(true);
		bas=new JRadioButton("Bas");
		droite=new JRadioButton("Droite");
		gauche=new JRadioButton("Gauche");
		basGauche=new JRadioButton("Bas-Gauche");
		hautGauche=new JRadioButton("Haut-Gauche");
		basDroite=new JRadioButton("Bas-Droite");
		hautDroite=new JRadioButton("Haut-Droite");
		JPanel radioPanel3 = new JPanel(new GridLayout(0, 1));
		radioPanel3.add(haut);
		radioPanel3.add(bas);
		radioPanel3.add(gauche);
		radioPanel3.add(droite);
		radioPanel3.add(basGauche);
		radioPanel3.add(hautGauche);
		radioPanel3.add(basDroite);
		radioPanel3.add(hautDroite);
		choixDirection.add(haut);
		choixDirection.add(bas);
		choixDirection.add(gauche);
		choixDirection.add(droite);
		choixDirection.add(basGauche);
		choixDirection.add(hautGauche);
		choixDirection.add(basDroite);
		choixDirection.add(hautDroite);

		haut.addActionListener(this);
		bas.addActionListener(this);
		gauche.addActionListener(this);
		droite.addActionListener(this);
		basGauche.addActionListener(this);
		hautGauche.addActionListener(this);
		basDroite.addActionListener(this);
		hautDroite.addActionListener(this);


		//JButton
		JButton b1 = new JButton("Passez son tour");
		JButton b2 = new JButton("Valider");
		b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//passer son tour
				ClicMenu son=new ClicMenu();
				son.setDaemon(true);
				son.start();

			}

		});

		b2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//valider
				ClicMenu son=new ClicMenu();
				son.setDaemon(true);
				son.start();

				Coordonnee direction=null;
				if (haut.isSelected())
					direction=Constante.HAUT;
				else if (bas.isSelected())
					direction=Constante.BAS;
				else if (droite.isSelected())
					direction=Constante.DROITE;
				else if (gauche.isSelected())
					direction=Constante.GAUCHE;
				else if (hautGauche.isSelected())
					direction=Constante.HAUT.ajouter(Constante.GAUCHE);
				else if (hautDroite.isSelected())
					direction=Constante.HAUT.ajouter(Constante.DROITE);
				else if (basDroite.isSelected())
					direction=Constante.BAS.ajouter(Constante.DROITE);
				else if (basGauche.isSelected())
					direction=Constante.BAS.ajouter(Constante.GAUCHE);

				if (deplacer.isSelected()) {
					Action a = new Deplacement (BoardDisplayer.board.getRobot(numEquipe, numRobot));
					a.agit(direction);
				} else if (miner.isSelected()) {
					Action a = new Mine (BoardDisplayer.board.getRobot(numEquipe, numRobot));
					a.agit(direction);
				} else if (tirer.isSelected()) {
					Action a = new Tir (BoardDisplayer.board.getRobot(numEquipe, numRobot));
					a.agit(direction);
				}

				numEquipe = (numEquipe+1%2)+1;


				radioPanel.removeAll();
				choixRobots.remove(r1);
				choixRobots.remove(r2);
				choixRobots.remove(r3);
				choixRobots.remove(r4);
				choixRobots.remove(r5);


				r1 = new JRadioButton("Robot 1");
				r2 = new JRadioButton("Robot 2");
				r3 = new JRadioButton("Robot 3");
				r4 = new JRadioButton("Robot 4");
				r5 = new JRadioButton("Robot 5");

				radioPanel.add(r1);
				radioPanel.add(r2);
				radioPanel.add(r3);
				radioPanel.add(r4);
				radioPanel.add(r5);
				choixRobots.add(r1);
				choixRobots.add(r2);
				choixRobots.add(r3);
				choixRobots.add(r4);
				choixRobots.add(r5);
				radioPanel.updateUI();

				WarPanel.t=new JTextArea(WarPanel.info);
				WarPanel.bd.repaint();


			}

		});
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(0,70,10));
		p2.add(b1);
		p2.add(b2);
		p.setLayout(new FlowLayout(10,10,10));
		p.add(radioPanel);
		p.add(radioPanel2);
		p.add(radioPanel3);
		this.add(p);
		this.add(p2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(r1.isSelected()){
			System.out.print(miner.isSelected());
			numRobot=1;
			if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Tireur ){
				miner.setEnabled(false);
				tirer.setEnabled(true);
				basGauche.setEnabled(true);
				hautGauche.setEnabled(true);
				basDroite.setEnabled(true);
				hautDroite.setEnabled(true);
			}
			else if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Piegeur ){
				tirer.setEnabled(false);
				miner.setEnabled(true);
				basGauche.setEnabled(true);
				hautGauche.setEnabled(true);
				basDroite.setEnabled(true);
				hautDroite.setEnabled(true);
			}
			else if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Char ) {
				miner.setEnabled(false);
				tirer.setEnabled(true);
				basGauche.setEnabled(false);
				hautGauche.setEnabled(false);
				basDroite.setEnabled(false);
				hautDroite.setEnabled(false);
			}

		}

		else if(r2.isSelected()){
			numRobot=2;
			if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Tireur ){
				miner.setEnabled(false);
				tirer.setEnabled(true);
				basGauche.setEnabled(true);
				hautGauche.setEnabled(true);
				basDroite.setEnabled(true);
				hautDroite.setEnabled(true);
			}
			else if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Piegeur ){
				tirer.setEnabled(false);
				miner.setEnabled(true);
				basGauche.setEnabled(true);
				hautGauche.setEnabled(true);
				basDroite.setEnabled(true);
				hautDroite.setEnabled(true);
			}
			else if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Char ) {
				miner.setEnabled(false);
				basGauche.setEnabled(false);
				hautGauche.setEnabled(false);
				basDroite.setEnabled(false);
				hautDroite.setEnabled(false);
				tirer.setEnabled(true);
			}

		}

		else if(r3.isSelected()){
			numRobot=3;
			if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Tireur ){
				miner.setEnabled(false);
				tirer.setEnabled(true);
				basGauche.setEnabled(true);
				hautGauche.setEnabled(true);
				basDroite.setEnabled(true);
				hautDroite.setEnabled(true);
			}
			else if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Piegeur ){
				tirer.setEnabled(false);
				miner.setEnabled(true);
				basGauche.setEnabled(true);
				hautGauche.setEnabled(true);
				basDroite.setEnabled(true);
				hautDroite.setEnabled(true);
			}
			else if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Char ) {
				miner.setEnabled(false);
				basGauche.setEnabled(false);
				hautGauche.setEnabled(false);
				basDroite.setEnabled(false);
				hautDroite.setEnabled(false);
				tirer.setEnabled(true);
			}

		}

		else if(r4.isSelected()){
			numRobot=4;
			if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Tireur ){
				miner.setEnabled(false);
				tirer.setEnabled(true);
				basGauche.setEnabled(true);
				hautGauche.setEnabled(true);
				basDroite.setEnabled(true);
				hautDroite.setEnabled(true);
			}
			else if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Piegeur ){
				tirer.setEnabled(false);
				miner.setEnabled(true);
				basGauche.setEnabled(true);
				hautGauche.setEnabled(true);
				basDroite.setEnabled(true);
				hautDroite.setEnabled(true);
			}
			else if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Char ) {
				miner.setEnabled(false);
				basGauche.setEnabled(false);
				hautGauche.setEnabled(false);
				basDroite.setEnabled(false);
				hautDroite.setEnabled(false);
				tirer.setEnabled(true);
			}

		}

		else if(r5.isSelected()){
			numRobot=5;
			if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Tireur ){
				miner.setEnabled(false);
				tirer.setEnabled(true);
				basGauche.setEnabled(true);
				hautGauche.setEnabled(true);
				basDroite.setEnabled(true);
				hautDroite.setEnabled(true);
			}
			else if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Piegeur ){
				tirer.setEnabled(false);
				miner.setEnabled(true);
				basGauche.setEnabled(true);
				hautGauche.setEnabled(true);
				basDroite.setEnabled(true);
				hautDroite.setEnabled(true);
			}
			else if (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Char ) {
				miner.setEnabled(false);
				basGauche.setEnabled(false);
				hautGauche.setEnabled(false);
				basDroite.setEnabled(false);
				hautDroite.setEnabled(false);
				tirer.setEnabled(true);
			}

		}
		if (miner.isSelected() || tirer.isSelected()) {
			basGauche.setEnabled(false);
			hautGauche.setEnabled(false);
			basDroite.setEnabled(false);
			hautDroite.setEnabled(false);
		}
		else if (deplacer.isSelected() && ! (BoardDisplayer.board.getRobot(numEquipe, numRobot) instanceof Char)){
			basGauche.setEnabled(true);
			hautGauche.setEnabled(true);
			basDroite.setEnabled(true);
			hautDroite.setEnabled(true);
		}
	}
}
