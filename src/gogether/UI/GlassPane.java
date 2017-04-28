package gogether.UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
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
	JButton addMemberButton;
	Timer timer;
	MemberListCanvas mlc;
	AddMemberCanvas amc;
	
	int x, y;
	
	public GlassPane(MapCanvas mc, JFrame jf, JButton startButton, JButton addMemberButton, MemberListCanvas mlc) {
		this.mc = mc;
		this.jf = jf;
		this.startButton = startButton;
		this.mlc = mlc;
		this.addMemberButton = addMemberButton;
		this.addMouseListener(this);
		timer = new Timer();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
		for (FastArea fa: mc.fas) {
			if (fa.isInFastArea(x, y)) {
				int alpha = 127;
				Color tYellow = new Color(255, 255, 102, alpha);
				g.setColor(tYellow);
				g.fillRoundRect(fa.leftupx, fa.leftupy, (fa.rightdownx - fa.leftupx), (fa.rightdowny - fa.leftupy), 15, 15);
				g.setColor(Color.black);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
				g.drawString("Fast Area", (fa.leftupx + fa.rightdownx) / 2, (fa.leftupy + fa.rightdowny) / 2);
				return;
			}
		}
		for (ComfortArea ca: mc.cas) {
			if (ca.isInComArea(x, y)) {
				int alpha = 127;
				Color tBlue = new Color(135,206,250, alpha);
				g.setColor(tBlue);
				g.fillRoundRect(ca.leftupx, ca.leftupy, (ca.rightdownx - ca.leftupx), (ca.rightdowny - ca.leftupy), 15, 15);
				g.setColor(Color.black);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
				g.drawString("Fast Area", (ca.leftupx + ca.rightdownx) / 2, (ca.leftupy + ca.rightdowny) / 2);
				return;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point glassPanePoint = e.getPoint();
		Container container = jf.getContentPane();
		Point containerPoint = SwingUtilities.convertPoint(
                this,
                glassPanePoint,
                container);
		Component component = SwingUtilities.getDeepestComponentAt(container, containerPoint.x, containerPoint.y);
		if ((component != null) 
                && (component.equals(startButton))) {
			for (int i = 0; i < 15; i++) {
				timer.schedule(new RouteDrawer(mc, 0, mlc), 0L, 100L);
			}		
			for (int i = 0; i < 15; i++) {
				timer.schedule(new RouteDrawer(mc, 1, mlc), 0L, 100L);
			}
			timer.schedule(amc.rd, 0L, 100L);
		}
		else if ((component != null)
				&& (component.equals(addMemberButton))) {
			JFrame addWindow = new JFrame("Add Member");
			amc = new AddMemberCanvas(mc, mlc);
			addWindow.add(amc);
			addWindow.setSize(400, 250);
			addWindow.setVisible(true);
		}
		else {
			Point mapCanvasPoint = SwingUtilities.convertPoint(this, glassPanePoint, mc);
			x = mapCanvasPoint.x;
			y = mapCanvasPoint.y;
			this.repaint();
		}
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
