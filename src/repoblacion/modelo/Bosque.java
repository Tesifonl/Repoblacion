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
		if (ancho<10 ||ancho>1000) {
			throw new IllegalArgumentException("ERROR: Anchura no válida.");
		}
		else {
			this.ancho = ancho;
		}
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		if (alto<10 ||alto>500 ) {
			throw new IllegalArgumentException("ERROR: Altura no válida.");
		}
		else {
			this.alto = alto;
		}
	}
	
	
	public Bosque( int ancho, int alto, int poblacion) {
		

			setAncho(ancho);
			setAlto (alto);	
			generador = new Random();
			checkPoblacion(poblacion);
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
	
public void checkPoblacion(int poblacion) {
		
		if (poblacion > 0) {
			if (poblacion> 2*(ancho+alto)) {throw new IllegalArgumentException ("ERROR: La población no puede superar el perímetro del bosque.");}
		}
		else {
			throw new IllegalArgumentException ("ERROR: La población debe ser mayor que cero.");
		}
}
	
	
	private boolean existeEspecie(Especie [] arrayEspecie,Especie especie) {/* hemos creado este metodo para utilizarlo en repoblar aunque no vieene en el diagrama*/
		boolean encontrado=false;
		for (int i=0;i<arrayEspecie.length;i++) 
		{if (arrayEspecie[i]!=null){ if (arrayEspecie[i].equals(especie)) {encontrado=true;}}}
		return encontrado;
	}
	
	
	public void repoblar() {
		
		int aleatorioEspecie=0;
		int totalEspecies=0;
		int xaleatorio;
		int yaleatorio;
		Arbol nuevo;	
		Posicion posicion;
		int i=0;
		Especie [] arrayEspecie= new Especie [4];

		
		while (i<arrayArbol.length) { 
		
		aleatorioEspecie=generador.nextInt(7);
		xaleatorio=-ancho/2+generador.nextInt(ancho/2-(-ancho/2));/* pongo primero el -ancho/2 porque el nextInt empieza desde cero y asi lo bajamos*/
		yaleatorio=-alto/2+generador.nextInt(alto/2-(-alto/2));
		
		posicion=new Posicion (xaleatorio,yaleatorio);
		

		switch (aleatorioEspecie) {
		
		 case (0): { if (!existeEspecie(arrayEspecie,Especie.ALAMO)||totalEspecies<4){ if (i==0) {nuevo=new Arbol(Especie.ALAMO,posicion );
		 arrayArbol[i]=nuevo;i++;arrayEspecie[totalEspecies]=Especie.ALAMO;totalEspecies++;} else {if (!arrayArbol[i-1].getEspecie().equals(Especie.CASTANO) && !arrayArbol[i-1].getEspecie().equals(Especie.CIPRES)&&
				 !arrayArbol[i-1].getEspecie().equals(Especie.OLIVO)) {nuevo=new Arbol(Especie.ALAMO,posicion ); arrayArbol[i]=nuevo;i++;arrayEspecie[totalEspecies]=Especie.ALAMO;totalEspecies++;}}}
		 	break;
		 } 
		
		 case (1): {if (!existeEspecie(arrayEspecie,Especie.ENCINA)||totalEspecies<4) {nuevo=new Arbol(Especie.ENCINA,posicion );
		 arrayArbol[i]=nuevo;i++;} 
		 	break;
		 }
		 
		 case (2): {if (!existeEspecie(arrayEspecie,Especie.CASTANO)||totalEspecies<4) {nuevo=new Arbol(Especie.CASTANO,posicion );
		 arrayArbol[i]=nuevo;i++;}
		 	break;
		 }
		 
		 case (3): {if (!existeEspecie(arrayEspecie,Especie.CIPRES)||totalEspecies<4) {nuevo=new Arbol(Especie.CIPRES,posicion );
		 arrayArbol[i]=nuevo;i++;} 
		 	break;
		 }
		 
		 case (4): {if (!existeEspecie(arrayEspecie,Especie.PINO)||totalEspecies<4) {nuevo=new Arbol(Especie.PINO,posicion );
		 arrayArbol[i]=nuevo;i++;} 
		 	break;
		 }
		 
		 case (5): {if (!existeEspecie(arrayEspecie,Especie.ROBLE)||totalEspecies<4) {nuevo=new Arbol(Especie.ROBLE,posicion );
		 arrayArbol[i]=nuevo;i++;}
		 	break;
		 }
		 
		 case (6): {if (!existeEspecie(arrayEspecie,Especie.OLIVO) || totalEspecies < 4){ if (i==0) {nuevo=new Arbol(Especie.OLIVO,posicion );
		 arrayArbol[i]=nuevo;i++;arrayEspecie[totalEspecies]=Especie.OLIVO;totalEspecies++;} else {if (!arrayArbol[i-1].getEspecie().equals(Especie.ALAMO) && !arrayArbol[i-1].getEspecie().equals(Especie.CIPRES)&&
				 !arrayArbol[i-1].getEspecie().equals(Especie.ENCINA) || totalEspecies < 4) {nuevo=new Arbol(Especie.OLIVO,posicion ); arrayArbol[i]=nuevo;i++;arrayEspecie[totalEspecies]=Especie.OLIVO;totalEspecies++;}}}
		 	break;
		 }
		
		}}}
		
		public Arbol getArbolMasCercano() {
			double distancia=0;
			double distanciaminima=Double.MAX_VALUE;
			Arbol arbolMasCercano=null;
			
			for (int i=0;i<arrayArbol.length;i++)
			{ distancia=arrayArbol[i].getPosicion().distancia(new Posicion (0,0));
			 if (distancia<distanciaminima) {distanciaminima=distancia; arbolMasCercano=arrayArbol[i];}}
			  
			return arbolMasCercano;	}
				
		
		public Arbol getArbolMasAlejado() {
			double distancia=0;
			double distanciamaxima=0;
			Arbol arbolMasAlejado=null;
			
			
			for (int i=0;i<arrayArbol.length;i++)
			{ distancia=arrayArbol[i].getPosicion().distancia(new Posicion (0,0));
			 if (distancia>distanciamaxima) {distanciamaxima=distancia; arbolMasAlejado=arrayArbol[i];}}
			  
			return arbolMasAlejado;	
		}
		
		
		public void realizarCalculos() {
			
			Arbol ArbolMasCercano=getArbolMasCercano();
			Arbol ArbolMasAlejado=getArbolMasAlejado();
			
			System.out.println(" Arbol mas cercano"+ArbolMasCercano+ " Arbol mas alejado"+ArbolMasAlejado);
		}
		
		
	}

 


