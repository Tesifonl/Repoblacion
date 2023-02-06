import repoblacion.modelo.Bosque;
import utilidades.Consola;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ancho;
		int alto;
		int poblacion;
		Bosque bosque = null;
		
		ancho=Consola.leerAnchura();
		alto=Consola.leerAnchura();
		
		do {
			poblacion=Consola.leerPoblacion();
			
		} while (poblacion> 2*(ancho+alto));
		
		bosque = new Bosque(ancho, alto, poblacion);
	}
}
