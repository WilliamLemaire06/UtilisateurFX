module appli {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires spring.security.crypto;


    requires spring.core;
    requires org.apache.commons.logging;



    opens appli to javafx.fxml;
    exports appli;

    exports appli.accueil;
    opens appli.accueil to javafx.fxml;

}