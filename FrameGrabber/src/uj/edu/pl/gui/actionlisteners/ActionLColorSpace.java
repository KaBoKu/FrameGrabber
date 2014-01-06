package uj.edu.pl.gui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class ActionLColorSpace extends AbstractListenerClass{

	public ActionLColorSpace(MainFrame mF, MonitorSOG mSOG) {
		super(mF, mSOG);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 JComboBox comboBox = (JComboBox) e.getSource();
		 
		 Object selected = comboBox.getSelectedItem();
         System.out.println("Selected Item  = " + selected);
         String command = e.getActionCommand();
         System.out.println("Action Command = " + command);
		 super.sOG.setoColorSpace((String)comboBox.getSelectedItem());
         mSOG.write();
	}
	
}
