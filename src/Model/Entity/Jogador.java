package Model.Entity;

import java.util.ArrayList;
import java.util.List;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;
import estruturadedados.Excessao;
import estruturadedados.Pilha;

public class Jogador {
    String nome;
    private Baralho baralhoClasse = null;
    private Baralho baralhoVida = null;
    private Baralho baralhoDescarte = null;
    private MaoJogador mao = null;
    private String cor = null;
    private String naipe = null;
    
    public Jogador(String nome, Naipe classe){
        this.nome = nome;
        baralhoClasse = new Baralho(classe);
        baralhoVida = new Baralho(Enums.inverterNaipe(classe));
        baralhoDescarte = new Baralho();
        baralhoDescarte.limparBaralho();
        mao = new MaoJogador();
        cor = this.getBaralhoClasse().getCartas().peek().getCor();
        naipe = this.getBaralhoClasse().getCartas().peek().getNaipe();
    }
    
    public void sacarCartas(){
        while(!mao.verificarCheia()){
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
    
    public void heroiDerrotado(Carta carta) {
    	if(mao.getMao().get(carta) != null){
    		baralhoDescarte.addCarta(mao.remover(carta));
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
    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Baralho getBaralhoClasse() {
		return baralhoClasse;
	}

	public void setBaralhoClasse(Baralho baralhoClasse) {
		this.baralhoClasse = baralhoClasse;
	}

	public Baralho getBaralhoVida() {
		return baralhoVida;
	}

	public void setBaralhoVida(Baralho baralhoVida) {
		this.baralhoVida = baralhoVida;
	}

	public Baralho getBaralhoDescarte() {
		return baralhoDescarte;
	}

	public void setBaralhoDescarte(Baralho baralhoDescarte) {
		this.baralhoDescarte = baralhoDescarte;
	}

	public MaoJogador getMao() {
		return mao;
	}

	public void setMao(MaoJogador mao) {
		this.mao = mao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getNaipe() {
		return naipe;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	public String toString() {
        return "Informações do Jogador:\n"
				+ "--------------------------------------------------------------"
				+ "\nNome = " + nome + "\nCartas em campo:\n" + mao + "\nMonteDescartadas:\n" + baralhoDescarte
				+ "\nBaralhoDeClasse:\n" + baralhoClasse + "\nBaralhoDeVida:\n" + baralhoVida + "\n";
	
    }
}
