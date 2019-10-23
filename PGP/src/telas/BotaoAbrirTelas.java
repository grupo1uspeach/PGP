package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JPanel;

public class BotaoAbrirTelas {

	private static final long serialVersionUID = 1L;
	private List<JPanel> paineis = new LinkedList<JPanel>();

	public void addActionListener(AbstractButton btn, String actionListenerName) {
		Object autoRef = this;
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					Method method = autoRef.getClass().getMethod(
							actionListenerName, ActionEvent.class);
					method.invoke(autoRef, evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	protected void mostraPainel(JPanel painel) {
		for (JPanel p : paineis) {
			if (p == painel) {
				p.setVisible(true);
			} else {
				p.setVisible(false);
			}
		}
	}
	
}
