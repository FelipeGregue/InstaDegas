import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sessao {
    LocalDateTime inicioSessao;
    static LocalDateTime  fimSessao;
    Usuario usuario;

    public Sessao (LocalDateTime inicioSessao , Usuario usuario){
        this.inicioSessao = inicioSessao;
        this.usuario = usuario;
    }


}
