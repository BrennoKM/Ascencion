/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.model.baralho;

import ufersa.edu.br.ascension.model.enums.Enums.Valor;
import ufersa.edu.br.ascension.model.enums.Enums.Naipe;
import ufersa.edu.br.ascension.model.estrutudadados.MyArrayList;

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
       // this.cartas.add(carta);
    	cartas.add(carta);
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
    
    public String mostrar() {
    	String str = "";
    	int i = 0;
    	for (Carta c: cartas)
    		str += c.toString() + "\n";
    	return str;
    }
    
    
}
