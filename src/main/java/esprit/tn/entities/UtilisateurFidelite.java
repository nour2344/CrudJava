package esprit.tn.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class UtilisateurFidelite {
    private int idUtilisateur;
    private int idNiveau;
    private int pointsAccumules;
    private int totalTrajetsEffectues;
    private double totalMontantDepense;
    private Timestamp dateDerniereMiseAJour;
    private String badgesDebloques;
    private String codeParrainage;
    private Integer idParrain;

    // ✅ Default constructor (needed for frameworks like Hibernate)
    public UtilisateurFidelite() {
    }

    // ✅ Constructor without idUtilisateur (useful when auto-generated in DB)
    public UtilisateurFidelite(int idNiveau, int pointsAccumules, int totalTrajetsEffectues,
                               double totalMontantDepense, Timestamp dateDerniereMiseAJour,
                               String badgesDebloques, String codeParrainage, Integer idParrain) {
        this.idNiveau = idNiveau;
        this.pointsAccumules = pointsAccumules;
        this.totalTrajetsEffectues = totalTrajetsEffectues;
        this.totalMontantDepense = totalMontantDepense;
        this.dateDerniereMiseAJour = dateDerniereMiseAJour;
        this.badgesDebloques = badgesDebloques;
        this.codeParrainage = codeParrainage;
        this.idParrain = idParrain;
    }

    // ✅ Full Constructor
    public UtilisateurFidelite(int idUtilisateur, int idNiveau, int pointsAccumules, int totalTrajetsEffectues,
                               double totalMontantDepense, Timestamp dateDerniereMiseAJour,
                               String badgesDebloques, String codeParrainage, Integer idParrain) {
        this.idUtilisateur = idUtilisateur;
        this.idNiveau = idNiveau;
        this.pointsAccumules = pointsAccumules;
        this.totalTrajetsEffectues = totalTrajetsEffectues;
        this.totalMontantDepense = totalMontantDepense;
        this.dateDerniereMiseAJour = dateDerniereMiseAJour;
        this.badgesDebloques = badgesDebloques;
        this.codeParrainage = codeParrainage;
        this.idParrain = idParrain;
    }

    // ✅ Getters & Setters
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(int idNiveau) {
        this.idNiveau = idNiveau;
    }

    public int getPointsAccumules() {
        return pointsAccumules;
    }

    public void setPointsAccumules(int pointsAccumules) {
        this.pointsAccumules = pointsAccumules;
    }

    public int getTotalTrajetsEffectues() {
        return totalTrajetsEffectues;
    }

    public void setTotalTrajetsEffectues(int totalTrajetsEffectues) {
        this.totalTrajetsEffectues = totalTrajetsEffectues;
    }

    public double getTotalMontantDepense() {
        return totalMontantDepense;
    }

    public void setTotalMontantDepense(double totalMontantDepense) {
        this.totalMontantDepense = totalMontantDepense;
    }

    public Timestamp getDateDerniereMiseAJour() {
        return dateDerniereMiseAJour;
    }

    public void setDateDerniereMiseAJour(Timestamp dateDerniereMiseAJour) {
        this.dateDerniereMiseAJour = dateDerniereMiseAJour;
    }

    public String getBadgesDebloques() {
        return badgesDebloques;
    }

    public void setBadgesDebloques(String badgesDebloques) {
        this.badgesDebloques = badgesDebloques;
    }

    public String getCodeParrainage() {
        return codeParrainage;
    }

    public void setCodeParrainage(String codeParrainage) {
        this.codeParrainage = codeParrainage;
    }

    public Integer getIdParrain() {
        return idParrain;
    }

    public void setIdParrain(Integer idParrain) {
        this.idParrain = idParrain;
    }

    // ✅ Equals & HashCode based on `idUtilisateur`
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UtilisateurFidelite)) return false;
        UtilisateurFidelite that = (UtilisateurFidelite) o;
        return idUtilisateur == that.idUtilisateur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtilisateur);
    }

    // ✅ Improved toString() for better debugging output
    @Override
    public String toString() {
        return "UtilisateurFidelite {" +
                "idUtilisateur=" + idUtilisateur +
                ", idNiveau=" + idNiveau +
                ", pointsAccumules=" + pointsAccumules +
                ", totalTrajetsEffectues=" + totalTrajetsEffectues +
                ", totalMontantDepense=" + totalMontantDepense +
                ", dateDerniereMiseAJour=" + dateDerniereMiseAJour +
                ", badgesDebloques='" + badgesDebloques + '\'' +
                ", codeParrainage='" + codeParrainage + '\'' +
                ", idParrain=" + idParrain +
                '}';
    }
}
