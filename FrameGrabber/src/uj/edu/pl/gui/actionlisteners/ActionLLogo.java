package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class ActionLLogo extends AbstractListenerClass{

	public ActionLLogo(MainFrame mF, MonitorSOG mSOG) {
		super(mF, mSOG);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    AbstractButton abstractButton = (AbstractButton) e.getSource();
	    boolean selected = abstractButton.getModel().isSelected();
		if (selected) sOG.setoLogo(true);
		else sOG.setoLogo(false);
		
		mSOG.write();
	}

}
