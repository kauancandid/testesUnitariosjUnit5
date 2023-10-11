import barriga.domain.Conta;
import barriga.domain.Usuario;
import barriga.domain.exceptions.ValidationExcpetions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static barriga.domain.builders.ContaBuilderM.umConta;
import static barriga.domain.builders.UsuarioBuilderOld.umUsuario;

public class ContaTest {

    @Test
    public void deveCriarContValida() {
        Conta conta = umConta().agora();
        Assertions.assertAll("Conta",
                () -> Assertions.assertEquals(1L, conta.getId()),
                () -> Assertions.assertEquals("Conta Válida", conta.getNome()),
                () -> Assertions.assertEquals(umUsuario().agora(), conta.getUsuario())
        );
    }

    @ParameterizedTest
    @MethodSource(value = "dataProvider")
    public void deveRejeitarContaInvalida(Long id, String nome, Usuario usuario, String mensagem){
        String errorMensagem = Assertions.assertThrows(ValidationExcpetions.class, () ->
                        umConta().comId(id).comNome(nome).comUsuario(usuario).agora()).getMessage();
        Assertions.assertEquals(mensagem, errorMensagem);
    }

    //provedor de dados
    private static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of(1L, null, umUsuario().agora(), "Nome é Obrigatório"),
                Arguments.of(1L, "Conta Válida", null, "Usuário é Obrigatório")
        );
    }
}
