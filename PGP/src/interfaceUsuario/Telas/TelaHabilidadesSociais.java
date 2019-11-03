package interfaceUsuario.Telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import beans.Funcionario;
import interfaceUsuario.InterfaceController;

public class TelaHabilidadesSociais extends FramePrincipal {

	/****************************************************************************/
	public TelaHabilidadesSociais(Funcionario f) {
		super(f);
		initialize();
		setTitulo("Habilidades Sociais");
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
				"<html><body><h2>Avalie as quest�es abaixo de 0 � 5, onde 5 seria o maior grau de atendimento ao requisito:</h2>Reconhece as necessidades dos outros e auxilia a encontrar uma solu��o</body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Estabelece rela��es de trabalho efetivas</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Incentiva a colabora��o com a equipe</body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Baseia-se na depend�ncia m�tua e compreens�o</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Gosta de compartilhar sua experi�ncia</p></body></html>" });
			preencheRespostas();
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		guardaRespostas();
		JFrame telaMetas = InterfaceController.controlaTelas("TelaProatividade", funcionarioAvaliado);
		telaMetas.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {
		guardaRespostas();
		JFrame telaHabilidadesPessoais = InterfaceController.controlaTelas("TelaHabilidadesPessoais", null);
		telaHabilidadesPessoais.setVisible(true);
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
				listaBotoesPerguntas.get(i).get(funcionarioAvaliado.avaliacaoHabilidadesSociais.get(i)).setSelected(true);
			}
		}catch(NullPointerException np) {
			
		}
	}
}
