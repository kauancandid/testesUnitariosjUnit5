package barriga.domain.builders;

import barriga.domain.Usuario;

public class UsuarioBuilderM {
    private Long id;
    private String nome;
    private String email;
    private String senha;

    private UsuarioBuilderM(){}

    public static UsuarioBuilderM umUsuario() {
        UsuarioBuilderM builder = new UsuarioBuilderM();
        inicializarDadosPadroes(builder);
        return builder;
    }

    private static void inicializarDadosPadroes(UsuarioBuilderM builder) {
        builder.id = 1L;
        builder.nome = "Usuário Válido";
        builder.email = "user@gmail.com";
        builder.senha = "123user";
    }

    public UsuarioBuilderM comId(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioBuilderM comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public UsuarioBuilderM comEmail(String email) {
        this.email = email;
        return this;
    }

    public UsuarioBuilderM comSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public Usuario agora() {
        return new Usuario(id, nome, email, senha);
    }
}