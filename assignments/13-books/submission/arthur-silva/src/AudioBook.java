

public class AudioBook extends Book {
    
    private double fileSizeInMB;
    private int playLengthInMinutes;
    private String narrator;

    // Construtor
    public AudioBook(String title, String author, int year, double fileSizeInMB, int playLengthInMinutes, String narrator) {
        // Chama o construtor da classe pai (Book)
        super(title, author, year);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

   
    public double getFileSizeInMB() {
        return fileSizeInMB;
    }

    public int getPlayLengthInMinutes() {
        return playLengthInMinutes;
    }

    public String getNarrator() {
        return narrator;
    }
    
    // Sobrescreve o método toString(), aproveitando a implementação da classe pai
    @Override
    public String toString() {
        // super.toString() chama o método da classe Book
        return String.format("%s\nTamanho do Arquivo: %.2f MB\nDuração: %d minutos\nNarrador: %s",
                super.toString(), fileSizeInMB, playLengthInMinutes, narrator);
    }
}