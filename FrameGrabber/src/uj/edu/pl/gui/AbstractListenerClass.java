package uj.edu.pl.gui;

import java.awt.event.ActionListener;

//Klasa abstrakcyja dla actionlistnenerow
public abstract class AbstractListenerClass implements ActionListener{
	protected StateOfGUI sOG;
	protected MainFrame mF;
	
	public AbstractListenerClass(MainFrame mF){
		this.sOG = StateOfGUI.INSTANCE;
		this.mF = mF;
	}
}
