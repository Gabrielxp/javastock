package javastock.venda.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Created by gabri on 05/06/2016.
 */
public class VendaView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TelaVendaFcx.fxml"));
        root.setStyle(
                String.format("-fx-background-image: url('img/telaVenda.png'); -fx-background-size: cover;")
        );
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("img/sacola.png"));
        primaryStage.setTitle("JavaStock Comercial Plataform");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
