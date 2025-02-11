package esprit.tn.services;

import esprit.tn.entities.RecompenseFidelite;
import esprit.tn.main.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecompenseFideliteService {

    Connection cnx;

    // Constructor to initialize the connection
    public RecompenseFideliteService() {
        cnx = DatabaseConnection.getInstance().getCnx();
    }

    // Method to add a RecompenseFidelite
    public void ajouter(RecompenseFidelite rf) {
        String req = "INSERT INTO recompensefidelite (nomRecompense, descriptionRecompense, pointsRequis, typeRecompense, dateExpiration, idUtilisateur) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = cnx.prepareStatement(req);
            stm.setString(1, rf.getNomRecompense());
            stm.setString(2, rf.getDescriptionRecompense());
            stm.setInt(3, rf.getPointsRequis());
            stm.setString(4, rf.getTypeRecompense());
            stm.setTimestamp(5, rf.getDateExpiration());
            stm.setInt(6, rf.getIdUtilisateur()); // Set the foreign key

            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to modify a RecompenseFidelite
    public void modifier(RecompenseFidelite rf) {
        String req = "UPDATE recompensefidelite SET nomRecompense = ?, descriptionRecompense = ?, pointsRequis = ?, typeRecompense = ?, dateExpiration = ?, idUtilisateur = ? WHERE idRecompense = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(req);
            stm.setString(1, rf.getNomRecompense());
            stm.setString(2, rf.getDescriptionRecompense());
            stm.setInt(3, rf.getPointsRequis());
            stm.setString(4, rf.getTypeRecompense());
            stm.setTimestamp(5, rf.getDateExpiration());
            stm.setInt(6, rf.getIdUtilisateur()); // Set the foreign key
            stm.setInt(7, rf.getIdRecompense());

            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to delete a RecompenseFidelite
    public void supprimer(int idRecompense) {
        String req = "DELETE FROM recompensefidelite WHERE idRecompense = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(req);
            stm.setInt(1, idRecompense);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to get all RecompenseFidelite records
    public List<RecompenseFidelite> getAll() {
        List<RecompenseFidelite> recompenses = new ArrayList<>();
        String req = "SELECT * FROM recompensefidelite";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                RecompenseFidelite rf = new RecompenseFidelite(
                        rs.getInt("idRecompense"),
                        rs.getString("nomRecompense"),
                        rs.getString("descriptionRecompense"),
                        rs.getInt("pointsRequis"),
                        rs.getString("typeRecompense"),
                        rs.getTimestamp("dateExpiration"),
                        rs.getInt("idUtilisateur") // Get the foreign key reference
                );
                recompenses.add(rf);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recompenses;
    }

    // Method to get a specific RecompenseFidelite by id
    public RecompenseFidelite getOneById(int idRecompense) {
        RecompenseFidelite rf = null;
        String req = "SELECT * FROM recompensefidelite WHERE idRecompense = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(req);
            stm.setInt(1, idRecompense);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                rf = new RecompenseFidelite(
                        rs.getInt("idRecompense"),
                        rs.getString("nomRecompense"),
                        rs.getString("descriptionRecompense"),
                        rs.getInt("pointsRequis"),
                        rs.getString("typeRecompense"),
                        rs.getTimestamp("dateExpiration"),
                        rs.getInt("idUtilisateur") // Get the foreign key reference
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rf;
    }
}
