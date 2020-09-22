import java.util.*;
public class Board {
	private Player PlayerOne;
	private Player PlayerTwo;
	private Player PlayerThree;
	private Player PlayerFour;
	private ArrayList<Domino> Boneyard;
	private Player order[];
	private ArrayList<Domino> board;
	private Scanner kb = new Scanner(System.in);
	private Domino current;
	private int round = 1;
	public Board() {
		board = new ArrayList<>();
		
		Deck d = new Deck();
		Boneyard = d.getDeck();
		PlayerOne = new Player("Player One");
		PlayerTwo = new Player("Player Two");
		PlayerThree = new Player("Player Three");
		PlayerFour = new Player("Player Four");
		order = new Player[4];
		while(PlayerOne.getScore()<100&&PlayerTwo.getScore()<100&&PlayerThree.getScore()<100&&PlayerFour.getScore()<100) {
			System.out.println("Round Number: "+round);
			PlayerOne.setHand(giveHand());
			PlayerTwo.setHand(giveHand());
			PlayerThree.setHand(giveHand());
			PlayerFour.setHand(giveHand());
		firstTurn(PlayerOne,PlayerTwo,PlayerThree,PlayerFour);
		printHand(order[0]);
		System.out.println("What first domino does "+order[0].getName()+ " want to place on the board? Choose the number beside the pips");
		int num = kb.nextInt();
		board.add(order[0].getPlayerHand().get(num));
		current = order[0].getPlayerHand().get(num);
		order[0].getPlayerHand().remove(num);
		int passes = 0;
		int i = 1;
		while(order[0].getPlayerHand().size()!=0&&order[1].getPlayerHand().size()!=0&&order[2].getPlayerHand().size()!=0&&order[3].getPlayerHand().size()!=0&&passes!=4) {
			if(i==4)
				i=0;
			System.out.println("CURRENT DOMINO: "+ current);
			printHand(order[i]);
			System.out.println("What domino does " +order[i].getName()+" to place on the board? Choose the number beside the pips. If you have to pass choose a random domino. MAKE SURE YOUR CHOICE IS COMPATIBLE WITH THE CURRENT DOMINO OR ELSE YOU WILL GET A PASS");
			int n = kb.nextInt();
			if(order[i].getPlayerHand().get(n).isCompatible(board.get(board.size()-1))) {
				board.add(order[i].getPlayerHand().get(n));
				current = order[i].getPlayerHand().get(n);
				order[i].getPlayerHand().remove(n);
				passes=0;
			}
			else {
				System.out.println("Your turn is passed");
				passes++;
			}
			i++;
		}
		if(order[0].getPlayerHand().size()==0)
			order[0].setScore(addUpScores(order[1],order[2],order[3]));
		if(order[1].getPlayerHand().size()==0)
			order[1].setScore(addUpScores(order[0],order[2],order[3]));
		if(order[2].getPlayerHand().size()==0)
			order[2].setScore(addUpScores(order[1],order[0],order[3]));
		if(order[3].getPlayerHand().size()==0)
			order[3].setScore(addUpScores(order[1],order[2],order[0]));
		
		System.out.println("Player One score: "+order[0].getScore());
		System.out.println("Player Two score: "+order[1].getScore());
		System.out.println("Player Three score: "+order[2].getScore());
		System.out.println("Player Four score: "+order[3].getScore());
		Boneyard = d.resetDeck();
		round++;
	}
		System.out.println("Player One FINAL score: "+order[0].getScore());
		System.out.println("Player Two FINAL score: "+order[1].getScore());
		System.out.println("Player Three FINAL score: "+order[2].getScore());
		System.out.println("Player Four FINAL score: "+order[3].getScore());
		if(order[0].getScore()>100)
			System.out.println("Player One WINS");
		if(order[1].getScore()>100)
			System.out.println("Player Two WINS");
		if(order[2].getScore()>100)
			System.out.println("Player Three WINS");
		if(order[3].getScore()>100)
			System.out.println("Player Four WINS");
		
	}
	public ArrayList<Domino> giveHand( ) {
		ArrayList temp = new ArrayList<Domino>();
		for(int i =0; i<7;i++) {
			temp.add(Boneyard.get(0));
			Boneyard.remove(Boneyard.get(0));
		}
		return temp;
	}
	
	public int addUpScores(Player p, Player x, Player y) {
		int n = p.getScore();
		for(int i = 0; i<p.getPlayerHand().size();i++) {
			n += p.getPlayerHand().get(i).getPip1();
			n += p.getPlayerHand().get(i).getPip2();
		}
		int c = x.getScore();
		for(int i = 0; i<x.getPlayerHand().size();i++) {
			c += x.getPlayerHand().get(i).getPip1();
			c += x.getPlayerHand().get(i).getPip2();
		}
		int o = y.getScore();
		for(int i = 0; i<y.getPlayerHand().size();i++) {
			o += y.getPlayerHand().get(i).getPip1();
			o+= y.getPlayerHand().get(i).getPip2();
		}
		return n+c+o;
	}
	public ArrayList<Domino> getPlayerOneDeck(){
		return order[0].getPlayerHand();
	}
	
	public ArrayList<Domino> getPlayerTwoDeck(){
		return order[1].getPlayerHand();
	}
	
	public ArrayList<Domino> getPlayerThreeDeck(){
		return order[3].getPlayerHand();
	}
	
	public ArrayList<Domino> getPlayerFourDeck(){
		return order[4].getPlayerHand();
	}
	public void printHand(Player p) {
		System.out.println("Current Hand:");
		for(int i = 0; i<p.getPlayerHand().size();i++) {
			System.out.println(p.getPlayerHand().get(i)+" "+i);
		}
	}
	public Player[] getOrder() {
		return order;
	}

	public void firstTurn(Player one, Player two, Player three, Player four) {
		int highestDoubleOne = 0;
		int highestDoubleTwo = 0;
		int highestDoubleThree = 0;
		int highestDoubleFour = 0;
		ArrayList<Integer> temp = new ArrayList<>();
		for(Domino d : one.getPlayerHand()) {
			if(d.isDouble()&&d.getPip1()>highestDoubleOne) {
				highestDoubleOne = d.getPip1();
			}
		}
		for(Domino d : two.getPlayerHand()) {
			if(d.isDouble()&&d.getPip1()>highestDoubleTwo) {
				highestDoubleTwo = d.getPip1();
			}
		}
		for(Domino d : three.getPlayerHand()) {
			if(d.isDouble()&&d.getPip1()>highestDoubleThree) {
				highestDoubleThree = d.getPip1();
			}
		}
		for(Domino d : four.getPlayerHand()) {
			if(d.isDouble()&&d.getPip1()>highestDoubleOne) {
				highestDoubleFour = d.getPip1();
			}
		}
		temp.add(highestDoubleOne);
		temp.add(highestDoubleTwo);
		temp.add(highestDoubleThree);
		temp.add(highestDoubleFour);
		Collections.sort(temp);
		if(temp.get(3)==highestDoubleOne)
			order[0] = PlayerOne;
		if(temp.get(3)==highestDoubleTwo)
			order[0] = PlayerTwo;
		if(temp.get(3)==highestDoubleThree)
			order[0] = PlayerThree;
		if(temp.get(3)==highestDoubleFour)
			order[0] = PlayerFour;
		if(temp.get(2)==highestDoubleOne)
			order[1] = PlayerOne;
		if(temp.get(2)==highestDoubleTwo)
			order[1] = PlayerTwo;
		if(temp.get(2)==highestDoubleThree)
			order[1] = PlayerThree;
		if(temp.get(2)==highestDoubleFour)
			order[1] = PlayerFour;
		if(temp.get(1)==highestDoubleOne)
			order[2] = PlayerOne;
		if(temp.get(1)==highestDoubleTwo)
			order[2] = PlayerTwo;
		if(temp.get(1)==highestDoubleThree)
			order[2] = PlayerThree;
		if(temp.get(1)==highestDoubleFour)
			order[2] = PlayerFour;
		if(temp.get(0)==highestDoubleOne)
			order[3] = PlayerOne;
		if(temp.get(0)==highestDoubleTwo)
			order[3] = PlayerTwo;
		if(temp.get(0)==highestDoubleThree)
			order[3] = PlayerThree;
		if(temp.get(0)==highestDoubleFour)
			order[3] = PlayerFour;
		
	}

}
