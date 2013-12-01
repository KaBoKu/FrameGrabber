package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;

public class ActionLaviSource extends AbstractListenerClass{

	public ActionLaviSource(MainFrame mF) {
		super(mF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.sOG.setAviSourceRadio(true);
		super.sOG.setCamSourceRadio(false);
		super.sOG.setJpgSourceRadio(false);
	}

}
