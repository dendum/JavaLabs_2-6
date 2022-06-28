package ua.lviv.iot.model;

public class Music {
	private String genre;
	private String songName;
	private String author;
	private double durationInMinutes;
	private double sizeInMb;

	public Music(final String genre, final String songName, final String author, final double durationInMinutes,
			final double sizeInMb) {
		this.genre = genre;
		this.songName = songName;
		this.author = author;
		this.durationInMinutes = durationInMinutes;
		this.sizeInMb = sizeInMb;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(final String genre) {
		this.genre = genre;
	}

	public String getName() {
		return songName;
	}

	public void setName(final String songName) {
		this.songName = songName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public double getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(final double durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public double getSizeInMb() {
		return sizeInMb;
	}

	public void setSizeInMb(final double sizeInMb) {
		this.sizeInMb = sizeInMb;
	}

	public String getHeaders() {
		return "genre,songName,author,durationInMinutes,sizeInMb";
	}

	public String toCSV() {
		return genre + "," + songName + "," + author + ","
         + durationInMinutes + "," + sizeInMb;
	}
}
