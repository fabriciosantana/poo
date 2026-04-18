public class AudioBook extends Book{

    private double fileSizeInMB;
    private int playLengthInMinutes;
    private String narrator;

    public AudioBook(String title, int year, String author, 
                     double fileSizeInMB, int playLengthInMinutes, String narrator){
        
        super(title, year, author);

        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;

    }

    public void setFileSizeInMB(double fileSizeInMB){ this.fileSizeInMB = fileSizeInMB; }
    public double getFileSizeInMB(){ return fileSizeInMB; }

    public void setPlayLengthInMinutes(int playLengthInMinutes){ this.playLengthInMinutes = playLengthInMinutes; }
    public int getPlayLengthInMinutes(){ return playLengthInMinutes; }

    public void setNarrator(String narrator){ this.narrator = narrator; }
    public String getNarrator(){ return narrator; }

    @Override
    public String toString(){
        return String.format("%sTamanho do arquivo em megabytes: %.2f\nDuração em minutos do áudio: %d\nNome do narrador: %s\n",
                            super.toString(), getFileSizeInMB(), getPlayLengthInMinutes(), getNarrator());
    }
}