package javastock.login.view;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Classe que mapeia os elementos e funções da tela.
 */
public class LoginControllerView {

    @FXML
    TextField login;
    @FXML
    PasswordField senha;


    public void logar(){
        System.out.println(" login:" + login.getText()+" senha:"+senha.getText());
    }

}
