package Model.Entity;

import java.io.FileWriter;
import java.io.IOException;
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
	    
	    @Override
	    public String toString() {
	        return "Usuario [id_usuario=" + id_usuario + ", login=" + login + ", senha=" + senha + ", vencidas=" + vencidas
	                + ", heroifavorito=" + heroifavorito + ", baralhoDeClasses=" + baralhoDeClasses + ", baralhoDeVidas="
	                + baralhoDeVidas + ", cartasSelecionadas=" + cartasSelecionadas + "]";
	    }
}
