/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruturadedados;

public interface MyArrayListInterface<T> {
    int size();
    boolean isEmpty();
    boolean contains(T element);
    T get(int index);
    boolean add(T element);
    T remove(int index);
    int indexOf(T element);
}
