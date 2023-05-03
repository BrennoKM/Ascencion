/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.model.estrutudadados;

import java.util.ArrayList;

public interface BuscaLinearInterface <T> {
	public int buscar(ArrayList<T> lista, T valorProcurado) throws Excessao;
}
