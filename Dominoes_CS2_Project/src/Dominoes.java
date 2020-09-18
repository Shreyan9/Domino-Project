import javax.swing.JFrame;
import javax.swing.JPanel;
public class Dominoes extends JFrame{
	private static final int WIDTH= 1600;
	private static final int HEIGHT= 1000;
	private JPanel panel;
	
	public Dominoes(String title) {
		super(title);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new DominoesPanel();
		add(panel);
		setVisible(true);
	}
}
