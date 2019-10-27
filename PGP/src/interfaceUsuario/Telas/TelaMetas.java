package interfaceUsuario.Telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import interfaceUsuario.FramePrincipal;
import interfaceUsuario.Funcionario;
import interfaceUsuario.InterfaceController;

public class TelaMetas extends FramePrincipal {

	/****************************************************************************/
	public TelaMetas(Funcionario f) {
		super(f);
		initialize();
		setTitulo("Metas");
		adicionaComponentes();
	}

	/****************************************************************************/
	private void adicionaComponentes() {
		insereBotoesFixos();
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		JFrame telaMetas = InterfaceController.controlaTelas("TelaHabilidadesPessoais", funcionarioAvaliado);
		telaMetas.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {

		JFrame telaEntrega = InterfaceController.controlaTelas("TelaEntrega", null);
		telaEntrega.setVisible(true);
		dispose();
	}

	/****************************************************************************/
}
