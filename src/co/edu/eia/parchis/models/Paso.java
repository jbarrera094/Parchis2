package co.edu.eia.parchis.models;

import java.util.*;

public class Paso {
	
    private int dado;
    private Ficha ficha;
    
    
    
    //Constructors
    
	public Paso(int dado, Ficha ficha) {
		this.dado = dado;
		this.ficha = ficha;
	}



	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
}