package co.edu.eia.parchis.views.utils;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.*;

import javax.swing.JLayeredPane;

public class app {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public app() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = (int )(gd.getDisplayMode().getWidth());
		int height = (int )(gd.getDisplayMode().getHeight());
	
		frame = new JFrame();
		frame.setBounds(0, 0, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		int x = (width>height)? height:width;
		x = (int) (x*0.9);
		
		
		JPanel panelsito = new JPanel();
		panelsito.setBounds(0, 0,x,x);
		frame.getContentPane().add(panelsito);
		
		
		//Ahora s� viene lo shido
		
		//Crear JLayeredPane (Contenedor en 3d, que permite enviar elementos (en este caso Jlabels) uno encima del otro)
		JLayeredPane lp = new JLayeredPane();
		panelsito.add(lp);		
		lp.setPreferredSize(new Dimension(x,x));
		
			
		//J Label (que va a contener la imagen del tablero)
		JLabel board = new JLabel("");		
		board.setBounds(0, 0, x, x);
		
		
		//Carga el tablero y lo ajusta al tamaño X
		ImageIcon board_img = new ImageIcon(getClass().getResource("tablero.png"));
		board.setIcon(new ImageIcon(board_img.getImage().getScaledInstance(x, x, Image.SCALE_DEFAULT)));
		
		//agregar el board al Layered Pane
		lp.add(board, 1);
		
		
		//Casilla 1
			//Espacio 1
		double l = x/9; //Largo relativo de una casilla
		double a = x/21; //Ancho relativo de una casilla
		
		Coordenada c = magia.convertir(0, 0, x); 
		
		int x1 = 388;
		int y1 = 666;
			//Espacio 2
		int x2 = 466;
		int y2 = 388;
		
		int tw = (int) (l/2);
		int th = (int) a;
		//Fichas
//		JLabel ficha1 = new JLabel("");		
//		ficha1.setBounds(x1, y1,30,30);
//		ImageIcon ficha_img = new ImageIcon(getClass().getResource("roja.png"));
		
//		JLabel ficha2 = new JLabel("");		
//		ficha2.setBounds(427, 466,30,30);
		
//		ficha1.setIcon(new ImageIcon(ficha_img.getImage().getScaledInstance(tw, th, Image.SCALE_DEFAULT)));
//		lp.add(ficha1, 0);
//		
//		ficha2.setIcon(new ImageIcon(ficha_img.getImage().getScaledInstance(tw, th, Image.SCALE_DEFAULT)));
//		lp.add(ficha2, 0);
		
		
		ArrayList<Coordenada> nombre = magia.casillasTablero(x);
		
		for (int i=0; i<136; i++) {
			
			JLabel ficha1 = new JLabel("");		
			ficha1.setBounds((int)nombre.get(i).getX(), (int)nombre.get(i).getY(),30,30);
			ImageIcon ficha_img = new ImageIcon(getClass().getResource("roja.png"));
			
			ficha1.setIcon(new ImageIcon(ficha_img.getImage().getScaledInstance(tw, th, Image.SCALE_DEFAULT)));
			lp.add(ficha1, 0);
		}
		
		nombre = magia.cielo0(x);
		for (int i=0; i<14; i++) {
			
			JLabel ficha1 = new JLabel("");		
			ficha1.setBounds((int)nombre.get(i).getX(), (int)nombre.get(i).getY(),30,30);
			ImageIcon ficha_img = new ImageIcon(getClass().getResource("roja.png"));
			
			ficha1.setIcon(new ImageIcon(ficha_img.getImage().getScaledInstance(tw, th, Image.SCALE_DEFAULT)));
			lp.add(ficha1, 0);
		}
		
		nombre = magia.cielo1(x);
		for (int i=0; i<14; i++) {
			
			JLabel ficha1 = new JLabel("");		
			ficha1.setBounds((int)nombre.get(i).getX(), (int)nombre.get(i).getY(),30,30);
			ImageIcon ficha_img = new ImageIcon(getClass().getResource("roja.png"));
			
			ficha1.setIcon(new ImageIcon(ficha_img.getImage().getScaledInstance(tw, th, Image.SCALE_DEFAULT)));
			lp.add(ficha1, 0);
		}
		nombre = magia.cielo2(x);
		for (int i=0; i<14; i++) {
			
			JLabel ficha1 = new JLabel("");		
			ficha1.setBounds((int)nombre.get(i).getX(), (int)nombre.get(i).getY(),30,30);
			ImageIcon ficha_img = new ImageIcon(getClass().getResource("roja.png"));
			
			ficha1.setIcon(new ImageIcon(ficha_img.getImage().getScaledInstance(tw, th, Image.SCALE_DEFAULT)));
			lp.add(ficha1, 0);
		}
		
		nombre = magia.cielo3(x);
		for (int i=0; i<14; i++) {
			
			JLabel ficha1 = new JLabel("");		
			ficha1.setBounds((int)nombre.get(i).getX(), (int)nombre.get(i).getY(),30,30);
			ImageIcon ficha_img = new ImageIcon(getClass().getResource("roja.png"));
			
			ficha1.setIcon(new ImageIcon(ficha_img.getImage().getScaledInstance(tw, th, Image.SCALE_DEFAULT)));
			lp.add(ficha1, 0);
		}
		
		
	}
}
