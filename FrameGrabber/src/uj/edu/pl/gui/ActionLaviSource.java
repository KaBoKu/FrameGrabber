package uj.edu.pl.gui;

import java.awt.event.ActionEvent;

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
