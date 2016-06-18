package javastock.login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javastock.login.equipe.EquipeView;
import javastock.pessoa.funcionario.Funcionario;
import javastock.principal.PrincipalView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Classe que mapeia os elementos e funções da tela  {@Link LoginView}.
 */
public class LoginControllerView implements Initializable {

    @FXML
    TextField login;
    @FXML
    PasswordField senha;
    @FXML
    AnchorPane root;

    @FXML
    Label incorreto;

    /**
     * Método para logar no sistema.
     *
     * @throws Exception
     */
    public void logar() throws Exception {
        Login login = new Login();
        login.setEmail(this.login.getText());
        login.setSenha(senha.getText());
        System.out.println(login.getEmail() + login.getSenha());
        Funcionario loginResponse = LoginController.logar(login);
        if (loginResponse != null) {
            new PrincipalView(loginResponse).start(new Stage());
            LoginView.close();
        } else {
            incorreto.setVisible(true);
        }

    }

    /**
     * Método que abre tela da equipe.
     *
     * @throws Exception
     */
    public void equipe() throws Exception {
        new EquipeView().start(new Stage());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login.setTooltip(new Tooltip("Email"));

    }

    public void validaDigitacao() {
        if (senha.getText().length() >= 18) {
            senha.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
        } else {
            senha.setStyle("-fx-background-color: transparent");
        }
        if (login.getText().length() >= 58) {
            login.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
        } else {
            login.setStyle("-fx-background-color: transparent");

        }
    }
}