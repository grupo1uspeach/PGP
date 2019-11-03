package interfaceUsuario.Telas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
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
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(getContentPane(), 
		            "Gostaria de salvar antes de sair?", "Fechar janela?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	encerrar();
		            System.exit(0);
		        }
		    }
		});

		inserePerguntas(new String[] {
				"<html><body><h2>Avalie as questões abaixo de 0 à 5, onde 5 seria o maior grau de atendimento ao requisito:</h2>Entrega suas atividades no prazo determinado</body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Produz mais do que o esperado continuamente</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">É um contribuinte importante para o sucesso do departamento</body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Realiza uma contribuição substancial para o crescimento contínuo da empres</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Excede objetivos de performance continuamente</p></body></html>" });

		preencheRespostas();
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		guardaRespostas();
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
				encerrar();
			}
			// Voltar para a tela inicial
			JFrame telaInicial = InterfaceController.controlaTelas("TelaInicial", null);
			telaInicial.setVisible(true);
			dispose();
		}

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
			for (int i = 0; i < listaPerguntas.size(); i++) {
				listaPerguntas.get(i).clearSelection();
				listaBotoesPerguntas.get(i).get(funcionarioAvaliado.avaliacaoEntrega.get(i)).setSelected(true);
			}
		} catch (NullPointerException np) {

		}
	}
}
