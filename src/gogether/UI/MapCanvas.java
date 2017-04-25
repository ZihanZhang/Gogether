package gogether.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
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

	FastArea fa1 = new FastArea();
	FastArea fa2 = new FastArea();
	ArrayList<FastArea> fas = new ArrayList<FastArea>();
	ComfortArea ca1 = new ComfortArea();
	ComfortArea ca2 = new ComfortArea();
	ArrayList<ComfortArea> cas = new ArrayList<ComfortArea>();
	NoPassArea npa1 = new NoPassArea();
	NoPassArea npa2 = new NoPassArea();
	ArrayList<NoPassArea> npas = new ArrayList<NoPassArea>();
	Image image1;
	int destx = 1200, desty = 600;
	int depax = 80, depay = 50;
	
	@Override
	public void paint(Graphics g) {
		drawCanvas(g);
	}
	
	private void drawCanvas(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		Dimension size=getSize();
		image1 = new ImageIcon("index.jpeg").getImage();
		
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0,size.width, size.height);
		
//		g2d.setColor(Color.black);
//		g2d.drawLine(0, 0, size.width, size.height);
		
		
		g2d.setColor(Color.yellow);
		g2d.fillRect(150, 0, 250, 250);
		ca1.leftupx = 150;
		ca1.leftupy = 0;
		ca1.rightdownx = 400;
		ca1.rightdowny = 250;
		cas.add(ca1);
		
		g2d.setColor(Color.blue);
		g2d.fillRect(400, 0, 250, 250);
		fa2.leftupx = 400;
		fa2.leftupy = 0;
		fa2.rightdownx = 650;
		fa2.rightdowny = 250;
		fas.add(fa2);
		
		g2d.setColor(Color.blue);
		g2d.fillRect(150, 250, 250, 200);
		fa1.leftupx = 150;
		fa1.leftupy = 250;
		fa1.rightdownx = 400;
		fa1.rightdowny = 450;
		fas.add(fa1);
		
		g2d.setColor(Color.yellow);
		g2d.fillRect(400, 250, 250, 200);
		ca2.leftupx = 400;
		ca2.leftupy = 250;
		ca2.rightdownx = 650;
		ca2.rightdowny = 450;
		cas.add(ca2);
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(250, 50, 250, 150);
		npa1.leftupx = 250;
		npa1.leftupy = 50;
		npa1.rightdownx = 500;
		npa1.rightdowny = 200;
		npas.add(npa1);
		g.drawImage(image1, 250, 50, null);
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(250, 300, 250, 150);
		npa2.leftupx = 250;
		npa2.leftupy = 300;
		npa2.rightdownx = 500;
		npa2.rightdowny = 450;
		npas.add(npa2);
		g.drawImage(image1, 250, 300, null);
		
		g2d.setColor(Color.RED);
		g2d.fillOval(80, 50, 5, 5);
		depax = 80;
		depay = 50;
		g2d.drawString("Departure", 85, 50);
		
		g2d.setColor(Color.RED);
		g2d.fillOval(1100, 600, 5, 5);
		destx = 1100;
		desty = 600;
		g2d.drawString("Destination", 1105, 605);
	}
	
}
