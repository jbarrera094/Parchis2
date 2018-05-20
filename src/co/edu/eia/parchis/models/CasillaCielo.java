package co.edu.eia.parchis.models;

import java.util.*;

public class CasillaCielo {
	private ArrayList<Ficha> fichas;
	private int x1,x2,y1,y2;

    public CasillaCielo() {
    	fichas=new ArrayList<>(2);
    }

//	public void agregarFicha(Ficha ficha) {
//		fichas.add(ficha);
//	}

	public Ficha quitarFicha(Ficha f) throws Exception {
		int i =fichas.indexOf(f);
		if(i>0)
			return fichas.remove(fichas.indexOf(f));
		else
			throw new Exception("No se encuentra la ficha en el camino al Cielo");
	}

    public boolean agregarFicha(Ficha ficha) {
       
    	//Verificar qué posición está libre o retornar falso
    	if(fichas.get(0)==null) {
    	   fichas.add(0, ficha);;
    	   return true;
       }else if(fichas.get(1)==null) {
    		   fichas.add(1,ficha);
    		   return true;
       }
       else {
    	   return false;
       }
    }

    
    //Por color
    public Ficha quitarFicha(String color) {
    	if(fichas.get(0).getColor().compareTo(color)==0){
    		Ficha temp = fichas.remove(0);
     	   	return temp;
        }else if(fichas.get(1).getColor().compareTo(color)==0){
    		Ficha temp = fichas.remove(1);
     	   	return temp;
        }
        else {
     	   return null;
        }
    }
    
    //Por index
    public Ficha quitarFicha(int index) {
    	if(fichas.get(index)!=null){
    		Ficha temp = fichas.remove(0);
     	   	return temp;
     	   }
        else {
     	   return null;
        }
    }

	public ArrayList<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(ArrayList<Ficha> fichas) {
		this.fichas = fichas;
	}
    
    
    
//    public static void main(String[] args) {
//		Ficha v = new Ficha("verde");
//		Ficha a = new Ficha("azul");
//		Ficha r = new Ficha("rojo");
//		CasillaCielo cs = new CasillaCielo();
//		cs.agregarFicha(v);
//		cs.agregarFicha(a);
//		
//		System.out.println(cs.agregarFicha(r));
//		
//		System.out.println(cs.quitarFicha("azul"));
//	}

}