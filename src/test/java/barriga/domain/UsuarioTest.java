package barriga.domain;

import barriga.domain.exceptions.ValidationExcpetions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    public void deveRejeitarUsuarioSemEmail() {
        ValidationExcpetions ex = Assertions.assertThrows(ValidationExcpetions.class, () -> {
            umUsuario().comEmail(null).agora();
        });
        assertEquals("Email é Obrigatório", ex.getMessage());

    }

    @Test
    public void deveRejeitarUsuarioSemSenha() {
        ValidationExcpetions ex = Assertions.assertThrows(ValidationExcpetions.class, () -> {
            umUsuario().comSenha(null).agora();
        });
        assertEquals("Senha é Obrigatório", ex.getMessage());

    }

    @ParameterizedTest(name = "[{index}] - {4}")
    @CsvSource(value = {
            "1, NULL, usergmail.com, 123user, Nome é Obrigatório",
            "1, Usuário Válido, NULL, 123user, Email é Obrigatório",
            "1, Usuário Válido, usergmail.com, NULL, Senha é Obrigatório"
    }, nullValues = "NULL")
    public void deveValidarCamposObrigatorios(Long id, String nome, String email, String senha, String mensagem){
        ValidationExcpetions ex = Assertions.assertThrows(ValidationExcpetions.class, () -> {
            umUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).agora();
        });
        assertEquals(mensagem, ex.getMessage());
    }

    @ParameterizedTest(name = "[{index}] - {4}")
    @CsvFileSource(files = "src\\test\\resources\\camposObrigatoriosUsuario.csv", nullValues = "NULL", numLinesToSkip = 1)
    public void deveValidarCamposObrigatoriosComFileSource(Long id, String nome, String email, String senha, String mensagem){
        ValidationExcpetions ex = Assertions.assertThrows(ValidationExcpetions.class, () -> {
            umUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).agora();
        });
        assertEquals(mensagem, ex.getMessage());

    }

}
