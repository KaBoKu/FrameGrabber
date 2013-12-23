package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class ActionLaviSource extends AbstractListenerClass{

	public ActionLaviSource(MainFrame mF, MonitorSOG mSOG) {
		super(mF, mSOG);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.sOG.setAviSourceRadio(true);
		super.sOG.setCamSourceRadio(false);
		super.sOG.setJpgSourceRadio(false);
		
		super.sOG.setiImageFile(false);
		super.sOG.setiVideoFile(true);
		super.sOG.setiWebCamera(false);
		
		mSOG.write();
	}

}
