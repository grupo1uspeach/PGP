package interfaceUsuario.Telas;

import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import beans.Funcionario;
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
	public void avancar(java.awt.event.ActionEvent evt) {
		JList list = new JList(new String[] { "Continuar avaliando", "Gerar relatório", "Salvar e fechar",
				"Salvar e avaliar um novo funcionario", "Descartar alteracoes" });
		JOptionPane.showMessageDialog(this, list, "A avaliacao chegou ao fim. O que deseja fazer?",
				JOptionPane.PLAIN_MESSAGE);

		if (Arrays.toString(list.getSelectedIndices()).equals("[1]")) {
			// Gerar Relatorio
			geraRelatorio(null);
		} else if (Arrays.toString(list.getSelectedIndices()).equals("[2]")) {
			// Salvar e fechar
			encerrar();
			dispose();
		} else if (Arrays.toString(list.getSelectedIndices()).equals("[3]")) {
			// Salvar e avaliar um novo funcionario
			encerrar();
			JFrame telaInicial = InterfaceController.controlaTelas("TelaInicial", null);
			telaInicial.setVisible(true);
			dispose();

		} else if (Arrays.toString(list.getSelectedIndices()).equals("[4]")) {
			// Descartar as alteracoes feitas
			JFrame telaInicial = InterfaceController.controlaTelas("TelaInicial", null);
			telaInicial.setVisible(true);
			dispose();

		}

	}

	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {

		JFrame telaProatividade = InterfaceController.controlaTelas("TelaProatividade", null);
		telaProatividade.setVisible(true);
		dispose();
	}

	/****************************************************************************/
}
