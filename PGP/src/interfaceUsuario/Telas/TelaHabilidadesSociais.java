package interfaceUsuario.Telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import interfaceUsuario.FramePrincipal;
import interfaceUsuario.Funcionario;
import interfaceUsuario.InterfaceController;

public class TelaHabilidadesSociais extends FramePrincipal {

	/****************************************************************************/
	public TelaHabilidadesSociais(Funcionario f) {
		super(f);
		initialize();
		setTitulo("Habilidades Sociais");
		adicionaComponentes();
	}

	/****************************************************************************/
	private void adicionaComponentes() {
		insereBotoesFixos();
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		JFrame telaMetas = InterfaceController.controlaTelas("TelaProatividade", funcionarioAvaliado);
		telaMetas.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {

		int salvarAvaliacao = JOptionPane.showConfirmDialog(this,
				"Voce gostaria de salvar os resultados da avaliacao?");
		if (salvarAvaliacao == 0) {
			// Salvar avaliacao
		}

		JFrame telaHabilidadesPessoais = InterfaceController.controlaTelas("TelaHabilidadesPessoais", null);
		telaHabilidadesPessoais.setVisible(true);
		dispose();
	}

	/****************************************************************************/
}
