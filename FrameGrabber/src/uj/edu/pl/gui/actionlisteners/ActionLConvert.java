package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class ActionLConvert extends AbstractListenerClass{

	public ActionLConvert(MainFrame mF, MonitorSOG mSOG) {
		super(mF, mSOG);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.sOG.setConvertButton(true);
		super.sOG.setStopButton(false);
		super.mSOG.write();
		super.mF.getFileChooserBut().setEnabled(false);
		super.mF.getAviOutput().setEnabled(false);
		super.mF.getAviSource().setEnabled(false);
		super.mF.getBmpOutput().setEnabled(false);
		super.mF.getJpgSource().setEnabled(false);
		super.mF.getJpgOutput().setEnabled(false);
		super.mF.getCamSource().setEnabled(false);
		super.mF.getMpgOutput().setEnabled(false);
		super.mF.getGifOutput().setEnabled(false);
		super.mF.getRGBRadioButton().setEnabled(false);
		super.mF.getGammaRadioButton().setEnabled(false);
		super.mF.getPreview().setEnabled(false);
		super.mF.getPlayVideo().setEnabled(false);
		super.mF.getStopVideo().setEnabled(false);
		super.mF.getSlider1().setEnabled(false);
		super.mF.getSliderVideo().setEnabled(false);
	}

}
