package interfaceUsuario.Telas;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import beans.Funcionario;
import interfaceUsuario.InterfaceController;
import interfaceUsuario.ValidaCampos;
import limitador.SoLetras;
import limitador.SoNumeros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TelaInicial extends FramePrincipal {

	private JTextField txtCodFunc;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtDepto;
	private JTextField txtIdade;
	private JComboBox<String> sexo;

	private String dataDeCadastro;

	// Variavel para versionamento de avaliacao
	private int versaoUltimaAvaliacao;

	// Data das ultimas avaliacoes feitas quando o programa fechou (avaliacoes
	// finalizadas)
	private String dataAntePenultimaAvaliacao;
	private String dataPenultimaAvaliacao;
	private String dataUltimaAvaliacao;

	// Guarda as tres ultimas versoes da avaliacao para que a pessoa possa dar uma
	// especie de ctrl + z
	private String dataAntePenultimaVersao;
	private String dataPenultimaVersao;
	private String dataUltimaVersao;
	private String dataAlteracaoCadastro;

	private ValidaCampos valida = new ValidaCampos();
	private final int qtdPerguntasEntrega;
	private final int qtdPerguntasMetas;
	private final int qtdPerguntasHabilidadesPessoais;
	private final int qtdPerguntasHabilidadesSociais;
	private final int qtdPerguntasProatividade;
	private final int qtdPerguntasAdequacaoAsRegras;

	/****************************************************************************/
	public TelaInicial() {
		super(new Funcionario());

		qtdPerguntasEntrega = 5;
		qtdPerguntasMetas = 5;
		qtdPerguntasHabilidadesPessoais = 5;
		qtdPerguntasHabilidadesSociais = 5;
		qtdPerguntasProatividade = 5;
		qtdPerguntasAdequacaoAsRegras = 5;

		this.height = 600;
		this.width = 700;
		initialize();
		setTitulo("Funcionario Avaliado");
		adicionaComponentes();

	}

	/****************************************************************************/
	// METODO PARA CRIAR E POSICIONAR OS ELEMENTOS NA TELA (CAMPOS, LABELS E BOTOES)
	private void adicionaComponentes() {
		// Cria uma lista de labels para inserir posteriormente
		LinkedList<JLabel> listaLabels = new LinkedList<JLabel>();

		// Label do campo codigo funcional
		listaLabels.add(new JLabel("Cod. Funcional:"));
		listaLabels.get(0).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		// Label do campo nome
		listaLabels.add(new JLabel("Nome:"));
		listaLabels.get(1).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		// Label do campo sobrenome
		listaLabels.add(new JLabel("Sobrenome:"));
		listaLabels.get(2).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		// Label do campo departamento
		listaLabels.add(new JLabel("Departamento:"));
		listaLabels.get(3).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		// Label do campo idade
		listaLabels.add(new JLabel("Idade:"));
		listaLabels.get(4).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		// Label do campo sexo
		listaLabels.add(new JLabel("Sexo:"));
		listaLabels.get(5).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		// Cria uma lista de caixas de texto para inserir posteriormente
		LinkedList<JTextField> listaCampos = new LinkedList<JTextField>();

		// Caixa de texto Cod. Funcional
		listaCampos.add(this.txtCodFunc = new JTextField());
		listaCampos.get(0).setColumns(10);
		listaCampos.get(0).setDocument(new SoNumeros(14));

		// Caixa de texto Nome
		listaCampos.add(this.txtNome = new JTextField());
		listaCampos.get(1).setColumns(10);
		listaCampos.get(1).setDocument(new SoLetras(25));

		// Caixa de texto Sobrenome
		listaCampos.add(this.txtSobrenome = new JTextField());
		listaCampos.get(2).setColumns(10);
		listaCampos.get(2).setDocument(new SoLetras(25));

		// Caixa de texto Departamento
		listaCampos.add(this.txtDepto = new JTextField());
		listaCampos.get(3).setColumns(10);
		listaCampos.get(3).setDocument(new SoLetras(25));

		// Caixa de texto Idade
		listaCampos.add(this.txtIdade = new JTextField());
		listaCampos.get(4).setColumns(10);
		listaCampos.get(4).setDocument(new SoNumeros(2));

		insereElementos(listaCampos, listaLabels);
	}

	/****************************************************************************/
	// METODO AUXILIAR PARA INSERIR OS ELEMENTOS CRIADOS NO METODO
	// adicionaComponentes
	protected void insereElementos(LinkedList<JTextField> txtCampo, LinkedList<JLabel> lblCampos) {

		// Quantidade de campos a serem inseridos
		int qtdCampos = lblCampos.size();

		Dimension maiorDimensaoLbl = lblCampos.get(0).getPreferredSize();
		Dimension dimensaoAtualLbl;

		Dimension maiorDimensaoTxt = lblCampos.get(0).getPreferredSize();
		Dimension dimensaoAtualTxt;

		for (int y = 0; y < qtdCampos; y++) {

			// Encontra a dimensao da maior label a ser inserida
			dimensaoAtualLbl = lblCampos.get(y).getPreferredSize();
			if (dimensaoAtualLbl.width > maiorDimensaoLbl.width) {
				dimensaoAtualLbl = maiorDimensaoLbl;
			}

			// Encontra a dimensao do maior campo de texto a ser inserido
			dimensaoAtualTxt = lblCampos.get(y).getPreferredSize();
			if (dimensaoAtualTxt.width > maiorDimensaoTxt.width) {
				dimensaoAtualTxt = maiorDimensaoTxt;
			}
		}

		int alturaLbl = maiorDimensaoLbl.height;
		int espacoDisponivel = height - titulo.getY() - this.titulo.getHeight();

		int lblY = (espacoDisponivel - qtdCampos * alturaLbl) / (qtdCampos + 1);
		int lblX = this.titulo.getX();

		int alturaTxt = maiorDimensaoTxt.height;
		int txtY = (espacoDisponivel - qtdCampos * alturaTxt) / (qtdCampos + 1);
		int txtX = lblX + maiorDimensaoLbl.width + width / 10;

		int deslocamentoLbl = this.titulo.getY() / 2;
		int deslocamentoTxt = titulo.getY() / 2;

		// Laco para inserir os campos e labels em posicoes relativas uns aos outros e
		// ao titulo da tela
		for (int campo = 0; campo < qtdCampos; campo++) {

			deslocamentoLbl += lblY;
			lblCampos.get(campo).setBounds(lblX, deslocamentoLbl, 2 * maiorDimensaoLbl.width, maiorDimensaoLbl.height);
			getContentPane().add(lblCampos.get(campo));
			deslocamentoLbl += alturaLbl;

			deslocamentoTxt += (txtY + lblY) / 2;
			if (campo != 5) {
				txtCampo.get(campo).setBounds(txtX, deslocamentoTxt, 2 * maiorDimensaoTxt.width,
						maiorDimensaoTxt.height);
				getContentPane().add(txtCampo.get(campo));
			} else {
				sexo = new JComboBox<>();
				sexo.setMaximumRowCount(4);
				sexo.setBounds(txtX, deslocamentoTxt, 2 * maiorDimensaoTxt.width, maiorDimensaoTxt.height);
				sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
				String[] sexos = { "Feminino", "Masculino" };
				for (int i = 0; i < sexos.length; i++) {
					sexo.addItem(sexos[i]);
				}
				getContentPane().add(sexo);
			}
			deslocamentoTxt += (alturaTxt + alturaLbl) / 2;
		}

		inicializaBotoesFixos(2, new String[] { "Sair", "Avaliar" });
		insereBotoesFixos();

		// botao avancar
		listaBotoesFixos.get(0).addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				voltar(evt);
			}
		});

		// botao avancar
		listaBotoesFixos.get(1).addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				avancar(evt);
			}
		});
	}

	/****************************************************************************/
	// METODO PARA VERIFICAR OS CAMPOS DIGITADOS E INSTANCIAR O OBJETO
	// funcionarioAvaliado
	public void avancar(java.awt.event.ActionEvent evt) {
		String nome, sobrenome, departamento, idade, sexo;
		nome = sobrenome = departamento = idade = sexo = "";
		try {
			String codFunc = this.txtCodFunc.getText();
			// SE O CAMPO CODIGO FUNCIONAL ESTIVER VAZIO, APRESENTA MENSAGEM DE ERRO
			if (!codFunc.isEmpty()) {
				// SE O CAMPO CODIGO FUNCIONAL TIVER UM CODIGO VALIDO, VERIFICA SE O FUNCIONARIO
				// TEM CADASTRO
				String nomePasta = "log/" + codFunc;
				File pastaFuncionario = new File(nomePasta);

				if (pastaFuncionario.exists()) {
					// SE JA HOUVER UMA PASTA PARA O FUNCIONARIO, ABRE O .properties DO FUNCIONARIO
					// E
					// PEGA AS INFORMACOES DELE PARA INSTANCIAR O OBJETO funcionarioAvaliado
					Properties cadastro = new Properties();
					FileInputStream arquivo = new FileInputStream(nomePasta + "/cadastro.properties");
					cadastro.load(arquivo);

					dataDeCadastro = cadastro.getProperty("dataDeCadastro");
					dataAlteracaoCadastro = cadastro.getProperty("dataAlteracaoCadastro");

					dataAntePenultimaAvaliacao = cadastro.getProperty("dataAntePenultimaAvaliacao");
					dataPenultimaAvaliacao = cadastro.getProperty("dataPenultimaAvaliacao");
					dataUltimaAvaliacao = cadastro.getProperty("dataUltimaAvaliacao");

					dataAntePenultimaVersao = cadastro.getProperty("dataAntePenultimaVersao");
					dataPenultimaVersao = cadastro.getProperty("dataPenultimaVersao");
					dataUltimaVersao = cadastro.getProperty("dataUltimaVersao");

					versaoUltimaAvaliacao = Integer.parseInt(cadastro.getProperty("versaoUltimaAvaliacao"));

					nome = cadastro.getProperty("nome");
					sobrenome = cadastro.getProperty("sobrenome");
					departamento = cadastro.getProperty("departamento");
					idade = cadastro.getProperty("idade");
					sexo = cadastro.getProperty("sexo");

					// Preenche os campos com as informacoes que estao no properties
					this.txtNome.setText(nome);
					this.txtSobrenome.setText(sobrenome);
					this.txtDepto.setText(departamento);
					this.txtIdade.setText(idade);
					this.sexo.setSelectedItem(sexo);

					arquivo.close();

				} else {

					// SE NAO HOUVER UMA PASTA PARA O FUNCIONARIO, VERIFICA SE TODAS AS INFORMACOES
					// DIGITADAS SAO VALIDAS E UTILIZA-AS PARA CRIAR
					// O CADASTRO DO FUNCIONARIO
					int resposta = JOptionPane.showConfirmDialog(this,
							"O funcionario nao possui historico de avaliacao ainda. Deseja continuar?");
					if (resposta == 0) {

						nome = this.txtNome.getText();
						sobrenome = this.txtSobrenome.getText();
						departamento = this.txtDepto.getText();
						idade = this.txtIdade.getText();
						sexo = this.sexo.getSelectedItem().toString();
						versaoUltimaAvaliacao = 0;

						// VERIFICACAO IMPORTANTE
						if (nome.isEmpty()) {
							JOptionPane.showMessageDialog(this, "Nome esta vazio!");
							return;
						}
						if (sobrenome.isEmpty()) {
							JOptionPane.showMessageDialog(this, "Sobrenome esta vazio!");
							return;
						}
						if (departamento.isEmpty()) {
							JOptionPane.showMessageDialog(this, "Departamento esta vazio!");
							return;
						}

						// CASO O USUARIO NAO PREENCHA ESSES VALORES, SERA COLOCADO UM VALOR PADRAO
						// NAO PREENCHIDO
						if (idade.isEmpty())
							idade = "Nao preenchida";
						if (sexo.isEmpty())
							sexo = "Nao preenchido";

						Date date = Calendar.getInstance().getTime();
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						dataUltimaAvaliacao = dateFormat.format(date).replace(":", "-");

						dataDeCadastro = dataUltimaAvaliacao;
						dataAlteracaoCadastro = dataUltimaAvaliacao;

						dataAntePenultimaAvaliacao = dataUltimaAvaliacao;
						dataPenultimaAvaliacao = dataUltimaAvaliacao;

						dataAntePenultimaVersao = dataUltimaAvaliacao;
						dataPenultimaVersao = dataUltimaAvaliacao;
						dataUltimaVersao = dataUltimaAvaliacao;

						pastaFuncionario.mkdirs();
						FileWriter c = new FileWriter(nomePasta + "/cadastro.properties");
						String cadastro = "dataDeCadastro = " + dataUltimaAvaliacao + "\n" + "dataAlteracaoCadastro = "
								+ dataUltimaAvaliacao + "\n" + "dataAntePenultimaAvaliacao = " + dataUltimaAvaliacao
								+ "\n" + "dataPenultimaAvaliacao = " + dataUltimaAvaliacao + "\n"
								+ "dataUltimaAvaliacao = " + dataUltimaAvaliacao + "\n" + "dataAntePenultimaVersao = "
								+ dataUltimaAvaliacao + "\n" + "dataPenultimaVersao = " + dataUltimaAvaliacao + "\n"
								+ "dataUltimaVersao = " + dataUltimaAvaliacao + "\n" + "versaoUltimaAvaliacao = "
								+ versaoUltimaAvaliacao + "\n" + "nome = " + nome + "\n" + "sobrenome = " + sobrenome
								+ "\n" + "departamento = " + departamento + "\n" + "idade = " + idade + "\n" + "sexo = "
								+ sexo;
						c.write(cadastro);
						c.close();

					} else
						return;
				}

			} else {
				JOptionPane.showMessageDialog(this, "Codigo funcional esta vazio!");
				return;
			}

			int resposta = JOptionPane.showConfirmDialog(this,
					"Tem certeza que deseja avaliar o funcionario: " + nome + " " + sobrenome + "?");
			if (resposta == 0) {

				// INICIALIZA OS ATRIBUTOS DO FUNCIONARIO
				funcionarioAvaliado.setDataDeCadastro(dataDeCadastro);
				funcionarioAvaliado.setDataAlteracaoCadastro(dataAlteracaoCadastro);

				funcionarioAvaliado.setDataAntePenultimaAvaliacao(dataAntePenultimaAvaliacao);
				funcionarioAvaliado.setDataPenultimaAvaliacao(dataPenultimaAvaliacao);
				funcionarioAvaliado.setDataUltimaAvaliacao(dataUltimaAvaliacao);

				funcionarioAvaliado.setDataAntePenultimaVersao(dataAntePenultimaVersao);
				funcionarioAvaliado.setDataPenultimaVersao(dataPenultimaVersao);
				funcionarioAvaliado.setDataUltimaVersao(dataUltimaVersao);

				funcionarioAvaliado.setVersaoUltimaAvaliacao(versaoUltimaAvaliacao);
				funcionarioAvaliado.setCodigoFuncional(codFunc);
				funcionarioAvaliado.setNome(nome);
				funcionarioAvaliado.setSobrenome(sobrenome);
				funcionarioAvaliado.setDepartamento(departamento);
				funcionarioAvaliado.setIdade(idade);
				funcionarioAvaliado.setSexo(sexo);

				inicializaRespostas();

				JFrame telaEntrega = InterfaceController.controlaTelas("TelaEntrega", funcionarioAvaliado);
				telaEntrega.setVisible(true);
				dispose();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente");
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Nao foi possivel encontrar o arquivo do funcionario");
		}

	}

	private void inicializaRespostas() {
		if (funcionarioAvaliado.getVersaoUltimaAvaliacao() != 0) {
			String nomePasta = "log/" + funcionarioAvaliado.getCodigoFuncional();
			try {
				Properties avaliacao = new Properties();
				FileInputStream arquivo = new FileInputStream(
						nomePasta + "/" + funcionarioAvaliado.getDataUltimaAvaliacao() + "_avaliacao.properties");
				avaliacao.load(arquivo);

				for (int i = 0; i < qtdPerguntasEntrega; i++) {
					funcionarioAvaliado.avaliacaoEntrega
							.add(Integer.parseInt(avaliacao.getProperty("entrega.pergunta" + i)));
				}

				for (int i = 0; i < qtdPerguntasMetas; i++) {
					funcionarioAvaliado.avaliacaoMetas
							.add(Integer.parseInt(avaliacao.getProperty("meta.pergunta" + i)));
				}

				for (int i = 0; i < qtdPerguntasHabilidadesPessoais; i++) {
					funcionarioAvaliado.avaliacaoHabilidadesPessoais
							.add(Integer.parseInt(avaliacao.getProperty("habilidadesPessoais.pergunta" + i)));
				}

				for (int i = 0; i < qtdPerguntasHabilidadesSociais; i++) {
					funcionarioAvaliado.avaliacaoHabilidadesSociais
							.add(Integer.parseInt(avaliacao.getProperty("habilidadesSociais.pergunta" + i)));
				}

				for (int i = 0; i < qtdPerguntasProatividade; i++) {
					funcionarioAvaliado.avaliacaoProatividade
							.add(Integer.parseInt(avaliacao.getProperty("proatividade.pergunta" + i)));
				}

				for (int i = 0; i < qtdPerguntasAdequacaoAsRegras; i++) {
					funcionarioAvaliado.avaliacaoAdequacaoAsRegras
							.add(Integer.parseInt(avaliacao.getProperty("adequacaoAsRegras.pergunta" + i)));
				}

				arquivo.close();
			} catch (IOException io) {
				io.printStackTrace();
				JOptionPane.showMessageDialog(this, "Nao foi possivel salvar a avaliacao do funcionario");
			}

		} else {
			for (int i = 0; i < qtdPerguntasEntrega; i++) {
				funcionarioAvaliado.avaliacaoEntrega.add(1);
			}

			for (int i = 0; i < qtdPerguntasMetas; i++) {
				funcionarioAvaliado.avaliacaoMetas.add(1);
			}

			for (int i = 0; i < qtdPerguntasHabilidadesPessoais; i++) {
				funcionarioAvaliado.avaliacaoHabilidadesPessoais.add(1);
			}

			for (int i = 0; i < qtdPerguntasHabilidadesSociais; i++) {
				funcionarioAvaliado.avaliacaoHabilidadesSociais.add(1);
			}

			for (int i = 0; i < qtdPerguntasProatividade; i++) {
				funcionarioAvaliado.avaliacaoProatividade.add(1);
			}

			for (int i = 0; i < qtdPerguntasAdequacaoAsRegras; i++) {
				funcionarioAvaliado.avaliacaoAdequacaoAsRegras.add(1);
			}
		}
	}

	/****************************************************************************/
	public void voltar(java.awt.event.ActionEvent evt) {

		// Perguntar se a pessoa tem ctz que quer sair
		int encerrarAvaliacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja sair?");
		if (encerrarAvaliacao == 0) {
			dispose();
		}
	}
}
