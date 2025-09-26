
public class AudioBook extends Book {
    // Atributos específicos de um audiolivro
    private double fileSizeInMB;
    private int playLengthInMinutes;
    private String narrator;

   
    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator) {
        // Chama o construtor da superclasse (Book)
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    
    @Override
    public String toString() {
        return String.format("%s, Narrador: %s, Duração (min): %d, Tamanho (MB): %.1f",
                             super.toString(), this.narrator, this.playLengthInMinutes, this.fileSizeInMB);
    }
}