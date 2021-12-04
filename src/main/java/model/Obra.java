package model;

public class Obra {
    private int idObra;
    private String nomeObra;
    private String tipo;
    private String local_origem;
    private int ano_criacao;
    private String material;
    private String tecnica;
    private String movimento;
    private Artista artista;

    public Obra(String nome_obra, String tipo, String local_origem, int ano_criacao, String material,
                String tecnica, String movimento) {
        this.nomeObra = nome_obra;
        this.tipo = tipo;
        this.local_origem = local_origem;
        this.ano_criacao = ano_criacao;
        this.material = material;
        this.tecnica = tecnica;
        this.movimento = movimento;
    }

    public Obra() {

    }

    public String getNomeObra() { return nomeObra; }

    public void setNomeObra(String nomeObra) { this.nomeObra = nomeObra; }
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocal_origem() {
        return local_origem;
    }

    public void setLocal_origem(String local_origem) {
        this.local_origem = local_origem;
    }

    public int getAno_criacao() {
        return ano_criacao;
    }

    public void setAno_criacao(int ano_criacao) {
        this.ano_criacao = ano_criacao;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getMovimento() {
        return movimento;
    }

    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) { this.artista = artista; }

    @Override
    public String toString(){
        return "--------------- NEW ART ----------------\n" +
                "id: " + idObra + "\n" +
                "Nome: " + nomeObra + "\n" +
                "Tipo: " + tipo + "\n" +
                "Local de origem: " + local_origem + "\n" +
                "Ano de criação: " + ano_criacao + "\n" +
                "Material: " + material + "\n" +
                "Técnica: " + tecnica + "\n" +
                "Movimento Artistico: " + movimento + "\n" +
                "Artista: " + artista.getNome_artista();

    }
}
