package estruturadedados;

import java.util.ArrayList;

public class BuscaLinear<T> implements BuscaLinearInterface<T> {
	public int buscar(ArrayList<T> lista, T valorProcurado) {
	      for (int i = 0; i < lista.size(); i++) {
	         if (lista.get(i) == valorProcurado) {
	            return i;
	         }
	      }
	      return -1;
	   }
}
