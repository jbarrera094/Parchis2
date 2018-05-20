package co.edu.eia.parchis.views;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import co.edu.eia.parchis.models.*;
import co.edu.eia.parchis.views.utils.*;
import co.edu.eia.parchis.views.utils.Coordenada;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.Dimension;

public class FormJuego {

	private Juego j;
	private JFrame frame;


	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					FormJuego window = new FormJuego();
	//					window.frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the application.
	 */
	public FormJuego(Juego j) {	
		initialize(j);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Juego j) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = (int )(gd.getDisplayMode().getWidth());
		int height = (int )(gd.getDisplayMode().getHeight());

		frame = new JFrame();
		frame.setBounds(0, 0, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		int x = (width>height)? height:width;
		x = (int) (x*0.9);


		JTablero panelsito = new JTablero(x,j);
		panelsito.setBounds(0, 0,x,x);
		frame.getContentPane().add(panelsito);



	}

	public JFrame getFrame() {
		return frame;
	}



}
