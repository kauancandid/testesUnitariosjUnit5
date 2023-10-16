package barriga.domain.infra.service;

import barriga.domain.Usuario;
import barriga.domain.builders.UsuarioBuilderM;
import barriga.domain.infra.UsuarioDummyRepository;
import barriga.domain.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioServiceTest {

    private UsuarioService service;

    @Test
    public void deveSalvarUsuarioComSucesso(){
        service = new UsuarioService(new UsuarioDummyRepository());
        Usuario user = UsuarioBuilderM.umUsuario().comId(null).comEmail("outro@gmail.com").agora();
        Usuario saverUser = service.salvar(user);
        Assertions.assertNotNull(saverUser.getId());
    }
}
