package interfaceUsuario;


import javax.swing.*;
import javax.swing.event.MenuEvent;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FramePrincipal extends JFrame {
	
	
	protected  final Funcionario funcionarioAvaliado;
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
		//int desloc = 5*(width - dimensaopreferida.width)/6;
		int desloc = (width - dimensaopreferida.width)/2;
		titulo.setBounds(desloc, height / 30, dimensaopreferida.width, dimensaopreferida.height);

	}
	/****************************************************************************/
	protected void insereBotoesFixos() {
		
		//Inicializa o botao voltar
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnVoltar.setForeground(Color.DARK_GRAY);
		btnVoltar.setBackground(Color.WHITE);
		Dimension dBtnVoltar = btnVoltar.getPreferredSize();
		
		//Inicializa o botao salvar
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSalvar.setForeground(Color.DARK_GRAY);
		btnSalvar.setBackground(Color.WHITE);
		Dimension dBtnSalvar = btnSalvar.getPreferredSize();
		
		//Inicializa o botao avancar
		btnAvancar = new JButton("Avançar");
		btnAvancar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAvancar.setForeground(Color.DARK_GRAY);
		btnAvancar.setBackground(Color.WHITE);
		Dimension dBtnAvancar = btnAvancar.getPreferredSize();
		
		//Inicializa o botao gerarelatorio
		btnGerarRelatorio = new JButton("Gerar Relatorio");
		btnGerarRelatorio.setFont(new Font("Verdana", Font.BOLD, 12));
		btnGerarRelatorio.setForeground(Color.DARK_GRAY);
		btnGerarRelatorio.setBackground(Color.WHITE);
		Dimension dBtnGerarRelatorio = btnGerarRelatorio.getPreferredSize();
		
		//Posiciona o botao voltar
		int voltarX =(int)(0.12*width - dBtnVoltar.width);
		int voltarY =  (int) (height - dBtnVoltar.height - 0.12*height);
		btnVoltar.setBounds(voltarX, voltarY, dBtnVoltar.width, dBtnVoltar.height);
		btnVoltar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				voltar(evt);
			}
		});
		getContentPane().add(btnVoltar);
		
		
		//Posiciona o botao avancar
		int avancarX = (int) (width - voltarX - dBtnAvancar.width);
		int avancarY =  voltarY;
		btnAvancar.setBounds(avancarX, avancarY, dBtnAvancar.width, dBtnAvancar.height);
		btnAvancar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				avancar(evt);
			}
		});
		getContentPane().add(btnAvancar);
		
		//Posiciona o botao salvar
		int salvarX = (int) dBtnVoltar.width + (avancarX - (voltarX + dBtnVoltar.width))/3;
		int salvarY =  voltarY;
		dBtnSalvar = btnSalvar.getPreferredSize();
		btnSalvar.setBounds(salvarX, salvarY, dBtnSalvar.width, dBtnSalvar.height);
		btnSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				salvar(evt);
			}
		});
		getContentPane().add(btnSalvar);
		
		//Posiciona o botao gerarRelatorio
		int gerarRelatorioX = (int)  dBtnVoltar.width + 2*(avancarX - (voltarX + dBtnVoltar.width))/3;
		int gerarRelatorioY = voltarY;
		dBtnGerarRelatorio = btnGerarRelatorio.getPreferredSize();
		btnGerarRelatorio.setBounds(gerarRelatorioX, gerarRelatorioY, dBtnGerarRelatorio.width, dBtnGerarRelatorio.height);
		btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				geraRelatorio(evt);
			}
		});
		getContentPane().add(btnGerarRelatorio);
	}

	/****************************************************************************/
	//Cada classe filha deve implementar esse metodo de uma forma diferente
	public abstract void avancar(java.awt.event.ActionEvent evt);
	
	/****************************************************************************/
	//Cada classe filha deve implementar esse metodo de uma forma diferente
	public abstract void voltar(java.awt.event.ActionEvent evt);
	
	/****************************************************************************/
	public void salvar(java.awt.event.ActionEvent evt) {
		String nomePasta = "log/" + funcionarioAvaliado.getFuncional();
		
		try {
			if(funcionarioAvaliado.getVersaoUltimaAvaliacao() <= 10) {
				
				FileWriter c = new FileWriter(nomePasta + "/avaliacao.properties");
				String avaliacao = "";
				
				for (int i = 0; i < funcionarioAvaliado.avaliacaoMetas.size(); i++) {
					avaliacao += "meta.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoMetas.get(i);
				}
				
				for (int i = 0; i < funcionarioAvaliado.avaliacaoEntrega.size(); i++) {
					avaliacao += "entrega.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoEntrega.get(i);
				}
				
				for (int i = 0; i < funcionarioAvaliado.avaliacaoHabilidadesPessoais.size(); i++) {
					avaliacao += "habilidadesPessoais.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoHabilidadesPessoais.get(i);
					
				}
				
				for (int i = 0; i < funcionarioAvaliado.avaliacaoHabilidadesSociais.size(); i++) {
					avaliacao += "habilidadesSociais.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoHabilidadesSociais.get(i);
					
				}
				
				for (int i = 0; i < funcionarioAvaliado.avaliacaoProatividade.size(); i++) {
					avaliacao += "proatividade.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoProatividade.get(i);
					
				}
				
				for (int i = 0; i < funcionarioAvaliado.avaliacaoAdequacaoAsRegras.size(); i++) {
					avaliacao += "adequacaoAsRegras.pergunta" + i + " = " + funcionarioAvaliado.avaliacaoEntrega.get(i);
				}
				
				c.write(avaliacao);
				c.close();
			}else {
				
			}
			
		}catch(IOException io) {
			io.printStackTrace();
			JOptionPane.showMessageDialog(this, "Nao foi possivel salvar a avaliacao do funcionario");
		}
		
	}
	
	/****************************************************************************/
	public void geraRelatorio(java.awt.event.ActionEvent evt) {
		
	}
	/****************************************************************************/
	
	public void listaVersoes() {
		ArrayList<JMenuItem> listaVersoes = new ArrayList<JMenuItem>();

	}

}
