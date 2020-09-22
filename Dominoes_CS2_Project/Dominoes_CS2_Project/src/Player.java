import java.util.*;
public class Player{
	private ArrayList<Domino> PlayerHand;
	private String name;
	private int score;
	public Player(String n) {
		score = 0;
		name = n;
	}
	public Player(ArrayList<Domino> p) {
		PlayerHand = p;
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
	public String getName() {
		return name;
	}
	public void setScore(int s) {
		score = s;
	}
	public int getScore() {
		return score;
	}
	public ArrayList<Domino> getPlayerHand() {
		return PlayerHand;
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
	public void setHand(ArrayList<Domino> x) {
		PlayerHand = x;
	}
	
	
	
}
