import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Pointage {
    private final LocalDate date;
    private final TypeTravail typeTravail;
    private final double quotaTemps;
    private final String description;
    private final String couleur;

    public Pointage(LocalDate date, TypeTravail typeTravail, double quotaTemps, String description, String couleur) {
        this.date = date;
        this.typeTravail = typeTravail;
        this.quotaTemps = quotaTemps;
        this.description = description;
        this.couleur = couleur;
    }

}

