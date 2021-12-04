import DAO.GaleriaDAO;
import DAO.InfoContatoDAO;
import DAO.ObraDAO;
import model.Artista;
import model.Galeria;
import model.InfoContato;
import model.Obra;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int op;
        Artista artAux = new Artista();
        GaleriaDAO gDAO = new GaleriaDAO();
        InfoContatoDAO icDAO = new InfoContatoDAO();
        ObraDAO oDAO = new ObraDAO();

        System.out.println("O que deseja fazer?");
        System.out.println("1) Deletar uma galeria");
        System.out.println("2) Atualizar endereco da galeria");
        System.out.println("3) Buscar galeria pelo email");
        System.out.println("4) Buscar contato de todas as galerias");
        System.out.println("5) Inserir uma nova informacao de contato");
        System.out.println("6) Inserir uma obra");
        System.out.println("7) Buscar todas as obras disponiveis por artista");
        System.out.println("0) Finalizar operação");
        System.out.println("-------------------------------------------------------");

        System.out.print("Digite o numero da operação: ");
        op = sc.nextInt();

        while(op != 0){
            String email;
            String end;
            switch (op){
                case 1:
                    System.out.print("Digite a id da Galeria que quer deletar: ");
                    int id_galeria = sc.nextInt();
                    if(gDAO.deleteGaleria(id_galeria)){
                        System.out.println("Galeria deletada com sucesso.");

                    }
                    else System.out.println("Ocorreu um problema, tente novamente mais tarde.");
                    break;
                case 3:
                    System.out.println("Digite o email que deseja buscar: ");
                    email = sc.next();
                    ArrayList<Galeria> galerias = icDAO.researchGaleriaEmail(email);
                    if(galerias.isEmpty()) System.out.println("Nenhum registro encontrado.");
                    break;
                case 2:
                    System.out.println("Digite o email da galeria: ");
                    email = sc.next();
                    sc.nextLine();
                    System.out.println("Digite o novo endereço: ");
                    end = sc.nextLine();
                    if(icDAO.updateEnderecoGaleria(email, end)){
                        System.out.println("Endereço atualizado com sucesso.");
                    }
                    else System.out.println("Ocorreu um problema, tente novamente mais tarde.");
                    break;
                case 4:
                    System.out.println("Buscando contato de galerias...");
                    ArrayList<InfoContato> contatos = icDAO.researchContato();
                    if(contatos.isEmpty()) System.out.println("Nenhum registro encontrado.");
                    break;
                case 5:
                    InfoContato ctt = new InfoContato();
                    System.out.print("Digite um telefone: ");
                    sc.nextLine();
                    ctt.setTelefone(sc.nextLine());
                    System.out.print("Digite um email: ");
                    //sc.nextLine();
                    ctt.setEmail(sc.next());
                    System.out.println("Digite um endereço: ");
                    sc.nextLine();
                    ctt.setEndereco(sc.nextLine());
                    if(icDAO.insertContato(ctt)){
                        System.out.println("Novas informações salvas com sucesso.");
                    }
                    else System.out.println("Ocorreu um problema, tente novamente mais tarde.");
                    break;
                case 7:
                    System.out.print("Digite a id do artista: ");
                    int idArt = sc.nextInt();
                    System.out.println("Buscando obras...");
                    ArrayList<Obra> obras = oDAO.researchObraArtista(idArt);
                    if(obras.isEmpty()) System.out.println("Nenhum registro encontrado.");
                    break;
                case 6:
                    Obra oAux = new Obra();
                    System.out.print("Digite o nome da obra: ");
                    sc.nextLine();
                    oAux.setNomeObra(sc.nextLine());
                    System.out.print("Digite o tipo de obra: ");
                    sc.nextLine();
                    oAux.setTipo(sc.nextLine());
                    System.out.print("Digite o local de origem da obra: ");
                    sc.nextLine();
                    oAux.setLocal_origem(sc.nextLine());
                    System.out.print("Digite o ano de criação: ");
                    oAux.setAno_criacao(sc.nextInt());
                    System.out.print("Digite o material utilizado: ");
                    sc.nextLine();
                    oAux.setMaterial(sc.nextLine());
                    System.out.print("Digite a técnica utilizada: ");
                    sc.nextLine();
                    oAux.setTecnica(sc.nextLine());
                    System.out.print("Digite o movimento artístico da obra: ");
                    sc.nextLine();
                    oAux.setMovimento(sc.nextLine());
                    System.out.print("Digite o nome do artista: ");
                    sc.nextLine();
                    artAux.setNome_artista(sc.nextLine());
                    oAux.setArtista(artAux);

                    if(oDAO.insertObra(oAux)){
                        System.out.println("Obra inserida com sucesso");
                    }
                    else System.out.println("Ocorreu um problema, tente novamente mais tarde.");
                    break;
            }
            System.out.println("-------------------------------------------------------");
            System.out.print("Digite o numero da operação: ");
            op = sc.nextInt();
            sc.nextLine();
        }
    }
}
