package co.edu.eia.parchis.models;

import java.util.*;

public class Jugada implements Comparable{

	private ArrayList<Paso> pasos;
	private Tablero tab;
	private Jugador j;
	int puntaje=0;

	public Jugada(Jugador j,int d1, int d2, Ficha f1, Ficha f2, Tablero tab) {//jugador que realiza la jugada junto con sus fichas y los dados
		this.tab=tab;
		this.j=j;
		this.pasos= new ArrayList<>();
		if(mismaFicha(f1,f2)) {//Para determinar dos movimientos seguidos con la misma ficha
			pasos.add(new Paso(d1,f1));
			pasos.add(new Paso(d2+d1,f1));

		}else {
			pasos.add(new Paso(d1,f1));
			pasos.add(new Paso(d2,f2));
		}
		puntaje = 0; 
		for (Paso paso : pasos) {
			puntaje+= calcularPuntaje(paso);
		}
		if(mismaFicha(f1,f2)) {//se borra el paso total, que sumaba los dos dados y se agrega el paso despu�s del primer			
			pasos.remove(1);
			pasos.add(new Paso(d2,f1));
		}
	}


	public Jugada(Jugador j,int d1, Ficha f1, Tablero tab) {//jugador que realiza la jugada junto con sus fichas y los dados
		this.tab=tab;
		this.j=j;
		this.pasos= new ArrayList<>();
		pasos.add(new Paso(d1,f1));
		puntaje = 0;
		for (Paso paso : pasos) {
			puntaje+= calcularPuntaje(paso);
		}
	}

	private boolean mismaFicha(Ficha f1, Ficha f2) {
		return f1.compareTo2(f2)==0;
	}

	public int calcularPuntaje(Paso p) {
		int cont = p.getFicha().getContador();
		int d = p.getDado();
		if(cont+d<=62) {
			return puntajeMovto(p,0);
		}
		else
			return puntajeCielo(p,0);
	}
	
	public int puntajeCielo(Paso p, int i) {
		int a=p.getDado()+p.getFicha().getContador();
		if(p.getFicha().getContador()<63&&a<=70) 
			i+=3;
		else if(a>70)
			i-=10;
		else if(a==70)
			i+=2;
		else
			i+=1;
		return i;
	}

	public int puntajeMovto(Paso p, int i) {
		Casilla c=tab.getCasilla(p.getFicha().getContador()+p.getDado(),j.getInicio());
		if(!c.getFichas().isEmpty()) {
			if(c.getFichas().size()==1) {
				if(p.getFicha().compareTo(c.getFichas().get(0))==0)
					i+=3;
				else
					i+=2;
			}else {
				i-=3;
			}
		}else if(c.isEsSeguro())
			i+=2;
		else
			i+=1;
		return i;
	}    

	public int getPuntaje() {
		return puntaje;
	} 

	@Override
	public int compareTo(Object o) {
		return ((Jugada) o).getPuntaje()-puntaje;
	}

	// Getters & setters 
	public ArrayList<Paso> getPasos() {
		return pasos;
	}

	public void setPasos(ArrayList<Paso> pasos) {
		this.pasos = pasos;
	}

}