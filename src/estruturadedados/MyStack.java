package estruturadedados;

import java.util.Random;
import java.util.Stack;

public class MyStack<T> implements MyStackInterface<T> {
    int size;
    private Object[] array = null;
    int top;

    public MyStack(int size){
        this.top = -1;
        this.size = size;
        this.array = new Object[size];
    }

    @Override
    public void push(T value) {
        if(isFull()) {
	        throw new MyStackException("\nERRO: pilha cheia [valor="+value+"]!!!\n" );
	    }

	    top = top + 1;
	    array[top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        T retorno;
        
	    if(isEmpty()) {
	        throw new MyStackException( "\nERRO: pilha vazia!!!\n" );
	    }

        retorno = (T) array[top];
        array[top] = "slot vazio";
        top = top - 1;

	    return retorno;
    }
    
    @SuppressWarnings("unchecked")
    public void shuffle(){
        Random rand = new Random();
        for(int i=top;i>0;i--){
            int j = rand.nextInt(i+1);
            T temp = (T) array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T search(int index){
        if(index < 0 || index > top){
            throw new MyStackException("ERRO: indice inválido");
        }
        return (T) array[top-index];
    }


    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        T retorno;
		
	    if(isEmpty()) {
	        throw new MyStackException( "\nERRO: pilha vazia!!!\n" );
	    }
	    
	    retorno = (T) array[top];

	    return retorno;
    }

    @Override
    public boolean isEmpty() {
        if(top == -1){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if(top == size-1){
            return true;
        }
        return false;
    }

    @Override
    public Object[] show() {
        for(int i=0; i <= top; i++) {
	        System.out.println(array[i]);
	    }
        return array;
    }

    @Override
    public int size() {
    	int count = 0;
		for(Object obj : array) {
			count++;
		}
		
		return count;
    }
   
    public int getTop() {
    	return this.top;
    }
    
    public String toString() {
    	String str = "";
		for(Object obj : array) {
			if (!obj.equals("slot vazio")) {
				str += obj.toString() + "\n";	
			}
		}
		
		return str;
    }
}
