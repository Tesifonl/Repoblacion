package repoblacion.modelo;

import java.util.Random;

public class Bosque {
	
	public static final int MAX_ALTURA=500;
	
	public static final int MINIMO=10;
	
	public static final int MAX_ANCHURA=1000;

	public static final int MAX_ESPECIES=4;
	
	private Arbol arbolMasAlejado;
	private Arbol arbolMasCentrado;
	private Arbol [] arrayArbol;
	private Random generador;
	private int ancho;
	private int alto;

	
	

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	
	public Bosque( int ancho, int alto, int poblacion) {
		

			setAncho(ancho);
			setAlto (alto);	
			generador = new Random();
			arrayArbol=new Arbol[poblacion];
			repoblar();
		}
	
	
	
	public Arbol [] duplicaBosque () {
		
		 Arbol []copiaArrayArbol=new Arbol [arrayArbol.length];
		 
		 for (int i=0;i<arrayArbol.length; i++) {
			 
			 copiaArrayArbol[i]=new Arbol(arrayArbol[i].getEspecie(),arrayArbol[i].getPosicion());
				 
		 }
		 return copiaArrayArbol;	 
	}
	
	
		
		
	}

 


