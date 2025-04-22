package tad;

public class MergeSort {

    public static void ordenar(Aluno[] arr) {
        if (arr.length > 1) {
            mergeSort(arr, 0, arr.length - 1);
        }
    }

    private static void mergeSort(Aluno[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(arr, inicio, meio);
            mergeSort(arr, meio + 1, fim);
            intercalar(arr, inicio, meio, fim);
        }
    }

    private static void intercalar(Aluno[] arr, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        Aluno[] esquerda = new Aluno[n1];
        Aluno[] direita = new Aluno[n2];

        for (int i = 0; i < n1; i++) {
            esquerda[i] = arr[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            direita[j] = arr[meio + 1 + j];
        }

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (esquerda[i].getNota() <= direita[j].getNota()) {
                arr[k++] = esquerda[i++];
            } else {
                arr[k++] = direita[j++];
            }
        }

        while (i < n1) {
            arr[k++] = esquerda[i++];
        }

        while (j < n2) {
            arr[k++] = direita[j++];
        }
    }

    public static void main(String[] args) {
        int tamanho = 1000000;

        // Teste com vetor inverso
        Aluno[] vetorInverso = GeradorDeAlunos.gerarInverso(tamanho);
        long inicioInverso = System.currentTimeMillis();
        ordenar(vetorInverso);
        long fimInverso = System.currentTimeMillis();
        System.out.printf("MergeSort (Inverso) finalizado em %d ms (tamanho: %d)%n",
                (fimInverso - inicioInverso), tamanho);

        // Teste com vetor aleatório
        Aluno[] vetorAleatorio = GeradorDeAlunos.gerarAleatorio(tamanho);
        long inicioAleatorio = System.currentTimeMillis();
        ordenar(vetorAleatorio);
        long fimAleatorio = System.currentTimeMillis();
        System.out.printf("MergeSort (Aleatório) finalizado em %d ms (tamanho: %d)%n",
                (fimAleatorio - inicioAleatorio), tamanho);
    }
}
