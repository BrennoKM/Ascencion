package Model.Entity;

import java.util.Scanner;

import Model.DAO.UsuarioDAO;
import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;
import Model.Service.UsuarioService;
import estruturadedados.Ordenacao;

public class Game {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String []args) throws Exception {
		
		String caminhoRyan = "C:\\Users\\Ryan\\eclipse-workspace-projects\\Ascencion\\src\\Database\\usuarios.txt";
		Usuario usuarios[] = null;
		conexao(caminhoRyan, usuarios);
		
		System.out.println("BEM-VINDO AO GAME ASCENSION\n");

		 
		 	// Instância dos jogadores
			Jogador jogador = addJogador();
			jogador.getBaralhoClasse().shuffle();
			jogador.getBaralhoVida().shuffle();
			jogador.sacarCartas();
			
			Jogador jogador2 = addJogador();
			jogador2.getBaralhoClasse().shuffle();
			jogador2.getBaralhoVida().shuffle();
			jogador2.sacarCartas();
			
			// Criação da mesa
			Mesa mesa = new Mesa(jogador, jogador2);
			
			// mesa.exibirCemiterio();
			
			while(!mesa.jogadoresGanharam() && !mesa.monstrosGanharam()) {
				// novo turno
				mesa.saqueDeCartas();
				mesa.exibirCartas();
				
				// vez dos jogadores
				mesa.ataqueDoJogador(mesa.getJogadores()[0]);
				mesa.ataqueDoJogador(mesa.getJogadores()[1]);
				
				// vez dos monstros
				mesa.ataqueTodosMonstros();
				
				// mostrar resultados do turno
				mesa.exibirCemiterio();
				mesa.exibirVidas();
				
				if(!mesa.jogadoresGanharam() && !mesa.monstrosGanharam()) {
					System.out.println();
					div();
					System.out.println("------------------------------NOVO-TURNO------------------------------");
					div();
					System.out.println();
				}
			}
			
			if(mesa.jogadoresGanharam()) {
				System.out.println("Parabéns! Os jogadores venceram.\n");
			} 
			else if(mesa.monstrosGanharam()) {
				System.out.println("Essa não! Os monstros venceram...\n");
			}
			
			System.out.println("----------------------------HEROIS-RESTANTES----------------------------");
			Ordenacao ord = new Ordenacao(mesa.getJogadores()[0].getBaralhoClasse().getCartas());
			System.out.println("Jogador 1:\n");
			System.out.println(ord.getBaralhoOrdenado());
			ord = new Ordenacao(mesa.getJogadores()[1].getBaralhoClasse().getCartas());
			System.out.println("Jogador 2:\n");
			System.out.println(ord.getBaralhoOrdenado());
			
	}
	
	public static void div() {
		System.out.println("----------------------------------------------------------------------");
	}
	
	public static Jogador addJogador() {
		System.out.print("Digite o nome do seu jogador: ");
		String name = scanner.next();
		Naipe heroi = Naipe.PAUS;
		System.out.print("Escolha a sua classe:\n[G]uerreiros	[P]aladinos	[A]assassinos	[M]agos\nSua opção: ");
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
		
		Jogador jogador = new Jogador(name, heroi); // Jogador criado
		
		return jogador;
	}
	
	public static Usuario conexao(String caminho, Usuario[] usuarios) throws Exception {
	    int opcao;
	    String nome,senha;

	    //do {
	        System.out.println("================================");    
	        System.out.println("SEJA BEM-VINDO AO GAME ASCENSION ");
	        System.out.println("================================\n");
	        System.out.println("Digite 1 para realizar o login\nDigite 2 para realizar o cadastro\n"
	        		+ "Digite 3 para sair da aplicação\nDigite 4 para ver usuarios cadastrados");
	        System.out.print("Opção escolhida: ");
	        opcao = scanner.nextInt();
	        scanner.nextLine(); // limpa o buffer do teclado
	        Usuario jogador = null;
	        
	        switch (opcao) {
	            case 1:
	            	 System.out.print("Digite o login: ");
	         	    nome = scanner.next();
	         	    System.out.print("Digite a senha: ");
	         	    senha = scanner.next();
	         	    jogador = UsuarioDAO.fazerLogin(caminho, nome, senha);

	         	    if (jogador != null) {
	         	        System.out.println("Login realizado com sucesso. Dados do jogador:");
	         	        UsuarioService.exibirPainelDeUsuario(jogador);
	         	    } else {
	         	    	throw new Exception("Não foi possível fazer o login. Verifique as informações de login e senha.");
	         	    }
	                break;
	            case 2:
	            	System.out.print("Digite o nome do usuario:");
	        		nome = scanner.next();
	        		System.out.print("Digite a senha do usuario:");
	        		senha = scanner.next();
	        		UsuarioDAO.cadastrarUsuario(caminho, nome, senha);
	        		jogador = UsuarioDAO.fazerLogin(caminho, nome, senha);
	        		if (jogador != null) {
	         	        System.out.println("Cadastro realizado com sucesso. Dados do jogador:");
	         	        UsuarioService.exibirPainelDeUsuario(jogador);
	         	    }
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

	    //} while (opcao != 3);
	        
	        return jogador;

	}
	
	/*public static void conexao() {
		String caminhoJovit = "C:\\Users\\Usuário\\Documents\\GitHub\\Ascencion\\src\\Database\\usuarios.txt";
		String caminhoRyan = "C:\\Users\\Ryan\\eclipse-workspace-projects\\Ascencion\\src\\Database\\usuarios.txt";
		Usuario[] usuarios = UsuarioDAO.lerUsuariosDoArquivo(caminhoRyan);
		    for (Usuario usuario : usuarios) {
		        System.out.println(usuario.toString());
		}
		    
		System.out.print("Digite o nome do usuario:");
		String nome = scanner.next();
		System.out.print("Digite a senha do usuario:");
		String senha = scanner.next();
		UsuarioDAO.cadastrarUsuario(caminhoRyan, nome, senha);
		 
		usuarios = UsuarioDAO.lerUsuariosDoArquivo(caminhoRyan);
	    for (Usuario usuario : usuarios) {
	        System.out.println(usuario.toString());
	    }
	    
	    System.out.print("Digite o login: ");
	    nome = scanner.next();
	    System.out.print("Digite a senha: ");
	    senha = scanner.next();
	    Usuario jogador = UsuarioDAO.fazerLogin(caminhoRyan, nome, senha);

	    if (jogador != null) {
	        System.out.println("Login realizado com sucesso. Dados do jogador:");
	        UsuarioService.exibirPainelDeUsuario(jogador);
	    } else {
	        System.out.println("Não foi possível fazer o login. Verifique as informações de login e senha.");
	    }
	}*/
	
}