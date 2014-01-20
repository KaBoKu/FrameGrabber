package uj.edu.pl.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Hashtable;
import java.util.regex.Matcher;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.Painter;
import javax.swing.UIDefaults;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import uj.edu.pl.gui.actionlisteners.ActionLColorSpace;
import uj.edu.pl.gui.actionlisteners.ActionLConvert;
import uj.edu.pl.gui.actionlisteners.ActionLGamma;
import uj.edu.pl.gui.actionlisteners.ActionLLogo;
import uj.edu.pl.gui.actionlisteners.ActionLPauseVideo;
import uj.edu.pl.gui.actionlisteners.ActionLPerview;
import uj.edu.pl.gui.actionlisteners.ActionLPlayVideo;
import uj.edu.pl.gui.actionlisteners.ActionLRGB;
import uj.edu.pl.gui.actionlisteners.ActionLSingleChannel;
import uj.edu.pl.gui.actionlisteners.ActionLStop;
import uj.edu.pl.gui.actionlisteners.ActionLStopVideo;
import uj.edu.pl.gui.actionlisteners.ActionLWindow;
import uj.edu.pl.gui.actionlisteners.ActionLaviOutput;
import uj.edu.pl.gui.actionlisteners.ActionLaviSource;
import uj.edu.pl.gui.actionlisteners.ActionLbmpOutput;
import uj.edu.pl.gui.actionlisteners.ActionLcamSource;
import uj.edu.pl.gui.actionlisteners.ActionLgifOutput;
import uj.edu.pl.gui.actionlisteners.ActionLjpgOutput;
import uj.edu.pl.gui.actionlisteners.ActionLjpgSource;
import uj.edu.pl.gui.actionlisteners.ActionLmpgOutput;
import uj.edu.pl.gui.actionlisteners.ItemStateListinerTButton;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class MainFrame extends JFrame {
	private JPanel pane;

	// Buttony do konwersji
	private JButton stop;
	private JButton preview;
	private JToggleButton convert;
	private JButton playVideoC;
	private JButton stopVideoC;
	private JButton nextC;
	private JButton pervC;
		
	// Buttony do plajera
	// Do wyrzucenia z powodu zmian w GUI
	private JButton playVideo;
	private JButton pauseVideo;
	private JButton stopVideo;
	
	private JSlider sliderVideo;
	private int percentSliderVideo;
	// Menu
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	// Layout
	private GridBagConstraints gBC;
	private GridBagLayout gBL;

	private JSlider slider1;
	private int valueOfRGBSlider;
	private int valueOfGammaSlider;
	private JLabel sliderLabel;
	private JLabel patchLabel;
	private JLabel infoLabel;
	private JLabel sliderInfoLabel;
	private JLabel statusLabel;
		
	//Napisy do panelMediaInfo
	private JLabel patchJLabel;
	private JLabel fotmat;
	private JLabel bitRate;
	private JLabel frameRate;
	private JLabel width;
	private JLabel height;
	private JLabel ratio;
	private JLabel audioBitrate;
	private JLabel duration;
	private JLabel channels;
	
	// RadioButtony do wyboru zrodla
	private JRadioButton aviSource;
	private JRadioButton jpgSource;
	private JRadioButton camSource;
	private ButtonGroup SourceRadioGroup;

	// Tym razem do outputu
	private ButtonGroup outputGroup;
	private JRadioButton gifOutput;
	private JRadioButton jpgOutput;
	private JRadioButton bmpOutput;
	private JRadioButton aviOutput;
	private JRadioButton mpgOutput;
	// RgbRadioButtons
	private JRadioButton RGBRadioButton;
	private JRadioButton gammaRadioButton;
	private ButtonGroup rgbButtonGroup;
	
	private JCheckBox singleChannelBox;
	private JCheckBox logoBox;
	private JComboBox<String> colorComboBox;

	// Wybor sciezki
	private JFileChooser patchChooser;
	private ExtensionFileFilter fileFilter;
	private JButton fileChooserBut;
	private JLabel filePatch;
	// Panele, ktore beda wrzucane do frame'a
	private JPanel panelSlider;
	private JPanel panelVideoControl;
	private JPanel panelRadioBoxPicture;
	private JPanel panelRadioBoxMovie;
	private JPanel panelRadioBoxSource;
	private JPanel panelOutput;
	private JPanel panelButtons;
	private JPanel panelFileChooser;
	private JPanel panelStatusBar;
	private JPanel panelMediaInfo;

	

	private String borderString;

	private StateOfGUI sOG;
	private MonitorSOG mSOG;
	
	public MainFrame(MonitorSOG mSOG) {
		super("Frame Grabber");
		sOG = StateOfGUI.INSTANCE;
		this.mSOG = mSOG;
		this.SetMenu();
		this.SetButtons();
		//this.SetVideoPlayer();
		this.SetRGBSlider();
		this.setFileChooser();
		this.SetRadioSource();
		this.SetOutput();
		this.SetStatusBar();
		this.addElementsToFrame();
		// this.add(pane);
		Dimension dimension = new Dimension(810, 450);
		this.setSize(dimension);
		this.setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new ActionLWindow(this, mSOG, this, 0));
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
		GridBagLayout layout = new GridBagLayout();
		panelButtons.setLayout(layout);
		GridBagConstraints gBC = new GridBagConstraints();
		
		this.panelButtons.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Set Mode"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		stop = new JButton("Stop");
		preview = new JButton("Perview");
		convert = new JToggleButton("Convert");
		
		playVideoC = new JButton("PlayC");
		stopVideoC = new JButton("StopC");
		nextC = new JButton("nextC");
		pervC = new JButton("pervC");
		// Tooltips set
		stop.setToolTipText("Press to stop");
		preview.setToolTipText("Press to perview");
		convert.setToolTipText("Press to start convert. It could take long time depends on ur PC");
		playVideoC.setToolTipText("Press to play");
		stopVideoC.setToolTipText("Press to stop or pause");
		nextC.setToolTipText("next frame");
		pervC.setToolTipText("pervieus frame");
		
		// Memonic set
		stop.setMnemonic(KeyEvent.VK_S);
		preview.setMnemonic(KeyEvent.VK_P);
		convert.setMnemonic(KeyEvent.VK_C);
		playVideoC.setMnemonic(KeyEvent.VK_K);
		stopVideoC.setMnemonic(KeyEvent.VK_I);
		nextC.setMnemonic(KeyEvent.VK_RIGHT);
		pervC.setMnemonic(KeyEvent.VK_LEFT);
		//Podpinamy listnenery
		stop.addActionListener(new ActionLStop(this, mSOG));
		preview.addActionListener(new ActionLPerview(this, mSOG));
		//convert.addActionListener(new ActionLConvert(this, mSOG));
		convert.addItemListener(new ItemStateListinerTButton(this,mSOG));
		stop.setFocusable(false);

		
		
		
		//Slider 
		// Klasa do moyfikowania JSlidera. Modyfikacja lokalna
				UIDefaults sliderDefaults = new UIDefaults();
				// Modyfikujemy slidera
				sliderDefaults.put("Slider.thumbWidth", 20);
				sliderDefaults.put("Slider.thumbHeight", 20);
				// Modyfikacja wygladu uchwytu
				sliderDefaults.put("Slider:SliderThumb.backgroundPainter",
						new Painter<JComponent>() {
							public void paint(Graphics2D g, JComponent c, int w, int h) {
								g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
										RenderingHints.VALUE_ANTIALIAS_ON);
								g.setStroke(new BasicStroke(2f));
								g.setColor(Color.RED);
								g.fillOval(1, 1, w - 3, h - 3);
								g.setColor(Color.WHITE);
								g.drawOval(1, 1, w - 3, h - 3);
							}
						});
				// Modyfikacja wygladu
				sliderDefaults.put("Slider:SliderTrack.backgroundPainter",
						new Painter<JComponent>() {
							public void paint(Graphics2D g, JComponent c, int w, int h) {
								g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
										RenderingHints.VALUE_ANTIALIAS_ON);
								g.setStroke(new BasicStroke(2f));
								g.setColor(Color.GRAY);
								g.fillRoundRect(0, 6, w - 1, 8, 8, 8);
								g.setColor(Color.WHITE);
								g.drawRoundRect(0, 6, w - 1, 8, 8, 8);
							}
						});
				sliderVideo = new JSlider();

				sliderVideo = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);
				sliderVideo.setPaintTrack(true);
				sliderVideo.setMinimum(0);
				sliderVideo.setMaximum(100);
				sliderVideo.setMajorTickSpacing(5);
				// sliderVideo.setPaintTicks(true);
				sliderVideo.setToolTipText("Here u can chose a value");
				sliderVideo.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						System.out.println("Slider2: " + sliderVideo.getValue());
						sOG.setSliderVideo(sliderVideo.getValue());
						sOG.setScroll((byte)sliderVideo.getValue());
						mSOG.write();
					}
				});

				Hashtable labelTable = new Hashtable();
				labelTable.put(new Integer(0), new JLabel("0"));
				labelTable.put(new Integer(100), new JLabel("100"));
				sliderVideo.setLabelTable(labelTable);
				sliderVideo.setPaintLabels(true);

				sliderVideo.putClientProperty("Nimbus.Overrides", sliderDefaults);
				sliderVideo
						.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
				
				//this.panelButtons.add(stop);
				gBC.gridx = 0;
				gBC.gridy = 0;
				this.panelButtons.add(preview,gBC);
				gBC.gridx = 1;
				gBC.gridy = 0;
				this.panelButtons.add(convert,gBC);
				gBC.gridx = 2;
				gBC.gridy = 0;
				this.panelButtons.add(playVideoC,gBC);
				gBC.gridx = 0;
				gBC.gridy = 1;
				this.panelButtons.add(stopVideoC,gBC);
				gBC.gridx = 1;
				gBC.gridy = 1;
				this.panelButtons.add(nextC,gBC);
				gBC.gridx = 2;
				gBC.gridy = 1;
				this.panelButtons.add(pervC,gBC);
				gBC.gridx = 0;
				gBC.gridy = 4;
				gBC.gridwidth = 3;
				gBC.gridheight = 2;
				this.panelButtons.add(sliderVideo,gBC);
	}

	/*private void SetVideoPlayer() {
		this.panelVideoControl = new JPanel();
		this.panelVideoControl.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Video Player"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		// Klasa do moyfikowania JSlidera. Modyfikacja lokalna
		UIDefaults sliderDefaults = new UIDefaults();
		// Modyfikujemy slidera
		sliderDefaults.put("Slider.thumbWidth", 20);
		sliderDefaults.put("Slider.thumbHeight", 20);
		// Modyfikacja wygladu uchwytu
		sliderDefaults.put("Slider:SliderThumb.backgroundPainter",
				new Painter<JComponent>() {
					public void paint(Graphics2D g, JComponent c, int w, int h) {
						g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						g.setStroke(new BasicStroke(2f));
						g.setColor(Color.RED);
						g.fillOval(1, 1, w - 3, h - 3);
						g.setColor(Color.WHITE);
						g.drawOval(1, 1, w - 3, h - 3);
					}
				});
		// Modyfikacja wygladu
		sliderDefaults.put("Slider:SliderTrack.backgroundPainter",
				new Painter<JComponent>() {
					public void paint(Graphics2D g, JComponent c, int w, int h) {
						g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						g.setStroke(new BasicStroke(2f));
						g.setColor(Color.GRAY);
						g.fillRoundRect(0, 6, w - 1, 8, 8, 8);
						g.setColor(Color.WHITE);
						g.drawRoundRect(0, 6, w - 1, 8, 8, 8);
					}
				});

		playVideo = new JButton("Play");
		playVideo.setToolTipText("Press to play video");
		pauseVideo = new JButton("Pause");
		pauseVideo.setToolTipText("Press to pasue");
		stopVideo = new JButton("Stop");
		stopVideo.setToolTipText("Press to stop");
		
		playVideo.addActionListener(new ActionLPlayVideo(this, mSOG));
		pauseVideo.addActionListener(new ActionLPauseVideo(this,mSOG));
		stopVideo.addActionListener(new ActionLStopVideo(this, mSOG));
		
		sliderVideo = new JSlider();

		sliderVideo = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);
		sliderVideo.setPaintTrack(true);
		sliderVideo.setMinimum(0);
		sliderVideo.setMaximum(100);
		sliderVideo.setMajorTickSpacing(5);
		// sliderVideo.setPaintTicks(true);
		sliderVideo.setToolTipText("Here u can chose a value");
		sliderVideo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println("Slider2: " + sliderVideo.getValue());
				sOG.setSliderVideo(sliderVideo.getValue());
				mSOG.write();
			}
		});

		Hashtable labelTable = new Hashtable();
		labelTable.put(new Integer(0), new JLabel("0"));
		labelTable.put(new Integer(100), new JLabel("100"));
		sliderVideo.setLabelTable(labelTable);
		sliderVideo.setPaintLabels(true);

		sliderVideo.putClientProperty("Nimbus.Overrides", sliderDefaults);
		sliderVideo
				.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

		this.panelVideoControl.add(sliderVideo);
		this.panelVideoControl.add(playVideo);
		this.panelVideoControl.add(stopVideo);

	}
*/
	private void SetRGBSlider() {
		this.panelSlider = new JPanel();
		this.panelSlider.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Jaki� napis"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		slider1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);
		slider1.setPaintTrack(true);
		slider1.setMinimum(0);
		slider1.setMaximum(255);
		slider1.setMajorTickSpacing(10);
		slider1.setPaintTicks(true);
		slider1.setToolTipText("Here u can chose a value");
		slider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (RGBRadioButton.isSelected()) {
					System.out.println("RGB: " + slider1.getValue());
					sOG.setRGBValue(slider1.getValue());
					mSOG.write();
				}
				if (gammaRadioButton.isSelected()) {
					System.out.println("Gamma: " + slider1.getValue());
					sOG.setGammaValue(slider1.getValue());
					mSOG.write();
				}
			}
		});
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
		
		this.RGBRadioButton.addActionListener(new ActionLRGB(this));
		/*this.RGBRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				slider1.setValue(sOG.getRGBValue());
			}
		});*/
		
		this.gammaRadioButton.addActionListener(new ActionLGamma(this));
		/*this.gammaRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				slider1.setValue(sOG.getGammaValue());
			}
		});*/
		String [] ComboBox = new String [3];
		ComboBox [0] ="RGB";
		ComboBox [1] ="CMYK";
		ComboBox [2]="HSB";
		this.logoBox = new JCheckBox("Logo");
		this.singleChannelBox = new JCheckBox("One Channel");
		
		this.colorComboBox = new JComboBox<String>(ComboBox);
		this.logoBox.addActionListener(new ActionLLogo(this,mSOG));
		this.singleChannelBox.addActionListener(new ActionLSingleChannel(this,mSOG));
		this.colorComboBox.addActionListener(new ActionLColorSpace(this, mSOG));
		
		this.infoLabel = new JLabel("None");
		this.panelSlider.add(slider1);
		this.panelSlider.add(infoLabel);
		this.panelSlider.add(RGBRadioButton);
		this.panelSlider.add(gammaRadioButton);
		this.panelSlider.add(singleChannelBox);
		this.panelSlider.add(logoBox);
		this.panelSlider.add(colorComboBox);
	}

	private void SetRadioSource() {
		this.panelRadioBoxSource = new JPanel();
		this.panelRadioBoxSource.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Set Source"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		this.aviSource = new JRadioButton("avi");
		this.camSource = new JRadioButton("Camera");
		this.jpgSource = new JRadioButton("Picture");
		
		this.aviSource.addActionListener(new ActionLaviSource(this, mSOG));
		this.camSource.addActionListener(new ActionLcamSource(this, mSOG));
		this.jpgSource.addActionListener(new ActionLjpgSource(this, mSOG));
		
		this.SourceRadioGroup = new ButtonGroup();
		this.SourceRadioGroup.add(aviSource);
		this.SourceRadioGroup.add(camSource);
		this.SourceRadioGroup.add(jpgSource);

		this.panelRadioBoxSource.add(aviSource);
		this.panelRadioBoxSource.add(camSource);
		this.panelRadioBoxSource.add(jpgSource);

	}

	private void SetOutput() {
		this.panelOutput = new JPanel();
		this.panelOutput.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Set Output"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		this.aviOutput = new JRadioButton("avi");
		this.mpgOutput = new JRadioButton("mpg");
		this.jpgOutput = new JRadioButton("jpg");
		this.gifOutput = new JRadioButton("gif");
		this.bmpOutput = new JRadioButton("bmp");
		
		this.aviOutput.addActionListener(new ActionLaviOutput(this, mSOG));
		this.mpgOutput.addActionListener(new ActionLmpgOutput(this, mSOG));
		this.jpgOutput.addActionListener(new ActionLjpgOutput(this, mSOG));
		this.gifOutput.addActionListener(new ActionLgifOutput(this, mSOG));
		this.bmpOutput.addActionListener(new ActionLbmpOutput(this, mSOG));

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
	
	private void setMediaInfo(){
		this.panelMediaInfo = new JPanel();
		this.panelMediaInfo.setLayout(new GridLayout(2,5));
		
		fotmat=new JLabel("format");
		patchJLabel=new JLabel("patch");
		width=new JLabel("width");
		height=new JLabel("height");
		ratio=new JLabel("ratio");
		frameRate=new JLabel("frameRate");
		bitRate=new JLabel("bitRate");
		audioBitrate=new JLabel("audioBitRate");
		channels=new JLabel("channels");
		duration=new JLabel("duration");
		
		panelMediaInfo.add(patchJLabel);
		panelMediaInfo.add(fotmat);
		panelMediaInfo.add(width);
		panelMediaInfo.add(height);
		panelMediaInfo.add(ratio);
		panelMediaInfo.add(frameRate);
		panelMediaInfo.add(bitRate);
		panelMediaInfo.add(audioBitrate);
		panelMediaInfo.add(channels);
		panelMediaInfo.add(duration);
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
		Pattern p;
		Matcher m;
		fileChooserBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				// TODO Auto-generated method stub
				patchChooser = new JFileChooser();
				fileFilter= new ExtensionFileFilter("avi, mpg,jpg,gif,bmp",new String []{"AVI","MPG","JPG","BMP","GIF","JPEG"});
				patchChooser.setFileFilter(fileFilter);
				patchChooser
						.setFileSelectionMode(JFileChooser.FILES_ONLY);
				patchChooser.setDialogTitle("Choose a file");
				int returnValue = patchChooser.showOpenDialog(null);
				if (returnValue == patchChooser.APPROVE_OPTION) {
					File selectedFile = patchChooser.getSelectedFile();
					System.out.println(selectedFile.getName());
				}
				
				if (patchChooser.getSelectedFile().getAbsolutePath()!=null){
					String filePatchString = patchChooser.getSelectedFile().getAbsolutePath(); 
					if(filePatchString.matches(".+\\.(jpg|bmp|gif)$"))System.out.println("file graphic");
					if(filePatchString.matches(".+\\.(avi|mpg)$"))System.out.println("file movie");;
					System.out.println("NIemanullla");
				filePatch.setText(patchChooser.getSelectedFile().getAbsolutePath());
				
				
				
				borderString = patchChooser.getSelectedFile().getAbsolutePath();
				}
				panelFileChooser.setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createTitledBorder(borderString),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));

				sOG.setPatchFile(patchChooser.getSelectedFile()
						.getAbsolutePath());
				sOG.setiFileName(patchChooser.getSelectedFile()
						.getAbsolutePath());
				mSOG.write();
			}

		});

		this.panelFileChooser.add(this.fileChooserBut);
		this.panelFileChooser.add(this.filePatch);

	}

	
	private void SetStatusBar(){
		this.panelStatusBar = new JPanel();
		panelStatusBar.setLayout(new BorderLayout(2,2));
		statusLabel = new JLabel();
		statusLabel.setBorder(BorderFactory.createLoweredBevelBorder());
		statusLabel.setForeground(Color.black);
		panelStatusBar.add(BorderLayout.CENTER,statusLabel);
		
		/*class StatusBar extends JPanel
		{
		private JLabel statusLabel;
		public StatusBar()
		{
		setLayout(new BorderLayout(2, 2));
		statusLabel = new JLabel("Ready");
		statusLabel.setBorder(BorderFactory.createLoweredBevelBorder());
		statusLabel.setForeground(Color.black);
		add(BorderLayout.CENTER, statusLabel);
		JLabel dummyLabel = new JLabel(" ");
		dummyLabel.setBorder(BorderFactory.createLoweredBevelBorder());
		add(BorderLayout.EAST, dummyLabel);
		}
		public void setStatus(String status)
		{
		if (status.equals(""))
		statusLabel.setText("Ready");
		else
		statusLabel.setText(status);
		}
		public String getStatus()
		{
		return statusLabel.getText();
		}
		}*/
		
	}
	
	private void addElementsToFrame() {
		// Metoda dodaj�ca przygotowana wczesniej elementy
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
		//this.pane.add(this.panelVideoControl, gBC);
		
		gBC.gridx = 1;
		gBC.gridy = 3;
		gBC.ipadx = 30;
		gBC.ipady = 10;
		gBC.anchor = GridBagConstraints.WEST;
		this.pane.add(this.panelStatusBar, gBC);
		
		this.add(pane);

		this.setJMenuBar(this.menuBar);

	}

	public JToggleButton getConvert() {
		return convert;
	}

	public void setConvert(JToggleButton convert) {
		this.convert = convert;
	}

	public JRadioButton getAviSource() {
		return aviSource;
	}

	public void setAviSource(JRadioButton aviSource) {
		this.aviSource = aviSource;
	}

	public JRadioButton getJpgSource() {
		return jpgSource;
	}

	public void setJpgSource(JRadioButton jpgSource) {
		this.jpgSource = jpgSource;
	}

	public JRadioButton getCamSource() {
		return camSource;
	}

	public void setCamSource(JRadioButton camSource) {
		this.camSource = camSource;
	}

	public JRadioButton getGifOutput() {
		return gifOutput;
	}

	public void setGifOutput(JRadioButton gifOutput) {
		this.gifOutput = gifOutput;
	}

	public JRadioButton getJpgOutput() {
		return jpgOutput;
	}

	public void setJpgOutput(JRadioButton jpgOutput) {
		this.jpgOutput = jpgOutput;
	}

	public JRadioButton getBmpOutput() {
		return bmpOutput;
	}

	public void setBmpOutput(JRadioButton bmpOutput) {
		this.bmpOutput = bmpOutput;
	}

	public JRadioButton getAviOutput() {
		return aviOutput;
	}

	public void setAviOutput(JRadioButton aviOutput) {
		this.aviOutput = aviOutput;
	}

	public JRadioButton getMpgOutput() {
		return mpgOutput;
	}

	public void setMpgOutput(JRadioButton mpgOutput) {
		this.mpgOutput = mpgOutput;
	}

	public JRadioButton getRGBRadioButton() {
		return RGBRadioButton;
	}

	public void setRGBRadioButton(JRadioButton rGBRadioButton) {
		RGBRadioButton = rGBRadioButton;
	}

	public JRadioButton getGammaRadioButton() {
		return gammaRadioButton;
	}

	public void setGammaRadioButton(JRadioButton gammaRadioButton) {
		this.gammaRadioButton = gammaRadioButton;
	}

	public JButton getFileChooserBut() {
		return fileChooserBut;
	}

	public void setFileChooserBut(JButton fileChooserBut) {
		this.fileChooserBut = fileChooserBut;
	}
	
	public JButton getPreview() {
		return preview;
	}

	public void setPreview(JButton preview) {
		this.preview = preview;
	}

	public JSlider getSliderVideo() {
		return sliderVideo;
	}

	public void setSliderVideo(JSlider sliderVideo) {
		this.sliderVideo = sliderVideo;
	}

	public JButton getPlayVideo() {
		return playVideo;
	}

	public void setPlayVideo(JButton playVideo) {
		this.playVideo = playVideo;
	}

	public JButton getStopVideo() {
		return stopVideo;
	}

	public void setStopVideo(JButton stopVideo) {
		this.stopVideo = stopVideo;
	}

	public JSlider getSlider1() {
		return slider1;
	}

	public void setSlider1(JSlider slider1) {
		this.slider1 = slider1;
	}
	
	
	public JButton getPlayVideoC() {
		return playVideoC;
	}

	public void setPlayVideoC(JButton playVideoC) {
		this.playVideoC = playVideoC;
	}

	public JButton getStopVideoC() {
		return stopVideoC;
	}

	public void setStopVideoC(JButton stopVideoC) {
		this.stopVideoC = stopVideoC;
	}

	public JButton getNextC() {
		return nextC;
	}

	public void setNextC(JButton nextC) {
		this.nextC = nextC;
	}

	public JButton getPervC() {
		return pervC;
	}

	public void setPervC(JButton pervC) {
		this.pervC = pervC;
	}
	
}