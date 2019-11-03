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
				"<html><body><h2>Avalie as questões abaixo de 0 à 5, onde 5 seria o maior grau de atendimento ao requisito:</h2>Vive os valores da empresa</body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Promove forte apoio a missão e visão da empresa</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Respeito o código de vestimenta da empresa</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Demonstra seguir a cultura e valores da empresa mesmo fora do ambiente de trabalho</body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Mantém seu espaço de trabalho organizado</p></body></html>" });
		preencheRespostas();
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		guardaRespostas();
		JFrame telaAnotacoes = InterfaceController.controlaTelas("TelaAnotacoes", funcionarioAvaliado);
		telaAnotacoes.setVisible(true);
		dispose();
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
