/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.model.entidades;

import ufersa.edu.br.ascension.model.baralho.Baralho;
import ufersa.edu.br.ascension.model.baralho.Carta;
import ufersa.edu.br.ascension.model.baralho.MaoMonstro;
import ufersa.edu.br.ascension.model.enums.Enums.Valor;

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
    
    public MaoMonstro getCartasMao(){
        return mao;
    }
    
    
    public void mostrarBaralho(){
        baralhoMonstro.toString();
    }
    
    
    public String toString() {
        return "Informações Monstros:\n"
				+ "--------------------------------------------------------------"
				+ "\nCartas em campo = " + mao + "\nMonteDescartadas = " + monstrosMortos
				+ "\nBaralho: " + baralhoMonstro + "";
	
    }
}
