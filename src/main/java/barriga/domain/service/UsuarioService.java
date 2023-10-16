package barriga.domain.service;

import barriga.domain.Usuario;
import barriga.domain.exceptions.ValidationExcpetions;
import barriga.domain.repository.UsuarioRepository;

import java.util.Optional;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario){
        usuarioRepository.getUserByEmail(usuario.getEmail()).ifPresent(user -> {
            throw new ValidationExcpetions(String.format("Usuário %s já cadastrado!", usuario.getEmail()));
        });
        return usuarioRepository.salvar(usuario);
    }

    public Optional<Usuario> getUserByEmail(String email){
        return usuarioRepository.getUserByEmail(email);
    }
}
