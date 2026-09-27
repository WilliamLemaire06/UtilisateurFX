package appli.accueil;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Utilisateur;

import repository.UtilisateurRepository;

import java.io.IOException;

public class LoginController {



    private PasswordEncoder encoder = new BCryptPasswordEncoder();
    private UtilisateurRepository uR = new UtilisateurRepository();

    @FXML
    private TextField ajoutEmail;

    @FXML
    private PasswordField ajoutMdp;

    @FXML
    private Label labelErreur;

    @FXML
    public void connexion(ActionEvent event) throws Exception {
        String email = ajoutEmail.getText();
        String mdp = ajoutMdp.getText();

        if (email.isEmpty() || mdp.isEmpty()) {
            labelErreur.setText("Veuillez rentrez les infos !");
            return;
        }

        Utilisateur u = uR.getUtilisateurParEmail(email);

        if (u == null) {
            labelErreur.setText("Email inconnu !");
        } else if (!encoder.matches(mdp, u.getMdp())) {
            labelErreur.setText("Mot de passe incorrect !");
        } else {
            StartApplication.changeScene("AccueilView.fxml");
        }
    }


    @FXML
    public void inscription(ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("InscriptionView.fxml");
    }

}
