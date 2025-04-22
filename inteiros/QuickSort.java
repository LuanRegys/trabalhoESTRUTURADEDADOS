package inteirostw;

public class QuickSort {

    public static void ordenar(int[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(arr, inicio, fim);
            ordenar(arr, inicio, pivo - 1);
            ordenar(arr, pivo + 1, fim);
        }
    }

    private static int particionar(int[] arr, int inicio, int fim) {
        // Novo pivô: valor do meio
        int meio = inicio + (fim - inicio) / 2;
        int pivo = arr[meio];

        // Troca o pivô com o último para reaproveitar o código existente
        trocar(arr, meio, fim);

        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (arr[j] < pivo) {
                i++;
                trocar(arr, i, j);
            }
        }
        trocar(arr, i + 1, fim);
        return i + 1;
    }

    private static void trocar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int tamanho = 50000; // Agora aceita valores maiores
        int repeticoes = 10;
        long[] temposInverso = new long[repeticoes];
        long[] temposAleatorio = new long[repeticoes];

        // Testes com vetor inverso
        for (int i = 0; i < repeticoes; i++) {
            int[] vetor = GeradorDeVetores.gerarInverso(tamanho);
            long inicio = System.currentTimeMillis();
            ordenar(vetor, 0, vetor.length - 1);
            long fim = System.currentTimeMillis();
            temposInverso[i] = fim - inicio;
        }

        // Testes com vetor aleatório
        for (int i = 0; i < repeticoes; i++) {
            int[] vetor = GeradorDeVetores.gerarAleatorio(tamanho);
            long inicio = System.currentTimeMillis();
            ordenar(vetor, 0, vetor.length - 1);
            long fim = System.currentTimeMillis();
            temposAleatorio[i] = fim - inicio;
        }

        double mediaInverso = Estatisticas.calcularMedia(temposInverso);
        double desvioInverso = Estatisticas.calcularDesvioPadrao(temposInverso, mediaInverso);

        double mediaAleatorio = Estatisticas.calcularMedia(temposAleatorio);
        double desvioAleatorio = Estatisticas.calcularDesvioPadrao(temposAleatorio, mediaAleatorio);

        System.out.printf("QuickSort (Inverso, %d elementos): Média = %.2f ms | Desvio Padrão = %.2f ms%n",
                tamanho, mediaInverso, desvioInverso);
        System.out.printf("QuickSort (Aleatório, %d elementos): Média = %.2f ms | Desvio Padrão = %.2f ms%n",
                tamanho, mediaAleatorio, desvioAleatorio);
    }
}
