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

	ArrayList<FastArea> fas = new ArrayList<FastArea>();
	ArrayList<ComfortArea> cas = new ArrayList<ComfortArea>();
	ArrayList<NoPassArea> npas = new ArrayList<NoPassArea>();
	int destx = 1200, desty = 600;
	int depax = 80, depay = 50;
	
	@Override
	public void paint(Graphics g) {
		drawCanvas(g);
	}
	
	private void drawCanvas(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		Dimension size=getSize();
		
		
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0,size.width, size.height);
		
		setComfortArea(150, 0, 250, 250, g);
		
		setFastArea(400, 0, 800, 250, g);
		
		setFastArea(150, 250, 250, 400, g);
		
		setFastArea(400, 450, 800, 250, g);
		
		setComfortArea(400, 250, 500, 200, g);
		
		setFastArea(900, 250, 300, 200, g);
		
		setNoPassArea(250, 50, 250, 150, new ImageIcon("building1.jpeg").getImage(), g);
		
		setNoPassArea(250, 300, 250, 150, new ImageIcon("building2.jpeg").getImage(), g);
		
		setNoPassArea(400 - 25, 250 - 25, 50, 50, new ImageIcon("building3.png").getImage(), g);
		
		setNoPassArea(600, 300, 250, 150, new ImageIcon("").getImage(), g);
		
		setNoPassArea(700, 400, 250, 150, new ImageIcon("").getImage(), g);
		
		putImage(600, 300, 350, 250, new ImageIcon("building5.png").getImage(), g);
		
		setNoPassArea(650, 225, 50, 50, new ImageIcon("building5.jpeg").getImage(), g);
		
		setNoPassArea(900, 200, 100, 200, new ImageIcon("building5.jpeg").getImage(), g);
		
		setNoPassArea(625, 50, 175, 150, new ImageIcon("building5.jpeg").getImage(), g);
		
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
	
	public void setNoPassArea(int x, int y, int width, int height, Image img, Graphics g) {
		NoPassArea npa = new NoPassArea();
		npa.leftupx = x;
		npa.leftupy = y;
		npa.rightdownx = x + width;
		npa.rightdowny = y + height;
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.drawImage(img, x, y, width, height, null);
		this.npas.add(npa);
//		g.drawImage(image1, x ,y, null);
	}
	
	public void putImage(int x, int y, int width, int height, Image img, Graphics g) {
		g.drawImage(img, x, y, width, height, null);
	}
	
	public void setFastArea(int x, int y, int width, int height, Graphics g) {
		FastArea fa = new FastArea();
		fa.leftupx = x;
		fa.leftupy = y;
		fa.rightdownx = x + width;
		fa.rightdowny = y + height;
//		g.setColor(Color.blue);
//		g.fillRect(x, y, width, height);
		this.fas.add(fa);
	}
	
	public void setComfortArea(int x, int y, int width, int height, Graphics g) {
		ComfortArea ca = new ComfortArea();
		ca.leftupx = x;
		ca.leftupy = y;
		ca.rightdownx = x + width;
		ca.rightdowny = y + height;
//		g.setColor(Color.yellow);
//		g.fillRect(x, y, width, height);
		this.cas.add(ca);
	}
	
}
