package uj.edu.pl.mediainfo;

import com.sun.jna.Platform;


public class MediaInfoException extends RuntimeException {
	
	public MediaInfoException(LinkageError e) {
		this(String.format("Unable to load %d-bit native library 'mediainfo'", Platform.isWindows()? 64 : 32), e);
	}
	

	public MediaInfoException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
