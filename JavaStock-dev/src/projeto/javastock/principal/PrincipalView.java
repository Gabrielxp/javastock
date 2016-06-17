package javastock.principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javastock.pessoa.funcionario.Funcionario;

/**
 * Created by gabri on 16/05/2016.
 */
public class PrincipalView extends Application {
    public static Funcionario funcionarioLogado;
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TelaPrincipalSoftware.fxml"));
        root.setStyle(String.format("-fx-background-image: url(''); -fx-background-size: cover;"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setFullScreen(true);
        primaryStage.getIcons().add(new Image("img/sacola.png"));
        primaryStage.setTitle("JavaStock Comercial");
        stage = primaryStage;
        primaryStage.show();

    }

    public PrincipalView(Funcionario funcionario) {
        this.funcionarioLogado = funcionario;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
