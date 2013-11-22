package uj.edu.pl.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class MainFrame extends JFrame {
	private JButton stop;
	private JButton preview;
	private JButton convert;
	private GridBagConstraints gBC;
	private GridBagLayout gBL;
	private JSlider slider1;
	private JLabel sliderLabel;
	private JLabel patchLabel;
	private JLabel infoLabel;
	
	
	private JRadioButton typeOfSource;
	private JRadioButton typeOfPicture;
	private JRadioButton typeOfMovie;
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
