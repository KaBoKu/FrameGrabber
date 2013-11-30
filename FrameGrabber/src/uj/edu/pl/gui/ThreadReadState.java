package uj.edu.pl.gui;
//Klasa czytajaca singletona
public class ThreadReadState implements Runnable {

	//Klasa trzymajaca stan gui
	private StateOfGUI sOG;

	//Konstrutor pobierajacy singletona
	public ThreadReadState() {
		sOG = StateOfGUI.INSTANCE;
	}
	
	//Drukowanie 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(sOG.isStopButton());
		}
	}

}
