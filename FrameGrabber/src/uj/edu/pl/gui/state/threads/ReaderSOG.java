package uj.edu.pl.gui.state.threads;

public class ReaderSOG implements Runnable{
	MonitorSOG mSOG;
	public ReaderSOG(MonitorSOG mSOG) {
		// TODO Auto-generated constructor stub
		this.mSOG = mSOG;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		mSOG.read();
	}

}
