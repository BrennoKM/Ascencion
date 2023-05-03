package ufersa.edu.br.ascension.model.estrutudadados;

public interface MyStackInterface<T> {
    void push(T value);
    T pop();
    T peek();
    T search(int index);
    boolean isEmpty();
    boolean isFull();
    void show();
    int size();
}
