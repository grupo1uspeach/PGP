package interfaceUsuario.Telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import beans.Funcionario;
import interfaceUsuario.InterfaceController;

public class TelaMetas extends FramePrincipal {

	/****************************************************************************/
	public TelaMetas(Funcionario f) {
		super(f);
		initialize();
		setTitulo("Metas");
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
				"<html><body><h2>Avalie as questões abaixo de 0 à 5, onde 5 seria o maior grau de atendimento ao requisito:</h2>Excede a meta original em suas tarefas atribuidas</body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Trouxe grandes avanços na entrega final do produto</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Supera padrões de produtividade</body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Destacou-se em desenvolver estratégias que ultrapassaram positivamente as metas estabelecidas.</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Consegue cumprir as metas determinadas mesmo em relações adversas</p></body></html>" });
				
		preencheRespostas();
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		guardaRespostas();
		JFrame telaMetas = InterfaceController.controlaTelas("TelaHabilidadesPessoais", funcionarioAvaliado);
		telaMetas.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {
		guardaRespostas();
		JFrame telaEntrega = InterfaceController.controlaTelas("TelaEntrega", null);
		telaEntrega.setVisible(true);
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
				listaBotoesPerguntas.get(i).get(funcionarioAvaliado.avaliacaoMetas.get(i)).setSelected(true);
			}
		}catch(NullPointerException np) {
			
		}
	}
}
