package javastock.Relatorios;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Header;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javastock.misc.DatabaseFactory;

import java.io.FileOutputStream;
import java.io.IOException;
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
     * Gera documento em PDF com relatorio de vendas por mes do ano informado.
     * @param ano Ano do relatorio.
     */
    public static void gerarRelatorio(int ano) {

        String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };

        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream("./vendas por mes.pdf"));
            doc.open();

            doc.add(new Paragraph("Vendas por mês - " + ano));


            for (int i = 0; i < 12; i++)
                doc.add(new Paragraph(meses[i] + ": " + calcular(i + 1, ano)));

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        doc.close();
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
