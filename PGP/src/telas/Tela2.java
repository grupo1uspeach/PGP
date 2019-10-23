package telas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Tela2 extends BotaoAbrirTelas {
	
	protected JFrame frmTela2;
	
    public Tela2() {
        try {
        	initialize();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "erro tela2", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public JFrame getFrame() {
        return frmTela2;
    }

    public void setFrame(JFrame frame) {
        this.frmTela2 = frame;
    }
    
    private void initialize() {
        setFrame(new JFrame(" "));
        getFrame().getContentPane().setBackground(new Color(204, 255, 153));
        getFrame().setBackground(Color.WHITE);
        getFrame().setBounds(100, 100, 500, 400);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().getContentPane().setLayout(null);
        getFrame().setResizable(false);
        getFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("ENTREGAS");
        lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(90, 11, 308, 24);
        getFrame().add(lblNewLabel);
    }

}
