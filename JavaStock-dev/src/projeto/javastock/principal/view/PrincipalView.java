package javastock.principal.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by gabri on 16/05/2016.
 */
public class PrincipalView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("TelaPrincipalSoftware.fxml"));
        root.setStyle(String.format("-fx-background-image: url('javastock/login/view/img/LogoJavaStock.png'); -fx-background-size: cover;"));
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("sacola.png"));
        primaryStage.setTitle("JavaStock Comercial");
        primaryStage.show();

    }
}
