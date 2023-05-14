package estruturadedados;

import Model.Entity.Carta;

public class Ordenacao {
	
	private Carta[] cartas = new Carta[52];
	private MyStack baralhoOrdenado;
	 
	public Ordenacao(MyStack<Carta> pilha) {
		int maxPilha = pilha.getTop() + 1;
		MyStack<Carta> aux = pilha;
		for(int i = 0; i < maxPilha; i++) {
			if(!pilha.isEmpty()) {
				this.cartas[i] = pilha.pop();
			}
		}
		
		baralhoOrdenado = ordenar2(this.cartas);
	}
	
	static MyStack ordenar2(Carta vetor[]) { // Confirmado passo a passo
		for(int j = 0; j < vetor.length; j++) {
			int menorIndice = j;
			for(int i = j; i < vetor.length; i++) {
				if(vetor[i] != null) {
					if(vetor[i].getValor() < vetor[menorIndice].getValor()) {
						menorIndice = i;
					}
				}
			}
			
			Carta aux = vetor[j];
			vetor[j] = vetor[menorIndice];
			vetor[menorIndice] = aux;	
			
		}
		
		return vetorPraPilha(vetor);
	}
	
	static MyStack vetorPraPilha(Carta[] vet) {
		MyStack<Carta> pilha = new MyStack<Carta>(52);
		for(Carta carta: vet) {
			pilha.push(carta);
		}
		
		return pilha;
	}

	public MyStack getBaralhoOrdenado() {
		return baralhoOrdenado;
	}

	public void setBaralhoOrdenado(MyStack baralhoOrdenado) {
		this.baralhoOrdenado = baralhoOrdenado;
	}
	
}
