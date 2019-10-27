package interfaceUsuario.Telas;

import javax.swing.*;

import beans.Funcionario;
import net.sf.jasperreports.engine.JRException;
import beans.Relatorio;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class FramePrincipal extends JFrame {

	protected final Funcionario funcionarioAvaliado;
	protected JButton btnAvancar;
	protected JButton btnVoltar;
	protected JButton btnSalvar;
	protected JButton btnGerarRelatorio;

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
	protected void initialize() {
		titulo = new JLabel();
		titulo.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		getContentPane().add(titulo);

		// Menu de voltar
		menuBar = new JMenuBar();
		sair = new JMenu();

		getContentPane().setBackground(new Color(204, 255, 153));
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

	/**
	 * ****************************************************************************
	 */

	protected void setTitulo(String t) {
		titulo.setText(t);
		Dimension dimensaopreferida = titulo.getPreferredSize();
		// int desloc = 5*(width - dimensaopreferida.width)/6;
		int desloc = (width - dimensaopreferida.width) / 2;
		titulo.setBounds(desloc, height / 30, dimensaopreferida.width, dimensaopreferida.height);

	}

	/****************************************************************************/
	protected void insereBotoesFixos() {

		// Inicializa o botao voltar
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnVoltar.setForeground(Color.DARK_GRAY);
		btnVoltar.setBackground(Color.WHITE);
		Dimension dBtnVoltar = btnVoltar.getPreferredSize();

		// Inicializa o botao salvar
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSalvar.setForeground(Color.DARK_GRAY);
		btnSalvar.setBackground(Color.WHITE);
		Dimension dBtnSalvar = btnSalvar.getPreferredSize();

		// Inicializa o botao avancar
		btnAvancar = new JButton("Avançar");
		btnAvancar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAvancar.setForeground(Color.DARK_GRAY);
		btnAvancar.setBackground(Color.WHITE);
		Dimension dBtnAvancar = btnAvancar.getPreferredSize();

		// Inicializa o botao gerarelatorio
		btnGerarRelatorio = new JButton("Gerar Relatorio");
		btnGerarRelatorio.setFont(new Font("Verdana", Font.BOLD, 12));
		btnGerarRelatorio.setForeground(Color.DARK_GRAY);
		btnGerarRelatorio.setBackground(Color.WHITE);
		Dimension dBtnGerarRelatorio = btnGerarRelatorio.getPreferredSize();

		// Posiciona o botao voltar
		int voltarX = (int) (0.12 * width - dBtnVoltar.width);
		int voltarY = (int) (height - dBtnVoltar.height - 0.12 * height);
		btnVoltar.setBounds(voltarX, voltarY, dBtnVoltar.width, dBtnVoltar.height);
		btnVoltar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				voltar(evt);
			}
		});
		getContentPane().add(btnVoltar);

		// Posiciona o botao avancar
		int avancarX = (int) (width - voltarX - dBtnAvancar.width);
		int avancarY = voltarY;
		btnAvancar.setBounds(avancarX, avancarY, dBtnAvancar.width, dBtnAvancar.height);
		btnAvancar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				avancar(evt);
			}
		});
		getContentPane().add(btnAvancar);

		// Posiciona o botao salvar
		int salvarX = (int) dBtnVoltar.width + (avancarX - (voltarX + dBtnVoltar.width)) / 3;
		int salvarY = voltarY;
		dBtnSalvar = btnSalvar.getPreferredSize();
		btnSalvar.setBounds(salvarX, salvarY, dBtnSalvar.width, dBtnSalvar.height);
		btnSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				salvar(evt);
			}
		});
		getContentPane().add(btnSalvar);

		// Posiciona o botao gerarRelatorio
		int gerarRelatorioX = (int) dBtnVoltar.width + 2 * (avancarX - (voltarX + dBtnVoltar.width)) / 3;
		int gerarRelatorioY = voltarY;
		dBtnGerarRelatorio = btnGerarRelatorio.getPreferredSize();
		btnGerarRelatorio.setBounds(gerarRelatorioX, gerarRelatorioY, dBtnGerarRelatorio.width,
				dBtnGerarRelatorio.height);
		btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				geraRelatorio(evt);
			}
		});
		getContentPane().add(btnGerarRelatorio);
	}

	/****************************************************************************/
	// Cada classe filha deve implementar esse metodo de uma forma diferente
	public abstract void avancar(java.awt.event.ActionEvent evt);

	/****************************************************************************/
	// Cada classe filha deve implementar esse metodo de uma forma diferente
	public abstract void voltar(java.awt.event.ActionEvent evt);

	/****************************************************************************/
	public void salvar(java.awt.event.ActionEvent evt) {
		String nomePasta = "log/" + funcionarioAvaliado.getCodigoFuncional();
		
		funcionarioAvaliado.setDataAntePenultimaVersao(funcionarioAvaliado.getDataPenultimaVersao());
		funcionarioAvaliado.setDataPenultimaVersao(funcionarioAvaliado.getDataUltimaVersao());
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dataUltimaVersao = dateFormat.format(date).replace(":", "-");
		funcionarioAvaliado.setDataUltimaVersao(dataUltimaVersao);
		
		try {
			
			FileWriter c = new FileWriter(nomePasta + "/" + funcionarioAvaliado.getDataUltimaVersao() + "_avaliacao.properties");
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
				avaliacao += "proatividade.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoProatividade.get(i) + "\n";

			}

			for (int i = 0; i < funcionarioAvaliado.avaliacaoAdequacaoAsRegras.size(); i++) {
				avaliacao += "adequacaoAsRegras.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoEntrega.get(i) + "\n";
			}

			c.write(avaliacao);
			c.close();

		} catch (IOException io) {
			io.printStackTrace();
			JOptionPane.showMessageDialog(this, "Nao foi possivel salvar a avaliacao do funcionario");
		}

	}

	/****************************************************************************/
	protected void geraRelatorio(java.awt.event.ActionEvent evt) {
        
		List<Funcionario> lista_func = new ArrayList<Funcionario>();
		
		lista_func.add(funcionarioAvaliado);
		//System.out.println(funcionarioAvaliado.getNome());
		Relatorio relatorio = new Relatorio();
		try {
			relatorio.geraRelatorio(lista_func);
		} catch (JRException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Nao foi possivel gerar o relatorio");

		}

	}

	protected void encerrar() {
		salvar(null);
		funcionarioAvaliado.setVersaoUltimaAvaliacao(funcionarioAvaliado.getVersaoUltimaAvaliacao() + 1);
		funcionarioAvaliado.setDataAntePenultimaAvaliacao(funcionarioAvaliado.getDataPenultimaAvaliacao());
		funcionarioAvaliado.setDataPenultimaAvaliacao(funcionarioAvaliado.getDataUltimaAvaliacao());
		funcionarioAvaliado.setDataUltimaAvaliacao(funcionarioAvaliado.getDataUltimaVersao());
		
		try {
			
			String nomePasta = "log/" + funcionarioAvaliado.getCodigoFuncional();
			
			FileWriter c = new FileWriter(nomePasta + "/cadastro.properties");
			String cadastro =
							"dataDeCadastro = " + funcionarioAvaliado.getDataDeCadastro() + "\n" +
							"dataAlteracaoCadastro = " + funcionarioAvaliado.getDataAlteracaoCadastro() + "\n" +
							"dataAntePenultimaAvaliacao = " + funcionarioAvaliado.getDataAntePenultimaAvaliacao() + "\n" +
							"dataPenultimaAvaliacao = " + funcionarioAvaliado.getDataPenultimaAvaliacao() + "\n" +
							"dataUltimaAvaliacao = " + funcionarioAvaliado.getDataUltimaAvaliacao() + "\n" +
							"dataAntePenultimaVersao = " + funcionarioAvaliado.getDataAntePenultimaVersao() + "\n" +
							"dataPenultimaVersao = " + funcionarioAvaliado.getDataPenultimaVersao() + "\n" +
							"dataUltimaVersao = " + funcionarioAvaliado.getDataUltimaVersao() + "\n" +
							"versaoUltimaAvaliacao = " + funcionarioAvaliado.getVersaoUltimaAvaliacao() + "\n" +
							"nome = " + funcionarioAvaliado.getNome() + "\n" +
							"sobrenome = " + funcionarioAvaliado.getSobrenome() + "\n" + 
							"departamento = " + funcionarioAvaliado.getDepartamento() + "\n" + 
							"idade = " + funcionarioAvaliado.getIdade() + "\n" + 
							"sexo = " + funcionarioAvaliado.getSexo();
			c.write(cadastro);
			c.close();
		}catch(IOException io) {
			
		}
	}
	
	/****************************************************************************/

	protected void listaVersoes() {
		ArrayList<JMenuItem> listaVersoes = new ArrayList<JMenuItem>();
		
		

	}

}
