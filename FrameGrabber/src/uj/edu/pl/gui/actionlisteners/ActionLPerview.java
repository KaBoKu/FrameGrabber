package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;

public class ActionLPerview extends AbstractListenerClass{

	public ActionLPerview(MainFrame mF) {
		super(mF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent eV) {
		// TODO Auto-generated method stub
		super.sOG.setPreviewButton(true);
	}

}
