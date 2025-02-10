package esprit.tn.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection cnx;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        try {
            // Make sure to replace these with your actual database details
            String url = "jdbc:mysql://localhost:3306/fidelite_pi";
            String user = "root";
            String password = "";

            // Initialize connection
            cnx = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    // Singleton pattern to ensure only one instance of DatabaseConnection exists
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Getter for the connection object
    public Connection getCnx() {
        return cnx;
    }

    // Close the connection (optional)
    public void close() {
        try {
            if (cnx != null && !cnx.isClosed()) {
                cnx.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
