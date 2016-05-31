package javastock.login;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javastock.login.equipe.EquipeView;
import javastock.principal.PrincipalView;

/**
 * Classe que mapeia os elementos e funções da tela.
 */
public class LoginControllerView {

    @FXML
    TextField login;
    @FXML
    PasswordField senha;


    public void logar() throws Exception {
        System.out.println(" login:" + login.getText() + " senha:" + senha.getText());
        new PrincipalView().start(new Stage());
    }


    public void equipe() throws Exception {
        new EquipeView().start(new Stage());
    }
}