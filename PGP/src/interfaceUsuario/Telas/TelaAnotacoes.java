package interfaceUsuario.Telas;

import javax.swing.JFrame;
import java.util.Arrays;
import javax.swing.JList;
import javax.swing.JOptionPane;

import beans.Funcionario;
import interfaceUsuario.InterfaceController;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaAnotacoes extends FramePrincipal {

	/****************************************************************************/
	
	private JFrame frame;
	JEditorPane editorPane;
	String anotacoes;
	
	public TelaAnotacoes(Funcionario f) {
		super(f);
		initialize();
		setTitulo("Anotações Gerais");
		adicionaComponentes();
	}
	
	/****************************************************************************/
	private void adicionaComponentes() {
		getContentPane().setLayout(null);
		
		editorPane = new JEditorPane();
		editorPane.setBackground(Color.WHITE);
		editorPane.setBounds(296, 166, 466, 180);
		getContentPane().add(editorPane);
		
		
		JLabel lblEsteEspao = new JLabel("Insira qualquer outra observação importante neste campo:");
		lblEsteEspao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEsteEspao.setBounds(296, 123, 466, 32);
		getContentPane().add(lblEsteEspao);
		
		inicializaBotoesFixos(4, new String[] { "Voltar", "Salvar", "Gerar relatório", "Encerrar" });
		insereBotoesFixos();

		// botao voltar
		listaBotoesFixos.get(0).addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				anotacoes = editorPane.getText();
				funcionarioAvaliado.setAnotacoesGerais(anotacoes);
				voltar(evt);
			}
		});

		// botao salvar
		listaBotoesFixos.get(1).addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				anotacoes = editorPane.getText();
				funcionarioAvaliado.setAnotacoesGerais(anotacoes);
				salvar(evt);
			}
		});

		// botao gerar relatorio
		listaBotoesFixos.get(2).addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				anotacoes = editorPane.getText();
				funcionarioAvaliado.setAnotacoesGerais(anotacoes);
				geraRelatorio(evt);
			}
		});

		// botao avançar
		listaBotoesFixos.get(3).addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				anotacoes = editorPane.getText();
				funcionarioAvaliado.setAnotacoesGerais(anotacoes);
				avancar(evt);
			}
		});
		/*inserePerguntas(new String[] {
				"<html><body>Adicione um comentário caso deseje:</body></html>" });
		preencheRespostas();
		*/
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
		JFrame telaAdequacaoAsRegras = InterfaceController.controlaTelas("TelaAdequacaoAsRegras", null);
		telaAdequacaoAsRegras.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	protected void guardaRespostas() {
		try {
			anotacoes = editorPane.getText();
			funcionarioAvaliado.setAnotacoesGerais(anotacoes);
			System.out.println(anotacoes);
					
		}catch(NullPointerException np){
			
		}
	}

	
	/****************************************************************************/
}
