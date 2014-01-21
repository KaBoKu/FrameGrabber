package uj.edu.pl.imageinfo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageInfo {

	private int width;
	private int height;
	private String filename;

	public ImageInfo(String filename) {
		super();
		// TODO Auto-generated constructor stub
		this.filename = filename;
		BufferedImage bimg;
		try {
			bimg = ImageIO.read(new File(this.filename));
			width = bimg.getWidth();
			height = bimg.getHeight();
			System.out.println(bimg.getPropertyNames());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
