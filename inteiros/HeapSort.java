package inteirostw;

public class HeapSort {

    public static void ordenar(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && arr[esquerda] > arr[maior])
            maior = esquerda;

        if (direita < n && arr[direita] > arr[maior])
            maior = direita;

        if (maior != i) {
            int swap = arr[i];
            arr[i] = arr[maior];
            arr[maior] = swap;

            heapify(arr, n, maior);
        }
    }

    public static void main(String[] args) {
        int tamanho =  50000;
        int repeticoes = 10;
        long[] temposAleatorio = new long[repeticoes];
        long[] temposInverso = new long[repeticoes];

        // Teste com vetor aleatório
        for (int i = 0; i < repeticoes; i++) {
            int[] vetor = GeradorDeVetores.gerarAleatorio(tamanho);
            long inicio = System.currentTimeMillis();
            ordenar(vetor);
            long fim = System.currentTimeMillis();
            temposAleatorio[i] = fim - inicio;
        }

        double mediaAleatorio = Estatisticas.calcularMedia(temposAleatorio);
        double desvioAleatorio = Estatisticas.calcularDesvioPadrao(temposAleatorio, mediaAleatorio);

        System.out.printf("HeapSort - Aleatório (%d elementos): Média = %.2f ms | Desvio Padrão = %.2f ms%n",
                tamanho, mediaAleatorio, desvioAleatorio);

        // Teste com vetor em ordem inversa
        for (int i = 0; i < repeticoes; i++) {
            int[] vetor = GeradorDeVetores.gerarInverso(tamanho);
            long inicio = System.currentTimeMillis();
            ordenar(vetor);
            long fim = System.currentTimeMillis();
            temposInverso[i] = fim - inicio;
        }

        double mediaInverso = Estatisticas.calcularMedia(temposInverso);
        double desvioInverso = Estatisticas.calcularDesvioPadrao(temposInverso, mediaInverso);

        System.out.printf("HeapSort - Inverso (%d elementos): Média = %.2f ms | Desvio Padrão = %.2f ms%n",
                tamanho, mediaInverso, desvioInverso);
    }
}
