package tad;

import java.util.Random;
import tad.Aluno;

public class GeradorDeAlunos {

    public static Aluno[] gerarAleatorio(int tamanho) {
        Aluno[] alunos = new Aluno[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            int matricula = random.nextInt(100000);
            String nome = "Aluno" + matricula;
            double nota = random.nextDouble() * 10; // Nota aleatória entre 0 e 10
            alunos[i] = new Aluno(matricula, nome, nota);
        }

        return alunos;
    }

    public static Aluno[] gerarInverso(int tamanho) {
        Aluno[] alunos = new Aluno[tamanho];

        // Inicializa alunos com notas em ordem decrescente
        for (int i = 0; i < tamanho; i++) {
            int matricula = i + 1;
            String nome = "Aluno" + matricula;
            double nota = 10 - (i * 10.0 / tamanho); // Nota em ordem decrescente
            alunos[i] = new Aluno(matricula, nome, nota);
        }

        return alunos;
    }
}
