package tad;

public class Estatisticas {

    // Método para calcular a média
    public static double calcularMedia(long[] tempos) {
        double soma = 0;
        for (long tempo : tempos) {
            soma += tempo;
        }
        return soma / tempos.length;
    }

    // Método para calcular o desvio padrão
    public static double calcularDesvioPadrao(long[] tempos, double media) {
        double somaQuadrados = 0;
        for (long tempo : tempos) {
            somaQuadrados += Math.pow(tempo - media, 2);
        }
        return Math.sqrt(somaQuadrados / tempos.length);
    }
}
