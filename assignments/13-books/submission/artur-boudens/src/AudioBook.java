public class AudioBook extends Book{
    private double fileSizeInMb;
    private int playLengthInMinutes;
    private String narrator;

    public AudioBook(String title, int year, String author, double fileSizeInMb, int playLengthInMinutes, String narrator) {
        super(title, year, author);

        this.fileSizeInMb = fileSizeInMb;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString(){
        return "Audiobook [Título: '" + super.title + "', Ano: '" + super.year + "', Autor: '" + super.author + "', Tamanho(MB): '" + this.fileSizeInMb + "', Duração(Min): '" + this.playLengthInMinutes +  "', Narrador: '" + this.narrator + "']";
    }

    public double getFileSizeInMb(){
        return this.fileSizeInMb;
    }
    public int getPlayLengthInMinutes(){
        return this.playLengthInMinutes;
    }
    public String getNarrator(){
        return this.narrator;
    }
    
}
