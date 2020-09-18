import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent; 
public class DominoesPanel extends JPanel implements MouseListener{
	private ArrayList<Domino> boneyard;
	private ArrayList<BufferedImage> boneyardGraphics;
	private Player PlayerOne;
	private Player PlayerTwo;
	private Player FirstTurn;
	public DominoesPanel() {
		PlayerOne = new Player();
		PlayerTwo = new Player();
		boneyard = new ArrayList<>();
		boneyardGraphics = new ArrayList<>();
		boneyard.add(new Domino(0,0));
		boneyard.add(new Domino(0,1));
		boneyard.add(new Domino(0,2));
		boneyard.add(new Domino(0,3));
		boneyard.add(new Domino(0,4));
		boneyard.add(new Domino(0,5));
		boneyard.add(new Domino(0,6));
		boneyard.add(new Domino(1,1));
		boneyard.add(new Domino(1,2));
		boneyard.add(new Domino(1,3));
		boneyard.add(new Domino(1,4));
		boneyard.add(new Domino(1,5));
		boneyard.add(new Domino(1,6));
		boneyard.add(new Domino(2,2));
		boneyard.add(new Domino(2,3));
		boneyard.add(new Domino(2,4));
		boneyard.add(new Domino(2,5));
		boneyard.add(new Domino(2,6));
		boneyard.add(new Domino(3,3));
		boneyard.add(new Domino(3,4));
		boneyard.add(new Domino(3,5));
		boneyard.add(new Domino(3,6));
		boneyard.add(new Domino(4,4));
		boneyard.add(new Domino(4,5));
		boneyard.add(new Domino(4,6));
		boneyard.add(new Domino(5,5));
		boneyard.add(new Domino(5,6));
		boneyard.add(new Domino(6,6));
		
		
		try {
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/0-0.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/0-1.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/0-2.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/0-3.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/0-4.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/0-5.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/0-6.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/1-1.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/1-2.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/1-3.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/1-4.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/1-5.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/1-6.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/2-2.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/2-3.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/2-4.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/2-5.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/2-6.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/3-3.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/3-4.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/3-5.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/3-6.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/4-4.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/4-5.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/4-6.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/5-5.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/5-6.PNG")));
			boneyardGraphics.add(ImageIO.read(DominoesPanel.class.getResource("/Image/6-6.PNG")));
		}
		catch(Exception e) {
			System.out.println("Exception");
			return;
		}
		giveHands();
		
		
		
	}
	
	public void giveHands() {
		PlayerOne = assign();
		PlayerTwo = assign();
		
	}
	
	public Player assign(){
		ArrayList<Domino> playerHand = new ArrayList<>();
		ArrayList<BufferedImage> v = new ArrayList<>();
		for(int i = 0; i<7; i++) {
			int random = (int)(Math.random()*boneyard.size());
			playerHand.add(boneyard.get(random));
			boneyard.remove(random);
			v.add(boneyardGraphics.get(random));
			boneyardGraphics.remove(random);
		}
		return new Player(playerHand,v);
	}
	
	public void setOrder() {
		int x = PlayerOne.compareTo(PlayerTwo);
		if(x==1) {
			PlayerOne.setTurn(true);
			PlayerTwo.setTurn(false);
		}
		else
			PlayerOne.setTurn(false);
			PlayerTwo.setTurn(true);
	}
	
	public void paint(Graphics g) {
		
	if(PlayerOne.getTurn())	{
		g.drawImage(PlayerOne.getGraphicsHand().get(0), 150, 500 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(1), 450, 500 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(2), 750, 500 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(3), 1050,500 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(4), 300, 600 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(5), 600, 600 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(6), 900, 600 , getWidth()/8, getHeight()/12, null);
	}
	else
		g.drawImage(PlayerOne.getGraphicsHand().get(0), 150, 500 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(1), 450, 500 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(2), 750, 500 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(3), 1050,500 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(4), 300, 600 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(5), 600, 600 , getWidth()/8, getHeight()/12, null);
		g.drawImage(PlayerOne.getGraphicsHand().get(6), 900, 600 , getWidth()/8, getHeight()/12, null);	
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	
}
