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

    // Default constructor (useful for frameworks like Hibernate)
    public RecompenseFidelite() {
    }

    // Constructor without idRecompense (for cases where id is auto-generated in DB)
    public RecompenseFidelite(String nomRecompense, String descriptionRecompense, int pointsRequis, String typeRecompense, Timestamp dateExpiration) {
        this.nomRecompense = nomRecompense;
        this.descriptionRecompense = descriptionRecompense;
        this.pointsRequis = pointsRequis;
        this.typeRecompense = typeRecompense;
        this.dateExpiration = dateExpiration;
    }

    // Full constructor
    public RecompenseFidelite(int idRecompense, String nomRecompense, String descriptionRecompense, int pointsRequis, String typeRecompense, Timestamp dateExpiration) {
        this.idRecompense = idRecompense;
        this.nomRecompense = nomRecompense;
        this.descriptionRecompense = descriptionRecompense;
        this.pointsRequis = pointsRequis;
        this.typeRecompense = typeRecompense;
        this.dateExpiration = dateExpiration;
    }

    // Getters and setters
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

    // Equals and hashCode based on idRecompense
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecompenseFidelite)) return false;
        RecompenseFidelite that = (RecompenseFidelite) o;
        return idRecompense == that.idRecompense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecompense);
    }

    // toString for easy debugging
    @Override
    public String toString() {
        return "RecompenseFidelite{" +
                "idRecompense=" + idRecompense +
                ", nomRecompense='" + nomRecompense + '\'' +
                ", descriptionRecompense='" + descriptionRecompense + '\'' +
                ", pointsRequis=" + pointsRequis +
                ", typeRecompense='" + typeRecompense + '\'' +
                ", dateExpiration=" + dateExpiration +
                '}';
    }
}
