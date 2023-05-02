package estruturadedados;

public interface BuscaBinariaInterface <T> {
    public <T extends Comparable<T>> int buscar(T[] array, T valorProcurado);
}
