package javastock.produto.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProdutoView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("CadastroProdutos.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("sacola.png"));
        primaryStage.setTitle("JavaStock Comercial Plataform");
        primaryStage.show();
        Image image = new Image("sacola.png");
        ImageView imageView = new ImageView(image);
        imageView.setVisible(true);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
