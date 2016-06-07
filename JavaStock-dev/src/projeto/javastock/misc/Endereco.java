package javastock.misc;

/**
 * Endereco de uma pessoa.
 */
public class Endereco {

    private String rua;
    private int numero;
    private String  bairro;
    private String cidade;
    private String uf;
    private String cep;

    /**
     * Cria um novo endereco.
     * @param rua Rua do endereco.
     * @param numero Numero do endereco.
     * @param bairro Bairro do endereco.
     * @param cidade Cidade do endereco.
     * @param uf Sigla do estado do endereco.
     * @param cep CEP do endereco.
     */
    public Endereco(String rua, int numero, String bairro, String cidade, String uf, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    /**
     * Obtem o nome rua do endereco.
     * @return Nome da rua.
     */
    public String getRua() {
        return rua;
    }

    /**
     * Altera a rua do endereco.
     * @param rua Nova rua.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setRua(String rua) {
        if (rua == null || rua.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.rua = rua;
    }

    /**
     * Obtem o numero endereco.
     * @return Numero do endereco.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Altera o numero endereco.
     * @param numero Novo numero.
     * @throws RuntimeException Caso o valor informado for menor que zero.
     */
    public void setNumero(int numero) {
        if (numero < 0)
            throw new RuntimeException("Numero nao pode ser negativo");

        this.numero = numero;
    }

    /**
     * Obtem o bairro do endereco.
     * @return Bairro do endereco.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Altera o bairro do endereco.
     * @param bairro Novo bairro.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setBairro(String bairro) {
        if (bairro == null || bairro.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.bairro = bairro;
    }

    /**
     * Obtem a cidade do endereco.
     * @return Cidade do endereco.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Altera a cidade do endereco.
     * @param cidade Nova cidade.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setCidade(String cidade) {
        if (cidade == null || cidade.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.cidade = cidade;
    }

    /**
     * Obtem a sigla do estado do endereco.
     * @return UF endereco.
     */
    public String getUf() {
        return uf;
    }

    /**
     * Altera a UF do endereco.
     * @param uf Nova uf.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setUf(String uf) {
        if (uf == null || uf.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.uf = uf;
    }

    /**
     * Obtem o CEP do endereco.
     * @return CEP do endereco.
     */
    public String getCep() {
        return cep;
    }

    /**
     * Altera o CEP do endereco.
     * @param cep Novo CEP.
     * @throws RuntimeException Caso o valor informado for vazio ou nulo.
     */
    public void setCep(String cep) {
        if (cep == null || cep.equals(""))
            throw new RuntimeException("Este campo é obrigatorio");

        this.cep = cep;
    }
}
