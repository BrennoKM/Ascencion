package Model.Entity;

import java.util.ArrayList;
import java.util.List;

import estruturadedados.Fila;
import estruturadedados.MyArrayList;
import estruturadedados.MyLinkedList;

public class Mesa {

	final int P1 = 0, P2 = 1;
	private Jogador[] jogadores;
	private Monstro monstro;

	public Mesa(Jogador jogador1, Jogador jogador2) {
		this.jogadores = new Jogador[2];
		this.jogadores[P1] = jogador1;
		this.jogadores[P2] = jogador2;
		/*if (jogador3 != null) {
			this.jogadores.add(jogador3);
		}
		if (jogador4 != null) {
			this.jogadores.add(jogador4);
		}*/
		this.monstro = new Monstro();
		monstro.removerDeuses();
		monstro.getBaralhoMonstro().shuffle();
		monstro.sacarCartas();
	}

	public void exibirMesa() {
		System.out.println("Jogadores:");
		System.out.println("---------------------------------------------------");
		for (Jogador jogador : jogadores) {
			System.out.println("Nome: " + jogador.getNome() + "\nCartas:\n" + jogador.getMao());
		}
		System.out.println("Monstros em campo:\n" + monstro.getMao().toString());
		System.out.println("Cartas descartadas: " + monstro.numMonstrosMortos());
	}
	
	public Carta ataqueAoMonstro(Jogador jogador) {
		MyLinkedList<Carta> playerAux = jogador.getMao().getMao();
		MyLinkedList<Carta> monsterAux = monstro.getMao().getMao();
		Carta ataque = null;
		for(int i = 0; i < playerAux.size(); i++) {
			if(playerAux.searchIndex(i).getNaipe() == monsterAux.searchIndex(i).getNaipe()) { // talvez .getNaipeEnhum() ?
				// se for do mesmo naipe, entra aqui
				if(playerAux.searchIndex(i).getCor().equals(monsterAux.searchIndex(i).getCor())) {
					// se mesmo naipe e mesmo valor
					ataque = playerAux.searchIndex(i);
				} else {
					// se mesmo naipe
					ataque = playerAux.searchIndex(i);
				}
					
			} else {
				// se não for do mesmo naipe, entra aqui
				if(playerAux.searchIndex(i).getCor().equals(monsterAux.searchIndex(i).getCor())) {
					// se mesmo valor / numero da carta
					ataque = playerAux.searchIndex(i);
				} else {
					// se nenhum dos dois
					ataque = playerAux.searchIndex(i);
				}
				
			}
		}
		return ataque;
	}
	
	public boolean ataque(Carta cartaAtacante, Carta cartaDefensor) {
		if(cartaAtacante.getValor() > cartaDefensor.getValor()) {
			return true;  // se for maior o ataque deu certo
		} 
		if(cartaAtacante.getValor() == cartaDefensor.getValor()) {
			return false; // se for igual, retorna falso pra ter outro tipo de condição
		}
		return false;
	}
	
	public boolean ataqueMonstro(Carta cartaAtacante, Jogador jogador) {
		// monstro ataca a próxima carta de vida do jogador
		Carta atacada = jogador.getBaralhoVida().getCartas().peek();
		if(cartaAtacante.getValor() >= atacada.getValor()) {
			jogador.sofrerDano();
			return true;  // se for maior o ataque deu certo
		} else {
			return false; // se não for, o ataque deu errado
		}
	}
	
	public boolean ataqueAosJogadores(Carta monstroAtacante) {
		for (Jogador jogador : jogadores) {
			if(monstroAtacante.getNaipe().equals(jogador.getNaipe())) {
				// se for mesmo NAIPE do jogador
				// no "peekMiddle()", os monstros estão direcionando seu ataque à carta do meio da mão do jogador
				defenderAtaque(monstroAtacante, jogador.getMao().getMao().peekMiddle()); // AQUI, AO INVÉS DE "peekMiddle()", o usuário que vai escolher a defesa
				//ataqueMonstro(monstroAtacante, jogador);
				return true;
			} else {
				// se não for do mesmo NAIPE
				if(monstroAtacante.getCor().equals(jogador.getCor())) {
					// se for da mesma COR do jogador
					defenderAtaque(monstroAtacante, jogador.getMao().getMao().peekMiddle()); // AQUI, AO INVÉS DE "peekMiddle()", o usuário que vai escolher a defesa
					//ataqueMonstro(monstroAtacante, jogador);
					return true;
				} 
			}
		}
		jogadores[P1].sofrerDano(); // se nenhum dos dois tiver naipe ou cor igual, o monstro ataca o jogador 1 mesmo
		return true;
	}
	
	public void ataqueTodosMonstros() {
		Fila<Carta> ordem = new Fila<Carta>(3); // 3 pq serão 3 monstros a atacar
		
		for(int i = 0; i < monstro.getMao().getMao().size(); i++) {
			ordem.add(monstro.getMao().getMao().searchIndex(i));
		}
		
		for(int i = 0; i < ordem.size(); i++) {
			ataqueAosJogadores(ordem.remove()); // ataca com o próximo da fila e remove-o da fila de ataque
		}
		
	}
	
	public boolean defenderAtaque(Carta atacante, Carta defensor) {
		if(defensor.getValor() > atacante.getValor()) {
			return true;
		} else {
			if(defensor.getValor() == atacante.getValor()) {
				monstro.monstroDerrotado(atacante);
				int i = 0;
				for(Jogador jogador : jogadores) {
					jogadores[i++].heroiDerrotado(defensor); // tenta remover dos dois, mas só um deles tem
				}
				return true;
			} else {
				reconhecerJogador(defensor).sofrerDano(); //fazer uma forma de reconhecer qual jogador que tá sendo atacado
				return false;
			}
		}
	}
	
	public Jogador reconhecerJogador(Carta carta) {
		Jogador pertence = null;
		for(int i = 0; i < jogadores.length; i++) {
			for(int contCarta = 0; contCarta < jogadores[i].getMao().getMao().size(); contCarta++) {
				if(jogadores[i].getMao().getMao().searchIndex(contCarta).equals(carta) && jogadores[i].getNaipe().equals(carta.getNaipe())) {
					pertence = jogadores[i];
					return pertence;
				}
			}
		}
		return pertence;
	}

	// getters e setters

	public Monstro getMonster() {
		return monstro;
	}

	public Jogador[] getJogadores() {
		return jogadores;
	}

	public void setJogadores(Jogador[] jogadores) {
		this.jogadores = jogadores;
	}

	public void setMonster(Monstro monstro) {
		this.monstro = monstro;
	}
}
