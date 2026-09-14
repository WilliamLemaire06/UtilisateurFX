package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InscriptionController {

    @FXML
    private PasswordField confirmationMdp;

    @FXML
    private TextField mail;

    @FXML
    private PasswordField mdp;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Label labelErreur;



    @FXML
    public void inscription() {
        String nom = this.nom.getText();
        String prenom = this.prenom.getText();
        String mail = this.mail.getText();
        String mdp = this.mdp.getText();
        String confirmationMdp = this.confirmationMdp.getText();

        if (nom.isEmpty() || prenom.isEmpty() || mail.isEmpty() || mdp.isEmpty()|| confirmationMdp.isEmpty()) {
            labelErreur.setText("Rempli les champs !");
        } else if (!mdp.equals(confirmationMdp)) {
            labelErreur.setText("La confirmation n'est pas comme le mdp");
        }else{
            labelErreur.setText("Inscription enregistrer :)");
        }

    }

    @FXML
    void connexion(ActionEvent event) throws IOException {
        StartApplication.changeScene("LoginView.fxml");
    }

}
