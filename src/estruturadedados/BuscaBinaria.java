package estruturadedados;

import Model.Entity.Jogador;

public class BuscaBinaria <T>{
	public static <T extends Comparable<T>> int buscar(T[] jogadores, T jogadores2) {
		 int inicio = 0; 
		    int fim = jogadores.length - 1;
		    while (inicio <= fim) {
		        int meio = (inicio + fim) / 2;
		        int comp = jogadores[meio].compareTo(jogadores2);
		        if (comp == 0) {
		            return meio;
		        } else if (comp < 0) {
		            inicio = meio + 1;
		        } else {
		            fim = meio - 1;
		        }
		    }
		    return -1;
    }
}
