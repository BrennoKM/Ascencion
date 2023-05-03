/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.api.game;

import ufersa.edu.br.ascension.model.baralho.Baralho;
import ufersa.edu.br.ascension.model.baralho.Carta;
import ufersa.edu.br.ascension.model.entidades.Jogador;
import ufersa.edu.br.ascension.model.estrutudadados.MyArrayList;

public class Mesa {

	private MyArrayList<Jogador> jogadores;
	private Baralho baralhoMonstros;
	private MyArrayList<Carta> monstrosEmCampo;
	private MyArrayList<Carta> monteDescartadas;

	public Mesa(Jogador jogador1, Jogador jogador2, Jogador jogador3, Jogador jogador4) {
		this.jogadores = new MyArrayList<>();
		this.jogadores.add(jogador1);
		this.jogadores.add(jogador2);
		if (jogador3 != null) {
			this.jogadores.add(jogador3);
		}
		if (jogador4 != null) {
			this.jogadores.add(jogador4);
		}
		this.baralhoMonstros = new Baralho();
		this.monstrosEmCampo = new MyArrayList<>();
		this.monteDescartadas = new MyArrayList<>();
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

	public MyArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(MyArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Baralho getBaralhoMonstros() {
		return baralhoMonstros;
	}

	public void setBaralhoMonstros(Baralho baralhoMonstros) {
		this.baralhoMonstros = baralhoMonstros;
	}

	public MyArrayList<Carta> getMonstrosEmCampo() {
		return monstrosEmCampo;
	}

	public void setMonstrosEmCampo(MyArrayList<Carta> monstrosEmCampo) {
		this.monstrosEmCampo = monstrosEmCampo;
	}

	public MyArrayList<Carta> getMonteDescartadas() {
		return monteDescartadas;
	}

	public void setMonteDescartadas(MyArrayList<Carta> monteDescartadas) {
		this.monteDescartadas = monteDescartadas;
	}
}
