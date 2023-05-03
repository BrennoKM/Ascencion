package Model.Entity;

import java.util.Random;
import java.util.Stack;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;
import estruturadedados.Fila;
import estruturadedados.Pilha;

public class Monstro {
	
    private Baralho baralhoMonstro = null;
    private Baralho monstrosMortos = null;
    private MaoMonstro mao = null;
    
    public Monstro(){
        baralhoMonstro = new Baralho();
        baralhoMonstro.shuffle();
        monstrosMortos = new Baralho();
        monstrosMortos.limparBaralho();
        mao = new MaoMonstro();
    }
    
    public void resetarBaralhoMonstro(){
        baralhoMonstro = new Baralho();
        baralhoMonstro.shuffle();
    }
    
    public void removerDeuses(){
        for(int i = 0; i < 52; i++) {
            Carta carta = baralhoMonstro.distribuirCarta();
		if (carta.getValorEnum() != Valor.AS) {
		// A carta tem valor "AS", faça algo aqui
		baralhoMonstro.addCarta(carta);
		}	
	}
    }
    
    public boolean sacarCartas(){
        while(!mao.verificarCheia()){
            Carta carta = baralhoMonstro.distribuirCarta();
            
            if(carta == null){
                return false;
            } else {
                mao.addCarta(baralhoMonstro.distribuirCarta());
                
            }
        }
        return true;
    }
    
    public void monstroDerrotado(int index){
        if(mao.consultarIndice(index) != null){
            monstrosMortos.addCarta(mao.removerIndice(index));
        }
    }
    
    public Carta consultarMao(int index){
        if(mao.consultarIndice(index) != null){
            return mao.consultarIndice(index);
        }
        return null;
    }
    
    
    public Baralho getBaralhoMonstro() {
		return baralhoMonstro;
	}

	public void setBaralhoMonstro(Baralho baralhoMonstro) {
		this.baralhoMonstro = baralhoMonstro;
	}

	public Baralho getMonstrosMortos() {
		return monstrosMortos;
	}

	public void setMonstrosMortos(Baralho monstrosMortos) {
		this.monstrosMortos = monstrosMortos;
	}

	public MaoMonstro getMao() {
		return mao;
	}

	public void setMao(MaoMonstro mao) {
		this.mao = mao;
	}

	public void mostrarBaralho(){
        baralhoMonstro.toString();
    }
    
    
    public String toString() {
        return "Informações Monstros:\n"
				+ "--------------------------------------------------------------"
				+ "\nCartas em campo:\n" + mao + "\nMonteDescartadas:\n" + monstrosMortos
				+ "\nBaralho:\n" + baralhoMonstro + "";
	
    }
}
