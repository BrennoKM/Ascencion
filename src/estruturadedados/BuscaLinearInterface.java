package estruturadedados;

import java.util.ArrayList;

public interface BuscaLinearInterface <T> {
	public int buscar(ArrayList<T> lista, T valorProcurado) throws Excessao;
}
