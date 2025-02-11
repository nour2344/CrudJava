package esprit.tn.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class RecompenseFidelite {
    private int idRecompense;
    private String nomRecompense;
    private String descriptionRecompense;
    private int pointsRequis;
    private String typeRecompense;
    private Timestamp dateExpiration;
    private int idUtilisateur;  // Foreign Key

    // Constructor
    public RecompenseFidelite(int idRecompense, String nomRecompense, String descriptionRecompense,
                              int pointsRequis, String typeRecompense, Timestamp dateExpiration, int idUtilisateur) {
        this.idRecompense = idRecompense;
        this.nomRecompense = nomRecompense;
        this.descriptionRecompense = descriptionRecompense;
        this.pointsRequis = pointsRequis;
        this.typeRecompense = typeRecompense;
        this.dateExpiration = dateExpiration;
        this.idUtilisateur = idUtilisateur;  // Set the foreign key
    }

    // Getters and Setters
    public int getIdRecompense() {
        return idRecompense;
    }

    public void setIdRecompense(int idRecompense) {
        this.idRecompense = idRecompense;
    }

    public String getNomRecompense() {
        return nomRecompense;
    }

    public void setNomRecompense(String nomRecompense) {
        this.nomRecompense = nomRecompense;
    }

    public String getDescriptionRecompense() {
        return descriptionRecompense;
    }

    public void setDescriptionRecompense(String descriptionRecompense) {
        this.descriptionRecompense = descriptionRecompense;
    }

    public int getPointsRequis() {
        return pointsRequis;
    }

    public void setPointsRequis(int pointsRequis) {
        this.pointsRequis = pointsRequis;
    }

    public String getTypeRecompense() {
        return typeRecompense;
    }

    public void setTypeRecompense(String typeRecompense) {
        this.typeRecompense = typeRecompense;
    }

    public Timestamp getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Timestamp dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    // equals() Method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecompenseFidelite that = (RecompenseFidelite) o;
        return idRecompense == that.idRecompense &&
                pointsRequis == that.pointsRequis &&
                idUtilisateur == that.idUtilisateur &&
                Objects.equals(nomRecompense, that.nomRecompense) &&
                Objects.equals(descriptionRecompense, that.descriptionRecompense) &&
                Objects.equals(typeRecompense, that.typeRecompense) &&
                Objects.equals(dateExpiration, that.dateExpiration);
    }

    // hashCode() Method
    @Override
    public int hashCode() {
        return Objects.hash(idRecompense, nomRecompense, descriptionRecompense, pointsRequis,
                typeRecompense, dateExpiration, idUtilisateur);
    }

    // toString() Method
    @Override
    public String toString() {
        return "RecompenseFidelite{" +
                "idRecompense=" + idRecompense +
                ", nomRecompense='" + nomRecompense + '\'' +
                ", descriptionRecompense='" + descriptionRecompense + '\'' +
                ", pointsRequis=" + pointsRequis +
                ", typeRecompense='" + typeRecompense + '\'' +
                ", dateExpiration=" + dateExpiration +
                ", idUtilisateur=" + idUtilisateur +
                '}';
    }
}
