package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class ActionLPerview extends AbstractListenerClass{

	public ActionLPerview(MainFrame mF, MonitorSOG mSOG) {
		super(mF, mSOG);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent eV) {
		// TODO Auto-generated method stub
		super.sOG.setPreviewButton(true);
		mSOG.write();
	}

}
