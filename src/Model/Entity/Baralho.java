package Model.Entity;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;
import estruturadedados.Pilha;
import estruturadedados.MyArrayList;
import estruturadedados.MyStack;

public class Baralho {
	
    private MyStack<Carta> cartas;
   
    public Baralho(){
        this.cartas = new MyStack<>(52);
        for (Naipe naipe : Naipe.values()) {
            for (Valor valor : Valor.values()) {
                this.cartas.push(new Carta(naipe, valor));
            }
        }
    }
    
    public Baralho(Naipe naipe) {
    	this.cartas = new MyStack<>(13);
        for (Valor valor : Valor.values()) {
            this.cartas.push(new Carta(naipe, valor));
        }
    }
    
    public void addBaralho(Baralho baralho) {
    if (baralho != null) {
    	for (int i = 0; i < cartas.size(); i++) {
             addCarta(cartas.pop());
         }
    }
}
    
    public void shuffle(){
    	cartas.shuffle();
    }
    
    public MyStack<Carta> getCartas() {
		return cartas;
    }
    
    public void setCartas(MyStack<Carta> cartas) {
		this.cartas = cartas;
    }
    
    public void addCarta(Carta carta) {
    	cartas.push(carta);
    }
    
    public void addCartas(MyArrayList<Carta> cartas) {
        for (Carta carta : cartas) {
            addCarta(carta);
        }
    }
    
    public void addCartas(MyStack<Carta> cartas) {
    	 for (int i = 0; i < cartas.size(); i++) {
             addCarta(cartas.pop());
         }
    }
    
    /*public void removeCarta(Carta removida) {
    	if (removida != null) {
    		cartas.remove(removida);
    	}
    }*/
    
    public void limparBaralho() {
    	for(int i = 0; i < cartas.size(); i++) {
        	cartas.pop();
    	}
    }
    
    public Carta distribuirCarta() {
        if (!this.cartas.isEmpty()) {
        	Carta carta = cartas.pop();
        	return carta;
        }
        return null;
    }
    
    public boolean verificarVazio(){
        return cartas.isEmpty();
    }
    
    public String toString() {
    	String str = cartas.toString();
    	return str;
    }
    
    
}
