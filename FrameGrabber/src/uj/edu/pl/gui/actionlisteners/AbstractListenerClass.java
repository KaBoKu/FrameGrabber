package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionListener;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.StateOfGUI;

//Klasa abstrakcyja dla actionlistnenerow
public abstract class AbstractListenerClass implements ActionListener{
	protected StateOfGUI sOG;
	protected MainFrame mF;
	
	public AbstractListenerClass(MainFrame mF){
		this.sOG = StateOfGUI.INSTANCE;
		this.mF = mF;
	}
}
