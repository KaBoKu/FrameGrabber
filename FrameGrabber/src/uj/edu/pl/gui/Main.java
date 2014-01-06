package uj.edu.pl.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import uj.edu.pl.gui.state.threads.MonitorSOG;
import uj.edu.pl.gui.state.threads.ReaderSOG;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(laf.getName())){
                        try {
                            UIManager.setLookAndFeel(laf.getClassName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
				MonitorSOG mSOG = new MonitorSOG();
				ThreadReadState tRS = new ThreadReadState();
				MainFrame mainFrame = new MainFrame(mSOG);
				
			
				
				
				//Czytanie stanu GUI
				ReaderSOG rSOG = new ReaderSOG(mSOG);
				Thread t = new Thread(rSOG);
				t.start();
				
				
			}
		});
	}
	

}

