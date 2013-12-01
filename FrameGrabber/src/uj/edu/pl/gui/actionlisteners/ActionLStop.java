package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;

public class ActionLStop extends AbstractListenerClass{

	public ActionLStop(MainFrame mF) {
		super(mF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (!super.sOG.isStopButton()) {
			sOG.setStopButton(true);
			sOG.setPreviewButton(false);
			sOG.setConvertButton(false);
			
			
			super.mF.getFileChooserBut().setEnabled(true);
			super.mF.getAviOutput().setEnabled(true);
			super.mF.getAviSource().setEnabled(true);
			super.mF.getBmpOutput().setEnabled(true);
			super.mF.getJpgSource().setEnabled(true);
			super.mF.getJpgOutput().setEnabled(true);
			super.mF.getCamSource().setEnabled(true);
			super.mF.getMpgOutput().setEnabled(true);
			super.mF.getGifOutput().setEnabled(true);
			super.mF.getRGBRadioButton().setEnabled(true);
			super.mF.getGammaRadioButton().setEnabled(true);
			super.mF.getPreview().setEnabled(true);
			super.mF.getPlayVideo().setEnabled(true);
			super.mF.getStopVideo().setEnabled(true);
			super.mF.getSlider1().setEnabled(true);
			super.mF.getSliderVideo().setEnabled(true);
		}
		
	}

}
