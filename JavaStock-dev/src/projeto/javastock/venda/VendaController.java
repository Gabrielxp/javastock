package javastock.venda;

import javastock.misc.DAO;
import javastock.produto.Produto;
import javastock.produto.ProdutoDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param carrinho Map contendo o ID do produto no carrinho e sua quantidade.
     * @param desconto   Desconto da venda;
     * @param idVendedor  ID do funcionario que realizou a venda.
     */
    public void criar(Map<Integer, Integer> carrinho, double desconto, int idVendedor) {

        List<Produto> produtos = ProdutoDAO.getInstancia().listar();

        Map<Produto, Integer> nCarrinho = new HashMap<>();

        // @TODO Otimizar isso.
        for (Map.Entry<Integer, Integer> item : carrinho.entrySet()) {
            int idProduto = item.getKey();
            for (Produto produto : produtos) {
                if (produto.getIdProduto() == idProduto) {
                    int quantidade = item.getValue();
                    nCarrinho.put(produto, quantidade);
                }
            }
        }

        Venda venda = new Venda(desconto, idVendedor, nCarrinho);

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
