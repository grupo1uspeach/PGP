package interfaceUsuario.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaceUsuario.FramePrincipal;
import interfaceUsuario.Funcionario;
import interfaceUsuario.InterfaceController;
import interfaceUsuario.ValidaCampos;
import limitador.SoLetras;
import limitador.SoNumeros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TelaInicial extends FramePrincipal {

	private static Funcionario funcionarioAvaliado;

	private JButton btnAvancar;
	protected JTextField txtCodFunc;
	protected JTextField txtNome;
	protected JTextField txtSobrenome;
	private JTextField txtDepto;
	private JTextField txtIdade;
	private JComboBox<String> sexo;
	ValidaCampos valida = new ValidaCampos();

	/****************************************************************************/
	public TelaInicial() {
		initialize();
		setTitulo("Funcionario Avaliado");
		adicionaComponentes();
	}

	/****************************************************************************/
	private void adicionaComponentes() {
		LinkedList<JLabel> listaCampos = new LinkedList<JLabel>();
		listaCampos.add(new JLabel("Cod. Funcional:"));
		listaCampos.get(0).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		listaCampos.add(new JLabel("Nome:"));
		listaCampos.get(1).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		listaCampos.add(new JLabel("Sobrenome:"));
		listaCampos.get(2).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		listaCampos.add(new JLabel("Departamento:"));
		listaCampos.get(3).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		listaCampos.add(new JLabel("Idade:"));
		listaCampos.get(4).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		listaCampos.add(new JLabel("Sexo:"));
		listaCampos.get(5).setFont(new Font("Segoe UI", Font.PLAIN, 13));

		LinkedList<JTextField> listaTextos = new LinkedList<JTextField>();

		// Testo Cod. Funcional
		listaTextos.add(this.txtCodFunc = new JTextField());
		listaTextos.get(0).setColumns(10);
		listaTextos.get(0).setDocument(new SoNumeros(14));

		// Texto Nome
		listaTextos.add(this.txtNome = new JTextField());
		listaTextos.get(1).setColumns(10);
		listaTextos.get(1).setDocument(new SoLetras(25));

		// Texto Sobrenome
		listaTextos.add(this.txtSobrenome = new JTextField());
		listaTextos.get(2).setColumns(10);
		listaTextos.get(2).setDocument(new SoLetras(25));

		// Texto Departamento
		listaTextos.add(this.txtDepto = new JTextField());
		listaTextos.get(3).setColumns(10);
		listaTextos.get(3).setDocument(new SoLetras(25));

		// Texto Idade
		listaTextos.add(this.txtIdade = new JTextField());
		listaTextos.get(4).setColumns(10);
		listaTextos.get(4).setDocument(new SoNumeros(2));

		insereElementos(listaTextos, listaCampos);
	}

	/****************************************************************************/
	protected void insereElementos(LinkedList<JTextField> txtCampo, LinkedList<JLabel> lblCampos) {

		int qtdCampos = lblCampos.size();

		Dimension maiorDimensaoLbl = lblCampos.get(0).getPreferredSize();
		Dimension dimensaoAtualLbl;

		Dimension maiorDimensaoTxt = lblCampos.get(0).getPreferredSize();
		Dimension dimensaoAtualTxt;

		for (int y = 0; y < qtdCampos; y++) {
			dimensaoAtualLbl = lblCampos.get(y).getPreferredSize();
			if (dimensaoAtualLbl.width > maiorDimensaoLbl.width) {
				dimensaoAtualLbl = maiorDimensaoLbl;
			}

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

		btnAvancar = new JButton("Avançar");
		Dimension dBtn = btnAvancar.getPreferredSize();
		btnAvancar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAvancar.setForeground(Color.DARK_GRAY);
		btnAvancar.setBackground(Color.WHITE);
		btnAvancar.setBounds(width / 2, deslocamentoLbl + lblY / 2, dBtn.width, dBtn.height);
		btnAvancar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAvancar(evt);
			}
		});
		getContentPane().add(btnAvancar);
	}

	/****************************************************************************/
	/*
	 * ACAO DO BOTAO AVANÇAR VERIFICA SE OS CAMPOS NECESSARIOS FORAM PREENCHIDOS E
	 * CORRETAMENTE: COD. FUNCIONAL, NOME, SOBRENOME, CAMPOS DE IDADE, SEXO,
	 * TELEFONE E DEPARTAMENTO ACEITAM SEM PREENCHIMENTO E ? COLOCADO VALOR N/A
	 * NELES
	 */
	public void btnAvancar(java.awt.event.ActionEvent evt) {
		String nome, sobrenome, departamento, idade, sexo;
		nome = sobrenome = departamento = idade = sexo = "";
		try {
			String codFunc = this.txtCodFunc.getText();
			if (!codFunc.isEmpty()) {
				String nomePasta = "log/" + codFunc;
				File pastaFuncionario = new File(nomePasta);
				if (pastaFuncionario.exists()) {
					Properties cadastro = new Properties();
					FileInputStream arquivo = new FileInputStream(nomePasta + "/cadastro.properties");
					cadastro.load(arquivo);
					
					nome = cadastro.getProperty("nome");

					sobrenome = cadastro.getProperty("sobrenome");
					departamento = cadastro.getProperty("departamento");
					idade = cadastro.getProperty("idade");
					sexo = cadastro.getProperty("sexo");

					this.txtNome.setText(nome);
					this.txtSobrenome.setText(sobrenome);
					this.txtDepto.setText(departamento);
					this.txtIdade.setText(idade);
					this.sexo.setSelectedItem(sexo);
					
					
				} else {
					int resposta = JOptionPane.showConfirmDialog(this,
							"O funcionario nao possui historico de avaliacao ainda. Deseja continuar?");
					if (resposta == 0) {

						nome = this.txtNome.getText();
						sobrenome = this.txtSobrenome.getText();
						departamento = this.txtDepto.getText();
						idade = this.txtIdade.getText();
						sexo = this.sexo.getSelectedItem().toString();
						
						// VERIFICACAO IMPORTANTE
						if (nome.isEmpty()) {
							JOptionPane.showMessageDialog(this, "Nome esta vazio!");
							return;
						}
						System.out.println("teste");
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

						pastaFuncionario.mkdirs();
						FileWriter c = new FileWriter(nomePasta + "/cadastro.properties");
						String cadastro =
								"nome = " + nome + "\n" +
								"sobrenome = " + sobrenome + "\n" + 
								"departamento = " + departamento + "\n" + 
								"idade = " + idade + "\n" + 
								"sexo = " + sexo;
						c.write(cadastro);
					} else return;
				}

			} else {
				JOptionPane.showMessageDialog(this, "Codigo funcional esta vazio!");
				return;
			}
			
			int resposta = JOptionPane.showConfirmDialog(this,
					"Tem certeza que deseja avaliar o funcionario: "+ nome + " " + sobrenome + "?");
			if (resposta == 0) {
				funcionarioAvaliado = new Funcionario();
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
	/****************************************************************************/
	
}
