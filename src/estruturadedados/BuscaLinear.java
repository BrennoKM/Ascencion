package estruturadedados;

import java.util.ArrayList;

public class BuscaLinear<T> implements BuscaLinearInterface<T> {
	public int buscar(MyArrayList<T> lista, T valorProcurado) throws Excessao{
	      for (int i = 0; i < lista.size(); i++) {
	         if (lista.get(i) == valorProcurado) {
	            return i;
	         }
	      }
	      return -1;
	   }
}
