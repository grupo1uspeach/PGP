package telas;

import java.text.Normalizer;
import javax.swing.JOptionPane;

public class ValidaCampos {

	//INFORMACOES DO FUNCIONARIO
	
	public boolean verificaCPF(String CodFunc) {
        /*
        if (CodFunc.length() != 11) {
            JOptionPane.showMessageDialog(null, "Codigo funcional invalido!\nDeve ter N digitos.");
            return false;
        }
        */
        if (!CodFunc.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Codigo funcional possui caracteres invalidos!");
            return false;
        }
        return true;
    }
	
	
	public boolean verificaNome(String nome) {
		String s = nome.toLowerCase();
		s = s.replaceAll(" ", "");
	    s = removeAcentos(s);
	    if(!s.matches("[a-z]+")) {
	    	JOptionPane.showMessageDialog(null,"Campo nome possui caracteres invalidos.");
	    	return false;
	    }
	    else {
	    	return true;
	    }
	}
	
	
	public boolean verificaSobrenome(String sobrenome) {
		String s = sobrenome.toLowerCase();
	    s = s.replaceAll(" ", "");
	    s = removeAcentos(s);

	    if(!s.matches("[a-z]+")) {
	    	JOptionPane.showMessageDialog(null,"Campo sobrenome possui caracteres invalidos.");
	    	return false;
	    }
	    else {
	    	return true;
	    }
		
	}
	
    public boolean verificaEndereco(String endereco) {
    	boolean dptovalido = false;
	    String s = endereco.toLowerCase();
	    s = s.replaceAll(" ", "");
	    s = removeAcentos(s);
	    dptovalido = s.matches("[0-z]+");
	    if(!dptovalido) {
	    	JOptionPane.showMessageDialog(null, "Departamento possui caracteres invalidos");
	    }

    	return dptovalido;
    }
	
    public String removeAcentos(String txt) {
        return Normalizer.normalize(txt, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
	
	public boolean verificaIdade(String idade) {
        if (!idade.matches("[0-9]+") && !(idade.length() == 1 || idade.length() == 2)) {
        	JOptionPane.showMessageDialog(null, "Idade invalida!");
            return false;
        }
        return true;
    }
	
	public boolean verificaSexo(String sexo) {
		if(sexo.equals("M") || sexo.equals("F") ) {
			return true;
		}		
		else {
			JOptionPane.showMessageDialog(null, "Sexo invalido!");
			return false;
		}
    }
}
