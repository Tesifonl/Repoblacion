package utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	public static int leerAnchura() {
		
		int ancho=0;
		
		do {
		System.out.println("Debe introducir una anchura");
		ancho=Entrada.entero();} while (ancho<10 ||ancho>1000 );
	
		return ancho;}
	
	public static int leerAltura() {
		
		int alto=0;
		
		do {
		System.out.println("Debe introducir una altura");
		alto=Entrada.entero();} while (alto<10 ||alto>500 );
	
		return alto;}
	
	public static int leerPoblacion() {
		
		int poblacion=0;
		
		do {
		System.out.println("Debe introducir una poblacion");
		poblacion=Entrada.entero();} while (poblacion<=0 );
	
		return poblacion;}

}
