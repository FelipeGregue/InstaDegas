import java.util.ArrayList;

public class ListaUsuario {
    static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void criarUsuario(String nome, String email, String senha, ArrayList<Usuario> usuarios){

        if(Main.verificaUsuarioExistente(nome, usuarios)){
            Usuario user = new Usuario(nome, email, senha);
            usuarios.add(user);
            System.out.println("Usuario criado com sucesso!");
        }else{
            System.out.println("Usuario ja existe!");
        }
    }

    public static void removerUsuario(ArrayList<Usuario> usuarios, int retorno){
        Usuario.getAmigos().clear();
        Usuario.getSessoes().clear();
        usuarios.remove(retorno);
        System.out.println("Usuario removido com sucesso!");
    }
}
