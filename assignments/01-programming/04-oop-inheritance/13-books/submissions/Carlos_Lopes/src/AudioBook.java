public class AudioBook extends Book{
    private double fileSizeInMB;
    private int playLengthInMinutes;
    private String narrator;


    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator){

    super(title, year, author);

    this.fileSizeInMB = fileSizeInMB;
    this.playLengthInMinutes = playLengthInMinutes;
    this.narrator = narrator;
    }

    public double getFileSizeInMB(){return fileSizeInMB;}
    public int getPlayLengthInMinutes(){return playLengthInMinutes;}
    public String getNarrator(){return narrator;}

    public void setFileSizeInMB(double fileSizeInMB ){this.fileSizeInMB = fileSizeInMB;}
    public void setPlayLengthInMinutes(int playLengthInMinutes){this.playLengthInMinutes = playLengthInMinutes;}
    public void setNarrator(String narrator){this.narrator = narrator;}

    @Override
    public String toString(){
        return 
        ("Título: " + getTitle()
        + "\nAno: " + getYear()
        + "\nAutor: " + getAuthor()
        + "\nTamanho do Arquivo em Mb: " +fileSizeInMB 
        + "\nDuração(Min): " +playLengthInMinutes 
        + "\nNarrador: " +narrator);
    }


}
