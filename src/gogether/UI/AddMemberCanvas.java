package gogether.UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.*;

public class AddMemberCanvas extends JPanel{
	JSlider preference = new JSlider(JSlider.HORIZONTAL, 0, 30, 15);
	MapCanvas mapCanvas;
	MemberListCanvas mlc;
	RouteDrawer rd;
	
	public AddMemberCanvas(MapCanvas mapCanvas, MemberListCanvas mlc, JFrame addWindow) {
		preference.addChangeListener(null);
		preference.setMajorTickSpacing(10);
		preference.setPaintTicks(true);
		
		Font font = new Font("Serif", Font.ITALIC, 15);
		preference.setFont(font);
		
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer( 0 ), new JLabel("Comfortable") );
		labelTable.put( new Integer( 30 ), new JLabel("Fast") );
		preference.setLabelTable( labelTable );
		
		preference.setPaintLabels(true);

		this.setLayout(new BorderLayout());

		JTextField jf = new JTextField("Please input Name");
		this.add(jf, BorderLayout.NORTH);

		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int pre;
				if (preference.getValue() <= 15) {
					pre = 1;
				}
				else {
					pre = 0;
				}

				String name = jf.getText();
				rd = new RouteDrawer(mapCanvas, pre, mlc);
				rd.m.name = name;
				addWindow.setVisible(false);
				addWindow.dispose();
			}
		});
		this.add(submit, BorderLayout.SOUTH);

		this.add(preference, BorderLayout.CENTER);
	}
}
