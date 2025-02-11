package esprit.tn.main;

import esprit.tn.entities.RecompenseFidelite;
import esprit.tn.entities.UtilisateurFidelite;
import esprit.tn.services.RecompenseFideliteService;
import esprit.tn.services.UtilisateurFideliteService;

import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initialize the services for both entities
        UtilisateurFideliteService utilisateurService = new UtilisateurFideliteService();
        RecompenseFideliteService recompenseService = new RecompenseFideliteService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add Utilisateur");
            System.out.println("2. Modify Utilisateur");
            System.out.println("3. Delete Utilisateur");
            System.out.println("4. Add Recompense");
            System.out.println("5. Modify Recompense");
            System.out.println("6. Delete Recompense");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add Utilisateur
                    System.out.println("Enter Utilisateur details:");
                    System.out.print("ID (0 for auto-generated): ");
                    int utilisateurId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Niveau: ");
                    int niveau = scanner.nextInt();
                    System.out.print("Points: ");
                    int points = scanner.nextInt();
                    System.out.print("Total Trajets: ");
                    int trajets = scanner.nextInt();
                    System.out.print("Montant Depense: ");
                    double montant = scanner.nextDouble();
                    System.out.print("Badges (comma separated): ");
                    scanner.nextLine();  // Consume newline
                    String badges = scanner.nextLine();
                    System.out.print("Code Parrainage: ");
                    String codeParrainage = scanner.nextLine();
                    System.out.print("ID Parrain: ");
                    int idParrain = scanner.nextInt();

                    UtilisateurFidelite newUser = new UtilisateurFidelite(
                            utilisateurId, niveau, points, trajets, montant,
                            new Timestamp(System.currentTimeMillis()), badges,
                            codeParrainage, idParrain
                    );
                    utilisateurService.ajouter(newUser);
                    System.out.println("Utilisateur added!");
                    break;

                case 2:
                    // Modify Utilisateur
                    System.out.print("Enter Utilisateur ID to modify: ");
                    int modifyUtilisateurId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    UtilisateurFidelite existingUser = utilisateurService.getOneById(modifyUtilisateurId);

                    if (existingUser != null) {
                        System.out.println("Modify details for Utilisateur ID: " + modifyUtilisateurId);
                        System.out.print("New Points: ");
                        int newPoints = scanner.nextInt();
                        System.out.print("New Total Trajets: ");
                        int newTrajets = scanner.nextInt();
                        existingUser.setPointsAccumules(newPoints);
                        existingUser.setTotalTrajetsEffectues(newTrajets);
                        utilisateurService.modifier(existingUser);
                        System.out.println("Utilisateur modified!");
                    } else {
                        System.out.println("Utilisateur not found!");
                    }
                    break;

                case 3:
                    // Delete Utilisateur
                    System.out.print("Enter Utilisateur ID to delete: ");
                    int deleteUtilisateurId = scanner.nextInt();
                    utilisateurService.supprimer(deleteUtilisateurId);
                    System.out.println("Utilisateur deleted!");
                    break;

                case 4:
                    // Add Recompense
                    System.out.println("Enter Recompense details:");
                    System.out.print("ID (0 for auto-generated): ");
                    int recompenseId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Nom Recompense: ");
                    String nomRecompense = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    int pointsRequis = 0;

                    // Validate integer input for Points Requis
                    while (true) {
                        try {
                            System.out.print("Points Requis: ");
                            pointsRequis = scanner.nextInt();
                            break;  // Exit loop if valid input is provided
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for Points Requis.");
                            scanner.nextLine();  // Clear the buffer
                        }
                    }

                    scanner.nextLine(); // Consume newline
                    System.out.print("Type Recompense: ");
                    String typeRecompense = scanner.nextLine();

                    // Validate Date Expiration
                    String dateExp = "";
                    while (true) {
                        System.out.print("Date Expiration (YYYY-MM-DD HH:MM:SS): ");
                        dateExp = scanner.nextLine();
                        // Check if the format is correct
                        if (dateExp.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                            break;
                        } else {
                            System.out.println("Invalid date format. Please use YYYY-MM-DD HH:MM:SS.");
                        }
                    }

                    // Ask for the idUtilisateur
                    System.out.print("Enter Utilisateur ID for this Recompense: ");
                    int idUtilisateur = scanner.nextInt();

                    // Check if the Utilisateur exists
                    UtilisateurFidelite user = utilisateurService.getOneById(idUtilisateur);  // Rename the variable
                    if (user != null) {
                        try {
                            RecompenseFidelite newRecompense = new RecompenseFidelite(
                                    recompenseId, nomRecompense, description, pointsRequis,
                                    typeRecompense, Timestamp.valueOf(dateExp), idUtilisateur
                            );
                            recompenseService.ajouter(newRecompense);
                            System.out.println("Recompense added!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: Invalid date format.");
                        }
                    } else {
                        System.out.println("Utilisateur with ID " + idUtilisateur + " does not exist. Cannot add Recompense.");
                    }
                    break;

                case 5:
                    // Modify Recompense
                    System.out.print("Enter Recompense ID to modify: ");
                    int modifyRecompenseId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    RecompenseFidelite existingRecompense = recompenseService.getOneById(modifyRecompenseId);

                    if (existingRecompense != null) {
                        System.out.println("Modify details for Recompense ID: " + modifyRecompenseId);
                        System.out.print("New Points Requis: ");
                        int newPointsRequis = scanner.nextInt();
                        existingRecompense.setPointsRequis(newPointsRequis);
                        recompenseService.modifier(existingRecompense);
                        System.out.println("Recompense modified!");
                    } else {
                        System.out.println("Recompense not found!");
                    }
                    break;

                case 6:
                    // Delete Recompense
                    System.out.print("Enter Recompense ID to delete: ");
                    int deleteRecompenseId = scanner.nextInt();
                    recompenseService.supprimer(deleteRecompenseId);
                    System.out.println("Recompense deleted!");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
