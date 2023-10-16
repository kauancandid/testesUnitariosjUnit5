package barriga.domain.infra;

import barriga.domain.Usuario;
import barriga.domain.exceptions.ValidationExcpetions;
import barriga.domain.service.UsuarioService;
import org.junit.jupiter.api.*;

import static barriga.domain.builders.UsuarioBuilderM.umUsuario;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceComUserMemoryRepositoryTest {
    private static UsuarioService service = new UsuarioService(new UsuarioMemoryRepository());

    @Test
    @Order(1)
    public void deveSalvarUsuarioValido(){
        Usuario user = service.salvar(umUsuario().comId(null).agora());
        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals(2L, user.getId());
    }

    @Test
    @Order(2)
    public void deveRejeitarUsuarioExistente(){
        ValidationExcpetions ex = Assertions.assertThrows(ValidationExcpetions.class, () ->
            service.salvar(umUsuario().comId(null).agora()));
        Assertions.assertEquals("Usuário user@gmail.com já cadastrado!", ex.getMessage());

    }
}
