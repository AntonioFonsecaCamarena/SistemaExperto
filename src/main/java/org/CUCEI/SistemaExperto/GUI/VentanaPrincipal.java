package org.CUCEI.SistemaExperto.GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import lombok.Getter;

public class VentanaPrincipal {

	@Getter
	private JFrame ventana;
	private final int ANCHOVENTANA = 800, ALTOVENTANA = 800;
	@Getter
	private List<String> personajes = new ArrayList<String>();

	public VentanaPrincipal() {
		ventana = new JFrame("CUCEI - Sistema Experto - Jose Antonio Fonseca");
		ventana.setSize(ANCHOVENTANA, ALTOVENTANA);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new PanelMenu(this));
		ventana.setVisible(true);
		personajes.add("brett");
		personajes.add("buddy");
		personajes.add("captainkoons");
		personajes.add("esmeralda");
		personajes.add("fablenne");
		personajes.add("jimmie");
		personajes.add("jody");
		personajes.add("jules");
		personajes.add("marcellus");
		personajes.add("maynard");
		personajes.add("paul");
		personajes.add("roger");
		personajes.add("thegimp");
		personajes.add("trudi");
		personajes.add("vincent");
		personajes.add("winston");
		personajes.add("yolanda");
		personajes.add("zed");
	}

}
