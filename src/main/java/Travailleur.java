import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter

    public abstract class Travailleur {
        private final int id;
        private final String nom;
        private final String prenom;
        private final String email;
        private final String telephone;
        private final List<Pointage> pointages = new ArrayList<>();

        public void ajouterPointage(Pointage p) {
            pointages.add(p);
        }

        public boolean pointageRouge(LocalDate date) {
            double total = 0;
            for (Pointage p : pointages) {
                if (p.getDate().equals(date)) {
                    double q = p.getQuotaTemps();
                    if (q > 1 || q <= 0) throw new IllegalArgumentException("Quota temps invalide");
                    total += q;
                }
            }
            return total == 1.0;
        }

        public double getDaysRed(LocalDate debut, LocalDate fin) {
            return pointages.stream()
                    .filter(p -> !p.getDate().isBefore(debut) && !p.getDate().isAfter(fin))
                    .filter(p -> p.getTypeTravail() != TypeTravail.ABS_PAYEE && p.getTypeTravail() != TypeTravail.ABS_NON_PAYEE)
                    .mapToDouble(Pointage::getQuotaTemps)
                    .sum();
        }
    }


