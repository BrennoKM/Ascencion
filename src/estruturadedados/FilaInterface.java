package estruturadedados;

public interface FilaInterface <T> {
    void add(T number) throws Excessao;
    T remove() throws Excessao;
    
    T peek() throws Excessao;	// consulta o início (primeiro elemento)
    
    boolean isEmpty();
    boolean isFull();
    
    void show(); // opcional e auxiliar
}
