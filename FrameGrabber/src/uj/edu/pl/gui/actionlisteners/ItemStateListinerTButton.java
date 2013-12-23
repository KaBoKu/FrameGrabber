package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.StateOfGUI;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class ItemStateListinerTButton implements ItemListener {
	protected StateOfGUI sOG;
	protected MonitorSOG mSOG;
	protected MainFrame mF;

	public ItemStateListinerTButton(MainFrame mF, MonitorSOG mSOG) {
		super();
		this.sOG = StateOfGUI.INSTANCE;
		this.mSOG = mSOG;
		this.mF = mF;
	}

	@Override
	public void itemStateChanged(ItemEvent ev) {
		// TODO Auto-generated method stub
		System.out.println("ItemEvent!");
		if (ev.getStateChange() == ItemEvent.SELECTED) {
			System.out.println("button is selected");
			sOG.setConvertButton(true);
			sOG.setStopButton(false);
			mSOG.write();
			mF.getFileChooserBut().setEnabled(false);
			mF.getPlayVideoC().setEnabled(false);
			mF.getNextC().setEnabled(false);
			mF.getPervC().setEnabled(false);
			mF.getStopVideoC().setEnabled(false);
			mF.getAviOutput().setEnabled(false);
			mF.getAviSource().setEnabled(false);
			mF.getBmpOutput().setEnabled(false);
			mF.getJpgSource().setEnabled(false);
			mF.getJpgOutput().setEnabled(false);
			mF.getCamSource().setEnabled(false);
			mF.getMpgOutput().setEnabled(false);
			mF.getGifOutput().setEnabled(false);
			mF.getRGBRadioButton().setEnabled(false);
			mF.getGammaRadioButton().setEnabled(false);
			mF.getPreview().setEnabled(false);
			//mF.getPlayVideo().setEnabled(false);
			//mF.getStopVideo().setEnabled(false);
			mF.getSlider1().setEnabled(false);
			mF.getSliderVideo().setEnabled(false);
		} else if (ev.getStateChange() == ItemEvent.DESELECTED) {
			System.out.println("button is not selected");
			sOG.setStopButton(true);
			sOG.setPreviewButton(false);
			sOG.setConvertButton(false);
			mSOG.write();

			mF.getFileChooserBut().setEnabled(true);
			mF.getPlayVideoC().setEnabled(true);
			mF.getNextC().setEnabled(true);
			mF.getPervC().setEnabled(true);
			mF.getStopVideoC().setEnabled(true);
			mF.getAviOutput().setEnabled(true);
			mF.getAviSource().setEnabled(true);
			mF.getBmpOutput().setEnabled(true);
			mF.getJpgSource().setEnabled(true);
			mF.getJpgOutput().setEnabled(true);
			mF.getCamSource().setEnabled(true);
			mF.getMpgOutput().setEnabled(true);
			mF.getGifOutput().setEnabled(true);
			mF.getRGBRadioButton().setEnabled(true);
			mF.getGammaRadioButton().setEnabled(true);
			mF.getPreview().setEnabled(true);
			//mF.getPlayVideo().setEnabled(true);
			//mF.getStopVideo().setEnabled(true);
			mF.getSlider1().setEnabled(true);
			mF.getSliderVideo().setEnabled(true);
		}
	}

}
