package Model.Entity;

public class Enums {
	public enum Naipe implements Comparable<Naipe> {
		ESPADAS("Assassinos"), COPAS("Paladinos"), OUROS("Magos"), PAUS("Guerreiros");
		private final String naipe;
		public String getNaipe() {
			return naipe;
		}
		private Naipe(String naipe) {
			this.naipe = naipe;
		}
	}

	public enum Valor implements Comparable<Valor> {
		DOIS(2,"2"), TRES(3,"3"), QUATRO(4,"4"), CINCO(5,"5"), SEIS(6,"6"), SETE(7,"7"), OITO(8,"8"), NOVE(9,"9"), DEZ(10,"10"), VALETE(11,"Valete"), DAMA(12,"Rainha"), REI(13,"Rei"), AS(14,"Ás");
		private final int valor;
		private final String valorString;
		
		public int getValor() {
			return valor;
		}
		
		public String getValorString() {
			return valorString;
		}

		private Valor(int valor, String valorString) {
			this.valor = valor;
			this.valorString = valorString;
		}
	}
        
        public static Naipe inverterNaipe(Naipe naipe) {
	    switch(naipe) {
	        case ESPADAS:
	            return Naipe.COPAS;
	        case COPAS:
	            return Naipe.ESPADAS;
	        case OUROS:
	            return Naipe.PAUS;
	        case PAUS:
	            return Naipe.OUROS;
	        default:
	            return null;
	    }
	}
}
