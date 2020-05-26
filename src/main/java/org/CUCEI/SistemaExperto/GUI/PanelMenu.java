package org.CUCEI.SistemaExperto.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private static final JLabel lblTitulo = new JLabel("Pregunta Quien y Adivino Quien!");
	private static final JButton btnComenzar = new JButton("Comenzar!");

	public PanelMenu(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		setBackground(Color.BLUE);
		lblTitulo.setFont(new Font("Serif", Font.PLAIN, 32));
		lblTitulo.setVerticalAlignment(JLabel.CENTER);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		lblTitulo.setForeground(Color.YELLOW);
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextScreen();
			}
		});
		setLayout(new BorderLayout());
		add(lblTitulo, BorderLayout.CENTER);
		add(btnComenzar, BorderLayout.SOUTH);
	}

	private void nextScreen() {
		ventanaPrincipal.getVentana().getContentPane().removeAll();
		ventanaPrincipal.getVentana().setContentPane(new PanelSeleccionaPersonaje(ventanaPrincipal));
		ventanaPrincipal.getVentana().revalidate();
	}
}
