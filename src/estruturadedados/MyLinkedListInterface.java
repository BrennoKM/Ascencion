package estruturadedados;

public interface MyLinkedListInterface<T> {

	int size();
	T addFirst(T element);
	T addLast(T element);
	T addAt(int index, T element);
	T remove(T element);
	T remove();
	T get(T element);
	void show();
	
}
