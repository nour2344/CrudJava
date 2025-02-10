package esprit.tn.services;

import esprit.tn.entities.UtilisateurFidelite;
import esprit.tn.main.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurFideliteService {

    Connection cnx;

    // Constructor to initialize the connection
    public UtilisateurFideliteService() {
        cnx = DatabaseConnection.getInstance().getCnx();  // Get the Connection object here
    }

    // Method to add a UtilisateurFidelite
    public void ajouter(UtilisateurFidelite uf) {
        String req = "INSERT INTO utilisateurfidelite (idNiveau, pointsAccumules, totalTrajetsEffectues, totalMontantDepense, dateDerniereMiseAJour, badgesDebloques, codeParrainage, idParrain) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = cnx.prepareStatement(req);
            stm.setInt(1, uf.getIdNiveau());
            stm.setInt(2, uf.getPointsAccumules());
            stm.setInt(3, uf.getTotalTrajetsEffectues());
            stm.setDouble(4, uf.getTotalMontantDepense());
            stm.setTimestamp(5, uf.getDateDerniereMiseAJour());
            stm.setString(6, uf.getBadgesDebloques());
            stm.setString(7, uf.getCodeParrainage());
            stm.setInt(8, uf.getIdParrain());

            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to update a UtilisateurFidelite
    public void modifier(UtilisateurFidelite uf) {
        String req = "UPDATE utilisateurfidelite SET idNiveau = ?, pointsAccumules = ?, totalTrajetsEffectues = ?, totalMontantDepense = ?, dateDerniereMiseAJour = ?, badgesDebloques = ?, codeParrainage = ?, idParrain = ? WHERE idUtilisateur = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(req);
            stm.setInt(1, uf.getIdNiveau());
            stm.setInt(2, uf.getPointsAccumules());
            stm.setInt(3, uf.getTotalTrajetsEffectues());
            stm.setDouble(4, uf.getTotalMontantDepense());
            stm.setTimestamp(5, uf.getDateDerniereMiseAJour());
            stm.setString(6, uf.getBadgesDebloques());
            stm.setString(7, uf.getCodeParrainage());
            stm.setInt(8, uf.getIdParrain());
            stm.setInt(9, uf.getIdUtilisateur());

            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to delete a UtilisateurFidelite
    public void supprimer(int idUtilisateur) {
        String req = "DELETE FROM utilisateurfidelite WHERE idUtilisateur = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(req);
            stm.setInt(1, idUtilisateur);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to get all UtilisateurFidelite records
    public List<UtilisateurFidelite> getAll() {
        List<UtilisateurFidelite> utilisateurs = new ArrayList<>();
        String req = "SELECT * FROM utilisateurfidelite";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                UtilisateurFidelite uf = new UtilisateurFidelite(
                        rs.getInt("idUtilisateur"),
                        rs.getInt("idNiveau"),
                        rs.getInt("pointsAccumules"),
                        rs.getInt("totalTrajetsEffectues"),
                        rs.getDouble("totalMontantDepense"),
                        rs.getTimestamp("dateDerniereMiseAJour"),
                        rs.getString("badgesDebloques"),
                        rs.getString("codeParrainage"),
                        rs.getInt("idParrain")
                );
                utilisateurs.add(uf);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utilisateurs;
    }

    // Method to get a specific UtilisateurFidelite by id
    public UtilisateurFidelite getOneById(int idUtilisateur) {
        UtilisateurFidelite uf = null;
        String req = "SELECT * FROM utilisateurfidelite WHERE idUtilisateur = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(req);
            stm.setInt(1, idUtilisateur);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                uf = new UtilisateurFidelite(
                        rs.getInt("idUtilisateur"),
                        rs.getInt("idNiveau"),
                        rs.getInt("pointsAccumules"),
                        rs.getInt("totalTrajetsEffectues"),
                        rs.getDouble("totalMontantDepense"),
                        rs.getTimestamp("dateDerniereMiseAJour"),
                        rs.getString("badgesDebloques"),
                        rs.getString("codeParrainage"),
                        rs.getInt("idParrain")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return uf;
    }
}
