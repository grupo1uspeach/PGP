package interfaceUsuario.Telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import interfaceUsuario.FramePrincipal;
import interfaceUsuario.Funcionario;
import interfaceUsuario.InterfaceController;

public class TelaAdequacaoAsRegras extends FramePrincipal {

	/****************************************************************************/
	public TelaAdequacaoAsRegras(Funcionario f) {
		super(f);
		initialize();
		setTitulo("Adequacao as regras");
		adicionaComponentes();
	}

	/****************************************************************************/
	private void adicionaComponentes() {
		insereBotoesFixos();
	}

	/****************************************************************************/
	protected void insereBotoesFixos() {
		
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		JFrame telaMetas = InterfaceController.controlaTelas("TelaMetas", funcionarioAvaliado);
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
		JFrame telaProatividade = InterfaceController.controlaTelas("TelaProatividade", null);
		telaProatividade.setVisible(true);
		dispose();
	}

	/****************************************************************************/
}
