package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;

public class ActionLStopVideo extends AbstractListenerClass{

	public ActionLStopVideo(MainFrame mF) {
		super(mF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent aE) {
		// TODO Auto-generated method stub
		super.sOG.setStopVideoButton(true);
		super.sOG.setPlayVideoButton(false);
	}

}
