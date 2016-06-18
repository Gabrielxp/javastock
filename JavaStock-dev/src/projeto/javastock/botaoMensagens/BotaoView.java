package javastock.botaoMensagens;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javastock.principal.PrincipalView;

/**
 * Created by gabri on 18/06/2016.
 */
public class BotaoView extends Application {

    public static String atencao;
    public static String mensagem;
    public static Stage scene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/BotaoMensagens.fxml"));

        primaryStage.setScene(new Scene(root));

        primaryStage.getIcons().add(new Image("img/sacola.png"));
        primaryStage.setTitle("JavaStock Comercial Plataform");
        primaryStage.initOwner(PrincipalView.stage);
        scene = primaryStage;
        primaryStage.show();

        Image image = new Image("img/sacola.png");
        ImageView imageView = new ImageView(image);
        imageView.setVisible(true);
    }

    public BotaoView(String atencao, String mensagem) {
        this.atencao = atencao;
        this.mensagem = mensagem;
    }
    public static void close(){
        scene.close();
    }
}
