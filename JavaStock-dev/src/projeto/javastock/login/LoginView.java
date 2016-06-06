package javastock.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Classe View do Login.
 */
public class LoginView extends Application {
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TelaLogin.fxml"));
        root.setStyle(
                String.format("-fx-background-image: url('img/LogoJavaStock.png'); -fx-background-size: cover;")
        );
        stage = primaryStage;
        primaryStage.setScene(new Scene(root));
        primaryStage.setFullScreen(true);

        primaryStage.getIcons().add(new Image("img/sacola.png"));
        primaryStage.setTitle("JavaStock Comercial Plataform");
        primaryStage.show();
        Image image = new Image("img/sacola.png");
        ImageView imageView = new ImageView(image);
        imageView.setVisible(true);


    }

    public static void close() {
        stage.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
