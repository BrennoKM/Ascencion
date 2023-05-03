package Model.Entity;

import java.util.ArrayList;
import java.util.List;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;
import estruturadedados.Excessao;
import estruturadedados.Pilha;

public class Jogador {
	private String nome;
	private String senha;
	private List<Carta> cartasMao;
	private Pilha<Carta> monteDescartadas;
	private Baralho baralhoDeClasse;
	private Baralho baralhoDeVida;
	
	public Jogador() {
		
	}

	public Jogador(String nome, Naipe naipeClasse, Naipe naipeClasse2) {
	    this.nome = nome;
	    this.cartasMao = new ArrayList<>();
	    this.baralhoDeClasse = new Baralho();
	    this.baralhoDeVida = new Baralho();
	    baralhoDeVida.limpar();
	    // o naipe do baralho de vida é o inverso do naipe do baralho de classe
	    for (Valor valor : Valor.values()) {
	    	baralhoDeVida.adicionarCarta(new Carta(inverterNaipe(naipeClasse), valor));
	    	baralhoDeVida.adicionarCarta(new Carta(inverterNaipe(naipeClasse2), valor));
        }
	    this.monteDescartadas = new Pilha<>(); // Lista vazia de cartas descartadas
	}

	private Naipe inverterNaipe(Naipe naipe) {
	    switch(naipe) {
	        case ESPADAS:
	            return Naipe.PAUS;
	        case COPAS:
	            return Naipe.OUROS;
	        case OUROS:
	            return Naipe.COPAS;
	        case PAUS:
	            return Naipe.ESPADAS;
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

	public void setMonteDescartadas(Pilha<Carta> monteDescartadas) {
		this.monteDescartadas = monteDescartadas;
	}

	public void pegarCarta(int quantidade) {
		
		for(int i = 0; i < quantidade; i++) {	
			Carta carta = baralhoDeClasse.distribuirCarta();
			if (carta == null) { // se o baralho de classe acabar
				if (monteDescartadas.size() == 0) { // se não houver cartas no montante, não há como pegar cartas
					devolverCartas(monteDescartadas); // as cartas do montante são devolvidas ao baralho de classe e embaralhadas
				}
				carta = baralhoDeClasse.distribuirCarta(); // a primeira carta é distribuída
			}
			if(cartasMao.size() <= 4) {
				cartasMao.add(carta);	
			} else {
				monteDescartadas.push(carta);
				throw new Excessao( "\nVocê já tem 4 cartas na mão!\n" );
			}
		}
	}

	
	
	public void devolverCartas(Pilha<Carta> cartasDescartadas) {
	    baralhoDeClasse.adicionarCartas(cartasDescartadas); // adiciona as cartas descartadas ao baralho de classe
	    baralhoDeClasse.embaralhar(); // embaralha o baralho de classe
	    // monteDescartadas.clear(); // limpa a lista de cartas descartadas
	}

	public void descartarCarta(int index) {
		Carta carta = cartasMao.remove(index);
		monteDescartadas.push(carta); // Adiciona a carta diretamente na lista de descartadas
	}

	public void sofrerDano() {
		Carta carta = baralhoDeVida.distribuirCarta();
		if (carta != null) {
			monteDescartadas.push(carta); // Adiciona a carta de dano diretamente na lista de descartadas
		}
	}

	// getters e setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Carta> getCartasMao() {
		return cartasMao;
	}
	
	public Pilha<Carta> getMonteDescartadas() {
		return monteDescartadas;
	}

	public void setCartasMao(List<Carta> cartasMao) {
		this.cartasMao = cartasMao;
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
				+ "\nNome = " + nome + "\nCartas = " + cartasMao + "\nMonteDescartadas = " + monteDescartadas
				+ "\nBaralhoDeClasse:\n" + baralhoDeClasse.mostrar() + "\nBaralhoDeVida:\n" + baralhoDeVida.mostrar() + "\n";
	}
}
