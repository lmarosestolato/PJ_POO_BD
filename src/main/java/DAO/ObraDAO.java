package DAO;

import model.Galeria;
import model.InfoContato;
import model.Obra;

import java.sql.SQLException;
import java.util.ArrayList;

public class ObraDAO extends ConnectionDAO {
    private boolean check = false;       // variável interna para confirmação de métodos do CRUD

    // ----------------------------INSERINDO NOVO REGISTRO----------------------------
    public boolean insertObra(Obra obra){
        connectToDB();
        String sql = "INSERT INTO obra(nome_obra, tipo, local_origem, ano_criacao, material, tecnica, movimento, artista_idArtista) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            pst = con.prepareStatement(sql);
            pst.setString(1, obra.getNomeObra());
            pst.setString(2, obra.getTipo());
            pst.setString(3, obra.getLocal_origem());
            pst.setInt(4, obra.getAno_criacao());
            pst.setString(5, obra.getMaterial());
            pst.setString(6, obra.getMaterial());
            pst.setString(7, obra.getTecnica());
            pst.setInt(8, obra.getArtista().getIdArtista());

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

    // --------------------------BUSCANDO REGISTRO PELO ARTISTA------------------------------
    public ArrayList<Obra> researchObraArtista(int idArtista){
        connectToDB();
        ArrayList<Obra> obras = new ArrayList<>();
        String sql = "SELECT * FROM obra WHERE artista_idArtista = '" + idArtista + "'";
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                Obra obra = new Obra(rs.getString("nome_obra"), rs.getString("tipo"),
                        rs.getString("local_origem"), rs.getInt("ano_criacao"),
                        rs.getString("material"), rs.getString("tecnica"),
                        rs.getString("movimento"));
                obra.setIdObra(rs.getInt("idObra"));
                System.out.println("ID = " + obra.getIdObra());
                System.out.println("Nome = " + obra.getNomeObra());
                System.out.println("Tipo = " + obra.getTipo());
                System.out.println("Localizacao = " + obra.getLocal_origem());
                System.out.println("Ano de criacao = " + obra.getAno_criacao());
                System.out.println("Material = " + obra.getMaterial());
                System.out.println("Tecnica = " + obra.getTecnica());
                System.out.println("Movimento Artistico = " + obra.getMovimento());
                System.out.println("------------------------------");
                obras.add(obra);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                con.close();
                st.close();
                rs.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return obras;
    }
}
