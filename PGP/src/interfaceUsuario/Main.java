package interfaceUsuario;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		inicializaTela();
	}

	public static void inicializaTela() {
		//Solicita ao controlador o objeto da tela inicial para inicia-la e exibir ao usuario
		JFrame telaInicial = InterfaceController.controlaTelas("TelaInicial", null);
		telaInicial.setVisible(true);

	}
}
