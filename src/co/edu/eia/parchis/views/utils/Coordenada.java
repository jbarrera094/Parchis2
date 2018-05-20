package co.edu.eia.parchis.views.utils;




public class Coordenada {
	double x;
	double y;
	
	public Coordenada(double d, double e) {
		this.x = d;
		this.y = e;
	}
	
	

	@Override
	public String toString() {
		return String.valueOf(x) + "  "+ String.valueOf(y);
	}



	public Coordenada() {}

	
	public double getX() {
		return x;
	}

	public void setX(double x1) {
		this.x = x1;
	}

	public double getY() {
		return y;
	}

	public void setY(double d) {
		this.y = d;
	}
	
	
}
