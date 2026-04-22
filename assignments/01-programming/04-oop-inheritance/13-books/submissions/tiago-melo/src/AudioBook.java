public class AudioBook extends Book {
    double fileSizeInMB;
    int playLengthInMinutes;
    String narrator;

    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return super.toString() + ", File Size: " + fileSizeInMB + "MB, Play Length: " + playLengthInMinutes + " min, Narrator: " + narrator;
    }
}