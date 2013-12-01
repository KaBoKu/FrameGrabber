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
		}
		
	}

}
