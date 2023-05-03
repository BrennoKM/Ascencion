/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.model.baralho;

import ufersa.edu.br.ascension.model.enums.Enums.Valor;
import ufersa.edu.br.ascension.model.enums.Enums.Naipe;

public class Carta {

    // Atributos privados da carta
    private Naipe naipe = null;
    private Valor valor = null;
    private boolean faceVirada = false;
    // Construtor que recebe o naipe e valor da carta
    public Carta(Naipe naipe, Valor valor) {
        this.naipe = naipe;
        this.valor = valor;
        faceVirada = true;
    }
    
    public String getNaipe() {
    	return naipe.getNaipe();
    }
    
    public int getValor() {
    	return valor.getValor();
    }

    
    // Método para acessar o naipe da carta
    public Naipe getNaipeEnum() {
        return naipe;
    }

    // Método para acessar o valor da carta
    public Valor getValorEnum() {
        return valor;
    }

    /*
    // Método que retorna uma string formatada com o valor e naipe da carta
    public String toString() {
        return valor + " de " + naipe;
    }*/
    
    public String toString() {
    	String texto = "";
    	if(faceVirada)
    		texto += "Heroi " + naipe.getNaipe() + " valor " + valor.getValorString();
    	else
    		texto += "Não há carta selecionada";
    	return texto;
    }
}
