package TP01exo3;
//import javax.swing.JPanel;
import javax.swing.JFrame;

public class Gui {
	
	public JFrame frame;
	public TicTacToe game = new TicTacToe();
	public MyListener Listner;
	//public JFrame framecopyright;
	
	public Gui() {
	frame = new JFrame();
	frame.setContentPane(game);
	frame.setSize(600,600);
	frame.setLocation(100, 100);
	frame.setResizable(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	Listner = new MyListener(game, frame);
	frame.addMouseListener(Listner);
	}
	
	public static void main(String [] args) {
		Gui GuiEx = new Gui();
	}
	
}

