package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField ajoutEmail;

    @FXML
    private PasswordField ajoutMdp;

    @FXML
    private Label labelErreur;

    @FXML
    public void connexion(ActionEvent event) {
        String email = ajoutEmail.getText();
        String mdp = ajoutMdp.getText();
        System.out.println("email : " + email);
        System.out.println("mdp : " + mdp);

        if(email.isEmpty() || mdp.isEmpty()){
            labelErreur.setText("Veuillez rentrez les infos !");

        }else if(email.equals("willi@goat.fr") && mdp.equals("FRANCE")){
            labelErreur.setText("Vous etes connectez !");
        }else{
            labelErreur.setText("T'es qui !");
        }
    }
    }

    @FXML
    public void inscription(ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("InscriptionView.fxml");
    }

}
