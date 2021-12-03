package model;

public class Galeria {
    private int idGaleria;
    private String nome_galeria;
    private String nome_gerente;
    private int num_func;
    private InfoContato contato;

    public Galeria(String nome_galeria, String nome_gerente, int num_func) {
        this.nome_galeria = nome_galeria;
        this.nome_gerente = nome_gerente;
        this.num_func = num_func;
    }

    public int getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(int idGaleria) {
        this.idGaleria = idGaleria;
    }

    public String getNome_galeria() {
        return nome_galeria;
    }

    public void setNome_galeria(String nome_galeria) {
        this.nome_galeria = nome_galeria;
    }

    public String getNome_gerente() {
        return nome_gerente;
    }

    public void setNome_gerente(String nome_gerente) {
        this.nome_gerente = nome_gerente;
    }

    public int getNum_func() {
        return num_func;
    }

    public void setNum_func(int num_func) {
        this.num_func = num_func;
    }

    public InfoContato getContato() {
        return contato;
    }

    public void setContato(InfoContato contato) {
        this.contato = contato;
    }

    @Override
    public String toString(){
        return "--------------- NEW GALLERY ----------------\n" +
                "id: " + idGaleria + "\n" +
                "Nome: " + nome_galeria + "\n" +
                "Gerente: " + nome_gerente + "\n" +
                "Numero de funcionarios: " + num_func;
    }
}
