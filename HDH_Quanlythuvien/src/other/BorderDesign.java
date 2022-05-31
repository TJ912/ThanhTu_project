package other;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BorderDesign implements Border {
	private Border lineBorder;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
	private Border compound;
	private Border Matte;
	private Border title;
	
	public Border getLineBorder(Color color) {
		 lineBorder= BorderFactory.createLineBorder(color);
		return lineBorder;
	}
	public Border getRaisedBevel() {
		return raisedBevel;
	}
	public Border getCompound() {
		lineBorder= BorderFactory.createLineBorder(Color.blue);
		compound= BorderFactory.createCompoundBorder(lineBorder,raisedBevel);
		return compound;
	}
	public Border getMatte(int weight,Color color) {
		Matte=BorderFactory.createMatteBorder(weight,weight,weight,weight,color);
		return Matte;
	}
	public Border getTitle(String title1,Color BorderColor,Color Titlecolor) {
		title=BorderFactory.createTitledBorder(getMatte(5, BorderColor), title1, TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,new Font("Yanone Kaffeesatz",Font.BOLD,20),Titlecolor);
		return title;
	}
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Insets getBorderInsets(Component c) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
