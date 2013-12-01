package uj.edu.pl.gui;

import java.awt.event.ActionEvent;

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
