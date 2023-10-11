package barriga.domain.builders;

import barriga.domain.Usuario;
import barriga.domain.Conta;

public class ContaBuilderM {
    private Long id;
    private String nome;
    private Usuario usuario;

    private ContaBuilderM(){}

    public static ContaBuilderM umConta() {
        ContaBuilderM builder = new ContaBuilderM();
        inicializarDadosPadroes(builder);
        return builder;
    }

    private static void inicializarDadosPadroes(ContaBuilderM builder) {
        builder.id = 1L;
        builder.nome = "Conta Válida";
        builder.usuario = UsuarioBuilderM.umUsuario().agora();
    }

    public ContaBuilderM comId(Long id) {
        this.id = id;
        return this;
    }

    public ContaBuilderM comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ContaBuilderM comUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Conta agora() {
        return new Conta(id, nome, usuario);
    }
}
