package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import telas.BotaoAbrirTelas;
import telas.ValidaCampos;
import java.io.IOException;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Tela1 extends BotaoAbrirTelas {

    protected JFrame frmTela1;

    private JButton identificaFunc;
    protected JTextField textCodFunc;
    protected JTextField textNome;
    protected JTextField textSobrenome;
    private JTextField textDepto;
    private JTextField textIdade;
    private JTextField textSexo;

    ValidaCampos valida = new ValidaCampos();

    public Tela1() throws IOException {
        initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tela1 window = new Tela1();
                    window.frmTela1.setVisible(true);
                  } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private void initialize() {
        setFrame(new JFrame(" "));
        getFrame().getContentPane().setBackground(new Color(204, 255, 153));
        getFrame().setBackground(Color.WHITE);
        // getFrame().setBounds(100, 100, 450, 300);
        getFrame().setBounds(100, 100, 500, 400);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().getContentPane().setLayout(null);
        getFrame().setResizable(false);

        JLabel lblCodFunc = new JLabel("Cod. Funcional:");
        lblCodFunc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblCodFunc.setBounds(70, 54, 32, 16);
        getFrame().add(lblCodFunc);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblNome.setBounds(60, 100, 42, 16);
        getFrame().add(lblNome);

        JLabel lblSobrenome = new JLabel("Sobrenome:");
        lblSobrenome.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblSobrenome.setBounds(28, 146, 75, 16);
        getFrame().add(lblSobrenome);

        JLabel lblDpto = new JLabel("Departamento:");
        lblDpto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblDpto.setBounds(40, 235, 59, 16);
        getFrame().add(lblDpto);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblIdade.setBounds(62, 190, 42, 16);
        getFrame().add(lblIdade);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblSexo.setBounds(155, 190, 32, 16);
        getFrame().add(lblSexo);

        textCodFunc = new JTextField();
        textCodFunc.setBounds(110, 50, 122, 28);
        textCodFunc.setColumns(10);
        getFrame().add( textCodFunc);

        textNome = new JTextField();
        textNome.setBounds(110, 95, 122, 28);
        getFrame().add(textNome);
        textNome.setColumns(10);

        textSobrenome = new JTextField();
        textSobrenome.setBounds(110, 140, 307, 28);
        getFrame().add(textSobrenome);
        textSobrenome.setColumns(10);

        textDepto = new JTextField();
        textDepto.setBounds(110, 230, 307, 28);
        getFrame().add(textDepto);
        textDepto.setColumns(10);

        textIdade = new JTextField();
        textIdade.setBounds(110, 185, 30, 28);
        getFrame().add(textIdade);
        textIdade.setColumns(10);

        textSexo = new JTextField();
        textSexo.setBounds(190, 185, 30, 28);
        getFrame().add(textSexo);
        textSexo.setColumns(10);

        JLabel lblCada = new JLabel("FUNCION¡RIO AVALIADO");
        lblCada.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        lblCada.setBounds(135, 11, 310, 24);
        getFrame().add(lblCada);

        identificaFunc = new JButton("AvanÁar");
        identificaFunc.setFont(new Font("Verdana", Font.BOLD, 12));
        identificaFunc.setForeground(Color.DARK_GRAY);
        identificaFunc.setBackground(Color.WHITE);
        identificaFunc.setBounds(200, 280, 100, 23);
        identificaFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identFuncActionPerformed(evt);
            }
        });
        getFrame().add(identificaFunc);
        // addActionListener(identificaFunc, "abreTela2");
    }

    public JFrame getFrame() {
        return frmTela1;
    }

    public void setFrame(JFrame frame) {
        this.frmTela1 = frame;
    }

    // ACAO DO BOTAO AVAN«AR
    // VERIFICA SE OS CAMPOS NECESSARIOS FORAM PREENCHIDOS E CORRETAMENTE: COD. FUNCIONAL, NOME
    // E SOBRENOME
    // CAMPOS DE IDADE, SEXO, TELEFONE E DEPARTAMENTO ACEITAM SEM PREENCHIMENTO E ?
    // COLOCADO VALOR N/A NELES
    public void identFuncActionPerformed(java.awt.event.ActionEvent evt) {
        String CodFunc =  textCodFunc.getText();
        String nome = textNome.getText();
        String sobrenome = textSobrenome.getText();
        String departamento = textDepto.getText();
        String idade = textIdade.getText();
        String sexo = textSexo.getText();

        // VERIFICACAO IMPORTANTE
        if (CodFunc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Codigo funcional esta vazio!");
            return;
        }
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome esta vazio!");
            return;
        }
        if (sobrenome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sobrenome esta vazio!");
            return;
        }

        if (departamento.isEmpty()){
            JOptionPane.showMessageDialog(null, "Departamento esta vazio!");
            return;
        }

        // CASO O USUARIO NAO PREENCHA ESSES VALORES, SERA COLOCADO UM VALOR PADRAO NAO PREENCHIDO
        if (idade.isEmpty()) {
            idade = "N„o preenchida";
        }
        if (sexo.isEmpty()) {
            sexo = "N„o preenchido";
        }
    }
        /*Paciente p = new Paciente();
        // TENTA CRIAR O OBJETO PACIENTE, VERIFICANDO A INTEGRIDADE DOS DADOS
        if (cadastraPaciente(CodFunc, nome, sobrenome, telefone, departamento, idade, sexo, p)) {
            // PacienteDAO pdao = new PacienteDAO(); PARA CADASTRAR NO BANCO DE DADOS
            // pdao.adiciona(p); PARA CADASTRAR NO BANCO DE DADOS AO CLICAR EM CONCLUIDO
            try {
                paci.adiciona(p);
                abreTela2(p);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }*/

    // SETA VALORES PARA PODER PASSAR ADIANTE ATE CHEGAR NA ULTIMA TELA ONDE SER√ÉO
    // MOSTRADOS NA TELA INFORMACOES SOBRE A CONSULTA MARCADA
    /*public boolean cadastraPaciente(String CodFunc, String nome, String sobrenome, String telefone, String departamento,
            String idade, String sexo, Paciente p) {
        boolean cadastrou = false;
        // VALIDA CodFunc, SE ESTIVER ERRADO JA RETORNA FALSO
        if (valida.verificaCPF(CodFunc)) {

            //FAZENDO VERIFICA√á√ÉO DO CodFunc NO BANCO
            try {

                double cpf_num;
                boolean jaexistecpf = false;
                cpf_num = Double.parseDouble(CodFunc);

                //CHAMADA DE METODO PARA VERIFICACAO
                jaexistecpf = paci.jaexisteCPF(cpf_num);
                if (!jaexistecpf) {
                    p.setCPF(CodFunc);
                    cadastrou = true;
                } else {
                    JOptionPane.showMessageDialog(null, "J√° existe um CodFunc com"
                            + " esse n√∫mero cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    //COLOCAR JOptionPane DE CONFIRMA√á√ÉO AQUI PARA LEVAR PARA A OUTRA TELA.
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return false;
        }
        // VALIDA NOME, SE ESTIVER ERRADO JA RETORNA FALSO
        if (valida.verificaNome(nome)) {
            p.setPNome(nome);
            cadastrou = true;
        } else {
            return false;
        }
        // VALIDA SOBRENOME, SE ESTIVER ERRADO JA RETORNA FALSO
        if (valida.verificaSobrenome(sobrenome)) {
            p.setUNome(sobrenome);
            cadastrou = true;
        } else {
            return false;
        }

        // VERIFCA TELEFONE, departamento, IDADE E SEXO SE ESTAO PRENCHIDOS
        if (!telefone.equals("N/A")) {
            cadastrou = valida.verificaTelefone(telefone);
            if (!cadastrou) {
                return false;
            }
        }
        if (!departamento.equals("N/A")) {
            cadastrou = valida.verificaEndereco(departamento);
            if (!cadastrou) {
                return false;
            }
        }
        if (!idade.equals("N/A")) {
            cadastrou = valida.verificaIdade(idade);
            if (!cadastrou) {
                return false;
            }
        }
        if (!sexo.equals("N/A")) {
            sexo = sexo.toUpperCase();
            cadastrou = valida.verificaSexo(sexo);
            if (!cadastrou) {
                return false;
            }
        }

        p.setTelefone(telefone);
        p.setEndereco(departamento);
        p.setIdade(idade);
        p.setSexo(sexo);

        return cadastrou;
    }*/

    // ABRE A PROXIMA TELA
    public void abreTela2() {
        Tela2 tela2 = new Tela2();
        System.out.println("Criei tela");
        //tela2.setPaciente(p);
        frmTela1.setVisible(false);
        tela2.frmTela2.setVisible(true);
    }
}
