package javastock.pessoa.funcionario.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Created by gabri on 17/06/2016.
 */
public class EdicaoFuncionarioView  extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/EdicaoFuncionarios.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("img/sacola.png"));
        primaryStage.setTitle("JavaStock Comercial Plataform");
        primaryStage.setFullScreen(true);
        primaryStage.show();
        Image image = new Image("img/sacola.png");
        ImageView imageView = new ImageView(image);
        imageView.setVisible(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
