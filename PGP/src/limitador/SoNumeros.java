package limitador;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SoNumeros extends PlainDocument{
	private int qtdMax;
	public SoNumeros(int maxLen) {
		super();
		if(maxLen <= 0) {
			throw new IllegalArgumentException("Defina o Tamanho maximo do campo");
		}
		qtdMax = maxLen;
	}
	
	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if(str==null || getLength() == qtdMax) {
			return;
		}
		int totalQtd = getLength() + str.length();
		if(totalQtd <= qtdMax) {
			super.insertString(offs, str.replaceAll("[^0-9]",""), a);
			return;
		}
		String newStr = str.substring(0,getLength()-qtdMax);
		super.insertString(offs, newStr, a);
	}
		
}
