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
		inicializaBotoesFixos(4, new String[] { "Voltar", "Salvar", "Gerar relatório", "Encerrar" });
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
		preencheRespostas();
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
		guardaRespostas();
		JFrame telaProatividade = InterfaceController.controlaTelas("TelaProatividade", null);
		telaProatividade.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	protected void guardaRespostas() {
		try {
			for (int i = 0; i < listaPerguntas.size(); i++) {
				funcionarioAvaliado.avaliacaoEntrega
						.add(i, Integer.parseInt(listaPerguntas.get(i).getSelection().getActionCommand()));
			}
		} catch (NullPointerException np) {

		}
	}

	
	/****************************************************************************/
	protected void preencheRespostas() {
		try {
			for(int i = 0; i < listaPerguntas.size(); i++) {
				listaPerguntas.get(i).clearSelection();
				listaBotoesPerguntas.get(i).get(funcionarioAvaliado.avaliacaoAdequacaoAsRegras.get(i)).setSelected(true);
			}
		}catch(NullPointerException np) {
			
		}
	}
}
