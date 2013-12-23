package uj.edu.pl.gui;

public enum StateOfGUI {
	INSTANCE;
	boolean stopButton;
	boolean previewButton;
	boolean convertButton;
	
	boolean playVideoButton;
	boolean pauseVideoButton;
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
	
	
	
	//Rodzaj przetwarzania
	private boolean preview;      // Podgl¶d
	private boolean convert;      // Konwersja, powt°rne przyciùni‡cie przerywa.

	//Kontrolki podgl¶du
	private boolean start;
	private boolean pause;
	private boolean stop;         // Zatrzymanie
	private boolean next;
	private boolean previous;
	private boolean first;
	private boolean last;
	private byte    scroll; //(moøe float? 0.0 do 1.0)

	//∆r°d-o / wejùcie
	private boolean iVideoFile;   // Plik filmowy                    OK
	private boolean iImageFile;   // Pliki graficzne                 OK
	private boolean iWebCamera;   // Kamera internetowa              OK
	private String  iFileName;    // Nazwa pliku filmowego lub pierwszego z plik°w graficznych
	                              // np. moj_film-012340.gif
	//Informacje o wejùciu
	private long    iNumAllFrames;   // Od wybranej do koΩca (pg) lub wszystkich (pf)
	private double  iFrameRate;   // Dla pf

	//Parametry wejùcia u¨yte do generacji wyjùcia (wyb°r suwakiem r°wnie¨!)
	private long    iStartTime;   // Przedzia- czasowy - pocz¶tek    OK
	private long    iDuration;    // Przedzia- czasowy - do obl. koΩca OK
	private long    iStartFrame;  // Klatka pocz¶tkowa - pf, wzgl. pierwszej - pg, 0 - k,
	private long    iNumFrames;   // Iloùä klatek
	                           // Dodaä suwak prezentuj¶cy wyb°r u¨ytkownika
	//Parametry wyjùcia
	//Typ wyjùcia
	private boolean oVideoFile;   // jw.                             OK
	private boolean oImageFile;   // jw.                             OK
	private String  oFileName;    // Pierwszy z pg lub ca-y pf

	//Iloùä i cz‡stotliwoùä klatek
	private long    oNumFrames;   // Iloùä kadr°w/pg wyjùciowych     OK
	private double  oFrameRate;   // Cz‡stotliwoùä kadr°w pf

	//Format
	private String  oImageFormat; // Format pg wyjùciowych
	private String  oVideoFormat; // Fromat pf wyjùciowego

	//Przekszta-cenia obrazu
	private String  oColorSpace;  // PrzestrzeΩ kolor°w              OK
	private byte    oGaussFilter; // Filtracja Gaussa                OK
	private byte    oBrightness;  // Jasnoùä                         OK
	private boolean oGreyscale;   // Obraz jednokana-owy             OK
	private boolean oLogo;        // Dodaä logo lub nie              OK

	private boolean stopApp; // flaga informujπca o wy≥πczeniu jednego z okienek (a wiÍc rÛwnieø zatrzymaniu ca≥ej aplikacji).
	                                  // ustawiasz, kiedy wciúniesz krzyøyk w okienku Windowsowym.
	
	/*
	//Rodzaj przetwarzania
	private boolean preview;      // Podgl¶d
	private boolean convert;      // Konwersja, powt°rne przyciùni‡cie przerywa.

	//Kontrolki podgl¶du
	private boolean start;
	private boolean pause;
	private boolean stop;         // Zatrzymanie
	private boolean next;
	private boolean previous;
	private boolean first;
	private boolean last;
	private byte    scroll; (moøe float? 0.0 do 1.0)

	//∆r°d-o / wejùcie
	private boolean iVideoFile;   // Plik filmowy                    OK
	private boolean iImageFile;   // Pliki graficzne                 OK
	private boolean iWebCamera;   // Kamera internetowa              OK
	private String  iFileName;    // Nazwa pliku filmowego lub pierwszego z plik°w graficznych
	                              // np. moj_film-012340.gif
	//Informacje o wejùciu
	private long    iNumAllFrames;   // Od wybranej do koΩca (pg) lub wszystkich (pf)
	private double  iFrameRate;   // Dla pf

	//Parametry wejùcia u¨yte do generacji wyjùcia (wyb°r suwakiem r°wnie¨!)
	private long    iStartTime;   // Przedzia- czasowy - pocz¶tek    OK
	private long    iDuration;    // Przedzia- czasowy - do obl. koΩca OK
	private long    iStartFrame;  // Klatka pocz¶tkowa - pf, wzgl. pierwszej - pg, 0 - k,
	private long    iNumFrames;   // Iloùä klatek
	                           // Dodaä suwak prezentuj¶cy wyb°r u¨ytkownika
	//Parametry wyjùcia
	//Typ wyjùcia
	private boolean oVideoFile;   // jw.                             OK
	private boolean oImageFile;   // jw.                             OK
	private String  oFileName;    // Pierwszy z pg lub ca-y pf

	//Iloùä i cz‡stotliwoùä klatek
	private long    oNumFrames;   // Iloùä kadr°w/pg wyjùciowych     OK
	private double  oFrameRate;   // Cz‡stotliwoùä kadr°w pf

	//Format
	private String  oImageFormat; // Format pg wyjùciowych
	private String  oVideoFormat; // Fromat pf wyjùciowego

	//Przekszta-cenia obrazu
	private String  oColorSpace;  // PrzestrzeΩ kolor°w              OK
	private byte    oGaussFilter; // Filtracja Gaussa                OK
	private byte    oBrightness;  // Jasnoùä                         OK
	private boolean oGreyscale;   // Obraz jednokana-owy             OK
	private boolean oLogo;        // Dodaä logo lub nie              OK

	private boolean stopApp; // flaga informujπca o wy≥πczeniu jednego z okienek (a wiÍc rÛwnieø zatrzymaniu ca≥ej aplikacji).
	                                  // ustawiasz, kiedy wciúniesz krzyøyk w okienku Windowsowym.
	*/
	
	
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
	
	public boolean isPauseVideoButton() {
		return pauseVideoButton;
	}

	public void setPauseVideoButton(boolean pauseVideoButton) {
		this.pauseVideoButton = pauseVideoButton;
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

	public boolean isPreview() {
		return preview;
	}

	public void setPreview(boolean preview) {
		this.preview = preview;
	}

	public boolean isConvert() {
		return convert;
	}

	public void setConvert(boolean convert) {
		this.convert = convert;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrevious() {
		return previous;
	}

	public void setPrevious(boolean previous) {
		this.previous = previous;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public byte getScroll() {
		return scroll;
	}

	public void setScroll(byte scroll) {
		this.scroll = scroll;
	}

	public boolean isiVideoFile() {
		return iVideoFile;
	}

	public void setiVideoFile(boolean iVideoFile) {
		this.iVideoFile = iVideoFile;
	}

	public boolean isiImageFile() {
		return iImageFile;
	}

	public void setiImageFile(boolean iImageFile) {
		this.iImageFile = iImageFile;
	}

	public boolean isiWebCamera() {
		return iWebCamera;
	}

	public void setiWebCamera(boolean iWebCamera) {
		this.iWebCamera = iWebCamera;
	}

	public String getiFileName() {
		return iFileName;
	}

	public void setiFileName(String iFileName) {
		this.iFileName = iFileName;
	}

	public long getiNumAllFrames() {
		return iNumAllFrames;
	}

	public void setiNumAllFrames(long iNumAllFrames) {
		this.iNumAllFrames = iNumAllFrames;
	}

	public double getiFrameRate() {
		return iFrameRate;
	}

	public void setiFrameRate(double iFrameRate) {
		this.iFrameRate = iFrameRate;
	}

	public long getiStartTime() {
		return iStartTime;
	}

	public void setiStartTime(long iStartTime) {
		this.iStartTime = iStartTime;
	}

	public long getiDuration() {
		return iDuration;
	}

	public void setiDuration(long iDuration) {
		this.iDuration = iDuration;
	}

	public long getiStartFrame() {
		return iStartFrame;
	}

	public void setiStartFrame(long iStartFrame) {
		this.iStartFrame = iStartFrame;
	}

	public long getiNumFrames() {
		return iNumFrames;
	}

	public void setiNumFrames(long iNumFrames) {
		this.iNumFrames = iNumFrames;
	}

	public boolean isoVideoFile() {
		return oVideoFile;
	}

	public void setoVideoFile(boolean oVideoFile) {
		this.oVideoFile = oVideoFile;
	}

	public boolean isoImageFile() {
		return oImageFile;
	}

	public void setoImageFile(boolean oImageFile) {
		this.oImageFile = oImageFile;
	}

	public String getoFileName() {
		return oFileName;
	}

	public void setoFileName(String oFileName) {
		this.oFileName = oFileName;
	}

	public long getoNumFrames() {
		return oNumFrames;
	}

	public void setoNumFrames(long oNumFrames) {
		this.oNumFrames = oNumFrames;
	}

	public double getoFrameRate() {
		return oFrameRate;
	}

	public void setoFrameRate(double oFrameRate) {
		this.oFrameRate = oFrameRate;
	}

	public String getoImageFormat() {
		return oImageFormat;
	}

	public void setoImageFormat(String oImageFormat) {
		this.oImageFormat = oImageFormat;
	}

	public String getoVideoFormat() {
		return oVideoFormat;
	}

	public void setoVideoFormat(String oVideoFormat) {
		this.oVideoFormat = oVideoFormat;
	}

	public String getoColorSpace() {
		return oColorSpace;
	}

	public void setoColorSpace(String oColorSpace) {
		this.oColorSpace = oColorSpace;
	}

	public byte getoGaussFilter() {
		return oGaussFilter;
	}

	public void setoGaussFilter(byte oGaussFilter) {
		this.oGaussFilter = oGaussFilter;
	}

	public byte getoBrightness() {
		return oBrightness;
	}

	public void setoBrightness(byte oBrightness) {
		this.oBrightness = oBrightness;
	}

	public boolean isoGreyscale() {
		return oGreyscale;
	}

	public void setoGreyscale(boolean oGreyscale) {
		this.oGreyscale = oGreyscale;
	}

	public boolean isoLogo() {
		return oLogo;
	}

	public void setoLogo(boolean oLogo) {
		this.oLogo = oLogo;
	}

	public boolean isStopApp() {
		return stopApp;
	}

	public void setStopApp(boolean stopApp) {
		this.stopApp = stopApp;
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
