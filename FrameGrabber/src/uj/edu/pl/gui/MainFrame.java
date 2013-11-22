package uj.edu.pl.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private JButton stop;
	private JButton preview;
	private JButton convert;
	private GridBagConstraints gBC;
	private GridBagLayout gBL;

	public MainFrame() {
		super("Frame Grabber");
		gBC = new GridBagConstraints();
		gBL = new GridBagLayout();
		Dimension dimension = new Dimension(810, 320);
		this.setSize(dimension);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
