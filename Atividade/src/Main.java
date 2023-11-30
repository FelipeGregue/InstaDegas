import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            ArrayList<Usuario> usuarios = ListaUsuario.getListaUsuarios();
            Scanner ler = new Scanner(System.in);
            int opcao;
            int retorno;
            String nome, email, senha, nomeAmigo;

            do{
                System.out.println(">>> Bem-vindo(a) ao InstaDegas <<<");
                System.out.println("[1] Novo Usuario");
                System.out.println("[2] Remover Usuario");
                System.out.println("[3] Logar");
                System.out.println("[0] Para Sair");
                opcao = ler.nextInt();

                switch (opcao){
                    case 1:
                        ler.nextLine();
                        System.out.println("Informe o nome: ");
                        nome = ler.nextLine();
                        System.out.println("Informe o e-mail: ");
                        email = ler.nextLine();
                        System.out.println("Informe a senha: ");
                        senha = ler.nextLine();

                        ListaUsuario.criarUsuario(nome, email, senha, usuarios);
                    break;

                    case 2:
                        int escolha;
                        ler.nextLine();
                        if(usuarios.isEmpty()){
                            System.out.println("Lista de usuarios vazia");
                            break;
                        }
                        System.out.println("Informe o e-mail: ");
                        email = ler.nextLine();
                        System.out.println("Informe a senha: ");
                        senha = ler.nextLine();
                        retorno = verificaLogin(email, senha, usuarios);

                        if(retorno == -1){
                            System.out.println("Usuario nao encontrado!");
                            break;
                        }

                        System.out.println("Realmente deseja excluir ? 1-SIM / 2 - NAO");
                        escolha = ler.nextInt();

                        if(escolha == 1){
                            ListaUsuario.removerUsuario(usuarios, retorno);
                        }

                    break;

                    case 3:
                        ler.nextLine();
                        System.out.println("Informe o e-mail: ");
                        email = ler.nextLine();
                        System.out.println("Informe a senha: ");
                        senha = ler.nextLine();
                        retorno = verificaLogin(email, senha, usuarios);

                        if( retorno != -1){
                            Usuario.logar(usuarios.get(retorno));
                            System.out.println("Logado com sucesso");

                            int opcaoSubMenu;
                            do{
                                System.out.println(">>> Menu de Sessao <<<");
                                System.out.println("[1] Listar Postagens");
                                System.out.println("[2] Criar Postagem");
                                System.out.println("[3] Criar Amizade");
                                System.out.println("[4] Desfazer Amizade");
                                System.out.println("[0] Deslogar");
                                opcaoSubMenu = ler.nextInt();

                                switch (opcaoSubMenu){
                                    case 1:
                                        Usuario.listaPostagens();
                                    break;

                                    case 2:
                                        String postagem;
                                        System.out.println("Digite a postagem: ");
                                        ler.nextLine();
                                        postagem = ler.nextLine();
                                        Usuario.novaPostagem(postagem);
                                        System.out.println("Postagem criada com sucesso!");
                                    break;

                                    case 3:
                                        System.out.println("Informe o nome do amigo: ");
                                        ler.nextLine();
                                        nomeAmigo = ler.nextLine();
                                        Usuario.criarAmizade(nomeAmigo, usuarios);
                                    break;

                                    case 4:
                                        System.out.println("Informe o nome do amigo: ");
                                        ler.nextLine();
                                        nomeAmigo = ler.nextLine();
                                        Usuario.destruirAmizade(nomeAmigo, usuarios);
                                    break;

                                    case 0:
                                        Usuario.deslogar(usuarios.get(retorno));
                                    break;

                                    default:
                                        System.out.println("Ops... Opção invalida tente novamente");
                                }
                            }while(opcaoSubMenu != 0);

                        }else{
                            System.out.println("Erro");
                        }
                    break;

                    case 0:
                    break;

                    default:
                        System.out.println("Ops... Opção invalida tente novamente");
                }
            }while(opcao != 0);

    }

    public static int  verificaLogin(String email, String senha, ArrayList<Usuario> usuarios){
        for(int i = 0; i<usuarios.size(); i++){
            if(usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getSenha().equals(senha) ){
                return i;
            }
        }
        return -1;
    }


    public static boolean verificaUsuarioExistente(String nomeAmigo,  ArrayList<Usuario> usuarios){
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeAmigo)) {
                return false;
            }
        }
        return true;
    }
}