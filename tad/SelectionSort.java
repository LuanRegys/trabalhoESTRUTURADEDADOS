package tad;

public class SelectionSort {

    public static void ordenar(Aluno[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].getNota() < arr[indiceMenor].getNota()) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                Aluno temp = arr[i];
                arr[i] = arr[indiceMenor];
                arr[indiceMenor] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int tamanho = 1000000;

        // Teste com vetor inverso
        Aluno[] vetorInverso = GeradorDeAlunos.gerarInverso(tamanho);
        long inicioInverso = System.currentTimeMillis();
        ordenar(vetorInverso);
        long fimInverso = System.currentTimeMillis();
        System.out.printf("SelectionSort (Inverso) finalizado em %d ms (tamanho: %d)%n",
                (fimInverso - inicioInverso), tamanho);

        // Teste com vetor aleatório
        Aluno[] vetorAleatorio = GeradorDeAlunos.gerarAleatorio(tamanho);
        long inicioAleatorio = System.currentTimeMillis();
        ordenar(vetorAleatorio);
        long fimAleatorio = System.currentTimeMillis();
        System.out.printf("SelectionSort (Aleatório) finalizado em %d ms (tamanho: %d)%n",
                (fimAleatorio - inicioAleatorio), tamanho);
    }
}
