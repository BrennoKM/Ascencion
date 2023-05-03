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

	
	}
	
	public Monstro(Naipe naipeClasse) {
		this.baralho = new Baralho(naipeClasse);
		this.cartas = new Pilha<>(52);
	
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
		
		int i = baralho.tamanho() - 1;
		for(Carta carta : baralho.getCartas()) {
			cartas.push(baralho.getCartas().get(i--));
		}
		
	    for (int j = 0; j < 4; j++) {
	    	baralhoJogado.add(cartas.pop());
	    }
	}
	
	public void mostrarCartasJogadas() {
	    System.out.println("Cartas jogadas pelo monstro:");
	    baralhoJogado.show();
	}
	
	@Override
	public String toString() {
		return "Cartas do monstro:\n\n" + baralho.mostrar();
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
