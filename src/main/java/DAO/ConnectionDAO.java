package DAO;

import java.sql.*;

public abstract class ConnectionDAO {
    Connection con;   // objeto responsável por fazer a conexão com o servidor do MySQL
    Statement st;     // objeto responsável por preparar consultas "SELECT"
    ResultSet rs;        // objeto responsável por executar consultas "SELECT"
    PreparedStatement pst;   // objeto responsável por preparar querys de manipulação dinâmicas (INSERT, UPDATE, DELETE)

    static final String user = "root";                  // usuário da instância local do servidor
    static final String password = "root";    // senha do usuário da instância local do servidor
    static final String database = "projetoGaleria";           // nome do banco de dados a ser utilizado

    // string com URL de conexão com servidor
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

    public void connectToDB(){
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso: " + con);
        }catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage());
        }

    }
}
