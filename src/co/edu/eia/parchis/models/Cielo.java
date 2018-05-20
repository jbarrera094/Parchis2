package co.edu.eia.parchis.models;

import java.util.*;



/*	
 * casilla cielo  index 
 * 
 * 	63=0
 * 	64=1
 * 	65=2
 * 	66=3
 * 	67=4
 * 	68=5
 * 	69=9
 * 
 * 
*/
public class Cielo {

	public LinkedList<CasillaCielo> escalera;

	public Stack<Ficha> trascendentes;


	public Cielo() {
		escalera = new  LinkedList<CasillaCielo>();
		for (int i = 0; i < 7; i++) {
			escalera.add(new CasillaCielo());
		}
		trascendentes = new Stack<>();
	}


//	public boolean mover(Ficha ficha, int pasos) {
//		CasillaCielo destino = null;
//		Iterator it =escalera.iterator();
//		int i=0;
//		while (it.hasNext()  && i < pasos) {
//			destino = (CasillaCielo)it.next();
//			i++;
//		}
//
//		if(i<=pasos) {
//			sacarFicha(ficha);
//			if(ficha.getContador()==71)
//				trascendentes.add(ficha);
//			else
//				destino.agregarFicha(ficha);
//			return true;
//		}else 
//			return false;
//	}
	
	public boolean mover (Ficha ficha, int pasos) throws Exception {   /// 63<= C.cielo<= 69
		CasillaCielo destino = null;
		int cont = ficha.getContador();
		int x =(cont-pasos-63>0)? cont-pasos-63: 0;
		CasillaCielo actual= this.escalera.get(x);
		if (cont<70 && cont-pasos >62 ) { // si ya est� en el cielo, y si se suma el dados, sigue en el cielo

			destino = this.escalera.get(cont-63);
			if (destino.getFichas().size()!=2) { // si no hay bloqueo en el cielo
				actual.getFichas().remove(ficha);
				destino.getFichas().add(ficha);
				return true;
				
		     }else { // si hay bloqueo en el cielo
				return false;
		     }

			
		}else {
			if (cont == 70) { // Si va a la trascendencia (Valor exacto, igual a 70)
				System.out.println("*******entro al cielo**********");
				actual.getFichas().remove(ficha);
				this.trascendentes.push(ficha);
				return true;
			}
			else {
				destino = this.escalera.get(cont-63);
				if (destino.getFichas().size()!=2) { // si no hay bloqueo en el cielo
					destino.getFichas().add(ficha);
					return true;
					
			     }else { // si hay bloqueo en el cielo
					return false;
			     }
			}
		}
		
	}

	public void sacarFicha(Ficha ficha) throws Exception {
		if(ficha.getContador()-62<8)
	
				escalera.get(ficha.getContador()-62).quitarFicha(ficha);
			
	}
	
	public CasillaCielo getCasilla(int count,int pasos) {	
		return escalera.get(count+pasos);
	}


	public LinkedList<CasillaCielo> getEscalera() {
		return escalera;
	}



	public void setEscalera(LinkedList<CasillaCielo> escalera) {
		this.escalera = escalera;
	}

	public Stack<Ficha> getTrascendentes() {
		return trascendentes;
	}
	public void setTrascendentes(Stack<Ficha> trascendentes) {
		this.trascendentes = trascendentes;
	}



}