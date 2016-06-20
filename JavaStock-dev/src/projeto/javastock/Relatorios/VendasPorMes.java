package javastock.Relatorios;

import javastock.misc.DatabaseFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsavel por gerar relatorios de vendas por mes.
 */
public class VendasPorMes {

    /**
     * Calcula o numero total de vendas ocorridas no mes informado.
     * @param numeroDoMes Numero do mes das vendas (1 = jan / 12 = dez).
     * @param numeroDoAno Ano das vendas. Ex: 2016.
     * @return Soma da quantidade de vendas.
     */
    public static int calcular(int numeroDoMes, int numeroDoAno) {
        String sql = "SELECT COUNT(*) as quantidade FROM Venda WHERE EXTRACT(MONTH FROM data) = ?" +
                " AND EXTRACT(YEAR FROM data) = ?";
        int quantidade = 0;

        try (Connection connection = getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, numeroDoMes);
            stmt.setInt(2, numeroDoAno);
            ResultSet registros = stmt.executeQuery();
            registros.next();
            quantidade = registros.getInt("quantidade");


        } catch (SQLException e) {
            System.out.print(e);
        }

        return quantidade;
    }

    /**
     * Metodo para conectar na base de dados.
     *
     * @return
     * @throws SQLException
     */
    private static Connection getConnection() throws SQLException {
        return new DatabaseFactory().getConnection();
    }

}
