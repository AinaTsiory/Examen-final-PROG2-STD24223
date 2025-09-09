import lombok.Getter;

import java.time.LocalDate;
@Getter

public class TravailleurPrestataires extends Travailleur {
     private final Salaire TJM;

    public TravailleurPrestataires(int id, String nom, String prenom, String email, String telephone, Salaire TJM) {
        super(id, nom, prenom, email, telephone);
        this.TJM = TJM;
    }

    public double calculerSalaire(LocalDate debut, LocalDate fin) {
            double totalJours = getDaysRed(debut, fin);
            double TJMCourant = TJM.getValeurCourante(fin);
            return totalJours * TJMCourant;
        }
}
