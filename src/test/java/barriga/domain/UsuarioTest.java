package barriga.domain;

import barriga.domain.exceptions.ValidationExcpetions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static barriga.domain.builders.UsuarioBuilderOld.umUsuario;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Domínio: Usuário")
public class UsuarioTest {

    @Test
    @DisplayName("Deve criar um usuário válido")
    public void deveCriarUsuarioValido() {
        var usuario = umUsuario().agora();
        Assertions.assertAll("Usuario",
                () -> assertEquals(1L, usuario.getId()),
                () -> assertEquals("Usuário Válido", usuario.getNome()),
                () -> assertEquals("user@gmail.com", usuario.getEmail()),
                () -> assertEquals("123user", usuario.getSenha())
        );
    }

    @Test
    public void deveRejeitarUsuarioSemNome() {
        ValidationExcpetions ex = Assertions.assertThrows(ValidationExcpetions.class, () -> {
            umUsuario().comNome(null).agora();
        });
        assertEquals("Nome é Obrigatório", ex.getMessage());

    }

}
