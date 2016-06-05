package javastock.misc;

/**
 * Contem dados de configuracao.
 */
interface Config {

    /**
     * @return URL da banco de dados.
     */
    String getEnderecoBD();

    /**
     * @return Usuario do banco de dados.
     */
    String getUsuarioBD();

    /**
     * @return Senha do banco de dados.
     */
    String getSenhaBD();
}
