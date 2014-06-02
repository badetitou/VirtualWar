package gameGraphic;

import gameWar.Plateau;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WarPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout cl;
	JPanel pan;
	public static JPanel p;
	static BoardDisplayer bd;
	public static JTextArea t;
	public static String info="coucou";

	public WarPanel(CardLayout cl, JPanel pan){
		this.cl=cl;
		this.pan=pan;
		this.setLayout(new GridLayout(1,2,20,20));
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p = new JPanel();
		p.setLayout(new GridLayout(2,1));
		int tours=0;
		bd = new BoardDisplayer(cl, pan, gameWar.Game.p = new Plateau(0));


		p.add(new ActionPanel((tours%2)+1));
		t=new JTextArea(info);
		tours++;


		//t.setEditable(false);
		t.setBounds(100,20,200,70);
		p2.add(t);
		p.add(p2);
		tours++;
		this.add(bd);
		this.add(p);


	}

}
