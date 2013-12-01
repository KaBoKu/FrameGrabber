package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;

public class ActionLjpgSource extends AbstractListenerClass{

	public ActionLjpgSource(MainFrame mF) {
		super(mF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.sOG.setAviSourceRadio(false);
		super.sOG.setCamSourceRadio(false);
		super.sOG.setJpgSourceRadio(true);
	}

}
