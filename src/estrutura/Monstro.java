package estrutura;

import java.util.Random;
import java.util.Stack;

import estrutura.Enums.Naipe;
import estrutura.Enums.Valor;

public class Monstro {
	private Baralho baralho;
    private Stack<Carta> cartas;
    private Baralho baralhoJogado;
    
	public Monstro() {}
	
	public Monstro(Naipe naipeClasse) {
		this.cartas = new Stack<>();
		this.baralho = new Baralho(naipeClasse);
	}
	
	public void adicionarCartas() {
		baralho = new Baralho();
		baralho.limpar();
		for (int i = 0; i < 50; i++) {
		Valor valor;
		do {
		valor = Valor.values()[new Random().nextInt(Valor.values().length)]; // qualquer valor, exceto "Ás"
		} while (valor == Valor.AS);
		Carta carta = new Carta(Naipe.values()[new Random().nextInt(Naipe.values().length)], valor);
		baralho.adicionarCarta(carta);
		}
	}
	
	public void pegarCartas() {
	    baralhoJogado = new Baralho();
	    baralhoJogado.limpar();

	    // Retira as 4 últimas cartas da pilha de cartas do monstro
	    for (int i = 0; i < 4; i++) {
	            baralhoJogado.adicionarCarta(cartas.pop());
	        }
	}
	
	public void mostrarCartasJogadas() {
	    System.out.println("\nCartas jogadas pelo monstro:\n\n" + baralhoJogado.mostrar() + "\n");
	}
	
	@Override
	public String toString() {
		return "\nCartas do monstro:\n\n" + baralho.mostrar() + "\n";
	}
	
	public Stack<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(Stack<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public Baralho getBaralho() {
		return baralho;
	}

	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}
	
}
