package javastock.login;

import javastock.pessoa.funcionario.Funcionario;

import java.sql.SQLException;

/**
 * Created by gabri on 14/06/2016.
 */
public class LoginController {
    public static Funcionario logar(Login login) throws SQLException {
        LoginDAO loginDAO = new LoginDAO();
       return loginDAO.logar(login);
    }
}
