package ua.lviv.iot.writer;

import java.util.List;
import java.io.FileWriter;

import ua.lviv.iot.model.Music;

public class MusicWriter {
	public void writeToFile(final List<Music> list) {
		try (FileWriter writer = new FileWriter("result.csv")) {
			writer.write(list.get(0).getHeaders() + "\r\n");
			for (Music m: list) {
				writer.write(m.toCSV() + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
