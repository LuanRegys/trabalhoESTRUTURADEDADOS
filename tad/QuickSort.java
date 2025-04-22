package tad;

public class QuickSort {

    public static void ordenar(Aluno[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Aluno[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int p = particionar(arr, inicio, fim);
            quickSort(arr, inicio, p - 1);
            quickSort(arr, p + 1, fim);
        }
    }

    private static int particionar(Aluno[] arr, int inicio, int fim) {
        Aluno pivo = arr[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (arr[j].getNota() <= pivo.getNota()) {
                i++;
                Aluno temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Aluno temp = arr[i + 1];
        arr[i + 1] = arr[fim];
        arr[fim] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int tamanho = 1000000;

        // Teste com vetor inverso
        Aluno[] vetorInverso = GeradorDeAlunos.gerarInverso(tamanho);
        long inicioInverso = System.currentTimeMillis();
        ordenar(vetorInverso);
        long fimInverso = System.currentTimeMillis();
        System.out.printf("QuickSort (Inverso) finalizado em %d ms (tamanho: %d)%n",
                (fimInverso - inicioInverso), tamanho);

        // Teste com vetor aleatório
        Aluno[] vetorAleatorio = GeradorDeAlunos.gerarAleatorio(tamanho);
        long inicioAleatorio = System.currentTimeMillis();
        ordenar(vetorAleatorio);
        long fimAleatorio = System.currentTimeMillis();
        System.out.printf("QuickSort (Aleatório) finalizado em %d ms (tamanho: %d)%n",
                (fimAleatorio - inicioAleatorio), tamanho);
    }
}
