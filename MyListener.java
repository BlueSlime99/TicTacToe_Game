package TP01exo3;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyListener extends MouseAdapter{
	private JFrame frameCopyright;
	private TicTacToe PanelSouris;
	private int [] [] players= new int [3][3];
	private int playerOne =1;
	private int playerTwo=0;
	private boolean PartieContinue = false;
	private String text1= "Player One Wins";
	private String text2= "Player Two Wins";
	private String title = "Show Frame";
	private int optionType = JOptionPane.OK_CANCEL_OPTION;
	private int P =0;
	
	public MyListener(TicTacToe Panel, JFrame framecopyright) {
		this.PanelSouris = Panel;
		this.frameCopyright= framecopyright;
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		super.mouseClicked(e);
		
		int PosX = e.getX() * 3 / PanelSouris.getSize().width;
		int PosY = e.getY() * 3 / PanelSouris.getSize().height;
		int x = PosX;
		int y =PosY;
	 	PosX = PosX* PanelSouris.getSize().width / 3; 
		PosY = PosY * PanelSouris.getSize().height / 3;
		Graphics g = PanelSouris.getGraphics();
			
		verification(PosX, PosY, x, y, g);
		winner();
	}

	private void winner() throws HeadlessException {
		if(PartieContinue) {
			if( P == 2) {
				int result = JOptionPane.showConfirmDialog(null, text2, title, optionType);
			    if (result == JOptionPane.OK_OPTION) {
			    	frameCopyright.setDefaultCloseOperation(frameCopyright.DISPOSE_ON_CLOSE);
			    	frameCopyright.dispose();
			    }
			}else if (P == 1) {
				int result = JOptionPane.showConfirmDialog(null, text1, title, optionType);
			    if (result == JOptionPane.OK_OPTION) {
			    	frameCopyright.setDefaultCloseOperation(frameCopyright.DISPOSE_ON_CLOSE);
			    	frameCopyright.dispose();
			    }
			}
		
		
	
		}
	}

	private void verification(int PosX, int PosY, int x, int y, Graphics g) {
		if(playerOne == 1 && players[x][y]==0) {
			playerOne--;
			playerTwo++;
			players[x][y] = 1;
			g.setColor(Color.BLUE);
			g.fillRect(PosX,  PosY, PanelSouris.getSize().width / 3, PanelSouris.getSize().height / 3);
		
		}

		else if(playerTwo == 1 && players[x][y] == 0) {
			playerOne++;
			playerTwo--;
			players[x][y] = 2;
			g.setColor(Color.RED);
			g.fillRect(PosX,  PosY, PanelSouris.getSize().width / 3, PanelSouris.getSize().height / 3);
		}
	
		for(int i=0; i<3 ; i++) {
				if(players[0][i] != 0)
				if((players[0][i] == players[1][i]) && (players[1][i] == players[2][i]) && PartieContinue == false) {
					PartieContinue = true;
					if(players[0][i] == 1) P = 1;
					else { P = 2;
					}
				}
		}
		for(int i=0; i<3 ; i++) {
			if(players[i][0] != 0)
			if((players[i][0] == players[i][1]) && (players[i][1] == players[i][2]) && PartieContinue == false) {
				PartieContinue = true;
				if(players[i][0] == 1) { P=1;
				
				}else {
					P = 2;
				}
			
			}
		}
	if(players[1][1] != 0) {	
		if(players[0][0] == players[1][1] && players[1][1] == players[2][2]) {
			PartieContinue = true;
			if(players[1][1] == 1) { P=1;
			
			}else {
				P = 2;
			}
		}
		if(players [0][2] == players[1][1] && players[1][1] == players[2][0]) {
			PartieContinue = true;
			if(players[1][1] == 1) { P=1;
			
			}else {
				P = 2;
			}
		}
	}
	}
}

