import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import java.util.*;
public class DominoesPanel extends JPanel{
	private Player[] order;
	
	public DominoesPanel() {
		Board b = new Board();
		order = b.getOrder();
		
	}

	
	
}
