package Model.Entity;

import java.util.ArrayList;
import java.util.Collections;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;

public class Baralho {

   //private List<Carta> cartas;
	private ArrayList<Carta> cartas;
	
    public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public Baralho() {
        this.cartas = new ArrayList<>();
        
        for (Naipe naipe : Naipe.values()) {
            for (Valor valor : Valor.values()) {
                this.cartas.add(new Carta(naipe, valor));
            }
        }
    }
    
    public Baralho(Naipe naipe) {
    	this.cartas = new ArrayList<>();
        this.cartas.clear();
        for (Valor valor : Valor.values()) {
            this.cartas.add(new Carta(naipe, valor));
        }
    }

    public int tamanho() {
        return this.cartas.size();
    }

    public void adicionarCarta(Carta carta) {
       // this.cartas.add(carta);
    	cartas.add(carta);
    }
    
    /*
    public void adicionarCartas(List<Carta> cartas) {
        for (Carta carta : cartas) {
            adicionarCarta(carta);
        }
    }*/

    public void embaralhar() {
    	Collections.shuffle(this.cartas);
    }

    public Carta distribuirCarta() {
        if (!this.cartas.isEmpty()) {
        	System.out.println(this.cartas.get(0));
        	return this.cartas.remove(0);
        }
        return null;
    }
    
    public void removerCarta(Carta removida) {
    	if (removida != null) {
    		cartas.remove(removida);
    	}
    }

    // limpar cartas:
    public void limpar() {
    	cartas.clear();
    }
    
    public String mostrar() {
    	String str = "";
    	int i = 0;
    	for (Carta c: cartas)
    		str += c.toString() + "\n";
    	return str;
    }
    
    public boolean darCarta(Carta carta, Baralho outroBaralho) {
    	if(!cartas.contains(carta)) {
    		return false;
    	}else {
    		cartas.remove(carta);
    		outroBaralho.adicionarCarta(carta);
    		return true;
    	}
    }

}
