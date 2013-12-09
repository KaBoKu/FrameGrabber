package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class ActionLjpgSource extends AbstractListenerClass{

	public ActionLjpgSource(MainFrame mF, MonitorSOG mSOG) {
		super(mF, mSOG);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.sOG.setAviSourceRadio(false);
		super.sOG.setCamSourceRadio(false);
		super.sOG.setJpgSourceRadio(true);
		mSOG.write();
	}

}
