package interfaceUsuario.Telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import beans.Funcionario;
import interfaceUsuario.InterfaceController;

public class TelaEntrega extends FramePrincipal {


	/****************************************************************************/
	public TelaEntrega(Funcionario f) {
		super(f);
		initialize();
		setTitulo("Avaliacao da entrega");
		adicionaComponentes();
	}

	/****************************************************************************/
	private void adicionaComponentes() {
		insereBotoesFixos();
	}
	
	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		JFrame telaMetas = InterfaceController.controlaTelas("TelaMetas", funcionarioAvaliado);
		telaMetas.setVisible(true);
		dispose();
	}
	
	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {
		
		//Perguntar se a pessoa tem ctz que quer sair
		int encerrarAvaliacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja encerrar a avaliacao?");
		
		//Perguntar se a pessoa gostaria de salvar
		if (encerrarAvaliacao == 0) {
			int salvarAvaliacao = JOptionPane.showConfirmDialog(this, "Voce gostaria de salvar os resultados da avaliacao antes de sair?");
			if(salvarAvaliacao == 0) {
				//Salvar avaliacao
				
			}
			//Voltar para a tela inicial
			JFrame telaInicial = InterfaceController.controlaTelas("TelaInicial", null);
			telaInicial.setVisible(true);
			dispose();
		}
		
	}
	
	/****************************************************************************/
}
