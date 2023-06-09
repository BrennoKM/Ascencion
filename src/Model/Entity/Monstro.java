package Model.Entity;

import java.util.Random;
import java.util.Stack;

import Model.Entity.Enums.Naipe;
import Model.Entity.Enums.Valor;
import estruturadedados.Fila;
import estruturadedados.MyStack;
import estruturadedados.Pilha;

public class Monstro {
	
    private Baralho baralhoMonstro = null;
    private Baralho monstrosMortos = null;
    private MaoMonstro mao = null;
    
    public Monstro(){
        baralhoMonstro = new Baralho();
        monstrosMortos = new Baralho();
        monstrosMortos.limparBaralho();
        mao = new MaoMonstro();
    }
    
    public void resetarBaralhoMonstro(){
        baralhoMonstro = new Baralho();
        baralhoMonstro.shuffle();
    }
    
    public void removerDeuses(){
    	MyStack<Carta> aux = new MyStack<Carta>(48);
        for(int i = 0; i < baralhoMonstro.getCartas().size(); i++) { // mudar de getTop() + 1 p size()
            Carta carta = baralhoMonstro.distribuirCarta();
            
            
            if (carta.getValorEnum() != Valor.AS) { // mudar de != pra ==
			// A carta tem valor "AS", faça algo aqui
				aux.push(carta);
			} 
        }
        baralhoMonstro.addCartas(aux);
    }
    
    public boolean sacarCartas(){
        while(!mao.verificarCheia()){
            Carta carta = baralhoMonstro.distribuirCarta();
            
            if(carta == null){
                return false;
            } else {
                mao.addCarta(carta);   
            }
        }
        return true;
    }
    
    public void monstroDerrotado(int index){
        if(mao.consultarIndice(index) != null){
            monstrosMortos.addCarta(mao.removerIndice(index));
        }
    }
    
    public void monstroDerrotado(Carta carta) {
    	if(mao.getMao().get(carta) != null){
    		Carta derrotado = mao.remover(carta);
    		monstrosMortos.addCarta(derrotado);
    		System.out.println("---------------------------------");
    		System.out.println("Monstro: " + derrotado.getValorEnum() + " de " + derrotado.getNaipe() + " derrotado");
    		System.out.println("---------------------------------");
    	}
    }
    
    public Carta consultarMao(int index){
        if(mao.consultarIndice(index) != null){
            return mao.consultarIndice(index);
        }
        return null;
    }
    
    public int numMonstrosMortos() {
    	int cont = 0;
    	while(cont < monstrosMortos.getCartas().getTop() + 1) {
    		cont++;
    	}
    	return cont;
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
				+ "\nCartas em campo:\n" + mao.toString() + "\nMonteDescartadas:\n" + monstrosMortos
				+ "\nBaralho:\n" + baralhoMonstro + "";
	
    }
}
