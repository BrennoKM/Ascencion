/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import estruturadedados.MyLinkedList;
import estruturadedados.MyStack;

public class MaoJogador {
    private MyLinkedList<Carta> mao = null;
    private MyLinkedList<Carta> maoAuxiliar = null;
    
    public MaoJogador(){
        mao = new MyLinkedList<>();
    }
    
    public boolean addCarta(Carta carta){
        if(carta != null && !mao.isFull()){
            mao.addLast(carta);
            return true;
        }
        return false;
    }
    
    public Carta remover(Carta carta) {
    	if(!mao.isEmpty()) {
    		mao.remove(carta);
    		return carta;
    	}
    	return null;
    }
    
    public boolean removeTop(){
        if(!mao.isEmpty()){
            mao.removeLast();
        }
        return false;
    }
    
    public Carta consultarIndice(int index){
        if(!mao.isEmpty() && (index<mao.size())){
            return mao.searchIndex(index);
            
        }
        return null;
    }
    
    public Carta removerIndice(int index){
        if(!mao.isEmpty() && (index<mao.size())){
            Carta carta = mao.searchIndex(index);
            maoAuxiliar = new MyLinkedList<>();
            
            for(int i = 0; i < mao.size(); i++){
                if(index != i){
                    maoAuxiliar.addLast(mao.searchIndex(i));
                }
            }
            mao = new MyLinkedList<>();
            for(int i = 0; i < maoAuxiliar.size(); i++){
                mao.addLast(maoAuxiliar.searchIndex(i));
            }
            maoAuxiliar = null;
            return carta;
        }
        return null;
    }
    
    public boolean verificarCheia(){
        if(mao.isFull()){
            return true;
        }
        return false;
    }

	public MyLinkedList<Carta> getMao() {
		return mao;
	}

	public void setMao(MyLinkedList<Carta> mao) {
		this.mao = mao;
	}

	public MyLinkedList<Carta> getMaoAuxiliar() {
		return maoAuxiliar;
	}

	public void setMaoAuxiliar(MyLinkedList<Carta> maoAuxiliar) {
		this.maoAuxiliar = maoAuxiliar;
	}

	public String toString(){
		String str = "";
	    for(int i = 0; i < mao.size(); i++){
	    	if(mao.searchIndex(i) != null){
	    		str += mao.searchIndex(i).toString() + "\n";
	        }
	    }
	    return str;
	}
	
}
