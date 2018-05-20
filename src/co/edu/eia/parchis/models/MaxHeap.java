package co.edu.eia.parchis.models;

import java.util.*;

import co.edu.eia.parchis.models.exceptions.TextException;

public class MaxHeap<E extends Comparable >{

	public int index;
	public Nodo< E > raiz;

	//Constructors

	public MaxHeap() {
		super();
		this.raiz=null;
		this.index=0;

	}

	//Methods

	public Nodo<E> getRaiz() {
		return raiz;
	}




	public void setRaiz(Nodo<E> raiz) {
		this.raiz = raiz;
	}


	public void add(E e) throws TextException {
		if(e!=null) {
			Nodo<E> n=new Nodo<E>(e); 
			index++;
			String binaryIndex = Integer.toBinaryString(index);
			char[] path = binaryIndex.substring(1, binaryIndex.length()).toCharArray();
			add(path,n);


		}
	}



	private void add(char[] path, Nodo<E> n) throws TextException {
		if(raiz!=null) {
			int i=0;
			Nodo<E> padre= raiz;
			Stack<Nodo<E>> pila=new Stack<Nodo<E>>();
			pila.push(padre);
			while(i < path.length-1) {
				padre = (path[i]=='0')? padre.getHijoIzq():padre.getHijoDer();
				pila.push(padre);
				i++;
			}
			addArbol(n,padre);
			while(!pila.isEmpty() && pila.peek().getLlave().compareTo(n.getLlave())>0) {
				Nodo<E> aux=pila.pop();
				E e=n.getLlave();				
				n.setLlave(aux.getLlave());
				aux.setLlave(e);
				n=aux;
			}

		}else 
			raiz = n ;

	}
	public void porAnchura() {
		if(raiz != null) {
			Queue<Nodo<E>> cola = (Queue<Nodo<E>>) new LinkedList<Nodo<E>>(); 
			cola.add(raiz);
			while(!cola.isEmpty()) {
				Nodo<E> n = cola.peek();
				System.out.print( n.getLlave()+" ");
				if(n.getHijoIzq()!=null)
					cola.add(n.getHijoIzq());
				if(n.getHijoDer()!=null)
					cola.add(n.getHijoDer());
				cola.poll();

			}

		}

	}

	public void addArbol(Nodo<E> n,Nodo<E> p)throws TextException {
		if(p.getHijoIzq()==null) {
			p.setHijoIzq(n);
			
		}else {
			if(p.getHijoDer()==null) {
				p.setHijoDer(n);
				
			}
			else
				throw new TextException("El nodo padre tiene ambos hijos llenos");
		}

	}

	public static void main(String[] args) {
		MaxHeap<Integer> mh = new MaxHeap<>();
		try {
			mh.add(new Integer(20));
			mh.add(new Integer(54));
			mh.add(new Integer(52));
			mh.add(new Integer(51));
			mh.add(new Integer(50));
			mh.add(new Integer(10));
			mh.add(new Integer(22));
			mh.add(new Integer(12));
			mh.add(new Integer(13));
			mh.add(new Integer(40));
			

			mh.porAnchura();
		} catch (TextException e) {

			e.printStackTrace();
		}
	}





}
