package repoblacion.modelo;

public class Arbol {
	
	private Posicion posicion;
	private Especie especie;
	
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public Arbol (Especie especie, Posicion posicion) {

		if (especie == null) {
			throw new NullPointerException("ERROR: La especie no puede ser nula.");
		}
		
		if (posicion == null) {
			throw new NullPointerException("ERROR: La posición no puede ser nula.");
		}
		
		
			
		setEspecie(especie);
		setPosicion(posicion);
	}
	
	public Arbol (Arbol arbol) {
		
		if (arbol != null) {
		
			setEspecie(arbol.especie);
			setPosicion(arbol.posicion);
		}
		else {
			throw new NullPointerException("ERROR: No se puede copiar un árbol nulo.");
		}
	}
	
	
	
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public Especie getEspecie() {
		return especie;
	}
	private void setEspecie(Especie especie) {
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "especie=" + especie + ", posicion=(" + posicion + ")";
	}
	
	

}
