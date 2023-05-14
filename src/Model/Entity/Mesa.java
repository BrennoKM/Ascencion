package Model.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Entity.Enums.Naipe;
import estruturadedados.BuscaBinaria;
import estruturadedados.BuscaLinear;
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
	
	public void exibirCartas() {
		System.out.println("-------------MONSTRO-------------");
		System.out.println(monstro.getMao().toString());
		System.out.println("------------JOGADOR-1------------");
		System.out.println(jogadores[P1].getMao());
		System.out.println("------------JOGADOR-2------------");
		System.out.println(jogadores[P2].getMao());
	}
	
	public void exibirCemiterio() {
		System.out.println("--------------------------CEMITÉRIO--------------------------");
		System.out.println("		  	    _______	  \r\n"
				+ "		  _____    /       \\    _____\r\n"
				+ "		 /     \\  |  R.I.P  |  /     \\\r\n"
				+ "		| R.I.P | |         | | R.I.P |\r\n"
				+ "		|  ___  | |   ___   | |  ___  |\r\n"
				+ "		| /   \\ | |  /   \\  | | /   \\ | ");
		System.out.println("-------------MONSTRO-------------");
		System.out.println(monstro.getMonstrosMortos());
		System.out.println("------------JOGADOR-1------------");
		System.out.println(jogadores[P1].getBaralhoDescarte());
		System.out.println("------------JOGADOR-2------------");
		System.out.println(jogadores[P2].getBaralhoDescarte());
	}
	
	public void exibirVidas() {
		System.out.println("----------------------------VIDAS----------------------------");
		System.out.println("		    ___  ___      ___  ___\r\n"
				+ "		   /   \\/   \\    /   \\/   \\\r\n"
				+ "		   \\        /    \\        /\r\n"
				+ "		    '\\    /'	  '\\    /'\r\n"
				+ "		      '\\/'	    '\\/'   ");
		System.out.println("Vidas de " + jogadores[P1].getNome() + ": " + jogadores[P1].contarVidas());
		System.out.println("Vidas de " + jogadores[P2].getNome() + ": " + jogadores[P2].contarVidas());
	}
	
	public void exibirJogadores() {
		MyArrayList myArr = new MyArrayList();
		myArr.add(jogadores[P1]);
		myArr.add(jogadores[P2]);
		BuscaLinear busca = new BuscaLinear();
		
		Jogador exib = jogadores[busca.buscar(myArr, jogadores[P1])];
		System.out.println(exib);
		exib = jogadores[busca.buscar(myArr, jogadores[P2])];
		System.out.println(exib);
	}
	
	public void saqueDeCartas() {
		jogadores[P1].sacarCartas();
		jogadores[P2].sacarCartas();
		monstro.sacarCartas();
	}
	
	public boolean ataque(Carta cartaAtacante, Carta cartaDefensor) {
		if(cartaAtacante.getValor() > cartaDefensor.getValor()) {
<<<<<<< HEAD
			monstro.monstroDerrotado(cartaDefensor);
			return true;
		} else {
			if(cartaAtacante.getValor() == cartaDefensor.getValor()) {
				monstro.monstroDerrotado(cartaDefensor);
				int i = 0;
				for(Jogador jogador : jogadores) {
					jogadores[i++].heroiDerrotado(cartaAtacante); // tenta remover dos dois, mas só um deles tem
				}
				return true;
			} else {
				int i = 0;
				for(Jogador jogador : jogadores) {
					jogadores[i++].heroiDerrotado(cartaAtacante); // tenta remover dos dois, mas só um deles tem
				}
				return false;
			}
=======
			Jogador j = reconhecerJogador(cartaAtacante);
			j.curarDoDescarte(j.getNaipeEnum());
			return true;  // se for maior o ataque deu certo
		} 
		if(cartaAtacante.getValor() == cartaDefensor.getValor()) {
			return false; // se for igual, retorna falso pra ter outro tipo de condição
>>>>>>> f4465d4f2c3664285e028f97acdb2d5fdf4fe52d
		}
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
		Carta defensor;
		for (Jogador jogador : jogadores) {
			if(monstroAtacante.getNaipe().equals(jogador.getNaipe()) && jogador.possuiVida()) {
				// se for mesmo NAIPE do jogador
				defensor = escolherDefensor(jogador);
				if(defenderAtaque(monstroAtacante, defensor)) {
					System.out.println("Defendido com sucesso!");
				} else {
					System.out.println("Falha na defesa...");
				}
				//ataqueMonstro(monstroAtacante, jogador);
				return true;
			} else {
				// se não for do mesmo NAIPE
				if(monstroAtacante.getCor().equals(jogador.getCor()) && jogador.possuiVida()) {
					// se for da mesma COR do jogador
					defensor = escolherDefensor(jogador);
					if(defenderAtaque(monstroAtacante, defensor)) {
						System.out.println("Defendido com sucesso!");
					} else {
						System.out.println("Falha na defesa...");
					}
					//ataqueMonstro(monstroAtacante, jogador);
					return true;
				} 
			}
		}
		if(jogadores[P1].possuiVida()) { // se nenhum dos dois tiver naipe ou cor igual, o monstro ataca o que tiver vida
			defensor = escolherDefensor(jogadores[P1]);
			if(defenderAtaque(monstroAtacante, defensor)) {
				System.out.println("Defendido com sucesso!");
			} else {
				System.out.println("Falha na defesa...");
			}
			return true;
		} else {
			defensor = escolherDefensor(jogadores[P2]);
			if(defenderAtaque(monstroAtacante, defensor)) {
				System.out.println("Defendido com sucesso!");
			} else {
				System.out.println("Falha na defesa...");
			}
			return true;
		}
	}
	
	public void ataqueTodosMonstros() {
		Fila<Carta> ordem = new Fila<Carta>(3); // 3 pq serão 3 monstros a atacar
		
		for(int i = 0; i < monstro.getMao().getMao().size(); i++) {
			ordem.add(monstro.getMao().getMao().searchIndex(i));
		}
		
		for(int i = 0; i < ordem.size(); i++) {
			if(ordem.peek() != null) {
				ataqueAosJogadores(ordem.remove()); // ataca com o próximo da fila e remove-o da fila de ataque
			}
		}
		
	}
	
	public boolean defenderAtaque(Carta atacante, Carta defensor) {
		if(defensor == null) {
			return false;
		}
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
	
	public Carta escolherDefensor(Jogador jog) {
		Carta defensor = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("Monstro quer atacar " + jog.getNome() + "! Defender!!!");
		System.out.println("[P]rimeira	[S]egunda	[T]erceira	[N]enhuma:");
		System.out.print("Opção: ");
		char opc = scan.next().charAt(0);
		switch(opc) {
		case 'P': 
		case 'p':
		case '1':
			defensor = jog.getMao().getMao().peekFirst();
			break;
		case 'S': 
		case 's':
		case '2':
			defensor = jog.getMao().getMao().peekMiddle();
			break;
		case 'T': 
		case 't':
		case '3':
			defensor = jog.getMao().getMao().peekLast();
			break;
		default:
			System.out.println("Pulou turno!");
		}
		
		return defensor;
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
	
	public String ataqueDoJogador(Jogador jogador) {
		Carta escolhidaMonstro = null, escolhidaJogador = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------ATACAR!-------------");
		System.out.println("Jogador: " + jogador.getNome());
		System.out.println("--------escolha-SUA-carta--------");
		System.out.println("[P]rimeira	[S]egunda	[T]erceira	[N]enhuma:");
		System.out.print("Opção: ");
		char opcJogador = scan.next().charAt(0);
		switch(opcJogador) {
		case 'P': 
		case 'p':
		case '1':
			escolhidaJogador = jogador.getMao().getMao().peekFirst();
			break;
		case 'S': 
		case 's':
		case '2':
			escolhidaJogador = jogador.getMao().getMao().peekMiddle();
			break;
		case 'T': 
		case 't':
		case '3':
			escolhidaJogador = jogador.getMao().getMao().peekLast();
			break;
		default:
			System.out.println("Pulou turno!");
		}
		
		
		System.out.println("-------------ATACAR!-------------");
		System.out.println("---escolha-a-carta-do-MONSTRO----");
		System.out.println("[P]rimeira	[S]egunda	[T]erceira	[N]enhuma:");
		System.out.print("Opção: ");
		char opcMonstro = scan.next().charAt(0);
		switch(opcMonstro) {
		case 'P': 
		case 'p':
		case '1':
			escolhidaMonstro = monstro.getMao().getMao().peekFirst();
			break;
		case 'S': 
		case 's':
		case '2':
			escolhidaMonstro = monstro.getMao().getMao().peekMiddle();
			break;
		case 'T': 
		case 't':
		case '3':
			escolhidaMonstro = monstro.getMao().getMao().peekLast();
			break;
		default:
			System.out.println("Pulou turno!");
		}
		
		if(escolhidaMonstro == null) {
			return "Monstros exterminados!";
		}
		if(escolhidaJogador == null) {
			return "Heróis exterminados...";
		}
		if(ataque(escolhidaJogador, escolhidaMonstro)) {
			return "Ataque bem sucedido!";
		}
		
		return "Ataque falhou!";
	}
	
	public boolean jogadoresGanharam() {
		if(monstro.numMonstrosMortos() >= 48) {
			return true;
		} else return false;
	}
	
	public boolean monstrosGanharam() {
		if(jogadores[P1].possuiVida() || jogadores[P2].possuiVida()) {
			return false;
		} else return true;
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
