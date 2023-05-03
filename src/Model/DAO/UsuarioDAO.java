package Model.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Entity.Usuario;

public class UsuarioDAO {
	public static Usuario[] lerUsuariosDoArquivo(String nomeArquivo) {
	    ArrayList<Usuario> usuariosList = new ArrayList<>();

	    try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine().trim();
	            if (line.startsWith("id_usuario=")) {
	                Usuario usuario = new Usuario();
	                usuario.setId_usuario(Integer.parseInt(line.substring(11)));
	                usuario.setLogin(scanner.nextLine().substring(6).trim());
	                usuario.setSenha(scanner.nextLine().substring(6).trim());
	                usuario.setVencidas(Integer.parseInt(scanner.nextLine().substring(9).trim()));
	                usuario.setHeroifavorito(scanner.nextLine().substring(14).trim());
	                usuariosList.add(usuario);
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }

	    return usuariosList.toArray(new Usuario[0]);
	}
	
	public static void cadastrarUsuario(String nomeArquivo, String login, String senha) {
	    Usuario[] usuarios = lerUsuariosDoArquivo(nomeArquivo);
	    boolean usuarioJaExiste = false;

	    for (Usuario usuario : usuarios) {
	        if (usuario.getLogin().equals(login)) {
	            usuarioJaExiste = true;
	            break;
	        }
	    }

	    if (!usuarioJaExiste) {
	        int novoId = usuarios.length + 1;
	        Usuario novoUsuario = new Usuario();
	        novoUsuario.setId_usuario(novoId);
	        novoUsuario.setLogin(login);
	        novoUsuario.setSenha(senha);
	        novoUsuario.setVencidas(0); // novo usuário começa com zero vitórias vencidas
	        novoUsuario.setHeroifavorito(""); // novo usuário ainda não tem herói favorito

	        try (PrintWriter writer = new PrintWriter(new FileOutputStream(nomeArquivo, true))) {
	            writer.println("id_usuario=" + novoId);
	            writer.println("login=" + login);
	            writer.println("senha=" + senha);
	            writer.println("vencidas=0");
	            writer.println("heroifavorito=\n\n");
	            writer.println(); // linha em branco para separar o próximo usuário, se houver
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Usuário cadastrado com sucesso!");
	    } else {
	        System.out.println("O usuário já existe no sistema.");
	    }
	}
	
	public static Usuario fazerLogin(String nomeArquivo, String login, String senha) {
	    Usuario[] usuarios = lerUsuariosDoArquivo(nomeArquivo);

	    for (Usuario usuario : usuarios) {
	        if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
	            Usuario jogador = new Usuario(usuario.getId_usuario(), usuario.getLogin(), usuario.getSenha(), usuario.getVencidas(), usuario.getHeroifavorito());
	            return jogador;
	        }
	    }

	    return null;
	}

}
