package javastock.login;

import javastock.misc.DatabaseFactory;
import javastock.misc.Endereco;
import javastock.pessoa.funcionario.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gabri on 14/06/2016.
 */
public class LoginDAO {

    public Funcionario logar(Login login) throws SQLException {
        Funcionario funcionario = null;
        try (Connection con = this.getConnection()) {

            String sql = "SELECT p.NOME, F_ID_PESSOA, FUNCAO FROM FUNCIONARIO as f " +
                    "inner join pessoa as p on p.id_pessoa = f.f_id_pessoa " +
                    " WHERE p.EMAIL = ? AND f.SENHA = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, login.getEmail());
            pstm.setString(2, login.getSenha());

            ResultSet resultSet = pstm.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("NOME");
                int id = resultSet.getInt("F_ID_PESSOA");
                int funcao = resultSet.getInt("FUNCAO");

                String func;
                if (funcao == 1) {
                    func = "vendedor";
                } else {
                    func = "gerente";
                }
                System.out.println(nome + id + funcao);
                funcionario = new Funcionario(id, nome, "1", "1", "1", new Endereco("1", 1, "1", "1", "1", "1"), 1, 1, 20, func, "1", "1");
            }

            pstm.close();

            return funcionario;
        } catch (Exception e) {
            System.err.print(e);

        }

        return null;
    }

    private Connection getConnection() throws SQLException {
        return new DatabaseFactory().getConnection();
    }


}
