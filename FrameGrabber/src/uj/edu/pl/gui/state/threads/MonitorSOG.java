package uj.edu.pl.gui.state.threads;

import uj.edu.pl.gui.StateOfGUI;

public class MonitorSOG {
	StateOfGUI sOG = StateOfGUI.INSTANCE;
	boolean wasSignalled = false;

	public void read() {
		synchronized (sOG) {
			while (!wasSignalled) {
				try {
					System.out.println("R-E-A-D");
					sOG.wait();
					System.out.println("READ DONE");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				wasSignalled = false;
			}
		}
	}

	public void write() {
		synchronized (sOG) {
			System.out.println("W-R-I-T-E");
			wasSignalled = true;
			sOG.notify();
		}
	}
}
