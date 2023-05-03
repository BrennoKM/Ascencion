package ufersa.edu.br.ascension.model.estrutudadados;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class MyArrayList<T> implements MyArrayListInterface<T>, Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elements;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity can't be negative: " + capacity);
        }
        this.elements = new Object[capacity];
    }
    
    public MyArrayList<T> addList(List<T> elements){
        MyArrayList<T> response = new MyArrayList<>();
        
        for(int i=0;i<elements.size();i++){
            response.add(elements.get(i));
        }
        return response;
    }
    
    public <E> E[] toArray(E[] array){
        if(array.length < size){
            return (E[]) Arrays.copyOf(elements,size,array.getClass());
        }
        System.arraycopy(elements,0,array,0,size);
        if(array.length > size){
            array[size] = null;
        }
        return array;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? elements[i] == null : element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }
    
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return (T) elements[index];
    }

    @Override
    public boolean add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        return true;
    }
    
    public T remove(Object element) {
        int index = indexOf((T) element);
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        T removed = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removed;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        T removed = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removed;
    }

    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

public void shuffle() {
        Random random = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            T temp = (T) elements[i];
            elements[i] = elements[j];
            elements[j] = temp;
        }
    }
    public Stream<T> stream() {
        return Arrays.stream(elements, 0, size).map(e -> (T) e);
    }
    
    
    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {
        private int currentIndex;

        public MyArrayListIterator() {
            this.currentIndex = 0;
        }

        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            T element = (T) elements[currentIndex];
            currentIndex++;
            return element;
        }
    }
    
}
