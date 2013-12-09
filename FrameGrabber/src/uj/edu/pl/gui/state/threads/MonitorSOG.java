package uj.edu.pl.gui.state.threads;

import uj.edu.pl.gui.StateOfGUI;

public class MonitorSOG {
	StateOfGUI sOG = StateOfGUI.INSTANCE;

	public void read() {
		synchronized (sOG) {
			try {
				System.out.println("R-E-A-D");
				sOG.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void write() {
			synchronized (sOG) {
				System.out.println("W-R-I-T-E");
				sOG.notifyAll();
			}
	}
}
