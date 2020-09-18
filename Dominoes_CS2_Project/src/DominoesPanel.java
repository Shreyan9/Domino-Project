import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.*;
import java.util.*;
public class DominoesPanel extends JPanel{
	
	private ArrayList<BufferedImage> boneyardGraphics;
	public DominoesPanel() {
		
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
		
		
		
	}
	public void paint(Graphics g) {
		
	}
	
	
}
