public class Film {
    private String title;
    private int languageId;
    private int rentalDuration;
    private double rentalRate;
    private double replacementCost;

    public Film(String title, int languageId, int rentalDuration, double rentalRate, double replacementCost) {
        this.title = title;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
    }

    public String getTitle() {
        return title;
    }

    public int getLanguageId() {
        return languageId;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public double getReplacementCost() {
        return replacementCost;
    }
}