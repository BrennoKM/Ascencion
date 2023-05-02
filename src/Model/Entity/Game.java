package Model.Entity;

import java.util.Random;
import java.util.Scanner;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;

public class Game {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String []args) {
		
		Baralho baralho = new Baralho(); baralho.limpar(); //Criação de um baralho aleatorio
		for (int i = 0; i < 50; i++) {
		    Carta carta = new Carta(Naipe.values()[new Random().nextInt(Naipe.values().length)], Valor.values()[new Random().nextInt(Valor.values().length)]);
		    baralho.adicionarCarta(carta);
		}
		
		 System.out.print("BEM-VINDO AO GAME ASCENSION\n\n");
		 Jogador jogador = new Jogador(); // Jogador criado
		 String heroi ="", heroi2 ="";
			System.out.print("Digite o nome do seu jogador:");
			String name = scanner.next();
			jogador.setNome(name);
			System.out.print("Escolha a sua classe:\n[G]uerreiros\n[P]aladinos\n[A]assassinos\n[M]agos\nSua opção:");
			char opcao = scanner.next().charAt(0);
			switch(opcao) {
			case 'G': 
			case 'g':
				heroi = "Guerreiros";
				break;
			case 'P': 
			case 'p':
				heroi = "Paladinos";
				break;
			case 'A': 
			case 'a':
				heroi = "Assassinos";
				break;
			case 'M': 
			case 'm':
				heroi = "Magos";
				break;
			default:
				System.out.println("Opção invalida");
			}
			
			System.out.print("Escolha outra opção de classe:\n[G]uerreiros\n[P]aladinos\n[A]assassinos\n[M]agos\nSua opção:");
			char opcao2 = scanner.next().charAt(0);
			switch(opcao2) {
			case 'G': 
			case 'g':
				heroi2 = "Guerreiros";
				break;
			case 'P': 
			case 'p':
				heroi2 = "Paladinos";
				break;
			case 'A': 
			case 'a':
				heroi2 = "Assassinos";
				break;
			case 'M': 
			case 'm':
				heroi2 = "Magos";
				break;
			default:
				System.out.println("Opção invalida");
			}
			
			System.out.print("Herois escolhidos: " + heroi + " e " + heroi2 + "\n");
	        
			Baralho baralhoJogador = new Baralho();
			baralhoJogador.limpar();
			
			for (Carta carta : baralho.getCartas()) {
			    if (carta.getNaipe().equals(heroi)) 
			    	baralhoJogador.adicionarCarta(carta);
			}
			
			for (Carta carta : baralho.getCartas()) {
			    if (carta.getNaipe().equals(heroi2)) 
			    	baralhoJogador.adicionarCarta(carta);
			}
			jogador.setBaralhoDeClasse(baralhoJogador);
			System.out.print(jogador.toString());
	       
	
	}
}