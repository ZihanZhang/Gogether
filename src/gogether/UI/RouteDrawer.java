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
	Member m3 = new Member();
	Member m4 = new Member();
	
	MapCanvas mapCanvas;
	
	public RouteDrawer(MapCanvas mapCanvas) {
		this.mapCanvas = mapCanvas;
		m1.curx = 80;
		m1.cury = 50;
		m1.fas = mapCanvas.fas;
		m1.npas = mapCanvas.npas;
		
		m2.curx = 80;
		m2.cury = 50;
		m2.cas = mapCanvas.cas;
		m2.npas = mapCanvas.npas;
		
		m3.curx = 80;
		m3.cury = 50;
		m3.cas = mapCanvas.cas;
		m3.npas = mapCanvas.npas;
		
		m4.curx = 80;
		m4.cury = 50;
		m4.fas = mapCanvas.fas;
		m4.npas = mapCanvas.npas;
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
		
		m3.w = 1;
		m3.c1 = 1;
		m3.c2 = 1;
		m3.gbestx = 700;
		m3.gbesty = 370;
		m3.oldx = m3.curx;
		m3.oldy = m3.cury;
		m3.setPbestxCom();
		m3.setPbestyCom();
		m3.setGbestx();
		m3.setGbesty();
		m3.setNextLocation();
		m3.setNewLocation();
		m3.avoidNoPassArea();
//		System.out.println(mapCanvas.fa.leftupx + " " + mapCanvas.fa.leftupy + " " + mapCanvas.fa.rightdownx + " " + mapCanvas.fa.rightdowny);
		g2d.drawLine(m3.curx, m3.cury, m3.newx, m3.newy);
//		g2d.drawRect(m2.curx - 50, m2.cury - 50, 50, 50);
//		System.out.println(m2.curx + " " + m2.cury);
		m3.moveToNewLocation();
		
		m4.w = 1;
		m4.c1 = 1;
		m4.c2 = 1;
		m4.gbestx = 700;
		m4.gbesty = 370;
		m4.oldx = m4.curx;
		m4.oldy = m4.cury;
		m4.setPbestxFast();
		m4.setPbestyFast();
		m4.setGbestx();
		m4.setGbesty();
		m4.setNextLocation();
		m4.setNewLocation();
		m4.avoidNoPassArea();
//		System.out.println(npa.leftupx + " " + npa.leftupy + " " + npa.rightdownx + " " + npa.rightdowny);
		g2d.drawLine(m4.curx, m4.cury, m4.newx, m4.newy);
//		g2d.drawRect(m1.newx - 50, m1.newy - 50, 50, 50);
//		System.out.println(m1.curx + " " + m1.cury);
		m4.moveToNewLocation();
		
		mapCanvas.validate();
	}

	@Override
	public void run() {
		draw();
	}
}
