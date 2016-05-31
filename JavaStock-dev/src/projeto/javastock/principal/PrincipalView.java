package javastock.principal;

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

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TelaPrincipalSoftware.fxml"));
        root.setStyle(String.format("-fx-background-image: url(''); -fx-background-size: cover;"));
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("img/sacola.png"));
        primaryStage.setTitle("JavaStock Comercial");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
