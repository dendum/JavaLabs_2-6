package ua.lviv.iot.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MusicTest {

	@Test
	void testGetHeaders() {
		Music m = new Music("rock", "Back_In_Black", "AC/DC", 12.5, 10);
		assertEquals("genre,songName,author,durationInMinutes,sizeInMb", m.getHeaders());
	}

	@Test
	void testToCSV() {
		Music m = new Music("rock", "Back_In_Black", "AC/DC", 12.5, 10);
		assertEquals("rock,Back_In_Black,AC/DC,12.5,10.0", m.toCSV());
	}

}
