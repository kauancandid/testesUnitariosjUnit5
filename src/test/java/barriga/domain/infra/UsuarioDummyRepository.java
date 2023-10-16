package barriga.domain.infra;

import barriga.domain.Usuario;
import barriga.domain.repository.UsuarioRepository;

import java.util.Optional;

import static barriga.domain.builders.UsuarioBuilderM.umUsuario;

public class UsuarioDummyRepository implements UsuarioRepository {
    @Override
    public Usuario salvar(Usuario usuario) {
        return umUsuario()
                .comNome(usuario.getNome())
                .comEmail(usuario.getEmail())
                .comSenha(usuario.getSenha())
        .agora();
    }

    @Override
    public Optional<Usuario> getUserByEmail(String email) {
        if("user@gmail.com".equals(email)){
            return Optional.of(umUsuario().comEmail(email).agora());
        }
        return Optional.empty();

    }
}
