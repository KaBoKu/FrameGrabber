package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionListener;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.StateOfGUI;
import uj.edu.pl.gui.state.threads.MonitorSOG;

//Klasa abstrakcyja dla actionlistnenerow
public abstract class AbstractListenerClass implements ActionListener{
	protected StateOfGUI sOG;
	protected MonitorSOG mSOG;
	protected MainFrame mF;
	
	public AbstractListenerClass(MainFrame mF, MonitorSOG mSOG){
		this.sOG = StateOfGUI.INSTANCE;
		this.mSOG = mSOG;
		this.mF = mF;
	}
}
