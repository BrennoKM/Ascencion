/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.model.estrutudadados;

public interface BuscaBinariaInterface <T> {
    public <T extends Comparable<T>> int buscar(T[] array, T valorProcurado);
}

