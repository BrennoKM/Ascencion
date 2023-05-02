package Model.Entity;

import java.util.ArrayList;
import java.util.List;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;

public class Jogador {
	private String nome;
	private String senha;
	private List<Carta> cartas;
	private List<Carta> monteDescartadas;
	private Baralho baralhoDeClasse;
	private Baralho baralhoDeVida;
	public Jogador() {
		
	}

	public Jogador(String nome, Naipe naipeClasse, Naipe naipeVida) {
	    this.nome = nome;
	    this.cartas = new ArrayList<>();
	    this.baralhoDeClasse = new Baralho(naipeClasse);
	    // o naipe do baralho de vida é o inverso do naipe do baralho de classe
	    this.baralhoDeVida = new Baralho(inverterNaipe(naipeClasse));
	    this.monteDescartadas = new ArrayList<>(); // Lista vazia de cartas descartadas
	}

	private Naipe inverterNaipe(Naipe naipe) {
	    switch(naipe) {
	        case ESPADAS:
	            return Naipe.COPAS;
	        case COPAS:
	            return Naipe.ESPADAS;
	        case OUROS:
	            return Naipe.PAUS;
	        case PAUS:
	            return Naipe.OUROS;
	        default:
	            return null;
	    }
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setMonteDescartadas(List<Carta> monteDescartadas) {
		this.monteDescartadas = monteDescartadas;
	}
/*
	public void pegarCarta() {
	    Carta carta = baralhoDeClasse.distribuirCarta();
	    if (carta == null) { // se o baralho de classe acabar
	        if (monteDescartadas.size() == 0) { // se não houver cartas no montante, não há como pegar cartas
	            return;
	        }
	        devolverCartas(monteDescartadas); // as cartas do montante são devolvidas ao baralho de classe e embaralhadas
	        carta = baralhoDeClasse.distribuirCarta(); // a primeira carta é distribuída
	    }
	    cartas.add(carta);
	}
/*
	/*
	public void devolverCartas(List<Carta> cartasDescartadas) {
	    baralhoDeClasse.adicionarCartas(cartasDescartadas); // adiciona as cartas descartadas ao baralho de classe
	    baralhoDeClasse.embaralhar(); // embaralha o baralho de classe
	    monteDescartadas.clear(); // limpa a lista de cartas descartadas
	}*/

	public void descartarCarta(int index) {
		Carta carta = cartas.remove(index);
		monteDescartadas.add(carta); // Adiciona a carta diretamente na lista de descartadas
	}

	public void sofrerDano() {
		Carta carta = baralhoDeVida.distribuirCarta();
		if (carta != null) {
			monteDescartadas.add(carta); // Adiciona a carta de dano diretamente na lista de descartadas
		}
	}

	// getters e setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Carta> getCartas() {
		return cartas;
	}
	
	public List<Carta> getMonteDescartadas() {
		return monteDescartadas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}


	public Baralho getBaralhoDeVida() {
		return baralhoDeVida;
	}

	public void setBaralhoDeVida(Baralho baralhoDeVida) {
		this.baralhoDeVida = baralhoDeVida;

	}
	
	public Baralho getBaralhoDeClasse() {
		return baralhoDeClasse;
	}

	public void setBaralhoDeClasse(Baralho baralhoDeClasse) {
		this.baralhoDeClasse = baralhoDeClasse;
	}
	
	@Override
	public String toString() {
		return "Informações do Jogador:\n"
				+ "--------------------------------------------------------------"
				+ "\nNome = " + nome + "\nCartas = " + cartas + "\nMonteDescartadas = " + monteDescartadas
				+ "\nBaralhoDeClasse=" + baralhoDeClasse.mostrar() + "\nBaralhoDeVida=" + baralhoDeVida + "\n";
	}
}
