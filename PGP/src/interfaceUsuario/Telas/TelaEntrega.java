package interfaceUsuario.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaceUsuario.FramePrincipal;
import interfaceUsuario.Funcionario;
import interfaceUsuario.InterfaceController;
import interfaceUsuario.ValidaCampos;
import limitador.SoLetras;
import limitador.SoNumeros;

public class TelaEntrega extends FramePrincipal {

	private final Funcionario funcionarioAvaliado;

	private JButton btnAvancar;
	protected JTextField txtCodFunc;
	protected JTextField txtNome;
	protected JTextField txtSobrenome;
	private JTextField txtDepto;
	private JTextField txtIdade;
	private JComboBox<String> sexo;
	ValidaCampos valida = new ValidaCampos();

	/****************************************************************************/
	public TelaEntrega(Funcionario f) {
		this.funcionarioAvaliado = f;
		initialize();
		setTitulo("Avaliacao da entrega");
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
	public void btnAvancar(java.awt.event.ActionEvent evt) {
		JFrame telaEntrega = InterfaceController.controlaTelas("TelaMetas", funcionarioAvaliado);
		telaEntrega.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	public void btnSalvar(java.awt.event.ActionEvent evt) {

	}
	/****************************************************************************/
	public void geraRelatorio(java.awt.event.ActionEvent evt) {

	}
	/****************************************************************************/
}
