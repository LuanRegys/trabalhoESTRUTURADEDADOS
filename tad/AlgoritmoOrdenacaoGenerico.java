package tad;

public interface AlgoritmoOrdenacaoGenerico<T extends Comparable<T>> {
    void ordenar(T[] vetor);
}
