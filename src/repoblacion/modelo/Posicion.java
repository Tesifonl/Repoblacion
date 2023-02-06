package repoblacion.modelo;

public class Posicion {
	
	private double x;
	private double y;
	
	
	public Posicion (double x, double y) {
		
		setX(x);
		setY(y);
	}
	
	public Posicion (Posicion posicion) {
		
		if (posicion != null) {
			setX(posicion.x);
			setY(posicion.y);
		}
		else {
			throw new NullPointerException ("ERROR: No se puede copiar una posición nula.");	
		}
	}

	public double getX() {
		return x;
	}

	private void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	private void setY(double y) {
		this.y = y;
	}
	
	
	public double distancia(Posicion posicion) {
		
		if (posicion!=null) {
			
			return Math.sqrt(Math.pow(x-posicion.x, 2)+ Math.pow(y-posicion.y, 2));}
		
		else {throw new NullPointerException("ERROR: No se puede calcular la distancia a una posición nula.");}
		}

	@Override
	public String toString() {
		return "x=" + String.format("%.3f", x) + ", y=" + String.format("%.3f", y);
	}
	
	
	
}
