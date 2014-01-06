package uj.edu.pl.gui.actionlisteners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sun.awt.WindowClosingListener;
import uj.edu.pl.gui.MainFrame;
import uj.edu.pl.gui.StateOfGUI;
import uj.edu.pl.gui.state.threads.MonitorSOG;

public class ActionLWindow extends WindowEvent implements WindowListener{
	protected StateOfGUI sOG;
	protected MonitorSOG mSOG;
	protected MainFrame mF;
	public ActionLWindow(MainFrame mF, MonitorSOG mSOG,Window source, int id) {
		super(source, id);
		//super(mF, mSOG);
		// TODO Auto-generated constructor stub
		this.sOG = StateOfGUI.INSTANCE;
		this.mSOG = mSOG;
		this.mF = mF;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent e) {
		System.out.println("Closing");
		int option = JOptionPane.showConfirmDialog(mF.getRootPane(), "Do you want to exit the application?",
				"Exit Application", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
			// if user commits closing the application simply exits without
			// disposing the frame
			System.out.println("assa");
			sOG.setStopApp(true);
			System.exit(0);
			} else if (option == JOptionPane.NO_OPTION) {
			// in case user cancels the closing the application disposes the
			// frame and calls windowClosed() which starts the frame again
			System.out.println("NIEEE");
			mF.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			} else {
			// if he closes the window we do nothing
			System.out.println("Coœ innego");
			mF.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		mSOG.write();
		}
	
		

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
