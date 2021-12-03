package DAO;

import model.Galeria;

import java.sql.SQLException;

public class GaleriaDAO extends ConnectionDAO {
    private boolean check = false;       // variável interna para confirmação de métodos do CRUD

    // ----------------------------EXCLUINDO REGISTRO----------------------------
    public boolean deleteGaleria(int id) {
        connectToDB();
        String sql = "DELETE FROM galeria WHERE idGaleria=?";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                con.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}
