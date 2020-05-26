package org.CUCEI.SistemaExperto.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.CUCEI.SistemaExperto.BaseDeConocimiento;

public class PanelSeleccionaPersonaje extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private static final JLabel lblTitulo = new JLabel("Seleccione un personaje:");
	private static final JPanel panelPersonajes = new JPanel();
	private static final JPanel panelPersonajeSeleccionado = new JPanel();
	private static final JPanel panelRespuesta = new JPanel();
	private static final HashMap<String, JButton> personajes = new HashMap<String, JButton>();
	private static String personajeSeleccionado;
	private static JTextArea txtConsola = new JTextArea(36, 25);
	private static BaseDeConocimiento base;
	private static ActionListener respuestas;

	public PanelSeleccionaPersonaje(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		setBackground(Color.BLUE);
		lblTitulo.setFont(new Font("Serif", Font.PLAIN, 32));
		lblTitulo.setVerticalAlignment(JLabel.CENTER);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		lblTitulo.setForeground(Color.YELLOW);
		txtConsola.setBackground(Color.BLACK);
		txtConsola.setForeground(Color.GREEN);
		txtConsola.setLineWrap(true);
		txtConsola.setEditable(false);
		panelPersonajes.setLayout(new FlowLayout());
		panelPersonajeSeleccionado.setLayout(new BorderLayout());
		panelRespuesta.setLayout(new FlowLayout());
		respuestas = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				responde(e.getActionCommand());
			}
		};
		addPersonajes();
		setLayout(new BorderLayout());
		add(lblTitulo, BorderLayout.NORTH);
		add(panelPersonajes, BorderLayout.CENTER);
		add(panelPersonajeSeleccionado, BorderLayout.EAST);
		print("Bienvenido, intentemos adivinar tu personaje!");

	}

	private void addPersonajes() {
		JButton btnPersonaje;
		for (String personaje : ventanaPrincipal.getPersonajes()) {
			try {
//				Image img = ImageIO.read(getClass().getResource("resources/img/brett.png"));
				btnPersonaje = new JButton(personaje);
				Image img = ImageIO.read(new File("resources/img/" + personaje + ".png"));
				btnPersonaje.setIcon(new ImageIcon(img));
				btnPersonaje.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						seleccionarPersonaje(e.getActionCommand());
					}

				});
				personajes.put(personaje, btnPersonaje);
				panelPersonajes.add(btnPersonaje);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}

	private void seleccionarPersonaje(String personaje) {
		if (personajeSeleccionado == null) {
			personajes.get(personaje).setBackground(Color.RED);
			panelPersonajeSeleccionado.add(personajes.get(personaje), BorderLayout.NORTH);
			panelPersonajeSeleccionado.add(new JScrollPane(txtConsola, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
			JButton si = new JButton("Si");
			si.addActionListener(respuestas);
			JButton no = new JButton("No");
			no.addActionListener(respuestas);
			panelRespuesta.add(si);
			panelRespuesta.add(no);
			lblTitulo.setText("Responde las preguntas!");
			panelPersonajeSeleccionado.add(panelRespuesta, BorderLayout.SOUTH);
			panelPersonajeSeleccionado.revalidate();
			personajeSeleccionado = personaje;
			base = new BaseDeConocimiento(this);
			base.start();
		}
	}

	private void responde(String actionCommand) {
		System.out.println(actionCommand);
		base.responde(actionCommand);
	}

	public void descartarPersonaje(String personaje) {
		personajes.get(personaje).setBackground(Color.BLACK);
		personajes.remove(personaje);
	}

	public void solucion(String personaje) {
		// TODO jaja
	}

	public void print(String msg) {
		txtConsola.setText(txtConsola.getText() + "\n\n" + msg);
	}
}
