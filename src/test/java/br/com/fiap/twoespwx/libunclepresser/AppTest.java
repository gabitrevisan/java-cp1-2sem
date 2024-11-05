package br.com.fiap.twoespwx.libunclepresser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    // Esse métod testa o método de compressão RLE com um exemplo simples
    @Test
    public void testRLECompression() {
        String input = "AAAACCCTTG";   // Entrada de teste
        String expected = "A4C3T2G1";   // Resultado esperado
        String actual = RLECompressor.compress(input);  // Comprime a entrada
        assertEquals(expected, actual);  // Verifica se o resultado está correto
    }

    // Testa o método de compressão RLE com uma sequência de caracteres diferentes
    @Test
    public void testRLECompressionWithUniqueChars() {
        String input = "ACGT";         // Entrada de teste com caracteres únicos
        String expected = "A1C1G1T1";   // Resultado esperado: cada caractere é único
        String actual = RLECompressor.compress(input);  // Comprime a entrada
        assertEquals(expected, actual);  // Verifica se o resultado está correto
    }

    // Testa o método de compressão RLE com uma sequência de caracteres repetidos
    @Test
    public void testRLECompressionWithSingleChar() {
        String input = "GGGGGGGGGG";  // Entrada de teste com um único caractere repetido 10 vezes
        String expected = "G10";       // Resultado esperado: "G" aparece 10 vezes
        String actual = RLECompressor.compress(input);  // Comprime a entrada
        assertEquals(expected, actual);  // Verifica se o resultado está correto
    }

}
