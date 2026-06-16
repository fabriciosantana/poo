public class Film {
    String title;
    int languageId;
    int rentalDuration;
    double rentalRate;
    double replacementCost;

    public Film(String title, int languageId, int rentalDuration, double rentalRate, double replacementCost) {
        this.title = title;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
    }
}
