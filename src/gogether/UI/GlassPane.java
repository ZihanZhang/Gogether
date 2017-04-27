package gogether.UI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class GlassPane extends JComponent{
	@Override
    protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
        g.fillRect(0, 0, 200, 200);
    }
}
