package estrutura;

import estrutura.Enums.Naipe;
import estrutura.Enums.Valor;

public class Carta {

    // Atributos privados da carta
    private Naipe naipe;
    private Valor valor;

    // Construtor que recebe o naipe e valor da carta
    public Carta(Naipe naipe, Valor valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    // Método para acessar o naipe da carta
    public Naipe getNaipe() {
        return naipe;
    }

    // Método para acessar o valor da carta
    public Valor getValor() {
        return valor;
    }

    // Método que retorna uma string formatada com o valor e naipe da carta
    public String toString() {
        return valor + " de " + naipe;
    }
}