package repoblacion.modelo;

public enum Especie { 
	
	ALAMO ("Alamo"),ENCINA ("Encina"), CASTANO("Castano"),CIPRES ("Cipres"),PINO("Pino"),ROBLE("Roble"), OLIVO("Olivo");
	
	private String cadenaAMostrar;
	
	private Especie (String cadenaAMostrar) {
		
		this.cadenaAMostrar=cadenaAMostrar;
	}

	public String toString() { 
		return cadenaAMostrar;
		
	}
}
