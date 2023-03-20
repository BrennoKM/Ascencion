package estrutura;

public class Enums {
	public enum Naipe implements Comparable<Naipe> {
		ESPADAS, COPAS, OUROS, PAUS;

	}

	public enum Valor implements Comparable<Valor> {
		DOIS, TRES, QUATRO, CINCO, SEIS, SETE, OITO, NOVE, DEZ, VALETE, DAMA, REI, AS;

	}
}
