package uj.edu.pl.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame {
	private JPanel pane;

	private JButton stop;
	private JButton preview;
	private JButton convert;

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;

	private GridBagConstraints gBC;
	private GridBagLayout gBL;

	private JSlider slider1;
	private JLabel sliderLabel;
	private JLabel patchLabel;
	private JLabel infoLabel;
	private JLabel sliderInfoLabel;

	private ButtonGroup group;
	private JRadioButton aviSource;
	private JRadioButton jpgSource;
	private JRadioButton camSource;
	private ButtonGroup SourceRadioGroup;

	private JFileChooser patchChooser;
	private JButton fileChooserBut;
	private JLabel filePatch;

	private JPanel panelSlider;
	private JPanel panelRadioBoxPicture;
	private JPanel panelRadioBoxMovie;
	private JPanel panelRadioBoxSource;
	private JPanel panelButtons;
	private JPanel panelFileChooser;
	private JComboBox<String> comboBox;
	
	private String borderString; 

	public MainFrame() {
		super("Frame Grabber");
		
		this.SetButtons();
		this.SetSlider();
		this.setFileChooser();
		this.SetRadioSource();
		this.addElementsToFrame();
		//this.add(pane);
		Dimension dimension = new Dimension(810, 320);
		this.setSize(dimension);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void SetButtons() {
		panelButtons = new JPanel();
		this.panelButtons.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Jakiœ napis"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		stop = new JButton("Stop");
		preview = new JButton("Perview");
		convert = new JButton("Convert");

		// Tooltips set
		stop.setToolTipText("Press to stop");
		preview.setToolTipText("Press to perview");
		convert.setToolTipText("Press to start convert. It could take long time depends on ur PC");

		// Memonic set
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

	private void SetRadioSource() {
		this.panelRadioBoxSource = new JPanel();
		this.panelRadioBoxSource.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Jakiœ napis"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		this.aviSource = new JRadioButton("avi");
		this.camSource = new JRadioButton("Camera");
		this.jpgSource = new JRadioButton("Picture");

		this.SourceRadioGroup = new ButtonGroup();
		this.SourceRadioGroup.add(aviSource);
		this.SourceRadioGroup.add(camSource);
		this.SourceRadioGroup.add(jpgSource);

		this.panelRadioBoxSource.add(aviSource);
		this.panelRadioBoxSource.add(camSource);
		this.panelRadioBoxSource.add(jpgSource);

	}

	private void setFileChooser() {
		this.panelFileChooser = new JPanel();
	    borderString = "None";
		this.panelFileChooser.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(borderString),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		//TitledBorder tb;
		//this.panelFileChooser.repaint();
		fileChooserBut = new JButton("Chosee file");
		filePatch = new JLabel("None");
		filePatch.setToolTipText("Patch to source");
		
		fileChooserBut.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ev) {
				// TODO Auto-generated method stub
				patchChooser = new JFileChooser();
				patchChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				patchChooser.setDialogTitle("Choose a file");
				 int returnValue = patchChooser.showOpenDialog(null);
			        if (returnValue == patchChooser.APPROVE_OPTION) {
			          File selectedFile = patchChooser.getSelectedFile();
			          System.out.println(selectedFile.getName());
			        }
			   filePatch.setText(patchChooser.getSelectedFile().getAbsolutePath());
			   borderString = patchChooser.getSelectedFile().getAbsolutePath();
			   panelFileChooser.setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(borderString),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
			}
			
		});
		
		this.panelFileChooser.add(this.fileChooserBut);
		this.panelFileChooser.add(this.filePatch);
		      

	}

	private void addElementsToFrame() {
		//Metoda dodaj¹ca przygotowana wczesniej elementy
		gBC = new GridBagConstraints();
		gBL = new GridBagLayout();
		setLayout(gBL);
		gBC.fill = GridBagConstraints.NONE;
		this.pane = new JPanel(gBL);
		
		
		gBC.fill = GridBagConstraints.HORIZONTAL;
		gBC.gridx = 0;
		gBC.gridy = 0;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		this.pane.add(this.panelButtons, gBC);
		gBC.fill = GridBagConstraints.HORIZONTAL;
		gBC.gridx = 1;
		gBC.gridy = 0;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		this.pane.add(this.panelRadioBoxSource, gBC);

		gBC.gridx = 2;
		gBC.gridy = 0;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		//this.pane.add(this.fileChooserBut, gBC);

		gBC.gridx = 0;
		gBC.gridy = 1;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		this.pane.add(this.panelSlider, gBC);
		
		gBC.gridx = 0;
		gBC.gridy = 2;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		this.pane.add(this.panelFileChooser, gBC);
		
		this.add(pane);

	}
}