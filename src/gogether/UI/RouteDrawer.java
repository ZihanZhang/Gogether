package gogether.UI;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.util.TimerTask;

import javax.swing.JPanel;

import gogether.Logic.Member;

public class RouteDrawer extends TimerTask{
	Member m = new Member();
	
	MapCanvas mapCanvas;
	
	public RouteDrawer(MapCanvas mapCanvas) {
		this.mapCanvas = mapCanvas;
		m.curx = 80;
		m.cury = 50;
		m.fa = mapCanvas.fa;
	}
	
	public void draw() {
//		if (newx == 700 && newy == 370) {
//			cancel();
//		}
		Graphics2D g2d=(Graphics2D) mapCanvas.getGraphics();
		g2d.setColor(Color.BLACK);
		m.w = 1;
		m.c1 = 1;
		m.c2 = 1;
		m.gbestx = 700;
		m.gbesty = 370;
		m.oldx = m.curx;
		m.oldy = m.cury;
		m.setPbestx();
		m.setPbesty();
		m.setGbestx();
		m.setGbesty();
		m.setNextLocation();
		m.setNewLocation();
//		System.out.println(mapCanvas.fa.leftupx + " " + mapCanvas.fa.leftupy + " " + mapCanvas.fa.rightdownx + " " + mapCanvas.fa.rightdowny);
		g2d.drawLine(m.curx, m.cury, m.newx, m.newy);
		m.moveToNewLocation();
		mapCanvas.validate();
	}

	@Override
	public void run() {
		draw();
	}
}
