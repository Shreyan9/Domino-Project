import java.util.*;
public class Deck {
	private ArrayList<Domino> boneyard;
	public Deck() {
		boneyard = new ArrayList<Domino>();
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
		Collections.shuffle(boneyard);
	}
	public ArrayList<Domino> getDeck(){
		return boneyard;
	}
	public void removeDomino(Domino d){
		for(int i = 0; i<boneyard.size();i++) {
			if(d.equals(boneyard.get(i)))
				boneyard.remove(i);
		}
	}
	
	public void resetDeck() {
		boneyard = new ArrayList<Domino>();
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
		Collections.shuffle(boneyard);
	} 


}
