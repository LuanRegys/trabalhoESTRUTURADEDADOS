package inteirostw;

public class Estatisticas {

    public static double calcularMedia(long[] tempos) {
        double soma = 0;
        for (long tempo : tempos) {
            soma += tempo;
        }
        return soma / tempos.length;
    }

    public static double calcularDesvioPadrao(long[] tempos, double media) {
        double soma = 0;
        for (long tempo : tempos) {
            soma += Math.pow(tempo - media, 2);
        }
        return Math.sqrt(soma / tempos.length);
    }
}
