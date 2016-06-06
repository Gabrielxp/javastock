package javastock.venda;

import javastock.misc.DAO;

import java.util.List;

/**
 * Controller de vendas.
 */
public class VendaController {

    private final static VendaController instancia = new VendaController();

    private VendaController() {}

    /**
     * Singleton
     * @return Instancia de VendaController
     */
    public static VendaController getInstancia(){
        return instancia;
    }

    private DAO<Venda> vendaDAO = VendaDAO.getInstancia();

    /**
     * Cria nova venda e salva no banco de dados.
     * @param data       Data da venda.
     * @param quantidade Quantidade de produtos.
     * @param carrinho   Carrinho com todos os produtos inclusos na venda e a quantidade de cada um.
     * @param desconto   Desconto da venda;
     * @param valorVenda Valor da venda.
     * @param orcamento  Valor orçamento.
     */

    public void criar(Date data, int quantidade, Map carrinho, double desconto, double valorVenda, double orcamento) {
        Venda venda = new Venda(data, quantidade, carrinho, desconto, valorVenda, orcamento);

        this.vendaDAO.salvar(venda);
    }

    /**
     * Lista todas as vendas contidas no banco de dados.
     * @return Lista de vendas
     */
    public List<Venda> listar() {
        return this.vendaDAO.listar();
    }
}
