package gogether.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GogetherUI {
	
	JFrame mainFrame = null;
	
	MapCanvas mainPanel = null;
	
	JPanel memberPanel = null;
	
	JPanel buttonPanel = null;
	
	JButton startButton = null;
	
	JButton addMember = null;
	
	MemberListCanvas mlc = null;
	
	GlassPane gp = null;
				
	
	public GogetherUI() {
		mainFrame = new JFrame();
		mainFrame.setSize(1270, 700);
		mainFrame.setTitle("Gogether");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = mainFrame.getContentPane();		
		contentPane.setLayout(new BorderLayout());
		
		buttonPanel = buttonPanel();
		contentPane.add(buttonPanel, BorderLayout.NORTH);
		
		mlc = new MemberListCanvas();
		JScrollPane listScroller = new JScrollPane(mlc,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(listScroller,  BorderLayout.WEST);
		
		mainPanel = new MapCanvas();
		gp = new GlassPane(mainPanel, mainFrame, startButton, addMember, mlc);
		mainFrame.setGlassPane(gp);
		gp.setVisible(true);
		contentPane.add(mainPanel, BorderLayout.CENTER);
			
		
		mainFrame.setVisible(true);
	}
	
	private JPanel buttonPanel() {
		buttonPanel = new JPanel();
		startButton = new JButton("Start");
		addMember = new JButton("Add Member");
		buttonPanel.add(startButton);
		buttonPanel.add(addMember);
		buttonPanel.setBackground(Color.gray);
		
		return buttonPanel;
	}
	
	public static void main(String [] args) {
		GogetherUI gogUI = new GogetherUI();
	}
}
