package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class ActionLbmpOutput extends AbstractListenerClass{

	public ActionLbmpOutput(MainFrame mF, MonitorSOG mSOG) {
		super(mF, mSOG);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.sOG.setGifOutputRadio(false);
		super.sOG.setBmpOutputRadio(true);
		super.sOG.setJpgOutputRadio(false);
		super.sOG.setAviOutputRadio(false);
		super.sOG.setMpgOutputRadio(false);
		mSOG.write();
	}

}
