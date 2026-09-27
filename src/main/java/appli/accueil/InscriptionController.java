package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.io.IOException;

public class InscriptionController {

    @FXML
    private PasswordField confirmationMdp;

    @FXML
    private TextField email;

    @FXML
    private PasswordField mdp;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField role;

    @FXML
    private Label labelErreur;



    @FXML
    public void inscription() throws Exception {
        String nom = this.nom.getText();
        String prenom = this.prenom.getText();
        String email = this.email.getText();
        String mdp = this.mdp.getText();
        String role = this.role.getText();
        String confirmationMdp = this.confirmationMdp.getText();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || mdp.isEmpty()|| confirmationMdp.isEmpty() || role.isEmpty()) {
            labelErreur.setText("Rempli les champs !");
        } else if (!mdp.equals(confirmationMdp)) {
            labelErreur.setText("La confirmation n'est pas comme le mdp");
        }else{
            Utilisateur u1 = new Utilisateur(nom,prenom,email,mdp,role);
            UtilisateurRepository u2 = new UtilisateurRepository();
            u2.ajouterUtilisateur(u1);

            System.out.println("role : " + role);
            labelErreur.setText("Inscription enregistrer :)");
        }

    }

    @FXML
    void connexion(ActionEvent event) throws IOException {
        StartApplication.changeScene("LoginView.fxml");
    }

}
