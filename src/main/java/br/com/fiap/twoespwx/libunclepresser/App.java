package br.com.fiap.twoespwx.libunclepresser;

import java.io.IOException;

public class App {
    // Método principal 
    public static void main(String[] args) {
        // Verifica se os argumentos de linha de comando foram passados corretamente
        if (args.length != 2) {
            System.out.println("Uso: java -jar <path/to/jar/file> <path/to/input> <path/to/output>");
            return;
        }

        // Caminho para o arquivo de entrada e saída recebidos como argumentos
        String inputFilePath = args[0];
        String outputFilePath = args[1];

        try {
            // Lê o conteúdo do arquivo de entrada
            String inputData = FileHandler.readFile(inputFilePath);
            
            // Comprime os dados usando o algoritmo RLE
            String compressedData = RLECompressor.compress(inputData);
            
            // Escreve os dados comprimidos no arquivo de saída
            FileHandler.writeFile(outputFilePath, compressedData);
            
            // Gera o relatório com as estatísticas de compressão
            ReportGenerator.generateReport(inputFilePath, outputFilePath, inputData.length(), compressedData.length(), inputData);
        } catch (IOException e) {
            // Caso ocorra algum erro durante a leitura
            e.printStackTrace();
        }
    }
}
