package javastock.misc;

import java.util.List;

/**
 * Responsavel por fazer operacoes no banco de dados.
 */
public interface DAO<T extends Entidade> {
    /**
     * Salva entidade no banco dados. Caso possua um ID, atualiza tupla,
     * caso contraria uma nova.
     * @param entidade Registro a ser salvo.
     */
    void salvar(T entidade);

    /**
     * Recupera todos os registros da banco.
     * @return Lista de registros encontrados.
     */
    List<T> listar();
}

