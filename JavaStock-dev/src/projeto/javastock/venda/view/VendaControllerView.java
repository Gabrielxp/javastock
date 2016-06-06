package javastock.venda.view;

import javastock.venda.VendaController;

import java.util.HashMap;
import java.util.Map;

/**
 * ControllerView de vendas, mapeando os inputs.
 */
public class VendaControllerView {
    public void salvarVenda(){
        // Map<IdProduto, quantidade>
        Map<Integer, Integer> carrinho = new HashMap<>();
        carrinho.put(1, 3);
        carrinho.put(2, 4);

        double desconto = .2;
        int idVendedor = 1;

        // Ter certeza que todos os IDs existam no banco.
        VendaController.getInstancia().criar(carrinho, desconto, idVendedor);

    }
    public void limparFuncionario(){

    }
}
