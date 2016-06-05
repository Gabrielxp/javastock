package javastock.misc;

class LocalConfig implements Config {

    private static final Config instancia = new LocalConfig();

    private LocalConfig() {}

    /**
     * Sigleton.
     * @return Instancia da classe.
     */
    static Config getInstancia() {
        return instancia;
    }

    public String getEnderecoBD() {
        throw new RuntimeException("Trocar dados do banco e remover essa linha");
        return "localhost:5432/teste";
    }

    public String getUsuarioBD() {
        return "postgres";
    }

    public String getSenhaBD() {
        return "";
    }

}
