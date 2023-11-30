
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Usuario {
    private String nome, email, senha;
    private static ArrayList<String> postagens;
    private static ArrayList<Usuario> amigos;
    private static ArrayList<Sessao> sessoes;
    private int qtdPostagens;

    public Usuario(String nome, String email, String senha ) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        postagens = new ArrayList<String>();
        amigos =  new ArrayList<Usuario>();
        sessoes =  new ArrayList<Sessao>();
        this.qtdPostagens = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static ArrayList<Sessao> getSessoes() {
        return sessoes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static void novaPostagem(String postagem) {
        postagens.add(postagem);
    }

    public static ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    public static void setAmigos(ArrayList<Usuario> amigos) {
        Usuario.amigos = amigos;
    }

    public static void logar(Usuario usuario){
        DateTimeFormatter inicioSessao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Sessao sessao = new Sessao(now, usuario );
        sessoes.add(sessao);
        System.out.println(now.format(inicioSessao));
    }

    public static void deslogar(Usuario usuario){
        DateTimeFormatter fimSessao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Sessao.fimSessao = now;
        System.out.println(now.format(fimSessao) );
    }

    public static void listaPostagens() {
        int i = 1;

        for (String postagem : postagens) {
            System.out.println("====== POSTAGEM " + i + " ======");
            System.out.println(postagem);
            System.out.println("================================");
            i++;
        }
    }

    public static void criarAmizade(String nomeAmigo, ArrayList<Usuario> usuarios){
        if(!verificaAmizade(nomeAmigo)){
            System.out.println("Amizade ja existe!");
            return;
        }
        for(int i = 0; i<usuarios.size(); i++){
            if(usuarios.get(i).getNome().equals(nomeAmigo) ){
                amigos.add(usuarios.get(i));
                System.out.println("Amizade criada com sucesso!");
                return;
            }
        }
        System.out.println("Amigo não encontrado");
    }

    public static void destruirAmizade(String nomeAmigo, ArrayList<Usuario> usuarios){
        for(int i = 0; i<usuarios.size(); i++){
            if(usuarios.get(i).getNome().equals(nomeAmigo) ){
                amigos.remove(usuarios.get(i));
                System.out.println("Amizade destruida com sucesso!");
                return;
            }
        }
        System.out.println("Amigo não encontrado");
    }

    public static boolean verificaAmizade(String nomeAmigo){
        for(int i = 0; i<amigos.size(); i++){
            if(amigos.get(i).getNome().equals(nomeAmigo)){
                return false;
            }
        }
        return true;
    }
}
