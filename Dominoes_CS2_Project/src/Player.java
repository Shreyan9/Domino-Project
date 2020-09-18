import java.awt.image.BufferedImage;
import java.util.*;
public class Player{
	private List<Domino> PlayerHand;
	private List<BufferedImage> PlayerGraphics;
	private int score;
	private boolean IsFirst;
	public Player() {score = 0;}
	public Player(List<Domino> p, List<BufferedImage> b) {
		PlayerHand = p;
		PlayerGraphics = b;
		int score = 0;
	}
	public void removeDomino(Domino d){
		for(int i = 0; i<PlayerHand.size();i++) {
			if(d.equals(PlayerHand.get(i)))
				PlayerHand.remove(i);
		}
	}
	public void addDomino(Domino d) {
		PlayerHand.add(d);
	}
	public void setScore(int s) {
		score = s;
	}
	public int getScore() {
		return score;
	}
	public List<Domino> getPlayerHand() {
		return PlayerHand;
	}
	public List<BufferedImage> getGraphicsHand() {
		return PlayerGraphics;
	}
	public int getHighestDouble() {
		int x =0;
		for(Domino d : PlayerHand) {
			if(d.isDouble()&&d.getPip1()>x) {
				x = d.getPip1();
			}
		}
		return x;
	}
	public int compareTo(Player p) {
		if(p.getHighestDouble()>getHighestDouble())
			return -1;
		return 1;
		
	}
	public void setTurn(boolean b) {
		IsFirst = b;
	}
	public boolean getTurn() {
		return IsFirst;
	}
	
}
