package barriga.domain;

import barriga.domain.exceptions.ValidationExcpetions;

public class Conta {

    private Long id;
    private String nome;
    private Usuario usuario;

    public Conta(Long id, String nome, Usuario usuario) {
        if(nome == null) throw new ValidationExcpetions("Nome é Obrigatório");
        if(usuario == null) throw new ValidationExcpetions("Usuário é Obrigatório");

        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
