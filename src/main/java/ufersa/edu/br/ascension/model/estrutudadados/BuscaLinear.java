/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.model.estrutudadados;

import java.util.ArrayList;

public class BuscaLinear<T> implements BuscaLinearInterface<T> {
	public int buscar(ArrayList<T> lista, T valorProcurado) {
	      for (int i = 0; i < lista.size(); i++) {
	         if (lista.get(i) == valorProcurado) {
	            return i;
	         }
	      }
	      return -1;
	   }
}

