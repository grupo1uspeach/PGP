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
		inicializaBotoesFixos(4, new String[] { "Voltar", "Salvar", "Gerar relat�rio", "Avancar" });
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
				"<html><body><h2>Avalie as quest�es abaixo de 0 � 5, onde 5 seria o maior grau de atendimento ao requisito:</h2>� inovador em situa��es adversas</body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Busca solu��es inovadoras</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Fometa a curiosidade por solu��es inovadoras</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Enxerga oportunidade e as aproveita</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Quando v� algo que o incomoda, tenta solucionar ou comunicar a seus superiores a respeito </p></body></html>" });
		
		preencheRespostas();
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		guardaRespostas();
		JFrame telaMetas = InterfaceController.controlaTelas("TelaAdequacaoAsRegras", funcionarioAvaliado);
		telaMetas.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {
		guardaRespostas();
		JFrame telaHabilidadesSociais = InterfaceController.controlaTelas("TelaHabilidadesSociais", null);
		telaHabilidadesSociais.setVisible(true);
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
				listaBotoesPerguntas.get(i).get(funcionarioAvaliado.avaliacaoProatividade.get(i)).setSelected(true);
			}
		}catch(NullPointerException np) {
			
		}
	}
}
