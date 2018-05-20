package co.edu.eia.parchis.models;

import java.util.*;

public class Nodo< E extends Comparable> {

    private Nodo<E> HijoDer;
    private Nodo<E> HijoIzq;
    private E Llave;
  //Constructors
	public Nodo(Nodo<E> hijoDer, Nodo<E> hijoIzq, E llave) {
		super();
		HijoDer = hijoDer;
		HijoIzq = hijoIzq;
		Llave = llave;
	}
	public Nodo(E llave) {
		super();
		HijoDer = null;
		HijoIzq = null;
		Llave = llave;
	}
	public Nodo<E> getHijoDer() {
		return HijoDer;
	}
	public void setHijoDer(Nodo<E> hijoDer) {
		HijoDer = hijoDer;
	}
	public Nodo<E> getHijoIzq() {
		return HijoIzq;
	}
	public void setHijoIzq(Nodo<E> hijoIzq) {
		HijoIzq = hijoIzq;
	}
	public E getLlave() {
		return Llave;
	}
	public void setLlave(E llave) {
		Llave = llave;
	}
	
    
    
    
    
}