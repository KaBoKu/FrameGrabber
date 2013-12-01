package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;

public class ActionLConvert extends AbstractListenerClass{

	public ActionLConvert(MainFrame mF) {
		super(mF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.sOG.setConvertButton(true);
		super.mF.getFileChooserBut().setEnabled(false);
		super.mF.getAviOutput().setEnabled(false);
		super.mF.getAviSource().setEnabled(false);
		super.mF.getBmpOutput().setEnabled(false);
		super.mF.getJpgSource().setEnabled(false);
		super.mF.getJpgOutput().setEnabled(false);
		super.mF.getCamSource().setEnabled(false);
		super.mF.getMpgOutput().setEnabled(false);
		super.mF.getRGBRadioButton().setEnabled(false);
		super.mF.getGammaRadioButton().setEnabled(false);
		super.mF.getPreview().setEnabled(false);
		
	}

}
