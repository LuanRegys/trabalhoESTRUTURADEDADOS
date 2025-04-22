package inteirostw;

public class MergeSort {

    public static void ordenar(int[] arr) {
        if (arr.length > 1) {
            int meio = arr.length / 2;
            int[] esquerda = new int[meio];
            int[] direita = new int[arr.length - meio];

            System.arraycopy(arr, 0, esquerda, 0, meio);
            System.arraycopy(arr, meio, direita, 0, arr.length - meio);

            ordenar(esquerda);
            ordenar(direita);

            intercalar(arr, esquerda, direita);
        }
    }

    private static void intercalar(int[] arr, int[] esquerda, int[] direita) {
        int i = 0, j = 0, k = 0;
        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] <= direita[j]) {
                arr[k++] = esquerda[i++];
            } else {
                arr[k++] = direita[j++];
            }
        }
        while (i < esquerda.length) {
            arr[k++] = esquerda[i++];
        }
        while (j < direita.length) {
            arr[k++] = direita[j++];
        }
    }

    public static void main(String[] args) {
        int tamanho = 50000;
        int repeticoes = 10;
        long[] temposInverso = new long[repeticoes];
        long[] temposAleatorio = new long[repeticoes];

        // Execuções com vetor inverso
        for (int i = 0; i < repeticoes; i++) {
            int[] vetor = GeradorDeVetores.gerarInverso(tamanho);
            long inicio = System.currentTimeMillis();
            ordenar(vetor);
            long fim = System.currentTimeMillis();
            temposInverso[i] = fim - inicio;
        }

        // Execuções com vetor aleatório
        for (int i = 0; i < repeticoes; i++) {
            int[] vetor = GeradorDeVetores.gerarAleatorio(tamanho);
            long inicio = System.currentTimeMillis();
            ordenar(vetor);
            long fim = System.currentTimeMillis();
            temposAleatorio[i] = fim - inicio;
        }

        // Estatísticas
        double mediaInverso = Estatisticas.calcularMedia(temposInverso);
        double desvioInverso = Estatisticas.calcularDesvioPadrao(temposInverso, mediaInverso);

        double mediaAleatorio = Estatisticas.calcularMedia(temposAleatorio);
        double desvioAleatorio = Estatisticas.calcularDesvioPadrao(temposAleatorio, mediaAleatorio);

        System.out.printf("MergeSort (Inverso, %d elementos): Média = %.2f ms | Desvio Padrão = %.2f ms%n",
                tamanho, mediaInverso, desvioInverso);
        System.out.printf("MergeSort (Aleatório, %d elementos): Média = %.2f ms | Desvio Padrão = %.2f ms%n",
                tamanho, mediaAleatorio, desvioAleatorio);
    }
}
