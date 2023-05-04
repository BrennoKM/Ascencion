package Model.Entity;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;

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
    
    public boolean isFaceVirada() {
		return faceVirada;
	}

	public void setFaceVirada(boolean faceVirada) {
		this.faceVirada = faceVirada;
	}

	public String toString() {
    	String texto = "";
    	if(valor.getValorString().equals("slot vazio")) {
    		faceVirada = false;
    	}
    	if(faceVirada) {
    		texto += naipe.getNaipe() + " valor " + valor.getValorString();	
    	}
    	else {
    		texto += "Não há carta selecionada";	
    	}
    	return texto;
    }
}