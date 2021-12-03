package DAO;

import model.Galeria;
import model.InfoContato;

import java.sql.SQLException;
import java.util.ArrayList;

public class InfoContatoDAO extends ConnectionDAO {
    private boolean check = false;       // variável interna para confirmação de métodos do CRUD

    // ----------------------------INSERINDO NOVO REGISTRO----------------------------
    public boolean insertContato(InfoContato ctt){
        connectToDB();
        String sql = "INSERT INTO info_contato(telefone, email, endereco) VALUES(?, ?, ?)";
        try {

            pst = con.prepareStatement(sql);
            pst.setString(1, ctt.getTelefone());      // concatena nome na primeira ? do comando
            pst.setString(2, ctt.getEmail());        // concatena nome na segunda ? do comando
            pst.setString(3, ctt.getEndereco());
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

    // ----------------------------BUSCANDO TODOS REGISTROS----------------------------
    public ArrayList<InfoContato> researchContato(){
        connectToDB();
        ArrayList<InfoContato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM info_contato";
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                InfoContato cttTemp = new InfoContato(rs.getString("telefone"), rs.getString("email"), rs.getString("endereco"));
                System.out.println("Email = " + cttTemp.getEmail());
                System.out.println("Telefone = " + cttTemp.getTelefone());
                System.out.println("Endereco = " + cttTemp.getEndereco());
                System.out.println("------------------------------");
                contatos.add(cttTemp);
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
        return contatos;
    }

    // --------------------------BUSCANDO REGISTRO PELO EMAIL------------------------------
    public ArrayList<Galeria> researchGaleriaEmail(String email){
        connectToDB();
        ArrayList<Galeria> galerias = new ArrayList<>();
        String sql = "SELECT * FROM galeria WHERE info_contato_email = '" + email + "'";
        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while(rs.next()){
                Galeria galeria = new Galeria(rs.getString("nome_galeria"), rs.getString("nome_gerente"));
                galeria.setIdGaleria(rs.getInt("idGaleria"));
                System.out.println("ID = " + galeria.getIdGaleria());
                System.out.println("Nome = " + galeria.getNome_galeria());
                System.out.println("Gerente = " + galeria.getNome_gerente());
                System.out.println("------------------------------");
                galerias.add(galeria);
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
        return galerias;
    }

    // ----------------------------ATUALIZANDO ENDEREÇO NO REGISTRO----------------------------
    public boolean updateEnderecoGaleria(String email, String novoEndereco){
        connectToDB();
        String sql = "UPDATE info_contato SET nome=? WHERE email=?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, novoEndereco);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                con.close();
                pst.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }


}
