package uj.edu.pl.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.Painter;
import javax.swing.UIDefaults;

public class MainFrame extends JFrame {
	private JPanel pane;
	
	//Buttony do konwersji
	private JButton stop;
	private JButton preview;
	private JButton convert;
	//Buttony do plajera
	private JButton playVideo;
	private JButton stopVideo;
	private JSlider sliderVideo;
	//Menu
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	//Leyout
	private GridBagConstraints gBC;
	private GridBagLayout gBL;

	private JSlider slider1;
	private JLabel sliderLabel;
	private JLabel patchLabel;
	private JLabel infoLabel;
	private JLabel sliderInfoLabel;
	
	//RadioButtony do wyboru zrodla
	private JRadioButton aviSource;
	private JRadioButton jpgSource;
	private JRadioButton camSource;
	private ButtonGroup SourceRadioGroup;
	
	//Tym razem do outputu
	private ButtonGroup outputGroup;
	private JRadioButton gifOutput;
	private JRadioButton jpgOutput;
	private JRadioButton bmpOutput;
	private JRadioButton aviOutput;
	private JRadioButton mpgOutput;
	//RgbRadioButtons
	private JRadioButton RGBRadioButton;
	private JRadioButton gammaRadioButton;
	
	private ButtonGroup rgbButtonGroup;
	
	//Wybor sciezki
	private JFileChooser patchChooser;
	private JButton fileChooserBut;
	private JLabel filePatch;
	//Panele, ktore beda wrzucane do frame'a
	private JPanel panelSlider;
	private JPanel panelVideoControl;
	private JPanel panelRadioBoxPicture;
	private JPanel panelRadioBoxMovie;
	private JPanel panelRadioBoxSource;
	private JPanel panelOutput;
	private JPanel panelButtons;
	private JPanel panelFileChooser;
	private JPanel panelStatusBar;
	
	private JComboBox<String> comboBox;

	private String borderString;

	public MainFrame() {
		super("Frame Grabber");
		
		this.SetMenu();
		this.SetButtons();
		this.SetVideoPlayer();
		this.SetRGBSlider();
		this.setFileChooser();
		this.SetRadioSource();
		this.SetOutput();
		this.addElementsToFrame();
		// this.add(pane);
		Dimension dimension = new Dimension(810, 450);
		this.setSize(dimension);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	private void SetMenu() {
		this.menuBar = new JMenuBar();
		this.menu = new JMenu("Info");
		this.menu.setMnemonic(KeyEvent.VK_I);
		this.menuBar.add(this.menu);
	}

	private void SetButtons() {
		panelButtons = new JPanel();
		this.panelButtons.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Set Mode"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		stop = new JButton("Stop");
		preview = new JButton("Perview");
		convert = new JButton("Convert");
		
		stop.addActionListener(new ActionLStop(this));
		
		// Tooltips set
		stop.setToolTipText("Press to stop");
		preview.setToolTipText("Press to perview");
		convert.setToolTipText("Press to start convert. It could take long time depends on ur PC");

		// Memonic set
		stop.setMnemonic(KeyEvent.VK_S);
		preview.setMnemonic(KeyEvent.VK_P);
		convert.setMnemonic(KeyEvent.VK_C);
			
		stop.setFocusable(false);
		
		this.panelButtons.add(stop);
		this.panelButtons.add(preview);
		this.panelButtons.add(convert);
	}
	private void SetVideoPlayer(){
		this.panelVideoControl = new JPanel();
		this.panelVideoControl.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Video Player"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		//Klasa do moyfikowania JSlidera. Modyfikacja lokalna
		UIDefaults sliderDefaults = new UIDefaults();
		//Modyfikujemy slidera
		sliderDefaults.put("Slider.thumbWidth", 20);
        sliderDefaults.put("Slider.thumbHeight", 20);
        //Modyfikacja wygladu uchwytu
        sliderDefaults.put("Slider:SliderThumb.backgroundPainter", new Painter<JComponent>() {
            public void paint(Graphics2D g, JComponent c, int w, int h) {
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setStroke(new BasicStroke(2f));
                g.setColor(Color.RED);
                g.fillOval(1, 1, w-3, h-3);
                g.setColor(Color.WHITE);
                g.drawOval(1, 1, w-3, h-3);
            }
        });
		//Modyfikacja wygladu
        sliderDefaults.put("Slider:SliderTrack.backgroundPainter", new Painter<JComponent>() {
            public void paint(Graphics2D g, JComponent c, int w, int h) {
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.setStroke(new BasicStroke(2f));
                g.setColor(Color.GRAY);
                g.fillRoundRect(0, 6, w-1, 8, 8, 8);
                g.setColor(Color.WHITE);
                g.drawRoundRect(0, 6, w-1, 8, 8, 8);
            }
        });
		
		playVideo = new JButton("Play");
		playVideo.setToolTipText("Press to play video");
		stopVideo = new JButton("Stop");
		stopVideo.setToolTipText("Press to stop");
		sliderVideo = new JSlider();
		
		sliderVideo = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);
		sliderVideo.setPaintTrack(true);
		sliderVideo.setMinimum(0);
		sliderVideo.setMaximum(100);
		sliderVideo.setMajorTickSpacing(5);
		//sliderVideo.setPaintTicks(true);
		sliderVideo.setToolTipText("Here u can chose a value");
		
		Hashtable labelTable = new Hashtable();
		labelTable.put(new Integer(0), new JLabel("0"));
		labelTable.put(new Integer(100), new JLabel("100"));
		sliderVideo.setLabelTable(labelTable);
		sliderVideo.setPaintLabels(true);
		
		sliderVideo.putClientProperty("Nimbus.Overrides",sliderDefaults);
        sliderVideo.putClientProperty("Nimbus.Overrides.InheritDefaults",false);
		
        this.panelVideoControl.add(sliderVideo);
        this.panelVideoControl.add(playVideo);
		this.panelVideoControl.add(stopVideo);
		
	}
	private void SetRGBSlider() {
		this.panelSlider = new JPanel();
		this.panelSlider.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Jakiœ½ napis"),
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

		this.RGBRadioButton = new JRadioButton("RGB");
		this.gammaRadioButton = new JRadioButton("Gamma");
		this.rgbButtonGroup = new ButtonGroup();
		this.rgbButtonGroup.add(RGBRadioButton);
		this.rgbButtonGroup.add(gammaRadioButton);
		

		this.infoLabel = new JLabel("None");
		this.panelSlider.add(slider1);
		this.panelSlider.add(infoLabel);
		this.panelSlider.add(RGBRadioButton);
		this.panelSlider.add(gammaRadioButton);
	}

	private void SetRadioSource() {
		this.panelRadioBoxSource = new JPanel();
		this.panelRadioBoxSource.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Set Source"),
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
	private void SetOutput(){
		this.panelOutput = new JPanel();
		this.panelOutput.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Set Output"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		this.aviOutput = new JRadioButton("avi");
		this.mpgOutput = new JRadioButton("mpg");
		this.jpgOutput = new JRadioButton("jpg");
		this.gifOutput = new JRadioButton("gif");
		this.bmpOutput = new JRadioButton("bmp");
		
		this.outputGroup = new ButtonGroup();
		this.outputGroup.add(aviOutput);
		this.outputGroup.add(mpgOutput);
		this.outputGroup.add(bmpOutput);
		this.outputGroup.add(jpgOutput);
		this.outputGroup.add(gifOutput);
		
		this.panelOutput.add(aviOutput);
		this.panelOutput.add(mpgOutput);
		this.panelOutput.add(bmpOutput);
		this.panelOutput.add(jpgOutput);
		this.panelOutput.add(gifOutput);
		
	}
	private void setFileChooser() {
		this.panelFileChooser = new JPanel();
		borderString = "Set file or patch";
		this.panelFileChooser.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(borderString),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		// TitledBorder tb;
		// this.panelFileChooser.repaint();
		fileChooserBut = new JButton("Chosee file");
		filePatch = new JLabel("None");
		filePatch.setToolTipText("Patch to source");

		fileChooserBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				// TODO Auto-generated method stub
				patchChooser = new JFileChooser();
				patchChooser
						.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				patchChooser.setDialogTitle("Choose a file");
				int returnValue = patchChooser.showOpenDialog(null);
				if (returnValue == patchChooser.APPROVE_OPTION) {
					File selectedFile = patchChooser.getSelectedFile();
					System.out.println(selectedFile.getName());
				}
				filePatch.setText(patchChooser.getSelectedFile()
						.getAbsolutePath());
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
		// Metoda dodajï¿½ca przygotowana wczesniej elementy
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
		// this.pane.add(this.fileChooserBut, gBC);

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
		
		gBC.gridx = 1;
		gBC.gridy = 1;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		this.pane.add(this.panelOutput, gBC);
		
		gBC.gridx = 1;
		gBC.gridy = 2;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		this.pane.add(this.panelVideoControl, gBC);
		
		this.add(pane);
		
		this.setJMenuBar(this.menuBar);

	}
}