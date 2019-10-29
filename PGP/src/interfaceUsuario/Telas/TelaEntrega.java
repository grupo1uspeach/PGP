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
		inicializaBotoesFixos(4, new String[] { "Voltar", "Salvar", "Gerar relatório", "Avaliar" });
		insereBotoesFixos();

		// botao avancar
		listaBotoesFixos.get(0).addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				voltar(evt);
			}
		});

		// botao salvar
		listaBotoesFixos.get(1).addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				salvar(evt);
			}
		});

		// botao gerar relatorio
		listaBotoesFixos.get(2).addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				geraRelatorio(evt);
			}
		});

		// botao avancar
		listaBotoesFixos.get(3).addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				avancar(evt);
			}
		});

		inserePerguntas(new String[] {
				"<html><body>Achei melhor testar um tipo de pergunta aqui, mas nao sabia o que escrever, entao escrevi qualquer coisa..."
						+ "<br>Achei melhor testar um tipo de pergunta aqui, mas nao sabia o que escrever, entao escrevi qualquer coisa...</body></html>",
				"<html><body>Achei melhor testar um tipo de pergunta aqui, mas nao sabia o que escrever, entao escrevi qualquer coisa..."
						+ "<br>Achei melhor testar um tipo de pergunta aqui, mas nao sabia o que escrever, entao escrevi qualquer coisa...</body></html>",
				"<html><body>Achei melhor testar um tipo de pergunta aqui, mas nao sabia o que escrever, entao escrevi qualquer coisa..."
						+ "<br>Achei melhor testar um tipo de pergunta aqui, mas nao sabia o que escrever, entao escrevi qualquer coisa...</body></html>",
				"<html><body>Achei melhor testar um tipo de pergunta aqui, mas nao sabia o que escrever, entao escrevi qualquer coisa..."
						+ "<br>Achei melhor testar um tipo de pergunta aqui, mas nao sabia o que escrever, entao escrevi qualquer coisa...</body></html>",
				"<html><body>Achei melhor testar um tipo de pergunta aqui, mas nao sabia o que escrever, entao escrevi qualquer coisa..."
						+ "<br>Achei melhor testar um tipo de pergunta aqui, mas nao sabia o que escrever, entao escrevi qualquer coisa...</body></html>" });
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		JFrame telaMetas = InterfaceController.controlaTelas("TelaMetas", funcionarioAvaliado);
		telaMetas.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {

		// Perguntar se a pessoa tem ctz que quer sair
		int encerrarAvaliacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja encerrar a avaliacao?");

		// Perguntar se a pessoa gostaria de salvar
		if (encerrarAvaliacao == 0) {
			int salvarAvaliacao = JOptionPane.showConfirmDialog(this,
					"Voce gostaria de salvar os resultados da avaliacao antes de sair?");
			if (salvarAvaliacao == 0) {
				// Salvar avaliacao

			}
			// Voltar para a tela inicial
			JFrame telaInicial = InterfaceController.controlaTelas("TelaInicial", null);
			telaInicial.setVisible(true);
			dispose();
		}

	}

	/****************************************************************************/
}
