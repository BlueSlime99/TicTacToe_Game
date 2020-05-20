package TP01exo3;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class TicTacToe extends JPanel{
	
@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getSize().width ;
		int height= getSize().height;
		g.setColor(Color.BLACK);
		g.drawLine(width / 3, 0, width / 3, height);
		g.drawLine(width * 2 / 3, 0, width * 2 / 3, height);
		g.drawLine(0, height / 3, width, height / 3);
		g.drawLine(0, height * 2 / 3, width, height * 2 / 3);
		
		
	}
}
	
