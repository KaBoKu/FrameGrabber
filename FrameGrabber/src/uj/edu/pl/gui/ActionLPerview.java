package uj.edu.pl.gui;

import java.awt.event.ActionEvent;

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
