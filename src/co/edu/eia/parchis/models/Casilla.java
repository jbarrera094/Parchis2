package co.edu.eia.parchis.models;

import java.util.*;

import co.edu.eia.parchis.views.utils.Coordenada;

public class Casilla {

    private boolean esSeguro;
    private boolean Bloqueado;
    private ArrayList<Ficha> fichas;
    private ArrayList<Coordenada> coordenadas;
    
    
   //Constructors
    public Casilla(boolean esSeguro) {
    	this.esSeguro= esSeguro;
    	Bloqueado = false;
    	fichas = new ArrayList<>(2);
    }
    
    public ArrayList<Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada coord1, Coordenada coord2) {
		coordenadas=new ArrayList<Coordenada>(2);
		coordenadas.add(coord1);
		coordenadas.add(coord2);
	}

	public Casilla() {
    	esSeguro= false;
    	Bloqueado = false;
    	fichas = new ArrayList<>(2);
    }

    //methods
    public void agregarPieza(Ficha f) {
    	fichas.add(f);
    	if (fichas.size()==2)
    		Bloqueado = true;
    
    }

    public Ficha quitarFicha(Ficha f) {
    	fichas.remove(f);
    	if (this.fichas.size()==2)
			this.Bloqueado=true;
		else
			this.Bloqueado=false;
    	return f;
    }

	public boolean isEsSeguro() {
		return esSeguro;
	}

	public void setEsSeguro(boolean esSeguro) {
		this.esSeguro = esSeguro;
	}

	public boolean isBloqueado() {
		return (fichas.size() == 2)? true:false;
	}

	public void setBloqueado(boolean bloqueado) {
		Bloqueado = bloqueado;
	}

	public ArrayList<Ficha> getFichas() {
		return fichas;
	}

	public void setFichas(ArrayList<Ficha> fichas) {
		this.fichas = fichas;
		if (this.fichas.size()==2)
			this.Bloqueado=true;
		else
			this.Bloqueado=false;
	}
	
    
}