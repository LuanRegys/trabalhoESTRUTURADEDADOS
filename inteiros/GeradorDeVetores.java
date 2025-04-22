package inteirostw;

import java.util.Random;

public class GeradorDeVetores {

    public static int[] gerarAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = rand.nextInt(tamanho);
        }
        return vetor;
    }

    public static int[] gerarInverso(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = tamanho - i;
        }
        return vetor;
    }
}
