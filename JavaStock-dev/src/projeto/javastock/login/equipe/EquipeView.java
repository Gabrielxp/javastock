package javastock.login.equipe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Equipe View, com informações da equipe.
 */
public class EquipeView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Equipe.fxml"));
        root.setStyle(
                String.format("-fx-background-image: url('img/Javali.png'); -fx-background-size: cover;")
        );

        primaryStage.setScene(new Scene(root));

        primaryStage.setTitle("Equipe JavaStock - UTFPR DV");
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
