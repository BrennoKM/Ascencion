package estrutura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import estrutura.Enums.Naipe;
import estrutura.Enums.Valor;

public class Baralho {

    private List<Carta> cartas;

    public Baralho() {
        this.cartas = new ArrayList<>();
        for (Naipe naipe : Naipe.values()) {
            for (Valor valor : Valor.values()) {
                this.cartas.add(new Carta(naipe, valor));
            }
        }
    }
    
    public Baralho(Naipe naipe) {
    	this.cartas = new ArrayList<>();
        this.cartas.clear();
        for (Valor valor : Valor.values()) {
            this.cartas.add(new Carta(naipe, valor));
        }
    }

    public int tamanho() {
        return this.cartas.size();
    }

    public void adicionarCarta(Carta carta) {
        this.cartas.add(carta);
    }
    
    public void adicionarCartas(List<Carta> cartas) {
        for (Carta carta : cartas) {
            adicionarCarta(carta);
        }
    }

    public void embaralhar() {
        Collections.shuffle(this.cartas);
    }

    public Carta distribuirCarta() {
        if (!this.cartas.isEmpty()) {
        	return this.cartas.remove(0);
        }
        return null;
    }

    

}
