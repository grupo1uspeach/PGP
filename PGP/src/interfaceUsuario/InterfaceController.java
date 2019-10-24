package interfaceUsuario;

import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;

import interfaceUsuario.Telas.TelaAdequacaoAsRegras;
import interfaceUsuario.Telas.TelaEntrega;
import interfaceUsuario.Telas.TelaHabilidadesPessoais;
import interfaceUsuario.Telas.TelaHabilidadesSociais;
import interfaceUsuario.Telas.TelaInicial;
import interfaceUsuario.Telas.TelaMetas;
import interfaceUsuario.Telas.TelaProatividade;

public class InterfaceController {
	public static JFrame controlaTelas(String NovaTela, Funcionario funcionarioAvaliado) {
		JFrame novaTela = new JFrame();
		switch (NovaTela) {

		case "TelaInicial":
			novaTela = new TelaInicial();
			break;

		case "TelaAdequacaoAsRegras":
			novaTela = new TelaAdequacaoAsRegras(funcionarioAvaliado);
			break;

		case "TelaEntrega":
			novaTela = new TelaEntrega(funcionarioAvaliado);
			break;

		case "TelaHabilidadesPessoais":
			novaTela = new TelaHabilidadesPessoais(funcionarioAvaliado);
			break;

		case "TelaHabilidadesSociais":
			novaTela = new TelaHabilidadesSociais(funcionarioAvaliado);
			break;

		case "TelaMetas":
			novaTela = new TelaMetas(funcionarioAvaliado);
			break;

		case "TelaProatividade":
			novaTela = new TelaProatividade(funcionarioAvaliado);
			break;
		}

		return novaTela;
	}
}
