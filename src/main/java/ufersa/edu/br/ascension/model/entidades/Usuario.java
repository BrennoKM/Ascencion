/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.model.entidades;

import ufersa.edu.br.ascension.model.baralho.Baralho;
import ufersa.edu.br.ascension.model.baralho.Carta;
import ufersa.edu.br.ascension.model.estrutudadados.MyArrayList;


public class Usuario {
	  	private int id_usuario;
	    private String login;
	    private String senha;
	    private int vencidas;
	    private String heroifavorito;
	    private MyArrayList<Baralho> baralhoDeClasses;
	    private MyArrayList<Baralho> baralhoDeVidas;
	    private MyArrayList<Carta> cartasSelecionadas;
	    private MyArrayList<Carta> cartasDescartadas;
	    
	    public Usuario() {
	        // Construtor vazio
	    }
	    
	    public Usuario(String login, String senha) {
	        this.login = login;
	        this.senha = senha;
	    }
	    
	    public Usuario(int id_usuario, String login, String senha, int vencidas, String heroifavorito) {
	        this.id_usuario = id_usuario;
	        this.login = login;
	        this.senha = senha;
	        this.vencidas = vencidas;
	        this.heroifavorito = heroifavorito;
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
	    
	    public MyArrayList<Baralho> getBaralhoDeClasses() {
	        return baralhoDeClasses;
	    }
	    
	    public void setBaralhoDeClasses (MyArrayList<Baralho> baralhoDeClasses) {
	        this.baralhoDeClasses = baralhoDeClasses;
	    }
	    
	    public MyArrayList<Baralho> getBaralhoDeVidas() {
	        return baralhoDeVidas;
	    }
	    
	    public void setBaralhoDeVidas (MyArrayList<Baralho> baralhoDeVidas) {
	        this.baralhoDeVidas = baralhoDeVidas;
	    }
	    
	    public MyArrayList<Carta> getCartasSelecionadas() {
	        return cartasSelecionadas;
	    }
	    
	    public void setCartasSelecionadas (MyArrayList<Carta> cartasSelecionadas) {
	        this.cartasSelecionadas = cartasSelecionadas;
	    }

		public MyArrayList<Carta> getCartasDescartadas() {
			return cartasDescartadas;
		}

		public void setCartasDescartadas (MyArrayList<Carta> cartasDescartadas) {
			this.cartasDescartadas = cartasDescartadas;
		}

		@Override
		public String toString() {
			return "Painel do jogador " + id_usuario + ", login=" + login + ", senha=" + senha + ", vencidas="
					+ vencidas + ", heroifavorito=" + heroifavorito + ", baralhoDeClasses=" + baralhoDeClasses
					+ ", baralhoDeVidas=" + baralhoDeVidas + ", cartasSelecionadas=" + cartasSelecionadas
					+ ", cartasDescartadas=" + cartasDescartadas + "]";
		}
		
}
