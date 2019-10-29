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
		inicializaBotoesFixos(4, new String[] { "Voltar", "Salvar", "Gerar relatório", "Avancar" });
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
