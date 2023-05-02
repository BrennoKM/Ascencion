package Model.Entity;

import java.util.Random;
import java.util.Stack;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;
import estruturadedados.Pilha;

public class Monstro {
	private Baralho baralho;
    private Pilha<Carta> cartas;
    private Baralho baralhoJogado;
    
	public Monstro() {}
	
	public Monstro(Naipe naipeClasse) {
		this.cartas = new Pilha<>();
		this.baralho = new Baralho(naipeClasse);
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
	    baralhoJogado = new Baralho();
	    baralhoJogado.limpar();

	    // Retira as 4 últimas cartas da pilha de cartas do monstro
	    for (int i = 0; i < 4; i++) {
	            //baralhoJogado.adicionarCarta(cartas.pop());
	        }
	}
	
	public void mostrarCartasJogadas() {
	    System.out.println("\nCartas jogadas pelo monstro:\n\n" + baralhoJogado.mostrar() + "\n");
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
