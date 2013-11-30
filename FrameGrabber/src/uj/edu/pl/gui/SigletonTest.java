package uj.edu.pl.gui;

public enum SigletonTest {
	INSTANCE;
	boolean inin;
	String kk;
	int ininin;
	public boolean isInin() {
		return inin;
	}
	public void setInin(boolean inin) {
		this.inin = inin;
	}
	public String getKk() {
		return kk;
	}
	public void setKk(String kk) {
		this.kk = kk;
	}
	public int getIninin() {
		return ininin;
	}
	public void setIninin(int ininin) {
		this.ininin = ininin;
	}
}
