package javastock.pessoa.funcionario.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javastock.botaoMensagens.BotaoView;
import javastock.login.InicialControllerView;
import javastock.pessoa.funcionario.Funcionario;
import javastock.pessoa.funcionario.FuncionarioController;
import javastock.pessoa.funcionario.FuncionarioDAO;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * ControllerView do cadastro de Funcionário, mapeando os inputs.
 */
public class CadastroFuncionarioControllerView implements Initializable {
    @FXML
    private TextField nome;
    @FXML
    private TextField senha;
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
    private TextField idfunc;
    @FXML
    private TextField rg;
    @FXML
    private ComboBox funcao;
    @FXML
    private TextField salario;
    @FXML
    private TextField cargaHoraria;
    @FXML
    private TextField regimeTrabalho;
    @FXML
    private TextField telefone;
    @FXML
    private CheckBox status;
    @FXML
    private Button botaoSalvar;
    @FXML
    private TextField idfuncbusca;

    private int idFuncionario = -1;

    public void salvarFuncionario() throws Exception {

        if (idFuncionario == -1) {
            salario.setText(salario.getText().replace(",", "."));
            FuncionarioController.getInstancia().criar(nome.getText(), cpf.getText(), rg.getText(), email.getText(), rua.getText(), Integer.parseInt(numero.getText()), bairro.getText(),
                    cidade.getText(), uf.getText(), cep.getText(), 1, Float.parseFloat(salario.getText()), Float.parseFloat(cargaHoraria.getText()), funcao.getValue().toString(), regimeTrabalho.getText(), senha.getText());
            new BotaoView("Atenção!", "Cadastro Feito com Sucesso").start(new Stage());
            limparFuncionario();
        } else {
            System.out.println(nome.getText()+ "|"+ cpf.getText()+ "|"+ rg.getText()+ "|"+ email.getText()+ "|"+ rua.getText()+ "|"+ Integer.parseInt(numero.getText())+ "|"+ bairro.getText()+ "|"+
                    cidade.getText()+ "|"+ uf.getText()+ "|"+ cep.getText()+ "|"+ 1+ "|"+ Float.parseFloat(salario.getText())+ "|"+ Float.parseFloat(cargaHoraria.getText())+ "|"+ funcao.getValue().toString()+ "|"+ regimeTrabalho.getText()+ "|"+ senha.getText());

            System.out.println("ENTROU AQUI");
            FuncionarioController.getInstancia().salvar(Integer.parseInt(id), nome.getText(), cpf.getText(), rg.getText(), email.getText(), rua.getText(), Integer.parseInt(numero.getText()), bairro.getText(),
                    cidade.getText(), uf.getText(), cep.getText(), 1, Float.parseFloat(salario.getText()), Float.parseFloat(cargaHoraria.getText()), funcao.getValue().toString(), regimeTrabalho.getText(), senha.getText());
          //fazer update
            limparFuncionario();
        }

    }

    public void limparFuncionario() {
        senha.clear();
        telefone.clear();
        nome.clear();
        rua.clear();
        numero.clear();
        bairro.clear();
        cep.clear();
        uf.clear();
        cidade.clear();
        cpf.clear();
        rg.clear();
        salario.clear();
        cargaHoraria.clear();
        regimeTrabalho.clear();
        email.clear();
        idFuncionario = -1;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funcao.getItems().setAll("Vendedor", "Gerente");
        // botaoSalvar.setDisable(true);
    }
    public static String id;
    public void buscarFunc() throws Exception {
        Funcionario funcionario = FuncionarioDAO.getInstancia().getById(Integer.parseInt(idfuncbusca.getText()));
        nome.setText(funcionario.getNome());
        rua.setText(funcionario.getEndereco().getRua());
        numero.setText(funcionario.getEndereco().getNumero() + "");
        bairro.setText(funcionario.getEndereco().getBairro());
        cep.setText(funcionario.getEndereco().getCep());
        uf.setText(funcionario.getEndereco().getUf());
        cidade.setText(funcionario.getEndereco().getCidade());
        cpf.setText(funcionario.getCpf());
        rg.setText(funcionario.getRg());
        salario.setText(funcionario.getSalario() + "");
        cargaHoraria.setText(funcionario.getCargaHoraria() + "");
        regimeTrabalho.setText(funcionario.getRegimeDeTrabalho());
        email.setText(funcionario.getEmail());
        senha.setText(funcionario.getSenha());
        idfunc.setText(funcionario.getIdPessoa()+"");
        status.setSelected(true);
        idFuncionario = funcionario.getIdPessoa();
    }

    public void validaDigitacao() {

//        SALARIO
        if (!salario.getText().matches("^\\d*(\\.\\d{1,2})?$") && !salario.getText().matches("^\\d*(\\,\\d{1,2})?$")) {
            salario.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            salario.setStyle("-fx-background-color: transparent");
            if (salario.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        }
//        CARGA HORARIA
        if (!cargaHoraria.getText().matches("^\\d*(\\.\\d{1,2})?$") && !cargaHoraria.getText().matches("^\\d*(\\,\\d{1,2})?$")) {
            cargaHoraria.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            cargaHoraria.setStyle("-fx-background-color: transparent");
            if (cargaHoraria.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        }
//        REGIME DE TRABALHO
        if (regimeTrabalho.getText().length() >= 40) {
            regimeTrabalho.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            regimeTrabalho.setStyle("-fx-background-color: transparent");
            if (regimeTrabalho.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
        }
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
//        SENHA
        if (senha.getText().length() >= 18) {
            senha.setStyle("-fx-background-color: rgba(255, 41, 26, 0.41)");
            botaoSalvar.setDisable(true);
        } else {
            if (senha.getText().equals("")) {
                botaoSalvar.setDisable(true);
            } else {
                botaoSalvar.setDisable(false);
            }
            senha.setStyle("-fx-background-color: transparent");
        }

    }

}
