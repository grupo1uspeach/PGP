package interfaceUsuario.Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;

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

public class TelaAdequacaoAsRegras extends FramePrincipal {

	private final Funcionario funcionarioAvaliado;

	private JButton btnAvancar;
	private JButton btnVoltar;

	/****************************************************************************/
	public TelaAdequacaoAsRegras(Funcionario f) {
		this.funcionarioAvaliado = f;
		initialize();
		setTitulo("Adequacao as regras");
		adicionaComponentes();
	}

	/****************************************************************************/
	private void adicionaComponentes() {
		insereElementos();
	}

	/****************************************************************************/
	protected void insereElementos() {

		btnAvancar = new JButton("Encerrar");
		btnAvancar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAvancar.setForeground(Color.DARK_GRAY);
		btnAvancar.setBackground(Color.WHITE);
		Dimension dBtn = btnAvancar.getPreferredSize();
		btnAvancar.setBounds((int) (width - dBtn.width - 0.05 * width), (int) (height - dBtn.height - 0.12 * height),
				dBtn.width, dBtn.height);
		btnAvancar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEncerrar(evt);
			}
		});
		getContentPane().add(btnAvancar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnVoltar.setForeground(Color.DARK_GRAY);
		btnVoltar.setBackground(Color.WHITE);
		dBtn = btnVoltar.getPreferredSize();
		btnVoltar.setBounds( (int)(0.12*width - dBtn.width), (int) (height - dBtn.height - 0.12*height), dBtn.width, dBtn.height);
		btnVoltar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnVoltar(evt);
			}
		});
		getContentPane().add(btnVoltar);

	}

	/****************************************************************************/
	public void btnEncerrar(java.awt.event.ActionEvent evt) {
		JFrame telaMetas = InterfaceController.controlaTelas("TelaMetas", funcionarioAvaliado);
		telaMetas.setVisible(true);
		dispose();
	}

	/****************************************************************************/
	public void btnVoltar(java.awt.event.ActionEvent evt) {

		int salvarAvaliacao = JOptionPane.showConfirmDialog(this,
				"Voce gostaria de salvar os resultados da avaliacao?");
		if (salvarAvaliacao == 0) {
			// Salvar avaliacao
		}
		JFrame telaProatividade = InterfaceController.controlaTelas("TelaProatividade", null);
		telaProatividade.setVisible(true);
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
