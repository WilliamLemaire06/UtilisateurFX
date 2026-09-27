package repository;

import database.Database;
import model.Utilisateur;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilisateurRepository {
    private Connection connection;
    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    public UtilisateurRepository() {
        this.connection = Database.getConnexion();
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) throws Exception {
        String sql = "INSERT INTO utilisateurs (nom, prenom, email, mdp, role) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            String mdpHache = encoder.encode(utilisateur.getMdp());
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, mdpHache);
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }

    public Utilisateur getUtilisateurParEmail(String email) throws Exception {
        String sql = "SELECT * FROM utilisateurs WHERE email = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_utilisateur");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String mdp = rs.getString("mdp");
                String role = rs.getString("role");
                return new Utilisateur(id, nom, prenom, email, mdp, role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ArrayList<Utilisateur> getTousLesUtilisateurs() {
        String sql = "SELECT * FROM utilisateurs";
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id_utilisateur = rs.getInt("id_utilisateur");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String mdp = rs.getString("mdp");
                String role = rs.getString("role");
                Utilisateur u1=new Utilisateur(id_utilisateur,nom,prenom,email,mdp,role);
                utilisateurs.add(u1);
            }
            for(Utilisateur utilisateur : utilisateurs){
                System.out.println(utilisateur);
            }

        }catch(Exception e){
            System.out.println("Erreur lors de la récuperation des comptes !! ");

        }
       return null;
    }

    public void supprimerUtilisateurParEmail(String email) {
        String sql = "DELETE FROM utilisateurs WHERE email = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();
            System.out.println("User bien supprimé");
        }catch(Exception e){
            System.out.println("Ce mail n'est pas relié a un compte !!");
        }

    }

    public void mettreAJourUtilisateur(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateurs SET nom = ?, prenom = ?, mdp = ?, role = ? WHERE email = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getMdp());
            stmt.setString(4, utilisateur.getRole());
            stmt.setString(5, utilisateur.getEmail());
            stmt.executeUpdate();

        }catch(Exception e){
            System.out.println("Les infos n'ont pas été mis à jour");
        }
    }




}
