package interfaceUsuario.Telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import beans.Funcionario;
import interfaceUsuario.InterfaceController;

public class TelaHabilidadesPessoais extends FramePrincipal {


	/****************************************************************************/
	public TelaHabilidadesPessoais(Funcionario f) {
		super(f);
		initialize();
		setTitulo("Habilidades Pessoais");
		adicionaComponentes();
	}

	/****************************************************************************/
	private void adicionaComponentes() {
		insereBotoesFixos();
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		JFrame telaMetas = InterfaceController.controlaTelas("TelaHabilidadesSociais", funcionarioAvaliado);
		telaMetas.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {

		JFrame telaMetas = InterfaceController.controlaTelas("TelaMetas", null);
		telaMetas.setVisible(true);
		dispose();
	}

	/****************************************************************************/
}
