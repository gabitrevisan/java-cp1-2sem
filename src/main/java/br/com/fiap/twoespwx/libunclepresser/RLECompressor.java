package br.com.fiap.twoespwx.libunclepresser;

public class RLECompressor {
    // Método que aplica a compressão RLE na sequência de dados
    public static String compress(String data) {
        StringBuilder compressed = new StringBuilder(); // Utlizamos StringBuilder para construir a string comprimida
        int count = 1; // Contador de repetições de caracteres

        // Itera pela sequência de dados (exceto o primeiro caractere)
        for (int i = 1; i < data.length(); i++) {
            // Se o caractere atual é igual ao anterior, aumenta o contador
            if (data.charAt(i) == data.charAt(i - 1)) {
                count++;
            } else {
                // Caso contrário, adiciona o caractere e o número de repetições na string comprimida
                compressed.append(data.charAt(i - 1)).append(count);
                count = 1; // Reinicia o contador para o novo caractere
            }
        }

        // Adiciona o último caractere e sua contagem
        compressed.append(data.charAt(data.length() - 1)).append(count);

        // Retorna a string comprimida
        return compressed.toString();
    }
}
