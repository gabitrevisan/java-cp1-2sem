package br.com.fiap.twoespwx.libunclepresser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ReportGenerator {
    // Esse método gera e imprime o relatório com estatísticas da compressão
    public static void generateReport(String inputFilePath, String outputFilePath, int inputSize, int outputSize, String originalData) throws IOException {
        // Cria um mapa para armazenar as frequências dos caracteres na sequência de nucleotídeos
        HashMap<Character, Integer> frequencies = new HashMap<>();
        
        // Conta a frequência de cada caractere na sequência de dados original
        for (char c : originalData.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        // Exibe as informações do relatório
        System.out.println(" -----------------------------------------------------------");
        System.out.println("|           LIB UNCLE PRESSER - GRUPO BATATA-DOCE           |");
        System.out.println("|-----------------------------------------------------------|");
        // Exibe o nome do arquivo de entrada e saída
        System.out.printf("| INPUT  FILENAME: %s\n", new File(inputFilePath).getName());
        System.out.printf("| OUTPUT FILENAME: %s\n", new File(outputFilePath).getName());
        
        // Exibe o tamanho do arquivo de entrada (em KB) e o número total de caracteres
        System.out.printf("| INPUT FILE SIZE: %dKB\n", inputSize / 1024);
        System.out.printf("| TOTAL INPUT CHARACTERS: %d\n", inputSize);
        
        // Exibe a frequência de cada nucleotídeo na sequência de entrada
        System.out.println("| FREQUENCIES:");
        for (var entry : frequencies.entrySet()) {
            System.out.printf("| %c: %d (%.2f%%)\n", entry.getKey(), entry.getValue(), (entry.getValue() * 100.0 / inputSize));
        }

        // Exibe as opções usadas no algoritmo
        System.out.println("| OPTIONS:");
        System.out.println("| ALGORITHM: Run-Length Encoding (RLE)");
        System.out.println("| TEXT-CODIFICATION: UTF-8");

        // Calcula e exibe a taxa de compressão
        System.out.printf("| COMPRESSION RATE: ~%.2f%%\n", (1.0 - (double) outputSize / inputSize) * 100);
        
        // Exibe o tamanho do arquivo comprimido
        System.out.printf("| OUTPUT FILE SIZE: %d BYTES\n", outputSize);
        System.out.println(" -----------------------------------------------------------");
        System.out.println("| SCORE: WELL-DONE                                          |");
        System.out.println(" -----------------------------------------------------------");
    }
}
