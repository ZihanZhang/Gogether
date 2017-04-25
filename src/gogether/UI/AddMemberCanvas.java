package gogether.UI;

import java.awt.Font;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class AddMemberCanvas extends JPanel{
	JSlider preference = new JSlider(JSlider.HORIZONTAL, 0, 30, 15);
	
	public AddMemberCanvas() {
		preference.addChangeListener(null);
		preference.setMajorTickSpacing(10);
		preference.setPaintTicks(true);
		
		Font font = new Font("Serif", Font.ITALIC, 15);
		preference.setFont(font);
		
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer( 0 ), new JLabel("Stop") );
		labelTable.put( new Integer( 30 ), new JLabel("Fast") );
		preference.setLabelTable( labelTable );
		
		preference.setPaintLabels(true);

		this.add(preference);
	}
}
