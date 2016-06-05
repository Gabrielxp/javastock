package javastock.misc;

import java.sql.*;

/**
 * Classe responsavel por criar a conexao com o banco de dados.
 */
public class DatabaseFactory {

    private final Config config = LocalConfig.getInstancia();

    /**
     * @return Conexao com o banco.
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        String endereco = "jdbc:postgresql://" + this.config.getEnderecoBD();
        String usuario = this.config.getUsuarioBD();
        String senha = this.config.getSenhaBD();

        return DriverManager.getConnection(endereco, usuario, senha);
    }

}
