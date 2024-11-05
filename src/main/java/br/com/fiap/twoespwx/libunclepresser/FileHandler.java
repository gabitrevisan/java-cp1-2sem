package br.com.fiap.twoespwx.libunclepresser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
    // Método para ler o conteúdo de um arquivo e retornar como uma string
    public static String readFile(String filePath) throws IOException {
        // Lê todos os bytes do arquivo e os converte para string usando UTF-8
        return new String(Files.readAllBytes(Paths.get(filePath)), "UTF-8").replaceAll("\\s+", "");
        // O replaceAll remove qualquer quebra de linha ou espaços em branco, já que a sequência de nucleotídeos deve ser contínua
    }

    // Método para escrever os dados comprimidos em um arquivo de saída
    public static void writeFile(String filePath, String data) throws IOException {
        // Escreve os dados no arquivo especificado, utilizando codificação UTF-8
        Files.write(Paths.get(filePath), data.getBytes("UTF-8"));
    }
}
