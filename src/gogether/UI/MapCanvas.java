package gogether.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gogether.Logic.ComfortArea;
import gogether.Logic.FastArea;
import gogether.Logic.NoPassArea;
import net.java.dev.designgridlayout.DesignGridLayout;

public class MapCanvas extends JPanel{

	FastArea fa = new FastArea();
	ComfortArea ca = new ComfortArea();
	NoPassArea npa = new NoPassArea();
	
	@Override
	public void paint(Graphics g) {
		drawCanvas(g);
	}
	
	private void drawCanvas(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		Dimension size=getSize();
		
		g2d.setColor(Color.GREEN);
		g2d.fillRect(0, 0,size.width, size.height);
		
//		g2d.setColor(Color.black);
//		g2d.drawLine(0, 0, size.width, size.height);
		
		
		g2d.setColor(Color.yellow);
		g2d.fillRect(150, 0, 500, 200);
		ca.leftupx = 150;
		ca.leftupy = 0;
		ca.rightdownx = 650;
		ca.rightdowny = 200;
		
		g2d.setColor(Color.blue);
		g2d.fillRect(150, 250, 500, 200);
		fa.leftupx = 150;
		fa.leftupy = 250;
		fa.rightdownx = 650;
		fa.rightdowny = 450;
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(250, 150, 250, 150);
		npa.leftupx = 250;
		npa.leftupy = 150;
		npa.rightdownx = 500;
		npa.rightdowny = 300;
		
		g2d.setColor(Color.RED);
		g2d.fillOval(80, 50, 5, 5);
		g2d.drawString("Departure", 85, 50);
		
		g2d.setColor(Color.RED);
		g2d.fillOval(700, 370, 5, 5);
		g2d.drawString("Destination", 705, 375);
	}
	
}
