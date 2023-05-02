package Model.Entity;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;

public class Carta {

    // Atributos privados da carta
    private Naipe naipe;
    private Valor valor;
    private boolean faceVirada;
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