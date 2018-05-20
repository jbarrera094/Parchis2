package co.edu.eia.parchis.views.utils;



import java.util.ArrayList;


public class magia {


	//Devuelve un arraylist de coordenadas de las casillas del tablero en orden
	//Los dos primeros elementos son las 2 Coordenadas de la casilla 0
	
	public static ArrayList<Coordenada>  casillasTablero(int pix) {
		// Dado que x es el lado del cuadrado, entonces (pongo 900 solo por probar):
		double x = pix;
		
		double l = x/9; //Largo relativo de una casilla
		double a = x/21; //Ancho relativo de una casilla
		
		ArrayList<Coordenada> casillas = new ArrayList<Coordenada>();
		
		//Generar a partir de 0 (5l,a)
		//1)
		imprimirV('a',5*l,a, casillas,x);
		//Curva
		//7)
		casillas.add(convertir((5*l)-l/12,8*a,x)); casillas.add(convertir((5*l)+l/4,8*a,x));
		//8)
		casillas.add(convertir(13*a,4*l,x)); casillas.add(convertir(13*a,(4*l)-l/3,x));
		
		
		//Generar a partir de 9: (6l,7a+l) 
		//2)
		imprimirH('d', 6*l,(7*a + l), casillas,x);
		
		/////// Seguro de cielo 16
		casillas.add(convertir(20*a,5*l,x)); casillas.add(convertir(20*a, 5*l - l/2,x));
		
		//Generar a partir de (20a,14a)
		//3)
		imprimirH('i',20*a, 14*a, casillas,x);
		
	
		/////Curva
		//24)
		casillas.add(convertir(13*a,6*l -l/6,x)); casillas.add(convertir(13*a,6*l -l/2,x));
		//25)
		casillas.add(convertir((5*l)-l/12,6*l,x)); casillas.add(convertir((5*l)+l/4,6*l,x));
		
		//Generar desde 26: (5a,15a) 
		//4)
		imprimirV('a',5*l,15*a, casillas,x);
		
		/////// Seguro de cielo 33:
		casillas.add(convertir(4*l,9*l,x)); casillas.add(convertir(4*l + l/2,9*l,x));
		
		
		//Generar desde 34: (3l,21a)
		imprimirV('b', 3*l,21*a, casillas,x);
		
		/////Curva
		//41
		casillas.add(convertir(3*l+l/4,6*l,x)); casillas.add(convertir(3*l + l/2 + l/12,6*l,x));
		//42
		casillas.add(convertir(7*a - l/20,6*l -l/6,x)); casillas.add(convertir(7*a - l/20,6*l - l/2,x));
		
		
		//Generar desde 43: (6a,14a)
		imprimirH('i', 6*a, 14*a, casillas,x);
		
		/////// Seguro de cielo
		casillas.add(convertir(0,5*l,x)); casillas.add(convertir(0,5*l -l/2,x));
		
		//Generar desde 51: (0,7a+l)
		imprimirH('d', 0, 7*a+l, casillas,x);
		
		/////Curva
		
		casillas.add(convertir(7*a - l/20,4*l,x)); casillas.add(convertir(7*a - l/20,4*l-l/3,x));
		casillas.add(convertir(3*l+l/4,8*a,x)); casillas.add(convertir(3*l + l/2 + l/12,8*a,x));
		
		//Generar desde 60: (7a,7a)
		imprimirV('b', 3*l,7*a, casillas,x);
		
		
		/////// Seguro de cielo
		casillas.add(convertir(4*l,a,x)); casillas.add(convertir(4*l + l/2,a,x));
		
		return casillas;
	}
	
	public static ArrayList<Coordenada> cielo0(int pix) {
		double x = pix;
		
		double l = x/9; //Largo relativo de una casilla
		double a = x/21; //Ancho relativo de una casilla
		ArrayList<Coordenada> cielo0 = new ArrayList<Coordenada>();
		imprimirV ('a', 4*l, a*2, cielo0, x);
		return cielo0;
	}
	
	public static ArrayList<Coordenada> cielo1(int pix) {
		double x = pix;
		
		double l = x/9; //Largo relativo de una casilla
		double a = x/21; //Ancho relativo de una casilla
		ArrayList<Coordenada> cielo1 = new ArrayList<Coordenada>();
		imprimirH ('i', 6*l+5*a, l*5, cielo1, x);
		return cielo1;
	}
	public static ArrayList<Coordenada> cielo2(int pix) {
		double x = pix;
		
		double l = x/9; //Largo relativo de una casilla
		double a = x/21; //Ancho relativo de una casilla
		ArrayList<Coordenada> cielo2 = new ArrayList<Coordenada>();
		imprimirV ('b', 4*l , 6*l+6*a, cielo2, x);
		return cielo2;
	}
	public static ArrayList<Coordenada> cielo3(int pix) {
		double x = pix;
		
		double l = x/9; //Largo relativo de una casilla
		double a = x/21; //Ancho relativo de una casilla
		ArrayList<Coordenada> cielo3 = new ArrayList<Coordenada>();
		imprimirH ('d', a, 5*l, cielo3, x);
		return cielo3;
	}

	public static void imprimirV(char d, double x1, double y1, ArrayList<Coordenada> list, double size) {
		Coordenada c1 = new Coordenada();
		Coordenada c2= new Coordenada();
		
		if(d=='a') {
			for(int i=0;i<7; i++) {
				c1.setY(size-y1);
				c1.setX(x1);
				c2.setX(x1+(size/18));
				c2.setY(size-y1);
				
				list.add(c1);
				list.add(c2);
				
				c1 = new Coordenada();
				c2 = new Coordenada();
				//Cambio en Y
				y1+=size/21;
			}

		}else {
			for(int i=0;i<7; i++) {
				c1.setY(size-y1);
				c1.setX(x1);
				c2.setX(x1+(size/18));
				c2.setY(size-y1);
				
				list.add(c1);
				list.add(c2);
				
				c1 = new Coordenada();
				c2 = new Coordenada();
				//Cambio en Y
				y1-=size/21;
			}
		}
	}


	public static void imprimirH(char d, double x1, double y1, ArrayList<Coordenada> list, double size) {
		Coordenada c1 = new Coordenada();
		Coordenada c2= new Coordenada();
		
		if(d=='d') {
			for(int i=0;i<7; i++) {
				c1.setY(size-y1);
				c1.setX(x1);
				
				c2.setX(x1);
				c2.setY(size-y1+(size/18));
				
				list.add(c1);
				list.add(c2);
				
				c1 = new Coordenada();
				c2 = new Coordenada();
				//Cambio en Y
				x1+=size/21;
			}

		}else {
			for(int i=0;i<7; i++) {
				c1.setY(size-y1);
				c1.setX(x1);
				
				c2.setX(x1);
				c2.setY(size-y1+(size/18));
				
				list.add(c1);
				list.add(c2);
				
				c1 = new Coordenada();
				c2 = new Coordenada();
				//Cambio en Y
				x1-=size/21;
			}
		}
	}
	
	public static Coordenada convertir(double x1, double y1 , double screensize) {
		Coordenada r = new Coordenada();
		r.setX(x1);
		r.setY(screensize - y1);
		return r;
	}
	
	
	//Imprimir los elementos de la lista, solo para probar
	public static void printList(ArrayList<Coordenada> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(i);
			System.out.println(list.get(i).getX());
			System.out.println(list.get(i).getY());
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
//		magia.printList(magia.casillasTablero(700));
		System.out.println(magia.casillasTablero(700));
	}

}
