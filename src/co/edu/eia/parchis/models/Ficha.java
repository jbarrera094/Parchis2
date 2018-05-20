package co.edu.eia.parchis.models;

import java.util.*;

public class Ficha implements Comparable, ObjetoObservable  {

    @Override
	public String toString() {
		return "Ficha [id=" + id + ", contador=" + contador + "]";
	}


	private String color;
    private int id;
	private int contador;
	private Jugador observador;

	public Ficha(String color,Jugador obs,int id) {
		this.contador=-1;
		this.color = color;
		this.observador=obs;
		this.id=id;

	}

	public Ficha(String color,Jugador obs) {
		this.contador=-1;
		this.color = color;
		this.observador=obs;

	}
	


	public int getContador() {
		return contador;
	}

	public int setContador(int paso){
		this.contador += paso;
		
//		if(contador >71)
//			throw new Exception("Contador mayor 71");
		return this.contador;
	}
	public void resetContador(){
		this.contador = -1;
//		if(contador >71)
//			throw new Exception("Contador mayor 71");
	}
	public int restContador(int paso){
		this.contador-= paso;
//		if(contador >71)
//			throw new Exception("Contador mayor 71");
		return this.contador;
	}
	


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

// ///////////////////////////////////
//	public int compareTo(Ficha f2) {
//		// TODO Auto-generated method stub
//		return f2.getColor().compareTo(color);
//	}
	
	public int compareTo2(Ficha f2) {
		// TODO Auto-generated method stub
		return (f2.getColor().compareTo(color)==0)?id-f2.getId():0;
	}
	
	public void haSidoComida() {
		notificarObservador();
	}
	
	public int getId() {
		return id;
	}


	@Override
	public void notificarObservador() {
		observador.actualizar(this);
		
	}

	@Override
	public int compareTo(Object o) {
		return ((Ficha) o).getColor().compareTo(color);
	}
}