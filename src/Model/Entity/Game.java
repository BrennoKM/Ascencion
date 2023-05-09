package Model.Entity;

import java.util.Scanner;

import Model.DAO.UsuarioDAO;
import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;
import Model.Service.UsuarioService;

public class Game {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void telaInicio(String caminho, Usuario[] usuarios) {
	    int opcao;
	    String nome,senha;

	    do {
	        System.out.println("================================");    
	        System.out.println("SEJA BEM-VINDO AO GAME ASCENSION ");
	        System.out.println("================================\n");
	        System.out.println("Digite 1 para realizar o login\nDigite 2 para realizar o cadastro\nDigite 3 para sair da aplicação\nDigite 4 para ver usuarios cadastrados");
	        System.out.print("Opção escolhida: ");
	        opcao = scanner.nextInt();
	        scanner.nextLine(); // limpa o buffer do teclado

	        switch (opcao) {
	            case 1:
	            	 System.out.print("Digite o login: ");
	         	    nome = scanner.next();
	         	    System.out.print("Digite a senha: ");
	         	    senha = scanner.next();
	         	    Usuario jogador = UsuarioDAO.fazerLogin(caminho, nome, senha);

	         	    if (jogador != null) {
	         	        System.out.println("Login realizado com sucesso. Dados do jogador:");
	         	        UsuarioService.exibirPainelDeUsuario(jogador);
	         	    } else {
	         	        System.out.println("Não foi possível fazer o login. Verifique as informações de login e senha.");
	         	    }
	                break;
	            case 2:
	            	System.out.print("Digite o nome do usuario:");
	        		nome = scanner.next();
	        		System.out.print("Digite a senha do usuario:");
	        		senha = scanner.next();
	        		UsuarioDAO.cadastrarUsuario(caminho, nome, senha);
	                break;
	            case 3:
	                System.out.println("Saindo da aplicação...");
	                break;
	            case 4:
	            	System.out.println("Mostrando usuarios cadastrados...");
	            	usuarios = UsuarioDAO.lerUsuariosDoArquivo(caminho);
	    		    for (Usuario usuario : usuarios) {
	    		        System.out.println(usuario.getLogin() + " vencidas " + usuario.getVencidas());
	    		    }
	            	break;
	            default:
	                System.out.println("Opção inválida! Tente novamente.\n");
	                break;
	        }

	    } while (opcao != 3);

	    scanner.close();
	}
	
	public static void main(String []args) {
		
		/*
		String caminho = "C:\\Users\\Usuário\\Documents\\GitHub\\Ascencion\\src\\Database\\usuarios.txt";
		 Usuario[] usuarios = UsuarioDAO.lerUsuariosDoArquivo(caminho);
		    for (Usuario usuario : usuarios) {
		        System.out.println(usuario.toString());
		    }
		    
		System.out.print("Digite o nome do usuario:");
		String nome = scanner.next();
		System.out.print("Digite a senha do usuario:");
		String senha = scanner.next();
		UsuarioDAO.cadastrarUsuario(caminho, nome, senha);
		 
		usuarios = UsuarioDAO.lerUsuariosDoArquivo(caminho);
	    for (Usuario usuario : usuarios) {
	        System.out.println(usuario.toString());
	    }
	    
	    System.out.print("Digite o login: ");
	    nome = scanner.next();
	    System.out.print("Digite a senha: ");
	    senha = scanner.next();
	    Usuario jogador = UsuarioDAO.fazerLogin(caminho, nome, senha);

	    if (jogador != null) {
	        System.out.println("Login realizado com sucesso. Dados do jogador:");
	        UsuarioService.exibirPainelDeUsuario(jogador);
	    } else {
	        System.out.println("Não foi possível fazer o login. Verifique as informações de login e senha.");
	    }
		*/
		
		/* Testes
		Monstro monster = new Monstro();
		System.out.println("monstroo");
		monster.removerDeuses();
		monster.getBaralhoMonstro().shuffle();
		monster.sacarCartas();
		div();
		System.out.println(monster);
		div();
		System.out.println("\nmao::\n" + monster.getMao());
		System.out.println("~~~~");
		div();
		monster.monstroDerrotado(2);
		System.out.println("Mãoo::\n" + monster.getMao());
		System.out.println("derrotados:\n" + monster.getMonstrosMortos());
		monster.sacarCartas();
		System.out.println("\nbaralho:2:\n" + monster.getBaralhoMonstro());
		System.out.println("mao211:\n" + monster.getMao());*/
		   
		Baralho baralho = new Baralho();
		
		String caminhoJovit = "C:\\Users\\Usuário\\Documents\\GitHub\\Ascencion\\src\\Database\\usuarios.txt";
		String caminhoRyan = "C:\\Users\\Ryan\\eclipse-workspace-projects\\Ascencion\\src\\Database\\usuarios.txt";
		Usuario[] usuarios = null;
		//telaInicio(caminhoRyan, usuarios);
		
		
		/*
		baralho.limpar(); //Criação de um baralho aleatorio
		for (int i = 0; i < 50; i++) {
		    Carta carta = new Carta(Naipe.values()[new Random().nextInt(Naipe.values().length)], Valor.values()[new Random().nextInt(Valor.values().length)]);
		    baralho.adicionarCarta(carta);
		} */
		
		 System.out.println("\nBEM-VINDO AO GAME ASCENSION\n");

		 Naipe heroi = Naipe.PAUS, heroi2 = Naipe.OUROS;
			System.out.print("Digite o nome do seu jogador:");
			String name = scanner.next();
			System.out.print("Escolha a sua classe:\n[G]uerreiros\n[P]aladinos\n[A]assassinos\n[M]agos\nSua opção:");
			char opcao = scanner.next().charAt(0);
			switch(opcao) {
			case 'G': 
			case 'g':
				heroi = Naipe.PAUS;
				break;
			case 'P': 
			case 'p':
				heroi = Naipe.COPAS;
				break;
			case 'A': 
			case 'a':
				heroi = Naipe.ESPADAS;
				break;
			case 'M': 
			case 'm':
				heroi = Naipe.OUROS;
				break;
			default:
				System.out.println("Opção invalida");
			}
			
			System.out.print("Escolha outra opção de classe:\n[G]uerreiros\n[P]aladinos\n[A]assassinos\n[M]agos\nSua opção:");
			char opcao2 = scanner.next().charAt(0);
			switch(opcao2) {
			case 'G': 
			case 'g':
				heroi2 = Naipe.PAUS;
				break;
			case 'P': 
			case 'p':
				heroi2 = Naipe.COPAS;
				break;
			case 'A': 
			case 'a':
				heroi2 = Naipe.ESPADAS;
				break;
			case 'M': 
			case 'm':
				heroi2 = Naipe.OUROS;
				break;
			default:
				System.out.println("Opção invalida");
			}
			
			System.out.print("Herois escolhidos: " + heroi.getNaipe() + " e " + heroi2.getNaipe() + "\n");
	        
			/* Essa parte do código é pra caso um só jogador queira dois naipes
			 Baralho baralhoJogador = new Baralho();
			 
			baralhoJogador.limparBaralho();
			
			for (Carta carta : baralho.getCartas()) {
			    if (carta.getNaipe().equals(heroi.getNaipe())) 
			    	baralhoJogador.addCarta(carta);
			}
			
			for (Carta carta : baralho.getCartas()) {
			    if (carta.getNaipe().equals(heroi2.getNaipe())) 
			    	baralhoJogador.addCarta(carta);
			}
			
			baralhoJogador.shuffle();
			
			Jogador jogador = new Jogador(name, heroi);
			jogador.setBaralhoClasse(baralhoJogador);
			*/
			
			Jogador jogador = new Jogador(name, heroi); // Jogador criado
			jogador.getBaralhoClasse().shuffle();
			jogador.getBaralhoVida().shuffle();
			
			System.out.print(jogador);
			
			
			jogador.sacarCartas();
			System.out.println(jogador.getMao());
			
			Jogador jogador2 = new Jogador(name, heroi2);
			jogador2.getBaralhoClasse().shuffle();
			jogador2.getBaralhoVida().shuffle();
			
			jogador2.sacarCartas();
			System.out.println(jogador2);
			
			/* testes
			jogador2.usarCarta(2);
			System.out.println(jogador2.getMao());
			jogador2.sacarCartas();
			System.out.println(jogador2.getMao());
			System.out.println("descartadas:\n" + jogador2.getBaralhoDescarte());
			*/
			
			Mesa mesa = new Mesa(jogador, jogador2);
		
			mesa.exibirMesa();
			//mesa.ataqueTodosMonstros();
			System.out.println("----------------monstro------------------");
			System.out.println(mesa.getMonster().getMao());
			System.out.println("---------------jogadores------------------");
			System.out.println("Descarte j1:\n" + mesa.getJogadores()[0].getBaralhoDescarte());
			System.out.println("Mão j1:\n" + mesa.getJogadores()[0].getMao());
			System.out.println("-------------------j----------------------");
			System.out.println("Descarte j2:\n" + mesa.getJogadores()[1].getBaralhoDescarte());
			System.out.println("Mão j2:\n" + mesa.getJogadores()[1].getMao());
			System.out.println("wdawdawd");
			
			jogador.sofrerDano();
			jogador.sacarCartas();
			jogador.usarCarta(1);
			jogador.usarCarta(2);
			jogador.sofrerDano();
			jogador.sofrerDano();
			jogador.toString();

			jogador.curarDoDescarte(jogador.getNaipeEnum());

			jogador.curarDoDescarte(jogador.getNaipeEnum());

			jogador.curarDoDescarte(jogador.getNaipeEnum());
			System.out.println(jogador);
			System.out.println("wdawdawd");
			
	}
	
	public static void div() {
		System.out.println("-----------------------------------------------------------------");
	}
	
}