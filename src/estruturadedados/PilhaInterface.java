package estruturadedados;

public interface PilhaInterface <T> {
    void push(T number) throws Excessao; 	// empilhar
    T pop() throws Excessao;					// desempilhar
    
    T peek() throws Excessao;				// consultar (topo)
    
    boolean isEmpty();
    boolean isFull();
   
    // O show não faz parte de um metodo basico de pilha (LEMBRAR)
    void show();	// opcional e auxiliar
    
    
}
