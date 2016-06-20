package javastock.pessoa.cliente.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javastock.botaoMensagens.BotaoView;
import javastock.pessoa.cliente.ClienteController;
import javastock.principal.PrincipalView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by gabri on 18/06/2016.
 */
public class CadastroClienteControllerView implements Initializable {
    @FXML
    private TextField nome;
    @FXML
    private TextField rua;
    @FXML
    private TextField numero;
    @FXML
    private TextField bairro;
    @FXML
    private TextField cep;
    @FXML
    private TextField uf;
    @FXML
    private TextField email;
    @FXML
    private TextField cidade;
    @FXML
    private TextField cpf;
    @FXML
    private TextField rg;
    @FXML
    private TextField telefone;
    @FXML
    private  Button botaoSalvar;

    @FXML
    private Label labelSucesso;

    public void salvarCliente() throws Exception {

        if (ClienteController.getInstancia().criar(nome.getText(), cpf.getText(), rg.getText(), email.getText(), rua.getText(), Integer.parseInt(numero.getText()), bairro.getText(), cidade.getText(), uf.getText(), cep.getText(), 1) != -1) {

            new BotaoView("Atenção!", "Cadastro Feito com Sucesso").start(new Stage());

            limparCliente();
        }

    }

    public void limparCliente() {
        nome.clear();
        rua.clear();
        numero.clear();
        bairro.clear();
        cep.clear();
        uf.clear();
        cidade.clear();
        cpf.clear();
        rg.clear();
        email.clear();
        telefone.clear();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void validaDigitacao() {
        System.out.println("VALIDOU");
//        EMAL
        if (email.getText().length() >= 60) {
            email.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            email.setStyle("-fx-background-color: transparent");
            if (email.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        }
        //        NOME
        if (nome.getText().length() >= 100) {
            nome.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            nome.setStyle("-fx-background-color: transparent");
            if (nome.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        }
//        TELEFONE
        if (!telefone.getText().matches("[0-9]+")) {
            if (!telefone.getText().equals("")) {
                telefone.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
                botaoSalvar.setDisable(true);
            }
            if (telefone.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        } else if (telefone.getText().length() >= 15) {
            telefone.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            telefone.setStyle("-fx-background-color: transparent");
            if (telefone.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        }
//        RUA
        if (rua.getText().length() >= 100) {
            rua.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            if (rua.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
            rua.setStyle("-fx-background-color: transparent");
        }
//        NUMERO
        if (!numero.getText().matches("[0-9]+")) {
            if (!numero.getText().equals("")) {
                numero.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            }
            botaoSalvar.setDisable(true);
        } else {
            if (numero.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
            numero.setStyle("-fx-background-color: transparent");
        }
//        BAIRRO
        if (bairro.getText().length() >= 30) {
            bairro.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            if (bairro.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
            bairro.setStyle("-fx-background-color: transparent");
        }
//        CEP
        if (cep.getText().length() >= 15) {
            cep.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            cep.setStyle("-fx-background-color: transparent");
            if (cep.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        }
//        UF
        if (uf.getText().length() >= 3) {
            uf.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            uf.setStyle("-fx-background-color: transparent");
            if (uf.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        }
//        CIDADE
        if (cidade.getText().length() >= 28) {
            cidade.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            cidade.setStyle("-fx-background-color: transparent");
            if (cidade.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        }
//        CPF
        if (cpf.getText().length() >= 15) {
            cpf.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            cpf.setStyle("-fx-background-color: transparent");
            if (cpf.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        }
//        RG
        if (rg.getText().length() >= 15) {
            rg.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            rg.setStyle("-fx-background-color: transparent");
            if (rg.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        }

    }
}
