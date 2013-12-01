package uj.edu.pl.gui;

import java.awt.event.ActionEvent;

public class ActionLPlayVideo extends AbstractListenerClass{

	public ActionLPlayVideo(MainFrame mF) {
		super(mF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.sOG.setPlayVideoButton(true);
	}

}
