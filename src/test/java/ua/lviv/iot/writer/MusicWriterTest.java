package ua.lviv.iot.writer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.model.Music;

class MusicWriterTest {

	@Test
	void testWriteToFile() {
		MusicWriter mw = new MusicWriter();
		List<Music> lst = new LinkedList<>();
		lst.add(new Music("rock", "Back_In_Black", "AC/DC", 12.5, 10));
		lst.add(new Music("rap", "PAID_MY_DUES", "NF", 10, 110));
		lst.add(new Music("rock", "Nothing_Else_Matters", "Metallica", 13, 20));
		lst.add(new Music("trap", "Lights_Off", "We_Are_Domi", 9, 2));
		lst.add(new Music("rock", "Smells_Like_Teen_Spirit", "Nirvana", 8, 20));
		mw.writeToFile(lst);
		try(
			var expectedFR = new FileReader("expected.csv");
			var expectedBR = new BufferedReader(expectedFR);
			var actualFR = new FileReader("result.csv");
			var actualBR = new BufferedReader(actualFR)
			){
			assertEquals(expectedBR.readLine(), actualBR.readLine());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
