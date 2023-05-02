package Model.Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	  	private int id_usuario;
	    private String login;
	    private String senha;
	    private int vencidas;
	    private String heroifavorito;
	    private List<Baralho> baralhoDeClasses;
	    private List<Baralho> baralhoDeVidas;
	    private List<Carta> cartasSelecionadas;
	    private List<Carta> cartasDescartadas;
	    
	    public Usuario() {
	        // Construtor vazio
	    }
	    
	    public Usuario(String login, String senha) {
	        this.login = login;
	        this.senha = senha;
	    }
	    
	    public int getId_usuario() {
	        return id_usuario;
	    }
	    
	    public void setId_usuario(int id_usuario) {
	        this.id_usuario = id_usuario;
	    }
	    
	    public String getLogin() {
	        return login;
	    }
	    
	    public void setLogin(String login) {
	        this.login = login;
	    }
	    
	    public String getSenha() {
	        return senha;
	    }
	    
	    public void setSenha(String senha) {
	        this.senha = senha;
	    }
	    
	    public int getVencidas() {
	        return vencidas;
	    }
	    
	    public void setVencidas(int vencidas) {
	        this.vencidas = vencidas;
	    }
	    
	    public String getHeroifavorito() {
	        return heroifavorito;
	    }
	    
	    public void setHeroifavorito(String heroifavorito) {
	        this.heroifavorito = heroifavorito;
	    }
	    
	    public List<Baralho> getBaralhoDeClasses() {
	        return baralhoDeClasses;
	    }
	    
	    public void setBaralhoDeClasses(List<Baralho> baralhoDeClasses) {
	        this.baralhoDeClasses = baralhoDeClasses;
	    }
	    
	    public List<Baralho> getBaralhoDeVidas() {
	        return baralhoDeVidas;
	    }
	    
	    public void setBaralhoDeVidas(List<Baralho> baralhoDeVidas) {
	        this.baralhoDeVidas = baralhoDeVidas;
	    }
	    
	    public List<Carta> getCartasSelecionadas() {
	        return cartasSelecionadas;
	    }
	    
	    public void setCartasSelecionadas(List<Carta> cartasSelecionadas) {
	        this.cartasSelecionadas = cartasSelecionadas;
	    }

		public List<Carta> getCartasDescartadas() {
			return cartasDescartadas;
		}

		public void setCartasDescartadas(List<Carta> cartasDescartadas) {
			this.cartasDescartadas = cartasDescartadas;
		}

		@Override
		public String toString() {
			return "Usuario [id_usuario=" + id_usuario + ", login=" + login + ", senha=" + senha + ", vencidas="
					+ vencidas + ", heroifavorito=" + heroifavorito + ", baralhoDeClasses=" + baralhoDeClasses
					+ ", baralhoDeVidas=" + baralhoDeVidas + ", cartasSelecionadas=" + cartasSelecionadas
					+ ", cartasDescartadas=" + cartasDescartadas + "]";
		}
		
		
		 public static Usuario[] lerUsuariosDoArquivo(String caminhoDoArquivo) throws IOException {
		        BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo));
		        List<Usuario> usuarios = new ArrayList<>();
		        String linha;

		        while ((linha = br.readLine()) != null) {
		            Usuario usuario = parseStringToUsuario(linha);
		            usuarios.add(usuario);
		        }

		        br.close();

		        Usuario[] vetorDeUsuarios = new Usuario[usuarios.size()];
		        vetorDeUsuarios = usuarios.toArray(vetorDeUsuarios);

		        return vetorDeUsuarios;
		    }

		 private static Usuario parseStringToUsuario(String linha) {
			    String[] campos = linha.split(", ");
			    if (campos.length < 5) {
			        throw new IllegalArgumentException("Linha inválida: " + linha);
			    }
			    Usuario usuario = new Usuario();
			    usuario.setId_usuario(Integer.parseInt(campos[0].substring(campos[0].indexOf('=') + 1)));
			    usuario.setLogin(campos[1].substring(campos[1].indexOf('=') + 1));
			    usuario.setSenha(campos[2].substring(campos[2].indexOf('=') + 1));
			    usuario.setVencidas(Integer.parseInt(campos[3].substring(campos[3].indexOf('=') + 1)));
			    usuario.setHeroifavorito(campos[4].substring(campos[4].indexOf('=') + 1));
			    // ... ler os outros campos e setar no objeto usuario ...
			    return usuario;
			}
		
		
}
