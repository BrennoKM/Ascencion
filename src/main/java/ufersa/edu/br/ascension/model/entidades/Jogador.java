/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.model.entidades;

import ufersa.edu.br.ascension.model.baralho.Baralho;
import ufersa.edu.br.ascension.model.baralho.Carta;
import ufersa.edu.br.ascension.model.baralho.MaoJogador;
import ufersa.edu.br.ascension.model.enums.Enums;
import ufersa.edu.br.ascension.model.enums.Enums.Naipe;

public class Jogador {
    String nome;
    private Baralho baralhoClasse = null;
    private Baralho baralhoVida = null;
    private Baralho baralhoDescarte = null;
    private MaoJogador mao = null;
    
    public Jogador(String nome, Naipe classe){
        this.nome = nome;
        baralhoClasse = new Baralho(classe);
        baralhoVida = new Baralho(Enums.inverterNaipe(classe));
    }
    
    public void sacarCartas(){
        while(mao.verificarCheia()){
            if(baralhoClasse.verificarVazio()){
                baralhoClasse.setCartas(baralhoDescarte.getCartas());
                baralhoClasse.shuffle();
                baralhoDescarte.limparBaralho();
            }
            mao.addCarta(baralhoClasse.distribuirCarta());
        }
    }
    
    public void usarCarta(int index){
        if(mao.consultarIndice(index) != null){
            baralhoDescarte.addCarta(mao.removerIndice(index));
        }
    }
    
    public boolean sofrerDano(){
        Carta carta = baralhoVida.distribuirCarta();
        if(carta != null){
            baralhoDescarte.addCarta(carta);
            return true;
        }
        return false;
    }
    
    public Carta consultarMao(int index){
        if(mao.consultarIndice(index) != null){
            return mao.consultarIndice(index);
        }
        return null;
    }
    
    public void mostrarBaralho(){
        baralhoClasse.toString();
    }
    
    public MaoJogador getCartasMao(){
        return this.mao;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String toString() {
        return "Informações do Jogador:\n"
				+ "--------------------------------------------------------------"
				+ "\nNome = " + nome + "\nCartas = " + mao + "\nMonteDescartadas = " + baralhoDescarte
				+ "\nBaralhoDeClasse:\n" + baralhoClasse.toString() + "\nBaralhoDeVida:\n" + baralhoVida.toString() + "\n";
	
    }
}
