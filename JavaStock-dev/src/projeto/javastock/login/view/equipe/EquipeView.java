package javastock.login.view.equipe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EquipeView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{



        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.setStyle(
                String.format("-fx-background-image: url('javastock/login/view/equipe/Javali.png'); -fx-background-size: cover;")
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