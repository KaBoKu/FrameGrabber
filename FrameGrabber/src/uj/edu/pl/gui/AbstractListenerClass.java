package uj.edu.pl.gui;

import java.awt.event.ActionListener;

public abstract class AbstractListenerClass implements ActionListener{
	private StateOfGUI sOG;
	private MainFrame mF;
	
	public AbstractListenerClass(StateOfGUI sOG, MainFrame mF){
		this.sOG = sOG;
		this.mF = mF;
	}
}
