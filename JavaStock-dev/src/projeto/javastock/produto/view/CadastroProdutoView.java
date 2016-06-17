package javastock.produto.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javastock.produto.Produto;

/**
 * View de CadastroProduto.
 */
public class CadastroProdutoView extends Application {
    public static Produto produtoParaEditar;
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/fxml/EdicaoProdutos.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("img/sacola.png"));
        primaryStage.setTitle("JavaStock Comercial Plataform");
        primaryStage.setFullScreen(true);
        stage = primaryStage;
        primaryStage.show();
        Image image = new Image("img/sacola.png");
        ImageView imageView = new ImageView(image);
        imageView.setVisible(true);


    }

    public CadastroProdutoView() {
    }

    public CadastroProdutoView(Produto produto) {
        produtoParaEditar = produto;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void close() {
        stage.close();

    }
}
