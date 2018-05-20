package co.edu.eia.parchis.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.sun.prism.Image;

import co.edu.eia.parchis.models.Juego;
import co.edu.eia.parchis.views.utils.RoundedBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FormInicio extends JFrame {

	private JPanel contentPane;
	private ArrayList<JTextField> txt;
	private int num;
	private int posX;
	private int posY;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormInicio frame = new FormInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormInicio() {
		
		
		
		this.num=1;
		this.posX = 64;
		this.posY = 158;
		txt= new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 343, 450);
		contentPane = new JPanel();
		contentPane.setFocusCycleRoot(true);
		contentPane.setBorder(UIManager.getBorder("RadioButton.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField txt1 = new JTextField();
		txt1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		txt1.setText("Jugador  #1");
		txt1.setName("");
		txt1.setBounds(posX, posY, 196, 32);
		contentPane.add(txt1);
		txt1.setColumns(10);
		txt.add(txt1);
		
		JLabel lblParchyss = new JLabel("PARCHYSS");
		lblParchyss.setHorizontalAlignment(SwingConstants.CENTER);
		lblParchyss.setFont(new Font("Century Gothic", Font.BOLD, 39));
		lblParchyss.setBounds(10, 11, 278, 43);
		contentPane.add(lblParchyss);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(64, 201, 196, 2);
		contentPane.add(separator);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch (txt.size()) {
				case 4:
					FormJuego win4=new FormJuego(new Juego(txt.get(0).getText(), txt.get(1).getText(), txt.get(2).getText(), txt.get(3).getText()));
					dispose();
					win4.getFrame().setVisible(true);			
					
					break;
				case 3:
					FormJuego win3=new FormJuego(new Juego(txt.get(0).getText(), txt.get(1).getText(), txt.get(2).getText()));
					dispose();
					win3.getFrame().setVisible(true);
					break;
				case 2:
					FormJuego win2=new FormJuego(new Juego(txt.get(0).getText(), txt.get(1).getText()));
					dispose();
					win2.getFrame().setVisible(true);
					break;
				case 1:
					FormJuego win1=new FormJuego(new Juego(txt.get(0).getText()));
					dispose();
					win1.getFrame().setVisible(true);
					break;
				default:
					JOptionPane.showMessageDialog(contentPane, "Error  XD");
					break;
				}
				
			}
		});
		
		btnPlay.setFont(new Font("Century Gothic", Font.BOLD, 22));
		btnPlay.setBounds(89, 357, 133, 43);
		contentPane.add(btnPlay);
		
		JButton button = new JButton("+");
		button.setFont(new Font("Tahoma", Font.PLAIN, 9));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				if(num<=3) {
					num++;
					posY+=50;	
					
					JTextField txtn = new JTextField();
					txtn.setFont(new Font("Century Gothic", Font.BOLD, 15));
					txtn.setText("Jugador  #"+num);
					txtn.setName("");
					txtn.setBounds(posX, posY, 196, 32);
					contentPane.add(txtn);
					txtn.setColumns(10);
					button.setBounds(posX+200, posY, 40, 40);
					contentPane.add(button);
					txt.add(txtn);
				}
				
			}
		});
		button.setBounds(posX+200, posY, 40, 40);
		button.setBorder(new RoundedBorder(40));
		contentPane.add(button);
		
		
		JLabel label = new JLabel(".");		
		label.setBounds(105, 62, 80, 80);
		ImageIcon iconexit =new ImageIcon(FormInicio.class.getResource("/dices.png"));
		ImageIcon iconosalir = new ImageIcon(iconexit.getImage().getScaledInstance(label.getWidth(),label.getHeight(),100 ));
		label.setIcon(iconosalir);
		contentPane.add(label);
	}
}
