package course3.biodomefamily07;

public class AnimalSong extends Song{
    private String targetAnimal;

    public AnimalSong(String title, int duration, String artist, String targetAnimal) {
        super(title, duration, artist);
        this.targetAnimal = targetAnimal;
    }

    public String getTargetAnimal() {
        return targetAnimal;
    }

    public void setTargetAnimal(String targetAnimal) {
        this.targetAnimal = targetAnimal;
    }

    @Override
    public String toString() {
        return getTitle() + ", " + getDuration() + "분, " + getArtist() + ", " + targetAnimal;
    }
}
