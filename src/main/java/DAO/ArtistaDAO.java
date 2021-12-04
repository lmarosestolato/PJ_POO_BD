package DAO;

import model.Artista;
import model.Obra;

import java.sql.SQLException;

public class ArtistaDAO extends ConnectionDAO {
    private boolean check = false;       // variável interna para confirmação de métodos do CRUD

    // ----------------------------INSERINDO NOVO REGISTRO----------------------------
    public boolean insertArtista(Artista artista){
        connectToDB();
        String sql = "INSERT INTO artista(idArtista, nome_artista) VALUES(?, ?)";
        try {

            pst = con.prepareStatement(sql);
            pst.setInt(1, artista.getIdArtista());
            pst.setString(2, artista.getNome_artista());

            pst.execute();                           // executa o comando
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                con.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

}
