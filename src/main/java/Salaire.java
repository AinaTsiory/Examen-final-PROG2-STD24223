import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Salaire {
    private final double valeurInitiale;
    private final List<Promotion> promotions = new ArrayList<>();

    public Salaire(double valeurInitiale) {
        this.valeurInitiale = valeurInitiale;
    }

    public void ajouterPromotion(double nouvelleValeur, LocalDate date, String raison) {
        promotions.add(new Promotion(nouvelleValeur, date, raison));
    }

    public double getValeurCourante(LocalDate date) {
        double valeur = valeurInitiale;
        for (Promotion promo : promotions) {
            if (!promo.getDate().isAfter(date)) {
                valeur = promo.getNouvelleValeur();
            }
        }
        return valeur;
    }

    @Getter
    private static class Promotion {
        private final double nouvelleValeur;
        private final LocalDate date;
        private final String raison;

        public Promotion(double nouvelleValeur, LocalDate date, String raison) {
            this.nouvelleValeur = nouvelleValeur;
            this.date = date;
            this.raison = raison;
        }

    }
}