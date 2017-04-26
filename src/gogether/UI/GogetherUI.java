package gogether.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import gogether.Logic.Member;
import net.java.dev.designgridlayout.DesignGridLayout;

public class GogetherUI {
	
	JFrame mainFrame = null;
	
	MapCanvas mainPanel = null;
	
	JPanel memberPanel = null;
	
	JList memberList = null;
	
	JPanel buttonPanel = null;
	
	JButton startButton = null;
	
	JButton addMember = null;
	
	Member[] mbs = new Member[50];
	
	private Timer timer = new Timer();
	
	public GogetherUI() {
		mainFrame = new JFrame();
		mainFrame.setSize(1270, 700);
		mainFrame.setTitle("Gogether");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setLayout(new BorderLayout());
		
		mainPanel = new MapCanvas();
		mainFrame.add(mainPanel, BorderLayout.CENTER);
		
		buttonPanel = buttonPanel();
		mainFrame.add(buttonPanel, BorderLayout.NORTH);
		
		Member m1 = new Member(1100, 600, 80, 50);
		Member m2 = new Member(1100, 600, 80, 50);
		mbs[0] = m1;
		mbs[1] = m2;
		memberList = new JList(mbs);
		JScrollPane listScroller = new JScrollPane(memberList);
		mainFrame.add(listScroller,  BorderLayout.WEST);
		
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
		
		startButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 15; i++) {
					timer.schedule(new RouteDrawer(mainPanel, 0), 0L, 100L);		
				}		
				for (int i = 0; i < 15; i++) {
					timer.schedule(new RouteDrawer(mainPanel, 1), 0L, 100L);
				}
			}			
		});
		
		return buttonPanel;
	}
	
	public static void main(String [] args) {
		GogetherUI gogUI = new GogetherUI();
	}
}
