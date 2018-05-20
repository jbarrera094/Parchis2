package co.edu.eia.parchis.models;

import java.util.*;

public class Jugador implements Observador{


	private Stack<Ficha> carcel ;
    private Ficha[] fichas;
    private Cielo cielo;
    private String nombre;
    private int inicio;
    private String color;
    private boolean esAutomatizado;


    //Constructors
    
    public Jugador(String nombre , int inicio,String color) {
  		this.nombre = nombre;
  		this.inicio = inicio;
  		this.color = color; 
  		fichas = new Ficha[]{ new Ficha(color,this,0),new Ficha(color,this,1),new Ficha(color,this,2),new Ficha(color,this,3)};
  		cielo = new Cielo();
  		carcel= new Stack<>(); 
  		
  		for (Ficha f : fichas) {
			carcel.add(f);
		}
  		
  		esAutomatizado = false;
  	}
    
    public Jugador(String nombre , int inicio,String color, boolean esAutomatizado) {
  		this.nombre = nombre;
  		this.inicio = inicio;
  		this.color = color; 
  		fichas = new Ficha[]{ new Ficha(color,this,0),new Ficha(color,this,1),new Ficha(color,this,2),new Ficha(color,this,3)};
  		cielo = new Cielo();
  		carcel= new Stack<>(); 
  		
  		for (Ficha f : fichas) {
			carcel.add(f);
		}
  		this.esAutomatizado = esAutomatizado;
  	}
    
    // Methods
    public Ficha salirDeCarcel() throws Exception {
       if(carcel.isEmpty())
    	   return null;
       else {
    	  Ficha f = carcel.pop();
    	  f.setContador(1);
    	  return f;
       }
       
    }
     
    public boolean entrarAlCielo(Ficha ficha, int pasos) throws Exception {
    	return cielo.mover(ficha,pasos);
    }
    
	public ArrayList<Ficha> fichasDisponibles(){
		
		ArrayList<Ficha> ans = new ArrayList<>();
		for (Ficha ficha : fichas) {
			int k = ficha.getContador();
			if(k !=-1 && k != 71)
				ans.add(ficha);
				
		}
		return ans;
		
		
	}
	
	
	public boolean esGanador() {
		return (cielo.getTrascendentes().size()==4)? true :false;
		
	}

	public Stack getCarcel() {
		return carcel;
	}

	public void setCarcel(Stack carcel) {
		this.carcel = carcel;
	}

	public Ficha[] getFichas() {
		return fichas;
	}

	public void setFichas(Ficha[] fichas) {
		this.fichas = fichas;
	}

	public Cielo getCielo() {
		return cielo;
	}
	
	public void serTrasendente(Ficha f) {
		
	}

	public void setCielo(Cielo cielo) {
		this.cielo = cielo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public boolean esAutomatizado() {
		return esAutomatizado;
	}

	public void setEsAutomatizado(boolean esAutomatizado) {
		this.esAutomatizado = esAutomatizado;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void actualizar(Ficha f) {
		carcel.push(f);	
	}

}