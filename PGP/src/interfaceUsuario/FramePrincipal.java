package interfaceUsuario;


import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FramePrincipal extends JFrame {
	public FramePrincipal() {
	}

	protected JLabel titulo;
	protected JLabel periodo;
	protected int height = 600;
	protected int width = 700;
	protected JMenuBar menuBar;
	protected JMenu voltar;

	/**
	 * ****************************************************************************
	 */

	protected void initialize() {
		titulo = new JLabel();
		titulo.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		getContentPane().add(titulo);
		
		
		// Menu de voltar
		menuBar = new JMenuBar();
		voltar = new JMenu();
		voltar.setText("Voltar");
		menuBar.add(voltar);

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

	/**
	 * ****************************************************************************
	 */

	protected void sair(MenuEvent ev) {
		// TODO os filhos devem implementar
	}

	protected void mudaPeriodo() {
		if (periodo.getText().charAt(periodo.getText().length() - 2) == 'd') {
			periodo.setText("Status do periodo de Matricula: Aberto");
		} else {
			periodo.setText("Status do periodo de Matricula: Fechado");
		}
	}

}
