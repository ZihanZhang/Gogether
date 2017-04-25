package gogether.UI;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.util.TimerTask;

import javax.swing.JPanel;

import gogether.Logic.Member;
import gogether.Logic.NoPassArea;

public class RouteDrawer extends TimerTask{
	int destx, desty, depax, depay;
	
	Member m;
	
	MapCanvas mapCanvas;
	
	public RouteDrawer(MapCanvas mapCanvas, int preference) {
		this.mapCanvas = mapCanvas;
		this.destx = mapCanvas.destx;
		this.desty = mapCanvas.desty;
		this.depax = mapCanvas.depax;
		this.depay = mapCanvas.depay;
		m = new Member(destx, desty, depax, depay);
		m.preference = preference;
		if (preference == 0) {
			m.curx = depax;
			m.cury = depay;
			m.fas = mapCanvas.fas;
			m.npas = mapCanvas.npas;
		}
		
		if (preference == 1) {
			m.curx = depax;
			m.cury = depay;
			m.cas = mapCanvas.cas;
			m.npas = mapCanvas.npas;
		}
	}
	
	public void draw() {
//		if (newx == 700 && newy == 370) {
//			cancel();
//		}
		Graphics2D g2d=(Graphics2D) mapCanvas.getGraphics();
		g2d.setColor(Color.red);
		m.w = 1;
		m.c1 = 0.5;
		m.c2 = 0.5;
		m.gbestx = destx;
		m.gbesty = desty;
		m.oldx = m.curx;
		m.oldy = m.cury;
		if (m.preference == 0) {
			m.setPbestxFast();
			m.setPbestyFast();
		}
		if (m.preference == 1) {
			m.setPbestxCom();
			m.setPbestyCom();
		}
		m.setGbestx();
		m.setGbesty();
		m.setNextLocation();
		m.setNewLocation();
		m.avoidNoPassArea();
//		System.out.println(npa.leftupx + " " + npa.leftupy + " " + npa.rightdownx + " " + npa.rightdowny);
		g2d.drawLine(m.curx, m.cury, m.newx, m.newy);
//		g2d.drawRect(m1.newx - 50, m1.newy - 50, 50, 50);
//		System.out.println(m1.curx + " " + m1.cury);
		m.moveToNewLocation();
		
		mapCanvas.validate();
	}

	@Override
	public void run() {
		draw();
	}
}
