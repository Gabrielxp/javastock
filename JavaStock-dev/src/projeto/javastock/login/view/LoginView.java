package javastock.login.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{



        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.setStyle(
                String.format("-fx-background-image: url('javastock/login/view/img/LogoJavaStock.png'); -fx-background-size: cover;")
        );

        primaryStage.setScene(new Scene(root));

        primaryStage.setTitle("Login JavaStock");
        primaryStage.show();
        Image image = new Image("javastock/login/view/img/LogoJavaStock.png");
        ImageView imageView = new ImageView(image);
        imageView.setVisible(true);



    }


    public static void main(String[] args) {
        launch(args);
    }
}
