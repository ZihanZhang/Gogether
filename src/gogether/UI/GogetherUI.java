package gogether.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.java.dev.designgridlayout.DesignGridLayout;

public class GogetherUI {
	
	JFrame mainFrame = null;
	
	JPanel mainPanel = null;
	
	JPanel buttonPanel = null;
	
	JButton startButton = null;
	
	public GogetherUI() {
		mainFrame = new JFrame();
		mainFrame.setSize(800, 500);
		mainFrame.setTitle("Gogether");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setLayout(new BorderLayout());
		
		mainPanel = new MapCanvas();
		mainFrame.add(mainPanel, BorderLayout.CENTER);
		
		buttonPanel = buttonPanel();
		mainFrame.add(buttonPanel, BorderLayout.NORTH);
		
		mainFrame.setVisible(true);
	}
	
	private JPanel buttonPanel() {
		buttonPanel = new JPanel();
		startButton = new JButton("Start");
		DesignGridLayout pLayout = new DesignGridLayout(buttonPanel);
		pLayout.row().center().add(startButton);
		buttonPanel.setBackground(Color.gray);
		return buttonPanel;
	}
	
	public static void main(String [] args) {
		GogetherUI gogUI = new GogetherUI();
	}
}
