package interfaceUsuario.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import beans.Funcionario;
import interfaceUsuario.InterfaceController;

public class TelaProatividade extends FramePrincipal {

	/****************************************************************************/
	public TelaProatividade(Funcionario f) {
		super(f);
		initialize();
		setTitulo("Proatividade");
		adicionaComponentes();
	}

	/****************************************************************************/
	private void adicionaComponentes() {
		insereBotoesFixos();
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		JFrame telaMetas = InterfaceController.controlaTelas("TelaAdequacaoAsRegras", funcionarioAvaliado);
		telaMetas.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {

		JFrame telaHabilidadesSociais = InterfaceController.controlaTelas("TelaHabilidadesSociais", null);
		telaHabilidadesSociais.setVisible(true);
		dispose();
	}

	/****************************************************************************/
}
