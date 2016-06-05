package javastock.login;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javastock.login.equipe.EquipeView;
import javastock.principal.PrincipalView;

import javax.swing.*;

/**
 * Classe que mapeia os elementos e funções da tela  {@Link LoginView}.
 */
public class LoginControllerView {

    @FXML
    TextField login;
    @FXML
    PasswordField senha;

    /**
     * Método para logar no sistema.
     *
     * @throws Exception
     */
    public void logar() throws Exception {
        System.out.println(" login:" + login.getText() + " senha:" + senha.getText());
        new PrincipalView().start(new Stage());
        LoginView.close();
    }

    /**
     * Método que abre tela da equipe.
     *
     * @throws Exception
     */
    public void equipe() throws Exception {
        new EquipeView().start(new Stage());

    }

}