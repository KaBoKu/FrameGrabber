package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class ActionLStopVideo extends AbstractListenerClass{

	public ActionLStopVideo(MainFrame mF, MonitorSOG mSOG) {
		super(mF, mSOG);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent aE) {
		// TODO Auto-generated method stub
		super.sOG.setStopVideoButton(true);
		super.sOG.setPlayVideoButton(false);
		mSOG.write();
	}

}
