package model;

public class Exposicao {
    private int idExposicao;
    private String data;
    private Galeria galeria;

    public int getIdExposicao() {
        return idExposicao;
    }

    public void setIdExposicao(int idExposicao) {
        this.idExposicao = idExposicao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Galeria getGaleria() {
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }

    @Override
    public String toString(){
        return "--------------- NEW EXPOSURE ----------------\n" +
                "Id: " + idExposicao + "\n" +
                "Data: " + data + "\n" +
                "Galeria: " + galeria.getNome_galeria();
    }
}
