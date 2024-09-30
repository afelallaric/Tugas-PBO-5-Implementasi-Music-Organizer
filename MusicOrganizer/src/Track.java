public class Track {
    private final String artist;
    private final String title;
    private final String filename;

    public Track(String artist, String title, String filename) {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
    }

    public String getDetails() {
        return artist + " - " + title;
    }

    public String getFilename() {
        return filename;
    }
}

