package uj.edu.pl.gui;

import java.awt.event.ActionEvent;

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
