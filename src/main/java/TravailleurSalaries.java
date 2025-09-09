    public class TravailleurSalaries extends Travailleur {
        private final Salaire salaireMensuel;

        public TravailleurSalaries(int id, String nom, String prenom, String email, String telephone, double salaireInitial) {
            super(id, nom, prenom, email, telephone);
            this.salaireMensuel = new Salaire(salaireInitial);
        }
        public Salaire getSalaireMensuel() {
            return salaireMensuel;
        }
    }

