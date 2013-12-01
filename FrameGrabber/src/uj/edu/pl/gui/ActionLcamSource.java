package uj.edu.pl.gui;

import java.awt.event.ActionEvent;

public class ActionLcamSource extends AbstractListenerClass{

	public ActionLcamSource(MainFrame mF) {
		super(mF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.sOG.setAviSourceRadio(false);
		super.sOG.setCamSourceRadio(true);
		super.sOG.setJpgSourceRadio(false);
	}

}
