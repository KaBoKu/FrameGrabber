package uj.edu.pl.gui;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

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
				new MainFrame();
				//Czytanie stanu GUI
				Thread t = new Thread(new ThreadReadState());
				t.start();
			}
		});
	}
	

}

