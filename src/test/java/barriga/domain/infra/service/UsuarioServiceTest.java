package barriga.domain.infra.service;

import barriga.domain.repository.UsuarioRepository;
import barriga.domain.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UsuarioServiceTest {

    private UsuarioService service;

    @Test
    public void deveRetornarUsuarioPorEmail(){
        UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioService(repository);
        var user = service.getUserByEmail("user@gmail.com");
        Assertions.assertTrue(user.isEmpty());

    }
}
