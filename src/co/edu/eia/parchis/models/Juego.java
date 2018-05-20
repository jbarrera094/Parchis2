package co.edu.eia.parchis.models;

import java.util.*;

import co.edu.eia.parchis.models.exceptions.TextException;

public class Juego {


	final private static String[] color = new String[] {"AMARILLO","ROJO","VERDE","AZUL"};
	private Queue<Jugador> jugadores;
	private int dado2;
	private int dado1;
	private Tablero tablero;
	



	public Juego( String nombreJ1,  String nombreJ2,  String nombreJ3,  String nombreJ4) {
		Jugador j1 = new Jugador(nombreJ1,4, color[0]);
		Jugador j2 = new Jugador(nombreJ2,21,color[1]);
		Jugador j3 = new Jugador(nombreJ3,38, color[2]);
		Jugador j4 = new Jugador(nombreJ4,55,color[3]);


		jugadores = (Queue<Jugador>) new LinkedList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);
		jugadores.add(j4);
		tablero = new Tablero();
	}
	public Juego( String nombreJ1,  String nombreJ2,  String nombreJ3) {
		Jugador j1 = new Jugador(nombreJ1,4, color[0]);
		Jugador j2 = new Jugador(nombreJ2,21,color[1]);
		Jugador j3 = new Jugador(nombreJ3,38, color[2]);
		Jugador j4 = new Jugador("CP 1",56, color[3],true);

		jugadores = (Queue<Jugador>) new LinkedList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);
		jugadores.add(j4);
		tablero = new Tablero();
	}

	public Juego( String nombreJ1,  String nombreJ2) {
		Jugador j1 = new Jugador(nombreJ1,5, color[0]);
		Jugador j2 = new Jugador(nombreJ2,22, color[1]);
		Jugador j3 = new Jugador("CP 1",39, color[2],true);
		Jugador j4 = new Jugador("CP 2",56, color[3],true);


		jugadores = (Queue<Jugador>) new LinkedList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);
		jugadores.add(j4);
		tablero = new Tablero();
	}
	public Juego( String nombreJ1) {
		Jugador j1 = new Jugador(nombreJ1,5, color[0]);
		Jugador j2 = new Jugador("CP 1",22, color[1],true);
		Jugador j3 = new Jugador("CP 2",39, color[2],true);
		Jugador j4 = new Jugador("CP 3",56, color[3],true);

		jugadores = (Queue<Jugador>) new LinkedList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);
		jugadores.add(j4);
		tablero = new Tablero();
	}

	public Juego() {
		Jugador j1 = new Jugador("CP 4",5, color[0],true);
		Jugador j2 = new Jugador("CP 1",22, color[1],true);
		Jugador j3 = new Jugador("CP 2",39, color[2],true);
		Jugador j4 = new Jugador("CP 3",56, color[3],true);

		jugadores = (Queue<Jugador>) new LinkedList<Jugador>();
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);
		jugadores.add(j4);
		tablero = new Tablero();
	}

	public void corriendo() throws Exception {
		int i=0;
		while(!hayGanador()) {
			Jugador j = jugadores.peek();
			System.out.println(j.getNombre()+" paso  : "+i +" |  En Cielo :" + j.getCielo().getTrascendentes().size() +"  | En Carcel :" + j.getCarcel().size());
			SiguienteTurno();
			System.out.println("\t  dado 1 : " + dado1+"   dado 2 : "+ dado2);
			Thread.sleep(50);
			i++;
			for(Ficha f:j.getFichas())
				System.out.println(f);
			System.out.println();
		}
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(" |\\/\\/\\/|\\/\\/\\/|  ***   ***  ****   ***   ***  ***  ***  ***  ******   ** *** "  );
		System.out.println(" | <>   o   <> |  **   ***   **    ***   ********  ********  ****     ***  ** ");
		System.out.println(" ---------------  ************    ***   **  ****  **  ****  ******   ***  ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\t \t <<<"+jugadores.poll().getNombre().toUpperCase()+"  IS THE KING! >>>");
		System.out.println("ME CAGO EN TODO!");
	}


	public Jugador SiguienteTurno() throws Exception {

		dado1= lanzarLosDados();
		dado2=lanzarLosDados();
		boolean isPair=false;
		Jugador jugadorEnTurno;
		// si se saca par entonces no se saca jugador de la pila 
		if(dado1==dado2) {
			jugadorEnTurno  =jugadores.peek();
			isPair=true;
		}else
			jugadorEnTurno=jugadores.poll();


		if((!jugadorEnTurno.getCarcel().isEmpty() )&& (dado1==5 || dado2==5 || dado2+dado1==5)) {/// Si saca cinco, Sale de la carcel
			boolean res = salirCarcel(jugadorEnTurno);
			if((dado2+dado1)==5 && res) {
				dado1=0;dado2=0;// 0 significa que ya se uso el dado
			}
			if(dado1==5 && dado2==5 && res) {
				if(!jugadorEnTurno.getCarcel().isEmpty()) {
					boolean res2 = salirCarcel(jugadorEnTurno);
					if(res2) { 
						dado1=0;dado2=0; 
					} else {
						dado1=0;
					}
				}
				/// Hacer caso en el que se saca 5 y 5, y hay un bloqueo de jugadorEnTurno en casilla inicio
			}

			if(dado1==5 && res ) {
				dado1=0;
			}
			if(dado2==5 && res ) {
				dado2=0;
			}
		}

		if(jugadorEnTurno.esAutomatizado()) {
			MaxHeap<Jugada> mj;

			if(dado1!=0 || dado2!=0) {
				if(dado1!=0 && dado2!=0) {
					try {
						mj=ayuda(jugadorEnTurno,dado1,dado2);
						
						if(mj!= null) {
							ArrayList<Paso> pasos = mj.getRaiz().getLlave().getPasos();
							for (Paso paso : pasos) {
								moverPieza(jugadorEnTurno, paso.getFicha(), paso.getDado());
							}
							
						}
					} catch (TextException e) {
						e.printStackTrace();
					}


				} else {
					MaxHeap<Jugada> mj2;
					if (dado1!=0)
						mj2 = ayuda(jugadorEnTurno,dado1);
					else
						mj2 = ayuda(jugadorEnTurno,dado2);
				
					if(mj2!= null) {
						ArrayList<Paso> pasos = mj2.getRaiz().getLlave().getPasos();
						for (Paso paso : pasos) {
							moverPieza(jugadorEnTurno, paso.getFicha(), paso.getDado());
						}
					}
				}
			}

		}


		if(jugadorEnTurno!= null && !isPair ) {
			boolean res = jugadores.add(jugadorEnTurno);
			return  jugadorEnTurno;
		}
		else 
			return null;


	}

	public int getDado2() {
		return dado2;
	}
	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}
	public int getDado1() {
		return dado1;
	}
	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}
	
	private MaxHeap<Jugada> ayuda(Jugador j ,int d1) throws TextException {		
		MaxHeap<Jugada> m = new MaxHeap<>();
		ArrayList<Ficha> l=j.fichasDisponibles();
		for (Ficha ficha : l) {
			m.add(new Jugada(j, d1, ficha, tablero));
		}
		return m;
	}


	public boolean hayGanador () {
		Iterator<Jugador> li= jugadores.iterator();
		while (li.hasNext() && li.next().esGanador() ) {
			return true;
		}
		return false;
	}



	public int lanzarLosDados() {
		Random rnd = new Random();
		return 1 + rnd.nextInt(6);
	}

	public boolean moverPieza(Jugador j,Ficha f,int pasos) throws Exception {
		int k = f.setContador(pasos);
		int inicio = j.getInicio();
		if(k<71) {
			if(k-pasos>62 ) {//Quiere decir que antes de tirar los dados, ya estaba en el cielo
				boolean r=false;
				if(k-63<8) {
					r =j.getCielo().mover(f, pasos);
					if(!r)
						f.restContador(pasos);			
				}
				return r;

			}
			else {
				if (k-pasos<=62 && k >62 && k<71) { /// Quiere decir que con el nuevo movimiento entr� al cielo
					tablero.getCasilla(k-pasos, inicio).quitarFicha(f);
					boolean bool = j.entrarAlCielo(f, pasos);
					if(!bool)
						f.restContador(pasos);
					return bool;
					
				}else if(k>=71)
					return false;
				else{ /// Movimiento en tablero normal
					return movimientoNormal(pasos,f ,inicio);
				}
			}
			
		}
		f.restContador(pasos);
		return false;	
	}
	
	
	public Queue<Jugador> getJugadores() {
		return jugadores;
	}
	public Tablero getTablero() {
		return tablero;
	}
	public boolean  movimientoNormal(int pasos, Ficha f , int inicio) {
		int  k =f.getContador();
		Casilla nuevaCasilla = tablero.getCasilla(k, inicio);
		if (nuevaCasilla.isBloqueado()) {// No puede dexplazarse a esa casilla
			f.restContador(pasos);
			return false;
		} else {//  ES un Movimiento normal
			tablero.getCasilla(k-pasos, inicio).quitarFicha(f);
			if (!nuevaCasilla.getFichas().isEmpty()) {
				Ficha comida = nuevaCasilla.getFichas().get(0);
				if (comida.getColor().compareTo(f.getColor())!=0) {
					comida.resetContador(); /// SE DEBE AVISAR AL JUGADOR QUE LA META A LA CARCEL
					nuevaCasilla.quitarFicha(comida); // Come ficha
					comida.haSidoComida();
				}else
					nuevaCasilla.setBloqueado(true);
			}
			
			nuevaCasilla.agregarPieza(f);
			return true;
		}
	}
	

	

	public boolean salirCarcel(Jugador j) throws Exception {

		Casilla casillaInicio = tablero.getCasillaInicio(j.getInicio()); // (Si esta no esta vacia)


		boolean bool = comer(casillaInicio,(Ficha)j.getCarcel().peek());

		if(bool || casillaInicio.getFichas().isEmpty()) {	
			casillaInicio.agregarPieza(j.salirDeCarcel());
			return true;
		}else 
			return false;


	}
	
	public void ingresarAlCielo(int pasos) {
		// TODO implement here

	}

	public MaxHeap<Jugada> ayuda(Jugador j, int d1, int d2) throws TextException {
		MaxHeap<Jugada> m = new MaxHeap<>();
		ArrayList<Ficha> l=j.fichasDisponibles();
		if(!l.isEmpty())
			return determinarPosiblesJugadas(m,0,0,l,d1,d2,j);
		else
			return null;

	}

	public MaxHeap<Jugada> determinarPosiblesJugadas(MaxHeap<Jugada> m,int k,int i,ArrayList<Ficha> f,int d1, int d2,Jugador j)  throws TextException{
		if( k==f.size()) {
			return m;
		}else
			m.add(new Jugada(j, d1, d2, f.get(k), f.get(i), tablero));
		if(i==f.size()-1)
			m=determinarPosiblesJugadas( m ,k+1,0,f,d1,d2,j);
		else
			m=determinarPosiblesJugadas( m ,k,i+1,f,d1,d2,j);
		return m;


	}

	public boolean determinarSiJugadaEsLegitima(Jugada jugada) {
		// TODO implement here
		return false;
	}

	public boolean comer(Casilla c, Ficha fentrante) throws Exception {
		ArrayList<Ficha> ff= c.getFichas();
		if(!ff.isEmpty()) {// Si hay fichas de diferente color en la casilla inicio, se las come a todas

			for (Iterator iterator = ff.iterator(); iterator.hasNext();) {
				Ficha ficha = (Ficha) iterator.next();
				if (ficha.compareTo(fentrante)!=0) {
					ficha.resetContador(); ////DECIRLE A EL JUGADOR QUE LLENE CARCEL
					ficha.haSidoComida();
					iterator.remove();
				}
			}
			c.setFichas(ff);

			if (ff.size()!=2)
				return true;
		}
		return false;
	}
	public static void main(String[] args) throws InterruptedException {
		Juego j= new Juego();
		
		
		
		try {
			j.corriendo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}