package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;

public class ActionLgifOutput extends AbstractListenerClass{

	public ActionLgifOutput(MainFrame mF) {
		super(mF, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.sOG.setGifOutputRadio(true);
		super.sOG.setBmpOutputRadio(false);
		super.sOG.setJpgOutputRadio(false);
		super.sOG.setAviOutputRadio(false);
		super.sOG.setMpgOutputRadio(false);
	}

}
