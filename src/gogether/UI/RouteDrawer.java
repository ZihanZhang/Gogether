package gogether.UI;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.util.TimerTask;

import javax.swing.JPanel;

public class RouteDrawer extends TimerTask{
	MapCanvas mapCanvas;
	int oldx = 80, oldy = 50, newx, newy;
	
	public RouteDrawer(MapCanvas mapCanvas) {
		this.mapCanvas = mapCanvas;
	}
	
	public void draw() {
		if (newx == 700 && newy == 370) {
			cancel();
		}
		Graphics2D g2d=(Graphics2D) mapCanvas.getGraphics();
		g2d.setColor(Color.BLACK);
		newx = oldx + 62;
		newy = oldy + 32;
		g2d.drawLine(oldx, oldy, newx, newy);
		oldx = newx;
		oldy = newy;
		mapCanvas.validate();
	}

	@Override
	public void run() {
		draw();
	}
}
