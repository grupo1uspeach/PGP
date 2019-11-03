package interfaceUsuario.Telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import beans.Funcionario;
import interfaceUsuario.InterfaceController;

public class TelaHabilidadesPessoais extends FramePrincipal {


	/****************************************************************************/
	public TelaHabilidadesPessoais(Funcionario f) {
		super(f);
		initialize();
		setTitulo("Habilidades Pessoais");
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
				"<html><body><h2>Avalie as quest�es abaixo de 0 � 5, onde 5 seria o maior grau de atendimento ao requisito:</h2>Baseia-se na depend�ncia m�tua e compreens�o</body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Responde rapidamente a novas instru��es, situa��es, m�todos e procedimentos</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Demonstra habilidade de aprender e adaptar-se rapidamente �s mudan�as de situa��o</body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Compartilha experi�ncias de aprendizado com os colegas</p></body></html>",
				"<html><body><p style=\"padding-bottom: 20px\">Se comunica de maneira clara e objetiva com seus colegas</p></body></html>" });

				preencheRespostas();
	}

	/****************************************************************************/
	public void avancar(java.awt.event.ActionEvent evt) {
		guardaRespostas();
		JFrame telaMetas = InterfaceController.controlaTelas("TelaHabilidadesSociais", funcionarioAvaliado);
		telaMetas.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {
		guardaRespostas();
		JFrame telaMetas = InterfaceController.controlaTelas("TelaMetas", null);
		telaMetas.setVisible(true);
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
				listaBotoesPerguntas.get(i).get(funcionarioAvaliado.avaliacaoHabilidadesPessoais.get(i)).setSelected(true);
			}
		}catch(NullPointerException np) {
			
		}
	}
}
