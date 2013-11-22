package uj.edu.pl.gui;


import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private JButton stop;
	private JButton preview;
	private JButton convert;
	public MainFrame() {
		super("Frame Grabber");
		
		Dimension dimension = new Dimension(810, 320);
		this.setSize(dimension);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
