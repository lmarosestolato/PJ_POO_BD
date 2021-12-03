package model;

public class Artista {
    private int idArtista;
    private String nome_artista;
    private String data_nasc;
    private String data_morte;
    private String naturalidade;
    private String estilo;

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNome_artista() {
        return nome_artista;
    }

    public void setNome_artista(String nome_artista) {
        this.nome_artista = nome_artista;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getData_morte() {
        return data_morte;
    }

    public void setData_morte(String data_morte) {
        this.data_morte = data_morte;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString(){
        return "--------------- NEW ARTIST ----------------\n" +
                "Nome: " + nome_artista + "\n" +
                "Data de nascimento: " + data_nasc + "\n" +
                "Data de morte: " + data_morte + "\n" +
                "Naturalidade: " + naturalidade + "\n" +
                "Estilo: " + estilo;
    }
}
