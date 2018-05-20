package co.edu.eia.parchis.views;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

import co.edu.eia.parchis.models.Casilla;
import co.edu.eia.parchis.models.Ficha;
import co.edu.eia.parchis.models.Juego;
import co.edu.eia.parchis.models.Jugador;
import co.edu.eia.parchis.views.utils.*;

public class JTablero extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLayeredPane lp;
	Juego j;
	ArrayList<Coordenada>  casillasTablero;
	JLabel tablero;
	ImageIcon imgTable;
	int size;
	ArrayList<Coordenada> cielo0= magia.cielo0(size);
	ArrayList<Coordenada> cielo1= magia.cielo1(size);
	ArrayList<Coordenada> cielo2= magia.cielo2(size);
	ArrayList<Coordenada> cielo3= magia.cielo3(size);

	//	Coordenada carcel0 = magia.convertir(, y1, size);

	public JTablero(int size,Juego j) {
		this.size=size;
		this.j =j;
		lp = new JLayeredPane();
		lp.setPreferredSize(new Dimension(size,size));
		casillasTablero = magia.casillasTablero(size);
		//Carga el tablero y lo ajusta al tamaño X

		tablero = new JLabel("");
		imgTable = new ImageIcon(getClass().getResource("/tablero.png"));
		tablero.setIcon(new ImageIcon(imgTable.getImage().getScaledInstance(size, size, 1)));
		tablero.setBounds(0,0,size,size);
		lp.add(tablero, 1);
		add(tablero);
		add(lp);

	}


	public void paintTablero() {		
		int tw = 40;
		int th = 40;
		LinkedList <Jugador>jug=(LinkedList)j.getJugadores();
		
		for (int i = 0; i < jug.size(); i++) {
			Jugador ju = jug.get(i);
			if(!ju.getCarcel().isEmpty())
				paintCarcel(ju.getColor(),ju);
			for (Ficha f:ju.fichasDisponibles()) {
				int cont =f.getContador();
				if(cont<63) {
					int num = (ju.getInicio()+cont>68)?ju.getInicio()+cont-68: ju.getInicio()+cont;
					ImageIcon image = getImage(f.getColor());
					Coordenada xy = paintCasilla(f,num);
					JLabel ficha1 = new JLabel("");
					ficha1.setIcon(new ImageIcon(image.getImage().getScaledInstance(tw, th, Image.SCALE_DEFAULT)));
					ficha1.setBounds((int)xy.getX(),(int)xy.getY(),tw,th);
					lp.add(ficha1, 3);
				}
				else {

				}

			}
		}


	}

	public Coordenada getXYcarcel(String color) {
		Coordenada carcel;
		switch (color) {
		case "AMARILLO":
			carcel = magia.convertir(size/9*6, size/9*3, size);
			break;
		case "ROJO":
			carcel = magia.convertir(size/9*6, size, size);
			break;
		case "VERDE":
			carcel = magia.convertir(size/9*3, size, size);
			break;
		case "AZUL":
			carcel = magia.convertir(size/9*3, size/9*3, size);
			break;


		default:
			carcel=null;
			break;
		}
		return carcel;
	}


	private Coordenada paintCasilla(Ficha f,int num ) {
		Coordenada xy =null;
		Casilla c = j.getTablero().getCasilla(num);
		if(c.isBloqueado()) {
			int i = c.getFichas().indexOf(f);
			if(i ==0)
				xy = casillasTablero.get(2*num);
			else
				xy = casillasTablero.get(2*num +1);
		}
		else 
			xy = casillasTablero.get(2*num +1);

		return xy;

	}


	private void paintCarcel( String color, Jugador jug) {

		String imagen = "/carcel_" + color.toLowerCase() + String.valueOf(jug.getCarcel().size())+ ".png";
		Coordenada c = getXYcarcel(color);
		JLabel l = new JLabel();
		ImageIcon im=new ImageIcon(getClass().getResource(imagen));
		l.setBounds((int)c.getX(), (int)c.getY(), size/3, size/3);
		l.setIcon(new ImageIcon(im.getImage().getScaledInstance(size/3, size/3, Image.SCALE_DEFAULT)));
		lp.add(l, 0);
		
	}

	private ImageIcon getImage(String color){
		ImageIcon f;
		switch (color) {
		case "ROJO":
			f = new ImageIcon(getClass().getResource("/fichita.png"));
			break;
		case "AZUL":
			f = new ImageIcon(getClass().getResource("/fichita.png"));	
			break;
		case "AMARILLO":
			f = new ImageIcon(getClass().getResource("/fichita.png"));
			break;
		case "VERDE":
			f = new ImageIcon(getClass().getResource("/fichita.png"));
			break;

		default:
			f = new ImageIcon(getClass().getResource("/fichita.png"));
			break;
		}
		return f;
	}

	public JLayeredPane getLp() {
		return lp;
	}
	public void setLp(JLayeredPane lp) {
		this.lp = lp;
	}
	public JLabel getTablero() {
		return tablero;
	}
	public void setTablero(JLabel tablero) {
		this.tablero = tablero;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintTablero();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Juego game = new Juego();
		JTablero t = new JTablero(700,game);
		frame.add(t);
		frame.pack();
		frame.setVisible( true );

		int i=0;
		while(!game.hayGanador()) {
			Jugador j = game.getJugadores().peek();
			System.out.println(j.getNombre()+" paso  : " +" |  En Cielo :" + j.getCielo().getTrascendentes().size() +"  | En Carcel :" + j.getCarcel().size());
			try {
				game.SiguienteTurno();
				Thread.currentThread().sleep(500);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\t  dado 1 : " + game.getDado1()+"   dado 2 : "+ game.getDado1());
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					frame.remove(t);
					frame.revalidate();
					t.paintTablero();
					frame.add(t);

				}

			});


			i++;
		}


	}

}
