package estruturadedados;

public class MyLinkedList<T> implements MyLinkedListInterface<T>{

	private static final int DEFAULT_CAPACITY = 4;
	private int size;
	private Node head, tail;
	
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public T addFirst(T element) {
		
		Node novo = new Node(element);
		
		if(head == null) {
			head = novo;
			tail = novo;
		} else {
			novo.next = head;
			head = novo;
		}
		size++;
		
		return element;
	}
	
	@Override
	public T addLast(T element) {
		
		Node novo = new Node(element);
		
		if(head == null) {
			head = novo;
			tail = novo;
		} else {
			tail.next = novo;
			tail = novo;
		}
		size++;
		
		return element;
	}

	@Override
	public T addAt(int index, T element) {

		return element;
		
	}
	
	public T removeFirst() {
		Node aux = head;
		T retorno = null;
		
		if(head != null) {
			retorno = head.valor;
			
			if(head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.next;
			}
			
			aux.next = null;
			size--;
		}
		return retorno;
	}
	
	public T removeLast() {
		T retorno = null;
		
		if(tail != null) {
			Node aux = head;
			while(aux.next != tail) {
				aux = aux.next;
			}
			tail = aux;
			tail.next = null;
		}
		size--;
		
		return retorno;
	}

	private Node searchBefore(T element) {
		
		Node aux = head;
		Node previor = null;
		
		while(aux != null) {
			previor = aux;
			aux = aux.next;
			
			if(aux != null && aux.valor.equals(element)) {
				return previor;
			}
		}
		return null;
	}
	
	@Override
	public T remove(T element) {
		
		Node previor = null;
		Node remove = null;
		
		if(element == null) {
			return null;
		}
		
		if (head == null) {
			throw new Excessao( "\nERRO: fila vazia!!!\n" );
		}
		
		previor = searchBefore(element);
		
		if(previor == null) {
			if(head.valor.equals(element) == false) {
				System.out.println("Elemento não existe");
				return null;
			} else {
				return removeFirst();
			}
		} else {
			remove = previor.next;
			
			if(remove == tail) {
				return removeLast();
			} else {
				previor.next = remove.next;
				remove.next = null;
				size--;
				
				return remove.valor;
			}
		}
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	private Node searchNode(T find) {
		Node aux = head;
		
		while(aux != null) {
			if (aux.valor.equals(find)) {
				return aux;
			}
			aux = aux.next;
		}
		return null;
	}
	
	public T searchIndex(int index) { // Só funciona pro nosso trabalho, pois são 3 cartas
		index = index % 3;
		
		switch(index) {
		case 0:
			return this.peekFirst();
		case 1:
			return this.peekMiddle();
		case 2: 
			return this.peekLast();
		default:
			return null;
		}
	}
	
	public T peekFirst() {
		if(head != null) {
			return head.valor;
		} else {
			return null;
		}
	}
	
	public T peekMiddle() { // "Middle" só pro nosso trabalho, pois são 3 cartas
		if(head != null) {
			return head.next.valor;
		} else {
			return null;
		}
	}
	
	public T peekLast() {
		if(tail != null) {
			return tail.valor;
		} else {
			return null;
		}
	}
	
	@Override
	public T get(T element) {
		
		Node aux = searchNode(element);
		
		if(aux == null) {
			return null;
		} else {
			return aux.valor;
		}
	}
	
	public boolean isFull() {
		if(size == 3) { // Aplicado à regra de negócio das mãos
			return true;
		} else {
			return false;
		}
	}
	
	public void show() {
		Node cont = head;
		
		if (cont != null) {
			while(cont != null) {
				System.out.println(cont.valor + "\n");
			}
		}
	}
	
	public boolean isEmpty() {
		if(tail == null && head == null) {
			return true;
		}
		return false;
		
	}
	
	/*public String toString() {
    	String str = "";
		for(int i = 0; i < size; i++) {
			str += get(i) + "\n";	
		}
		
		return str;
    }*/

	class Node {
		
		T valor;
		Node next;
		
		Node(T value) {
			this.valor = value;
			next = null;
		}
		
	}
	
}