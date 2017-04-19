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
	Member m1 = new Member();
	Member m2 = new Member();
	
	MapCanvas mapCanvas;
	
	public RouteDrawer(MapCanvas mapCanvas) {
		this.mapCanvas = mapCanvas;
		m1.curx = 80;
		m1.cury = 50;
		m1.fa = mapCanvas.fa;
		m1.npa = mapCanvas.npa;
		
		m2.curx = 80;
		m2.cury = 50;
		m2.ca = mapCanvas.ca;
		m2.npa = mapCanvas.npa;
	}
	
	public void draw() {
//		if (newx == 700 && newy == 370) {
//			cancel();
//		}
		Graphics2D g2d=(Graphics2D) mapCanvas.getGraphics();
		g2d.setColor(Color.red);
		m1.w = 1;
		m1.c1 = 1;
		m1.c2 = 1;
		m1.gbestx = 700;
		m1.gbesty = 370;
		m1.oldx = m1.curx;
		m1.oldy = m1.cury;
		m1.setPbestxFast();
		m1.setPbestyFast();
		m1.setGbestx();
		m1.setGbesty();
		m1.setNextLocation();
		m1.setNewLocation();
		m1.avoidNoPassArea();
//		System.out.println(npa.leftupx + " " + npa.leftupy + " " + npa.rightdownx + " " + npa.rightdowny);
		g2d.drawLine(m1.curx, m1.cury, m1.newx, m1.newy);
//		g2d.drawRect(m1.newx - 50, m1.newy - 50, 50, 50);
//		System.out.println(m1.curx + " " + m1.cury);
		m1.moveToNewLocation();
		
		m2.w = 1;
		m2.c1 = 1;
		m2.c2 = 1;
		m2.gbestx = 700;
		m2.gbesty = 370;
		m2.oldx = m2.curx;
		m2.oldy = m2.cury;
		m2.setPbestxCom();
		m2.setPbestyCom();
		m2.setGbestx();
		m2.setGbesty();
		m2.setNextLocation();
		m2.setNewLocation();
		m2.avoidNoPassArea();
//		System.out.println(mapCanvas.fa.leftupx + " " + mapCanvas.fa.leftupy + " " + mapCanvas.fa.rightdownx + " " + mapCanvas.fa.rightdowny);
		g2d.drawLine(m2.curx, m2.cury, m2.newx, m2.newy);
//		g2d.drawRect(m2.curx - 50, m2.cury - 50, 50, 50);
//		System.out.println(m2.curx + " " + m2.cury);
		m2.moveToNewLocation();
		
		mapCanvas.validate();
	}

	@Override
	public void run() {
		draw();
	}
}
