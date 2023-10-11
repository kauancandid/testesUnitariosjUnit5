import org.example.Calculadora;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraTest {

    private  Calculadora calculadora = new Calculadora();
    private static int contador = 0;

    @BeforeEach
    public void antes(){
        System.out.println("^^^");
    }

    @AfterEach
    public void depois(){
        System.out.println("vvv");
    }

    // beforeAll|afterAll  tem que ser estatico, por conta que iniciado ates da "crição da classe"
    @BeforeAll
    public static void antesAll(){
        System.out.println("----- Before All -----");
    }

    @AfterAll
    public static void depoisAll(){
        System.out.println("----- After All -----");
    }




    @Test
    public void testeSomar() {
        System.out.println(++contador);
        Assertions.assertTrue(calculadora.soma(2, 3) == 5);
        Assertions.assertEquals(5, calculadora.soma(2, 3));
    }

    @Test
    public void assertivas() {
        System.out.println(++contador);
        Assertions.assertEquals("casa", "casa");
        Assertions.assertNotEquals("Casa", "casa");
        Assertions.assertTrue("casa".equalsIgnoreCase("CASA"));
        Assertions.assertTrue("casa".endsWith("sa"));
        Assertions.assertFalse("Casa".startsWith("ca"));

        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        List<String> s3 = null;

        Assertions.assertEquals(s1, s2);
        Assertions.assertSame(s1, s1);
        Assertions.assertNotEquals(s1, s3);
        Assertions.assertNull(s3);
        Assertions.assertNotNull(s1);
        //Assertions.fail("Falhou por esse motivo de keke");

    }

    @Test
    public void deveRetornarNumeroInteiroNaDivisao() {
        System.out.println(++contador);
        var resultado = calculadora.dividir(6, 2);
        Assertions.assertEquals(3, resultado);

    }

    @Test
    public void deveRetornarNumeroNegativoNaDivisao() {
        System.out.println(++contador);
        var resultado = calculadora.dividir(6, -2);
        Assertions.assertEquals(-3, resultado);

    }

    @Test
    public void deveRetornarNumeroDecimalNaDivisao() {
        System.out.println(++contador);
        var resultado = calculadora.dividir(10, 3);
        Assertions.assertEquals(3.3333332538604736, resultado);
        Assertions.assertEquals(3.33, resultado, 0.01); //Testando com margem de erro

    }

    @Test
    public void deveRetornarZeroComNumeradorZeroNaDivisao() {
        var resultado = calculadora.dividir(0, 2);
        Assertions.assertEquals(0, resultado);

    }

    @Test
    public void deveLancarExcecaoQuandoDividirPorZero_jUnit4() {
        try {
            float resultado = 10 / 0;
            Assertions.fail("Deveria ter sido lançado uma exceção na divisão");
        } catch (ArithmeticException e) {
            Assertions.assertEquals("/ by zero", e.getMessage());
        }
    }

    //Esse bloco tem que lançar uma exceção é tem que ser do tipo ArithmeticException - Por isso que passa no teste
    @Test
    public void deveLancarExcecaoQuandoDividirPorZero_jUnit5() {
        var exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            float resultado = 10 / 0;
        });
        Assertions.assertEquals("/ by zero", exception.getMessage());
    }
}
