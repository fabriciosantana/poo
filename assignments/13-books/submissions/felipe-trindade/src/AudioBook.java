public class AudioBook extends Book{
    private double sizeMB;
    private int durationMin;
    private String narrator;

    public AudioBook(String title, String author, int year, double sizeMB, int durationMin, String narrator){
        super(title, author, year);
        this.sizeMB = sizeMB;
        this.durationMin = durationMin;
        this.narrator = narrator;
    }

    @Override
    public String toString(){
        return super.toString()
        + " | Arquivo: " + String.format("%.1f", sizeMB) + " MB"
        + " | Duração: " + durationMin + " min"
        + " | Narrador: " + narrator;
    }
}
