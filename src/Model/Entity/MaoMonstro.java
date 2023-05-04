/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import estruturadedados.MyLinkedList;
import estruturadedados.MyStack;

public class MaoMonstro {
    private MyLinkedList<Carta> mao = null;
    private MyLinkedList<Carta> maoAuxiliar = null;
    
    public MaoMonstro(){
        mao = new MyLinkedList<>();
    }
    
    public boolean addCarta(Carta carta){
        if(carta != null && !mao.isFull()){
            mao.addLast(carta);
            return true;
        }
        return false;
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
            System.out.println(carta);
            return carta;
        }
        return null;
    }
    
    public boolean verificarCheia(){
        if(mao.size() >= 3){
            return true;
        } else {
            return false;	
        }
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
