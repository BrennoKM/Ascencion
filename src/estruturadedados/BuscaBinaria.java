package estruturadedados;

public class BuscaBinaria <T>{
	public static <T extends Comparable<T>> int buscar(T[] array, T valorProcurado) {
		 int inicio = 0; 
		    int fim = array.length - 1;
		    while (inicio <= fim) {
		        int meio = (inicio + fim) / 2;
		        int comp = array[meio].compareTo(valorProcurado);
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
