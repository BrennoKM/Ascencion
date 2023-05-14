package estruturadedados;

import java.util.ArrayList;

public interface BuscaLinearInterface <T> {
	public int buscar(MyArrayList<T> lista, T valorProcurado) throws Excessao;
}
