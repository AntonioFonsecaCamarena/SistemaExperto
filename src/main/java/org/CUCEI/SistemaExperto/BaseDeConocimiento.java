package org.CUCEI.SistemaExperto;

import java.util.ArrayList;
import java.util.List;

import org.CUCEI.SistemaExperto.GUI.PanelSeleccionaPersonaje;

import Rule.BooleanRuleBase;
import Rule.Clause;
import Rule.Condition;
import Rule.Rule;
import Rule.RuleVariable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDeConocimiento extends Thread {
	BooleanRuleBase base;
	RuleVariable hombre, sexo;
	RuleVariable pielClara, colorPiel;
	RuleVariable cabelloLargo, colorCabello;
	RuleVariable bigote;
	RuleVariable colorOjos, ojosAzules;
	RuleVariable lentes;
	RuleVariable mascara;
	RuleVariable personaje;
	Condition igual;
	PanelSeleccionaPersonaje panelSeleccionaPersonaje;
	List<Rule> reglas = new ArrayList<Rule>();
	private boolean respondio = false;
	private String respuesta = "";

	public BaseDeConocimiento(PanelSeleccionaPersonaje panelSeleccionaPersonaje) {
		this.panelSeleccionaPersonaje = panelSeleccionaPersonaje;
		base = new BooleanRuleBase("base");
		hombre = new RuleVariable(base, "");
		sexo = new RuleVariable(base, "");
		pielClara = new RuleVariable(base, "");
		colorPiel = new RuleVariable(base, "");
		cabelloLargo = new RuleVariable(base, "");
		colorCabello = new RuleVariable(base, "");
		bigote = new RuleVariable(base, "");
		colorOjos = new RuleVariable(base, "");
		ojosAzules = new RuleVariable(base, "");
		lentes = new RuleVariable(base, "");
		personaje = new RuleVariable(base, "");
		igual = new Condition("=");

		reglas.add(new Rule(base, "sexo", new Clause[] { new Clause(hombre, igual, "si") },
				new Clause(sexo, igual, "hombre")));
		reglas.add(new Rule(base, "sexo", new Clause[] { new Clause(hombre, igual, "no") },
				new Clause(sexo, igual, "mujer")));
		reglas.add(new Rule(base, "piel", new Clause[] { new Clause(pielClara, igual, "si") },
				new Clause(colorPiel, igual, "wero")));
		reglas.add(new Rule(base, "piel", new Clause[] { new Clause(pielClara, igual, "no") },
				new Clause(colorPiel, igual, "negro")));
		reglas.add(new Rule(base, "cabello", new Clause[] { new Clause(cabelloLargo, igual, "si") },
				new Clause(cabelloLargo, igual, "si")));
		reglas.add(new Rule(base, "cabello", new Clause[] { new Clause(cabelloLargo, igual, "no") },
				new Clause(cabelloLargo, igual, "no")));
		reglas.add(new Rule(base, "colorCabello", new Clause[] { new Clause(colorCabello, igual, "si") },
				new Clause(colorCabello, igual, "rubio")));
		reglas.add(new Rule(base, "colorCabello", new Clause[] { new Clause(colorCabello, igual, "no") },
				new Clause(colorCabello, igual, "negro")));
		reglas.add(new Rule(base, "bigote", new Clause[] { new Clause(bigote, igual, "si") },
				new Clause(bigote, igual, "si")));
		reglas.add(new Rule(base, "bigote", new Clause[] { new Clause(bigote, igual, "no") },
				new Clause(bigote, igual, "no")));
		reglas.add(new Rule(base, "lentes", new Clause[] { new Clause(lentes, igual, "si") },
				new Clause(lentes, igual, "si")));
		reglas.add(new Rule(base, "lentes", new Clause[] { new Clause(lentes, igual, "no") },
				new Clause(lentes, igual, "no")));
		reglas.add(new Rule(base, "colorOjos", new Clause[] { new Clause(ojosAzules, igual, "si") },
				new Clause(ojosAzules, igual, "si")));
		reglas.add(new Rule(base, "colorOjos", new Clause[] { new Clause(ojosAzules, igual, "no") },
				new Clause(ojosAzules, igual, "no")));

		// Paul
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "negro"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "si"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "Paul")));
		// jody
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "mujer"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "si"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "si") },
				new Clause(personaje, igual, "Jody")));
		// Marcellus
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "negro"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "Marcellus")));
		// Jimmie
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "Jimmie")));
		// Esmeralda
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "mujer"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "si"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "Esmeralda")));
		// Captain Koons
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "camptainKooks")));
		// Jules
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "negro"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "si"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "Jules")));
		// Buddy
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "si"), new Clause(ojosAzules, igual, "si") },
				new Clause(personaje, igual, "Buddy")));
		// The Gimp
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "si") },
				new Clause(personaje, igual, "thegimp")));
		// Yolanda
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "mujer"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "si"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "Yolanda")));
		// Roger
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "si"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "roger")));
		// Fablenne
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "mujer"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "si"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "si") },
				new Clause(personaje, igual, "Fablenne")));
		// Ringo
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "si") },
				new Clause(personaje, igual, "Ringo")));
		// Raquel
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "mujer"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "si"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "si") },
				new Clause(personaje, igual, "Raquel")));
		// Lance
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "si"), new Clause(bigote, igual, "si"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "si") },
				new Clause(personaje, igual, "Lance")));
		// Butch
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "si") },
				new Clause(personaje, igual, "Butch")));
		// Mia
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "mujer"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "si"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "si") },
				new Clause(personaje, igual, "Mia")));
		// Marvin
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "negro"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "Marvin")));
		// Zed
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "si") },
				new Clause(personaje, igual, "Zed")));
		// Brett
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "Brett")));
		// Trudi
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "mujer"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "si"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "Trudi")));
		// Maynard
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "si"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "Maynard")));
		// Vincent
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "si"), new Clause(bigote, igual, "no"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "si") },
				new Clause(personaje, igual, "Vincent")));
		// Winston
		reglas.add(new Rule(base, "quienEs",
				new Clause[] { new Clause(sexo, igual, "hombre"), new Clause(colorPiel, igual, "wero"),
						new Clause(cabelloLargo, igual, "no"), new Clause(bigote, igual, "si"),
						new Clause(lentes, igual, "no"), new Clause(ojosAzules, igual, "no") },
				new Clause(personaje, igual, "Winston")));

	}

	private void evalua() {

		base.forwardChain();
		print("Tu personaje sera " + personaje.getValue() + "??");
	}

	private void print(String msg) {
		panelSeleccionaPersonaje.print(msg);
	}

	public void responde(String actionCommand) {
		respuesta = actionCommand;
		respondio = true;
	}

	public void preguntaSexo() {
		print("tu personaje es hombre?");
		while (!respondio) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hombre.setValue(respuesta);
		print(respuesta);
		respondio = false;
		preguntaPiel();
	}

	private void preguntaPiel() {
		print("tu personaje es de piel clara?");
		while (!respondio) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pielClara.setValue(respuesta);
		print(respuesta);
		respondio = false;
		preguntaCabelloLargo();
	}

	private void preguntaCabelloLargo() {
		print("tu personaje tiene el cabello largo?");
		while (!respondio) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cabelloLargo.setValue(respuesta);
		print(respuesta);
		respondio = false;
		preguntaColorCabello();
	}

	private void preguntaColorCabello() {
		print("tu personaje tiene el cabello wero?");
		while (!respondio) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		colorCabello.setValue(respuesta);
		print(respuesta);
		respondio = false;
		preguntaBigote();
	}

	private void preguntaBigote() {
		print("tu personaje tiene bigote?");
		while (!respondio) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bigote.setValue(respuesta);
		print(respuesta);
		respondio = false;
		PreguntaOjosAzules();

	}

	private void PreguntaOjosAzules() {
		print("tu personaje tiene el cabellolargo?");
		while (!respondio) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ojosAzules.setValue(respuesta);
		print(respuesta);
		respondio = false;
		PreguntaLentes();
	}

	private void PreguntaLentes() {
		print("tu personaje tiene lentes?");
		while (!respondio) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lentes.setValue(respuesta);
		print(respuesta);
		respondio = false;
//		preguntaBigote();
		evalua();
	}

	@Override
	public void run() {
		System.out.println("run");
		preguntaSexo();
	}

}
