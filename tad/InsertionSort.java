package tad;

public class InsertionSort {

    public static void ordenar(Aluno[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Aluno chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getNota() > chave.getNota()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
        }
    }

    public static void main(String[] args) {
        int tamanho = 1000000;

        // Teste com vetor inverso
        Aluno[] vetorInverso = GeradorDeAlunos.gerarInverso(tamanho);
        long inicioInverso = System.currentTimeMillis();
        ordenar(vetorInverso);
        long fimInverso = System.currentTimeMillis();
        System.out.printf("InsertionSort (Inverso) finalizado em %d ms (tamanho: %d)%n",
                (fimInverso - inicioInverso), tamanho);

        // Teste com vetor aleatório
        Aluno[] vetorAleatorio = GeradorDeAlunos.gerarAleatorio(tamanho);
        long inicioAleatorio = System.currentTimeMillis();
        ordenar(vetorAleatorio);
        long fimAleatorio = System.currentTimeMillis();
        System.out.printf("InsertionSort (Aleatório) finalizado em %d ms (tamanho: %d)%n",
                (fimAleatorio - inicioAleatorio), tamanho);
    }
}
