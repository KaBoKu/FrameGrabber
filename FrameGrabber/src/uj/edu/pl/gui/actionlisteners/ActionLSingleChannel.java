package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class ActionLSingleChannel extends AbstractListenerClass{

	public ActionLSingleChannel(MainFrame mF, MonitorSOG mSOG) {
		super(mF, mSOG);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton abstractButton = (AbstractButton) e.getSource();
	    boolean selected = abstractButton.getModel().isSelected();
		if (selected) sOG.setoGreyscale(true);
		else sOG.setoGreyscale(false);
		
		mSOG.write();
		
	}

}
