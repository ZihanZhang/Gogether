package gogether.UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gogether.Logic.ComfortArea;
import gogether.Logic.FastArea;

public class GlassPane extends JComponent implements MouseListener{
	
	MapCanvas mc;
	JFrame jf;
	JButton startButton;
	Timer timer;
	MemberListCanvas mlc;
	
	int x, y;
	
	public GlassPane(MapCanvas mc, JFrame jf, JButton startButton, MemberListCanvas mlc) {
		this.mc = mc;
		this.jf = jf;
		this.startButton = startButton;
		this.mlc = mlc;
		this.addMouseListener(this);
		timer = new Timer();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
//		for (FastArea fa: mc.fas) {
//			if (fa.isInFastArea(x, y)) {
//				g.setColor(Color.black);
//				g.fillRect(fa.leftupx, fa.leftupy, (fa.rightdownx - fa.leftupx), (fa.rightdowny - fa.leftupy));
//			}
//		}
//		for (ComfortArea ca: mc.cas) {
//			if (ca.isInComArea(x, y)) {
//				g.setColor(Color.black);
//				g.fillRect(ca.leftupx, ca.leftupy, (ca.rightdownx - ca.leftupx), (ca.rightdowny - ca.leftupy));
//			}
//		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point glassPanePoint = e.getPoint();
		Container container = jf.getContentPane();
		Point containerPoint = SwingUtilities.convertPoint(
                this,
                glassPanePoint,
                container);
		// TODO Auto-generated method stub
		Component component = SwingUtilities.getDeepestComponentAt(container, containerPoint.x, containerPoint.y);
		if ((component != null) 
                && (component.equals(startButton))) {
			for (int i = 0; i < 15; i++) {
				timer.schedule(new RouteDrawer(mc, 0, mlc), 0L, 100L);		
			}		
			for (int i = 0; i < 15; i++) {
				timer.schedule(new RouteDrawer(mc, 1, mlc), 0L, 100L);
			}
		}
		System.out.println(containerPoint.x + " " + containerPoint.y); 
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
