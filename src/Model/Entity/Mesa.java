package Model.Entity;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

	private List<Jogador> jogadores;
	private Baralho baralhoMonstros;
	private List<Carta> monstrosEmCampo;
	private List<Carta> monteDescartadas;

	public Mesa(Jogador jogador1, Jogador jogador2, Jogador jogador3, Jogador jogador4) {
		this.jogadores = new ArrayList<>();
		this.jogadores.add(jogador1);
		this.jogadores.add(jogador2);
		if (jogador3 != null) {
			this.jogadores.add(jogador3);
		}
		if (jogador4 != null) {
			this.jogadores.add(jogador4);
		}
		this.baralhoMonstros = new Baralho();
		this.monstrosEmCampo = new ArrayList<>();
		this.monteDescartadas = new ArrayList<>();
	}

	public void exibirMesa() {
		System.out.println("Jogadores:");
		for (Jogador jogador : jogadores) {
			System.out.println("Nome: " + jogador.getNome() + ", Cartas: " + jogador.getCartasMao());
		}
		System.out.println("Monstros em campo: " + monstrosEmCampo);
		System.out.println("Cartas descartadas: " + monteDescartadas.size());
	}

	// getters e setters

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Baralho getBaralhoMonstros() {
		return baralhoMonstros;
	}

	public void setBaralhoMonstros(Baralho baralhoMonstros) {
		this.baralhoMonstros = baralhoMonstros;
	}

	public List<Carta> getMonstrosEmCampo() {
		return monstrosEmCampo;
	}

	public void setMonstrosEmCampo(List<Carta> monstrosEmCampo) {
		this.monstrosEmCampo = monstrosEmCampo;
	}

	public List<Carta> getMonteDescartadas() {
		return monteDescartadas;
	}

	public void setMonteDescartadas(List<Carta> monteDescartadas) {
		this.monteDescartadas = monteDescartadas;
	}
}
