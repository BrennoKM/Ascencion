package estruturadedados;

public class Fila<T> implements FilaInterface<T> {
	private int sizeMax;
	private Object[] array;
	private int first;
	private int last;
	
	
	public Fila(int size) {
		this.first = -1;
		this.last = -1;
		this.sizeMax = size;
		this.array = new Object[size];
	}

	//Na prova: vetor e é pedido para adicionar e remover elementos de uma fila e uma pilha e realizar as manipulações
	public void add(T valor) throws Excessao
	{
		System.out.println("\nInserir...\n");

	    int lastTemp = (last + 1) % sizeMax; //vai dar zero se for igual

	    if (lastTemp == first) {
	       throw new Excessao( "\nERRO: fila cheia["+valor+"]!!!\n" );
	    }

	    last = lastTemp;
        array[ last ] = valor;
		
        // inserindo o primeiro elemento
        if (first == -1) {
            first = 0;
        }
	}


	@SuppressWarnings("unchecked")
	public T remove() throws Excessao
	{
		System.out.println("\nRemover...\n");

		T retorno;
		
	    if (first == -1) {
	    	throw new Excessao( "\nERRO: fila vazia!!!\n" );
	    }

        retorno = (T) array[first];

        if (first == last)
        {
        	// removendo o unico elemento
            first = -1;
            last = -1;
        }
        else
        {
        	first = (first + 1) % sizeMax;
        }

	    return retorno;
	}


	@SuppressWarnings("unchecked")
	public T peek() throws Excessao
	{
		System.out.println("\nConsultar elemento no inicio...\n");

		T retorno;
		
	    if(first == -1) {
	        throw new Excessao( "\nERRO: fila vazia!!!\n" );
	    }
	    
	    retorno = (T) array[ first ];
	    
	    return retorno;
	}
	
	
	public boolean isFull()
	{
	    int lastTemp = (last + 1) % sizeMax;

	    if (lastTemp == first) {
	        return true;
	    }
	    else { 
	    	return false;
	    }
	}
	
	
	public boolean isEmpty()
	{
	    if( first == -1 ) {
	        return true;
	    }
	    else { 
	    	return false;
	    }
	}
	
	
	public void show()
	{
		System.out.println("\nExibindo...\n");
		
	    int i = first;
	    
	    if(first == -1) {
	    	return;
	    }
	    	    
	    while(i != last)
	    {
	    	System.out.println("posicao " + i + " = " + array[i] + "\n");

	        i = (i + 1) % sizeMax;
	    }
	    System.out.println("posicao " + i + " = " + array[i] + "\n");
	    
		System.out.println("inicio = " + first + "  fim = " + last + "\n");
	}
}
