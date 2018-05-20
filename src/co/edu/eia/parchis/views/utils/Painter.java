package co.edu.eia.parchis.views.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JPanel;

public class Painter extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = 1L;

	public Painter() {
		setFocusable(true);
		requestFocus();
		setBackground(Color.WHITE);
		addMouseListener(this);
	}

	
	


	public void mousePressed(MouseEvent e) {

	}


	public void mouseReleased(MouseEvent e) {

	}


	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}


	


	@Override
	public void mouseClicked(MouseEvent e) {
			
	}

}

