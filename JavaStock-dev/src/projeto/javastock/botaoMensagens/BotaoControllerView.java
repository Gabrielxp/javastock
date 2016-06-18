package javastock.botaoMensagens;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gabri on 18/06/2016.
 */
public class BotaoControllerView implements Initializable {
    @FXML
    Label atencao;
    @FXML
    Label mensagem;
    @FXML
    ImageView alert;

    public boolean ok() {
        BotaoView.close();
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        atencao.setStyle("-fx-font-weight: bold");
        atencao.setText(BotaoView.atencao);
        mensagem.setText(BotaoView.mensagem);
    }

}
