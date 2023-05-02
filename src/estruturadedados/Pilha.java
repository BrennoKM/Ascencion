package estruturadedados;

public class Pilha <T> implements PilhaInterface <T> {
	private int sizeMax;
	private Object[] array;
	private int top;
	
	
	public Pilha(int sizeMax) {
		this.top = -1;
		this.sizeMax = sizeMax;
		this.array = new Object[sizeMax];
	}

	public Pilha() {
	}
	
	public void push(T valor) throws Excessao	
	{

	    if(isFull()) {
	        throw new Excessao("\nERRO: pilha cheia [valor="+valor+"]!!!\n" );
	    }
	    //Observação: primeiro incrementa o top e depois altera o valor
	    top = top + 1;
	    array[ top ] = valor;
	}

	
	@SuppressWarnings("unchecked")
	public T pop() throws Excessao
	{

		T retorno;
		
	    if(isEmpty()) {
	        throw new Excessao( "\nERRO: pilha vazia!!!\n" );
	    }

        retorno = (T) array[ top ];
        top = top - 1;

	    return retorno;
	}

	
	@SuppressWarnings("unchecked")
	public T peek() throws Excessao
	{
		
	    if(isEmpty()) {
	        throw new Excessao( "\nERRO: pilha vazia!!!\n" );
	    }
	    
	    T retorno = (T) array[ top ];

	    return retorno;
	}
	

	public boolean isFull()
	{
	    if( top == sizeMax-1) {
	        return true;
	    }
	    else { 
	    	return false;
	    }
	}
	
	
	public boolean isEmpty()
	{
	    if( top == -1) {
	        return true;
	    }
	    else { 
	    	return false;
	    }
	}
	
	
	public void show()
	{
	    int i;
		
	    for(i=0; i <= top; i++) {
	        System.out.println(array[i]);
	    }
		System.out.println("topo index = " + top + "\n");
	}
	
	public int size() {
		int count = 0;
		for(Object obj : array) {
			count++;
		}
		
		return count;
	}
	
}
