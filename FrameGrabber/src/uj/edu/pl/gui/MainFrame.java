package uj.edu.pl.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class MainFrame extends JFrame {
	private JPanel pane;

	private JButton stop;
	private JButton preview;
	private JButton convert;
	private GridBagConstraints gBC;
	private GridBagLayout gBL;
	private JSlider slider1;
	private JLabel sliderLabel;
	private JLabel patchLabel;
	private JLabel infoLabel;
	private JLabel sliderInfoLabel;
	private ButtonGroup group;

	private JRadioButton typeOfSource;
	private JRadioButton typeOfPicture;
	private JRadioButton typeOfMovie;

	private JFileChooser patchChooser;

	private JPanel panelSlider;
	private JPanel panelRadioBox;
	private JPanel panelButtons;
	private JComboBox<String> comboBox;

	public MainFrame() {
		super("Frame Grabber");
		gBC = new GridBagConstraints();
		gBL = new GridBagLayout();
		setLayout(gBL);
		gBC.fill = GridBagConstraints.NONE;
		pane = new JPanel(gBL);

		this.SetButtons();
		this.SetSlider();
		this.addElementsToFrame();
		this.add(pane);
		Dimension dimension = new Dimension(810, 320);
		this.setSize(dimension);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void SetButtons(){
		panelButtons = new JPanel();
		this.panelButtons.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Jakiœ napis"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
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
		
		this.panelButtons.add(stop);
		this.panelButtons.add(preview);
		this.panelButtons.add(convert);
	}

	private void SetSlider() {
		this.panelSlider = new JPanel();
		this.panelSlider.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Jakiœ napis"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		slider1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);
		slider1.setPaintTrack(true);
		slider1.setMinimum(0);
		slider1.setMaximum(255);
		slider1.setMajorTickSpacing(10);
		slider1.setPaintTicks(true);
		slider1.setToolTipText("Here u can chose a value");

		// Add labes to slider
		Hashtable labelTable = new Hashtable();
		labelTable.put(new Integer(0), new JLabel("0"));
		labelTable.put(new Integer(255), new JLabel("255"));
		slider1.setLabelTable(labelTable);
		slider1.setPaintLabels(true);

		this.infoLabel = new JLabel("None");
		this.panelSlider.add(slider1);
		this.panelSlider.add(infoLabel);
	}

	private void SetRadioButtons() {

	}

	private void addElementsToFrame() {
		gBC.fill = GridBagConstraints.HORIZONTAL;
		gBC.gridx = 0;
		gBC.gridy = 0;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		this.pane.add(this.panelButtons, gBC);
		/*gBC.fill = GridBagConstraints.HORIZONTAL;
		gBC.gridx = 1;
		gBC.gridy = 0;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		this.pane.add(this.preview, gBC);
		gBC.gridx = 2;
		gBC.gridy = 0;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		this.pane.add(this.convert, gBC);*/
		gBC.gridx = 0;
		gBC.gridy = 1;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		this.pane.add(this.panelSlider, gBC);

	}
}