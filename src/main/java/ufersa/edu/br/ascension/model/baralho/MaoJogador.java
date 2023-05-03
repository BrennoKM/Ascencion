/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufersa.edu.br.ascension.model.baralho;

import ufersa.edu.br.ascension.model.estrutudadados.MyStack;

public class MaoJogador {
    private MyStack<Carta> mao = null;
    private MyStack<Carta> maoAuxiliar = null;
    
    public MaoJogador(){
        mao = new MyStack<>(3);
    }
    
    public boolean addCarta(Carta carta){
        if(carta != null && !mao.isFull()){
            mao.push(carta);
            return true;
        }
        return false;
    }
    
    public boolean removeTop(){
        if(!mao.isEmpty()){
            mao.pop();
        }
        return false;
    }
    
    public Carta consultarIndice(int index){
        if(!mao.isEmpty() && (index<mao.size())){
            return mao.search(index);
            
        }
        return null;
    }
    
    public Carta removerIndice(int index){
        if(!mao.isEmpty() && (index<mao.size())){
            Carta carta = mao.search(index);
            maoAuxiliar = new MyStack<>(3);
            for(int i = 0; i < mao.size(); i++){
                if(index != i){
                    maoAuxiliar.push(mao.search(i));
                }
            }
            mao = new MyStack<>(3);
            for(int i = 0; i < maoAuxiliar.size(); i++){
                mao.push(maoAuxiliar.search(i));
            }
            maoAuxiliar = null;
            return carta;
        }
        return null;
    }
    
    public String toString(){
        String str = "";
        for(int i = 0; i < mao.size()-1; i++){
            if(mao.search(i) != null){
                str += mao.search(i).toString();
            }
        }
        return null;
    }
    
    public boolean verificarCheia(){
        if(mao.isFull()){
            return true;
        }
        return false;
    }
}
