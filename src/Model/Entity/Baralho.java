package Model.Entity;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;
import estruturadedados.Pilha;
import estruturadedados.MyArrayList;
import estruturadedados.MyStack;

public class Baralho {
	
    private MyArrayList<Carta> cartas;
   
    public Baralho(){
        this.cartas = new MyArrayList<>();
        for (Naipe naipe : Naipe.values()) {
            for (Valor valor : Valor.values()) {
                this.cartas.add(new Carta(naipe, valor));
            }
        }
    }
    
    public Baralho(Naipe naipe) {
    	this.cartas = new MyArrayList<>();
        this.cartas.clear();
        for (Valor valor : Valor.values()) {
            this.cartas.add(new Carta(naipe, valor));
        }
    }
    
    public void addBaralho(Baralho baralho) {
    if (baralho != null) {
        for (Carta carta : baralho.getCartas()) {
            addCarta(carta);
        }
    }
}
    
    public void shuffle(){
        cartas.shuffle();
    }
    
    public MyArrayList<Carta> getCartas() {
		return cartas;
    }
    
    public void setCartas(MyArrayList<Carta> cartas) {
		this.cartas = cartas;
    }
    
    public void addCarta(Carta carta) {
    	cartas.add(carta);
    }
    
    public void addCartas(MyArrayList<Carta> cartas) {
        for (Carta carta : cartas) {
            addCarta(carta);
        }
    }
    
    public void addCartas(MyStack<Carta> cartas) {
    	 for (int i = 0; i < cartas.size(); i++) {
         	System.out.println(cartas.peek());
             addCarta(cartas.pop());
         }
    }
    
    public void removeCarta(Carta removida) {
    	if (removida != null) {
    		cartas.remove(removida);
    	}
    }
    
    public void limparBaralho() {
    	cartas.clear();
    }
    
    public Carta distribuirCarta() {
        if (!this.cartas.isEmpty()) {
        	return this.cartas.remove(0);
        }
        return null;
    }
    
    public boolean verificarVazio(){
        return cartas.isEmpty();
    }
    
    public String toString() {
    	String str = "";
    	int i = 0;
    	for (Carta c: cartas)
    		str += c.toString() + "\n";
    	return str;
    }
    
    
}
