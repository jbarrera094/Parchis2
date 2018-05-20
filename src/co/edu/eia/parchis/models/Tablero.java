package co.edu.eia.parchis.models;

import java.util.*;

import co.edu.eia.parchis.views.utils.*;

public class Tablero {


    public ArrayList<Casilla> casillas;
    private ArrayList<Coordenada> coordenadas;

   //Constructors
    
    public Tablero() {
		this.casillas = llenarTablero();
	}



	//Methods
   public ArrayList<Casilla> llenarTablero(){
    	ArrayList<Casilla> t = new ArrayList<>();
    
    	for (int i = 0; i < 4; i++) {
    		
			for (int j = 0; j < 4; j++) {
				t.add( new Casilla());
				
			}
			
			t.add( new Casilla(true));
			
			for (int j = 0; j < 6; j++) {
				t.add( new Casilla());
				
			}
			
			t.add( new Casilla(true));
			
			for (int j = 0; j < 4; j++) {
				t.add( new Casilla());
				
			}
			
			t.add( new Casilla(true));
		}
    	
    	return t;
    }
    
    

    public Casilla getCasilla(int i) {	
    	return (i>68)? casillas.get(i-69):casillas.get(i-1);
    }
		
    public ArrayList<Casilla> getCasillas() {
		return casillas;
	}



	public void setCasillas(ArrayList<Casilla> casillas) {
		this.casillas = casillas;
	}


	// Devuelve casilla en el arrayList (diferente a la casilla visual)
	public Casilla getCasilla(int count, int inicio) {	// No sirve cuando una ficha est� en el cielo
		if(count+inicio > 67)
			return casillas.get(count+inicio-68);
		else
			return casillas.get(count+inicio);
	}
	
	public Casilla getCasillaInicio(int inicio) {	
		if(inicio>0)
			return casillas.get(inicio);
		return null;
		
	}
}