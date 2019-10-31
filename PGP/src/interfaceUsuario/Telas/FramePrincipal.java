package interfaceUsuario.Telas;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import beans.Funcionario;
import net.sf.jasperreports.engine.JRException;
import beans.Relatorio;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public abstract class FramePrincipal extends JFrame {

	protected final Funcionario funcionarioAvaliado;
	protected ArrayList<JButton> listaBotoesFixos;
	protected ArrayList<ButtonGroup> listaPerguntas;
	protected ArrayList<JLabel> listaLabelPerguntas;
	protected ArrayList<ArrayList<JRadioButton>> listaBotoesPerguntas;

	protected JLabel titulo;
	protected JLabel periodo;
	protected int height = 700;
	protected int width = 1000;
	protected JMenuBar menuBar;
	protected JMenu sair;

	/*****************************************************************************/
	public FramePrincipal(Funcionario f) {
		this.funcionarioAvaliado = f;
	}

	/*****************************************************************************/
	// Metodo que inicializa os elementos comuns a todas as classes filhas
	protected void initialize() {
		titulo = new JLabel();
		titulo.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		getContentPane().add(titulo);

		// Menu de voltar
		menuBar = new JMenuBar();
		sair = new JMenu();

		getContentPane().setBackground(new Color(162, 198, 235));
		setBackground(Color.WHITE);
		setBounds(100, 100, width, height);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setJMenuBar(menuBar);
	}

	/*****************************************************************************/
	// Metodo para alterar o titulo da tela
	protected void setTitulo(String t) {
		titulo.setText(t);
		Dimension dimensaopreferida = titulo.getPreferredSize();
		int desloc = (width - dimensaopreferida.width) / 2;
		titulo.setBounds(desloc, height / 30, dimensaopreferida.width, dimensaopreferida.height);

	}

	/*****************************************************************************/
	protected void inicializaBotoesFixos(int qtdBotoes, String[] nomes) {
		listaBotoesFixos = new ArrayList<JButton>();

		for (int i = 0; i < qtdBotoes; i++) {
			listaBotoesFixos.add(i, new JButton(nomes[i]));
			listaBotoesFixos.get(i).setFont(new Font("Verdana", Font.BOLD, 12));
			listaBotoesFixos.get(i).setForeground(Color.DARK_GRAY);
			listaBotoesFixos.get(i).setBackground(Color.WHITE);
		}
	}

	/****************************************************************************/
	// METODO PARA INSERIR OS QUATRO BOTOES QUE SAO FIXOS EM TODAS AS TELAS MENOS NA INICIAL
	protected void insereBotoesFixos() {
		// QUANTIDADE DE CAMPOS A SEREM INSERIDOS
		int qtdCampos = listaBotoesFixos.size();

		Dimension maiorDimensaoListaBtn = listaBotoesFixos.get(0).getPreferredSize();
		Dimension dimensaoAtualListaBtn;

		for (int i = 0; i < listaBotoesFixos.size(); i++) {
			dimensaoAtualListaBtn = listaBotoesFixos.get(i).getPreferredSize();
			if (dimensaoAtualListaBtn.width > maiorDimensaoListaBtn.width) {
				dimensaoAtualListaBtn = maiorDimensaoListaBtn;
			}
		}

		int posY = 9 * height / 10 - maiorDimensaoListaBtn.height;
		int posX = width / 10;

		int espacoDisponivel = 9 * width / 10 - 2 * maiorDimensaoListaBtn.width - width / 10;

		int deslocamentoListaBtn = espacoDisponivel / (listaBotoesFixos.size() - 1);

		for (int i = 0; i < listaBotoesFixos.size(); i++) {
			listaBotoesFixos.get(i).setBounds(posX, posY, 2 * maiorDimensaoListaBtn.width,
					maiorDimensaoListaBtn.height);
			getContentPane().add(listaBotoesFixos.get(i));
			posX += deslocamentoListaBtn;
		}
	}
	
	/****************************************************************************/
	//METODO PARA INSERIR PERGUNTAS COM BASE NO VETOR DE STRINGS COM OS TEXTOS DAS PERGUNTAS
	protected void inserePerguntas(String[] perguntas) {
		
		//CRIA UMA LISTA DE LABELS PARA INSERIR OS TEXTOS DAS PERGUNTAS
		listaLabelPerguntas = new ArrayList<>();
		for (int i = 0; i < perguntas.length; i++) {
			listaLabelPerguntas.add(new JLabel(perguntas[i]));
			listaLabelPerguntas.get(i).setFont(new Font("Segoe UI", Font.PLAIN, 16));
		}
		
		//ENCONTRA AS DIMENSOES DA MAIOR PERGUNTA
		Dimension maiorDimensaoListaPerguntas = listaLabelPerguntas.get(0).getPreferredSize();
		Dimension dimensaoAtualListaPerguntas;

		for (int i = 0; i < listaLabelPerguntas.size(); i++) {
			dimensaoAtualListaPerguntas = listaLabelPerguntas.get(i).getPreferredSize();
			if (dimensaoAtualListaPerguntas.width > maiorDimensaoListaPerguntas.width) {
				dimensaoAtualListaPerguntas = maiorDimensaoListaPerguntas;
			}
		}

		//POSICIONA A PRIMEIRA PERGUNTA EM RELACAO AO TITULO
		int posYLabel = titulo.getY() + this.titulo.getHeight();
		int posXLabel = this.titulo.getX() + this.titulo.getWidth()/2 - maiorDimensaoListaPerguntas.width/2;
		
		//O ESPACO DISPONIVEL EH O ESPACO ENTRE O TITULO E OS BOTOES FIXOS
		int espacoDisponivelLabel = listaBotoesFixos.get(0).getY() - posYLabel;
		
		//O DESLOCAMENTO EH O ESPACO DISPONIVEL DIVIDIDO PELO NUMERO DE BOTOES
		int deslocamentoListaPerguntasLabel = (espacoDisponivelLabel / (listaLabelPerguntas.size()));
		
		
		int posYBotao, posXBotao, espacoDisponivelBotoes, deslocamentoListaPerguntasBtn;
		//CRIA UMA LISTA DE JRADIOBUTTONS PARA LINKAR OS BOTOES
		listaPerguntas = new ArrayList<>();
		listaBotoesPerguntas = new ArrayList<>();
		JRadioButton b;
		b = new JRadioButton("0");
		Dimension d = new Dimension();
		Dimension dPerguntaAtual = new Dimension();
		//LACO PARA COLOCAR AS LABELS NA JANELA, INICIALIZAR OS BOTOES E COLOCA-LOS NA JANELA
		for (int i = 0; i < perguntas.length; i++) {
			listaBotoesPerguntas.add(new ArrayList<JRadioButton>());
			//CRIA UM GRUPO DE BOTOES PARA INSERIR OS JRADIOBUTTONS DA PERGUNTA ATUAL
			listaPerguntas.add(new ButtonGroup());
			
			dPerguntaAtual = listaLabelPerguntas.get(i).getPreferredSize();
			//POSICIONA A LABEL DA PERGUNTA
			listaLabelPerguntas.get(i).setBounds(posXLabel, posYLabel, maiorDimensaoListaPerguntas.width, maiorDimensaoListaPerguntas.height);
			
			d = b.getPreferredSize();
			
			//ATUALIZA A POSICAO DO PRIMEIRO JRADIOBUTTON
			posYBotao = posYLabel + dPerguntaAtual.height;

			posXBotao = posXLabel;
			
			//O ESPACO DISPONIVEL EH O TAMANHO DA PERGUNTA
			espacoDisponivelBotoes = maiorDimensaoListaPerguntas.width;
			deslocamentoListaPerguntasBtn = espacoDisponivelBotoes/5;
			
			add(listaLabelPerguntas.get(i));
			//LACO QUE INICIALIZA OS JRADIOBUTTONS, COLOCA-OS NA TELA E NO GRUPO DE BOTOES
			for (int j = 0; j < 5; j++) {

				b = new JRadioButton();
				listaBotoesPerguntas.get(i).add(b);
				b.setText("" + (j + 1));
				b.setActionCommand("" + (j + 1));
				d = b.getPreferredSize();
				
				b.setBounds(posXBotao, posYBotao, d.width, d.height);
				add(listaBotoesPerguntas.get(i).get(j));
				
				posXBotao += deslocamentoListaPerguntasBtn;
				
				listaPerguntas.get(i).add(listaBotoesPerguntas.get(i).get(j));

			}
			posYLabel += deslocamentoListaPerguntasLabel;
		}
	}

	/****************************************************************************/
	// Cada classe filha deve implementar esse metodo de uma forma diferente, pois
	// chama uma tela diferente
	protected abstract void avancar(java.awt.event.ActionEvent evt);

	/****************************************************************************/
	// Cada classe filha deve implementar esse metodo de uma forma diferente, pois
	// chama uma tela diferente
	protected abstract void voltar(java.awt.event.ActionEvent evt);

	/****************************************************************************/
	// Salva a versao atual das respostas do usuario. Serve para manter as ultimas
	// versoes salvas em disco
	protected void salvar(java.awt.event.ActionEvent evt) {
		String nomePasta = "log/" + funcionarioAvaliado.getCodigoFuncional();

		funcionarioAvaliado.setDataAntePenultimaVersao(funcionarioAvaliado.getDataPenultimaVersao());
		funcionarioAvaliado.setDataPenultimaVersao(funcionarioAvaliado.getDataUltimaVersao());

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dataUltimaVersao = dateFormat.format(date).replace(":", "-");
		funcionarioAvaliado.setDataUltimaVersao(dataUltimaVersao);

		try {

			FileWriter c = new FileWriter(
					nomePasta + "/" + funcionarioAvaliado.getDataUltimaVersao() + "_avaliacao.properties");
			String avaliacao = "";

			for (int i = 0; i < funcionarioAvaliado.avaliacaoEntrega.size(); i++) {
				avaliacao += "entrega.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoEntrega.get(i) + "\n";
			}

			for (int i = 0; i < funcionarioAvaliado.avaliacaoMetas.size(); i++) {
				avaliacao += "meta.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoMetas.get(i) + "\n";
			}

			for (int i = 0; i < funcionarioAvaliado.avaliacaoHabilidadesPessoais.size(); i++) {
				avaliacao += "habilidadesPessoais.pergunta" + i + " = "
						+ funcionarioAvaliado.avaliacaoHabilidadesPessoais.get(i) + "\n";

			}

			for (int i = 0; i < funcionarioAvaliado.avaliacaoHabilidadesSociais.size(); i++) {
				avaliacao += "habilidadesSociais.pergunta" + i + " = "
						+ funcionarioAvaliado.avaliacaoHabilidadesSociais.get(i) + "\n";

			}

			for (int i = 0; i < funcionarioAvaliado.avaliacaoProatividade.size(); i++) {
				avaliacao += "proatividade.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoProatividade.get(i)
						+ "\n";

			}

			for (int i = 0; i < funcionarioAvaliado.avaliacaoAdequacaoAsRegras.size(); i++) {
				avaliacao += "adequacaoAsRegras.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoEntrega.get(i)
						+ "\n";
			}

			c.write(avaliacao);
			c.close();

		} catch (IOException io) {
			io.printStackTrace();
			JOptionPane.showMessageDialog(this, "Nao foi possivel salvar a avaliacao do funcionario");
		}

	}

	/****************************************************************************/
	// Salva o relatorio na pasta do funcionario e exibe o relatorio em tela que o
	// usuario tambem tenha a opcao de conferir os dados e salvar em outro lugar
	protected void geraRelatorio(java.awt.event.ActionEvent evt) {

		List<Funcionario> lista_func = new ArrayList<Funcionario>();

		lista_func.add(funcionarioAvaliado);
		Relatorio relatorio = new Relatorio();
		try {
			relatorio.geraRelatorio(lista_func);
		} catch (JRException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Nao foi possivel gerar o relatorio");

		}

	}

	/****************************************************************************/
	// Alem de salvar a versao atual, atualiza no arquivo de cadastro, qual foi a
	// ultima versao finalizada
	protected void encerrar() {
		salvar(null);
		String nomePasta = "log/" + funcionarioAvaliado.getCodigoFuncional();

		funcionarioAvaliado.setVersaoUltimaAvaliacao(funcionarioAvaliado.getVersaoUltimaAvaliacao() + 1);
		funcionarioAvaliado.setDataAntePenultimaAvaliacao(funcionarioAvaliado.getDataPenultimaAvaliacao());
		funcionarioAvaliado.setDataPenultimaAvaliacao(funcionarioAvaliado.getDataUltimaAvaliacao());
		funcionarioAvaliado.setDataUltimaAvaliacao(funcionarioAvaliado.getDataUltimaVersao());

		try {

			Properties cadastro = new Properties();
			FileInputStream arquivo = new FileInputStream(nomePasta + "/cadastro.properties");
			cadastro.load(arquivo);

			cadastro.setProperty("dataAntePenultimaVersao", funcionarioAvaliado.getDataAntePenultimaVersao());
			cadastro.setProperty("dataPenultimaVersao", funcionarioAvaliado.getDataPenultimaVersao());
			cadastro.setProperty("dataUltimaVersao", funcionarioAvaliado.getDataUltimaVersao());
			cadastro.setProperty("versaoUltimaAvaliacao", "" + funcionarioAvaliado.getVersaoUltimaAvaliacao());

			arquivo.close();
		} catch (IOException io) {

		}
	}

	/****************************************************************************/

	protected void listaVersoes() {
		ArrayList<JMenuItem> listaVersoes = new ArrayList<JMenuItem>();

	}
	
	

}
