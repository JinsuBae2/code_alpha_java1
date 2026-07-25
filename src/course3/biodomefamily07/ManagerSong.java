package course3.biodomefamily07;

public class ManagerSong extends Song{
    private String genre;

    public ManagerSong(String title, int duration, String artist, String genre) {
        super(title, duration, artist);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return getTitle() + ", " + getDuration() + "분, " + getArtist() + ", " + genre;
    }
}
