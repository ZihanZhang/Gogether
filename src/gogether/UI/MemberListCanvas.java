package gogether.UI;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class MemberListCanvas extends JPanel{
	
	public HashMap<String, Component> components = new HashMap<String, Component>();
	
	public int num = 0;
	
	GridLayout gl = new GridLayout(0, 1);
	
	public MemberListCanvas() {
		this.setLayout(gl);
		this.add(new JLabel("Member     X     Y    "));
	}
	
	public void putComponentByName(String name, Component c) {
		components.put(name, c);
	}
	
	public Component getComponentByName(String name) {
		return components.get(name);
	}

}
