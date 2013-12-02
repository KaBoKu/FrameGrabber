package uj.edu.pl.gui;

public enum StateOfGUI {
	INSTANCE;
	boolean stopButton;
	boolean previewButton;
	boolean convertButton;
	
	boolean playVideoButton;
	boolean stopVideoButton;
	int sliderVideo;//Wartosc procentowa
	
	boolean aviSourceRadio;
	boolean jpgSourceRadio;
	boolean camSourceRadio;
	
	boolean gifOutputRadio;
	boolean jpgOutputRadio;
	boolean bmpOutputRadio;
	boolean aviOutputRadio;
	boolean mpgOutputRadio;
	
	
	int RGBValue;
	int gammaValue;
	
	String patchFile;

	
	
	public boolean isStopButton() {
		return stopButton;
	}

	public void setStopButton(boolean stopButton) {
		this.stopButton = stopButton;
	}

	public boolean isPreviewButton() {
		return previewButton;
	}

	public void setPreviewButton(boolean previewButton) {
		this.previewButton = previewButton;
	}

	public boolean isConvertButton() {
		return convertButton;
	}

	public void setConvertButton(boolean convertButton) {
		this.convertButton = convertButton;
	}

	public boolean isPlayVideoButton() {
		return playVideoButton;
	}

	public void setPlayVideoButton(boolean playVideoButton) {
		this.playVideoButton = playVideoButton;
	}

	public boolean isStopVideoButton() {
		return stopVideoButton;
	}

	public void setStopVideoButton(boolean stopVideoButton) {
		this.stopVideoButton = stopVideoButton;
	}

	public int getSliderVideo() {
		return sliderVideo;
	}

	public void setSliderVideo(int sliderVideo) {
		this.sliderVideo = sliderVideo;
	}

	public boolean isAviSourceRadio() {
		return aviSourceRadio;
	}

	public void setAviSourceRadio(boolean aviSourceRadio) {
		this.aviSourceRadio = aviSourceRadio;
	}

	public boolean isJpgSourceRadio() {
		return jpgSourceRadio;
	}

	public void setJpgSourceRadio(boolean jpgSourceRadio) {
		this.jpgSourceRadio = jpgSourceRadio;
	}

	public boolean isCamSourceRadio() {
		return camSourceRadio;
	}

	public void setCamSourceRadio(boolean camSourceRadio) {
		this.camSourceRadio = camSourceRadio;
	}

	public boolean isGifOutputRadio() {
		return gifOutputRadio;
	}

	public void setGifOutputRadio(boolean gifOutputRadio) {
		this.gifOutputRadio = gifOutputRadio;
	}

	public boolean isJpgOutputRadio() {
		return jpgOutputRadio;
	}

	public void setJpgOutputRadio(boolean jpgOutputRadio) {
		this.jpgOutputRadio = jpgOutputRadio;
	}

	public boolean isBmpOutputRadio() {
		return bmpOutputRadio;
	}

	public void setBmpOutputRadio(boolean bmpOutputRadio) {
		this.bmpOutputRadio = bmpOutputRadio;
	}

	public boolean isAviOutputRadio() {
		return aviOutputRadio;
	}

	public void setAviOutputRadio(boolean aviOutputRadio) {
		this.aviOutputRadio = aviOutputRadio;
	}

	public boolean isMpgOutputRadio() {
		return mpgOutputRadio;
	}

	public void setMpgOutputRadio(boolean mpgOutputRadio) {
		this.mpgOutputRadio = mpgOutputRadio;
	}

	public int getRGBValue() {
		return RGBValue;
	}

	public void setRGBValue(int rGBValue) {
		RGBValue = rGBValue;
	}

	public int getGammaValue() {
		return gammaValue;
	}

	public void setGammaValue(int gammaValue) {
		this.gammaValue = gammaValue;
	}

	public String getPatchFile() {
		return patchFile;
	}

	public void setPatchFile(String patchFile) {
		this.patchFile = patchFile;
	}

	@Override
	public String toString() {
		return "StateOfGUI [stopButton=" + stopButton + ", previewButton="
				+ previewButton + ", convertButton=" + convertButton
				+ ", playVideoButton=" + playVideoButton + ", stopVideoButton="
				+ stopVideoButton + ", sliderVideo=" + sliderVideo
				+ ", aviSourceRadio=" + aviSourceRadio + ", jpgSourceRadio="
				+ jpgSourceRadio + ", camSourceRadio=" + camSourceRadio
				+ ", gifOutputRadio=" + gifOutputRadio + ", jpgOutputRadio="
				+ jpgOutputRadio + ", bmpOutputRadio=" + bmpOutputRadio
				+ ", aviOutputRadio=" + aviOutputRadio + ", mpgOutputRadio="
				+ mpgOutputRadio + ", RGBValue=" + RGBValue + ", gammaValue="
				+ gammaValue + ", patchFile=" + patchFile + "]";
	}	
}
