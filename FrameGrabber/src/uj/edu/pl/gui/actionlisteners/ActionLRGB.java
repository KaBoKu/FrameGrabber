package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import uj.edu.pl.gui.MainFrame;

public class ActionLRGB extends AbstractListenerClass{

	public ActionLRGB(MainFrame mF) {
		super(mF, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.mF.getSlider1().setValue(sOG.getRGBValue());
	}

}
