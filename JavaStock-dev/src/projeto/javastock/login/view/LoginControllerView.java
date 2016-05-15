package javastock.login.view;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javastock.login.view.equipe.EquipeView;

/**
 * Classe que mapeia os elementos e funções da tela.
 */
public class LoginControllerView {

    @FXML
    TextField login;
    @FXML
    PasswordField senha;


    public void logar() {
        System.out.println(" login:" + login.getText() + " senha:" + senha.getText());
    }


    public void equipe() throws Exception {
    new EquipeView().start(new Stage());
    }
}