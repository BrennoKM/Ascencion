package Model.Entity;

import java.util.Random;
import java.util.Stack;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;
import estruturadedados.Fila;
import estruturadedados.Pilha;

public class Monstro {
	private Baralho baralho;
    private Pilha<Carta> cartas;
    private Fila<Carta> baralhoJogado = new Fila<>(4);
    
	public Monstro() {
		this.baralho = new Baralho();
		this.cartas = new Pilha<>(52);
		int i = 0;
		for(Carta carta : baralho.getCartas()) {
			cartas.push(baralho.getCartas().get(i++));
		}
	}
	
	public Monstro(Naipe naipeClasse) {
		this.baralho = new Baralho(naipeClasse);
		this.cartas = new Pilha<>(52);
		int i = 0;
		for(Carta carta : baralho.getCartas()) {
			cartas.push(carta);
		}
	}
	
	public void adicionarCartas() {
		baralho = new Baralho();
		
		for(int i = 0; i < 52; i++) {
			Carta carta = baralho.distribuirCarta();
			if (carta.getValorEnum() != Valor.AS) {
			    // A carta tem valor "AS", faça algo aqui
				baralho.adicionarCarta(carta);
			}
			
		}
	}
	
	public void pegarCartas() {
	    // Retira as 4 últimas cartas da pilha de cartas do monstro
	    for (int i = 0; i < 4; i++) {
	    	System.out.println(cartas.peek());
	            baralhoJogado.add(cartas.pop());
	        }
	}
	
	public void mostrarCartasJogadas() {
	    System.out.println("\nCartas jogadas pelo monstro:\n" + baralhoJogado + "\n");
	}
	
	@Override
	public String toString() {
		return "\nCartas do monstro:\n\n" + baralho.mostrar() + "\n";
	}
	
	public Pilha<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(Pilha<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public Baralho getBaralho() {
		return baralho;
	}

	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}

	public void embaralhar() {
		baralho.embaralhar();
	}
	
}
