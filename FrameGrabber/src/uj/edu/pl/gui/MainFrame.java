package uj.edu.pl.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
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
	private ButtonGroup group;
	
	private JRadioButton typeOfSource;
	private JRadioButton typeOfPicture;
	private JRadioButton typeOfMovie;
	public MainFrame() {
		super("Frame Grabber");
		gBC = new GridBagConstraints();
		gBL = new GridBagLayout();
		setLayout(gBL);
		gBC.fill = GridBagConstraints.NONE;
		Dimension dimension = new Dimension(810, 320);
		this.setSize(dimension);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void SetButtons(){
		stop = new JButton("Stop");
		preview = new JButton("Perview");
		convert = new JButton("Convert");
		
		//Tooltips set
		stop.setToolTipText("Press to stop");
		preview.setToolTipText("Press to perview");
		convert.setToolTipText("Press to start convert. It could take long time depends on ur PC");
		
		//Memonic set
		stop.setMnemonic(KeyEvent.VK_S);
		preview.setMnemonic(KeyEvent.VK_P);
		convert.setMnemonic(KeyEvent.VK_C);
	}
	
	private void SetSlider(){
		
	}
	
	private void SetRadioButtons(){
		
	}
}
