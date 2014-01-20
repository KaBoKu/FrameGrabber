package uj.edu.pl.mediainfo;

import java.awt.print.Printable;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class Media {
	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */

	public void run() throws UnsupportedEncodingException {
		String url0 = getClass()
				.getResource("/Lenda Murray.mp4").getPath();
		if (url0.startsWith("/", 0))
			url0 = url0.replaceFirst("/", "");
		url0 = URLDecoder.decode(url0, "UTF-8");

		System.out.println(url0);
		String fileName = url0;
		File file = new File(fileName);
		MediaInfo info = new MediaInfo();
		info.open(file);
		int i = 0;
		String format = info.get(MediaInfo.StreamKind.Video, i, "Format",
				MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
		String bitRate = info.get(MediaInfo.StreamKind.Video, i, "BitRate",
				MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
		String frameRate = info.get(MediaInfo.StreamKind.Video, i, "FrameRate",
				MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
		String width = info.get(MediaInfo.StreamKind.Video, i, "Width",
				MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);

		String audioBitrate = info.get(MediaInfo.StreamKind.Audio, i,
				"BitRate", MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
		String audioChannels = info.get(MediaInfo.StreamKind.Audio, i,
				"Channels", MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
		String height = info.get(MediaInfo.StreamKind.Video, i, "Height",
				MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);

		String codec = info.get(MediaInfo.StreamKind.Video, i, "Codec",
				MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
		String ratio = info.get(MediaInfo.StreamKind.Video, i,
				"AspectRatio/String", MediaInfo.InfoKind.Text,
				MediaInfo.InfoKind.Name);
		String duration = info.get(MediaInfo.StreamKind.Video, i, "Duration",
				MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);

		System.out.println(format);
		System.out.println(bitRate);
		System.out.println(frameRate);
		System.out.println(width);
		System.out.println(height);
		System.out.println(codec);
		System.out.println(ratio);
		System.out.println(audioBitrate);
		System.out.println(Integer.parseInt(duration) / 60.0);

	}
}

public class Main {
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		new Media().run();

	}

}
