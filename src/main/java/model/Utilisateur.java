package model;

public class Utilisateur {

    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String confirmationMdp;
    private String role;

    public Utilisateur(int id,String nom, String prenom, String email, String mdp, String confirmationMdp, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.confirmationMdp = confirmationMdp;
    }
    public Utilisateur(String nom, String prenom, String email, String mdp, String confirmationMdp,String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.confirmationMdp = confirmationMdp;
    }
    public Utilisateur(String email,String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Bienvenue"+getNom();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getConfirmationMdp() {
        return confirmationMdp;
    }

    public void setConfirmationMdp(String confirmationMdp) {
        this.confirmationMdp = confirmationMdp;
    }
}
