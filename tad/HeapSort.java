package tad;

public class HeapSort {

    public static void ordenar(Aluno[] arr) {
        int n = arr.length;

        // Construir o heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapificar(arr, n, i);
        }

        // Extrair elementos do heap
        for (int i = n - 1; i > 0; i--) {
            Aluno temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapificar(arr, i, 0);
        }
    }

    private static void heapificar(Aluno[] arr, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && arr[esquerda].getNota() > arr[maior].getNota()) {
            maior = esquerda;
        }

        if (direita < n && arr[direita].getNota() > arr[maior].getNota()) {
            maior = direita;
        }

        if (maior != i) {
            Aluno temp = arr[i];
            arr[i] = arr[maior];
            arr[maior] = temp;

            heapificar(arr, n, maior);
        }
    }

    public static void main(String[] args) {
        int tamanho = 1000000;

        // Teste com vetor inverso
        Aluno[] vetorInverso = GeradorDeAlunos.gerarInverso(tamanho);
        long inicioInverso = System.currentTimeMillis();
        ordenar(vetorInverso);
        long fimInverso = System.currentTimeMillis();
        System.out.printf("HeapSort (Inverso) finalizado em %d ms (tamanho: %d)%n",
                (fimInverso - inicioInverso), tamanho);

        // Teste com vetor aleatório
        Aluno[] vetorAleatorio = GeradorDeAlunos.gerarAleatorio(tamanho);
        long inicioAleatorio = System.currentTimeMillis();
        ordenar(vetorAleatorio);
        long fimAleatorio = System.currentTimeMillis();
        System.out.printf("HeapSort (Aleatório) finalizado em %d ms (tamanho: %d)%n",
                (fimAleatorio - inicioAleatorio), tamanho);
    }
}
