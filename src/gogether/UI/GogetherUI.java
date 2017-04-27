package gogether.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import gogether.Logic.Member;
import gogether.Logic.MemberManager;
import net.java.dev.designgridlayout.DesignGridLayout;

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
		gp = new GlassPane(mainPanel, mainFrame, startButton, mlc);
		mainFrame.setGlassPane(gp);
		gp.setVisible(true);
		contentPane.add(mainPanel, BorderLayout.CENTER);
			
		
		mainFrame.setVisible(true);
	}
	
	private JPanel buttonPanel() {
		buttonPanel = new JPanel();
		startButton = new JButton("Start");
		addMember = new JButton("Add Member");
		DesignGridLayout pLayout = new DesignGridLayout(buttonPanel);
		pLayout.row().center().add(startButton, addMember);
		buttonPanel.setBackground(Color.gray);
		
		addMember.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame addWindow = new JFrame("Add Member");
				AddMemberCanvas amc = new AddMemberCanvas();
				addWindow.add(amc);
				addWindow.setSize(400, 250);
				addWindow.setVisible(true);
			}
			
		});
		
		return buttonPanel;
	}
	
	public static void main(String [] args) {
		GogetherUI gogUI = new GogetherUI();
	}
}
