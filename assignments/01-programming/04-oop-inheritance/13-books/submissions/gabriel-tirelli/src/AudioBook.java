public class AudioBook extends Book {
    
    protected double fileSizeInMB;
    protected int playLenghtInMinutes;
    protected String narrator;

    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLenghtInMinutes, String narrator){
        super(title,year,author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLenghtInMinutes = playLenghtInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString(){
        String string = super.toString();
        return(string + " - Narrador: " + this.narrator + " - Tamanho: " + this.fileSizeInMB + "Mb - Duração: "+ this.playLenghtInMinutes + " min");
    }

}
