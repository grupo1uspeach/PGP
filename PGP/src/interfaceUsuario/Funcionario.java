package interfaceUsuario;

import java.util.ArrayList;
import java.util.Date;

public class Funcionario {

	private String funcional;
	private String nome;
	private String sobrenome;
	private String departamento;
	private String idade;
	private String sexo;
	//Variavel para versionamento de avaliacao
	private int versaoUltimaAvaliacao;
	private String dataUltimaAvaliacao;
	
	//Listas de respostas para salvar
	public ArrayList<Integer> avaliacaoEntrega;
	public ArrayList<Integer> avaliacaoMetas;
	public ArrayList<Integer> avaliacaoHabilidadesPessoais;
	public ArrayList<Integer> avaliacaoHabilidadesSociais;
	public ArrayList<Integer> avaliacaoProatividade;
	public ArrayList<Integer> avaliacaoAdequacaoAsRegras;

	
	public String getFuncional() {
		return funcional;
	}
	public void setFuncional(String funcional) {
		this.funcional = funcional;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getVersaoUltimaAvaliacao() {
		return this.versaoUltimaAvaliacao;
	}
	public void setVersaoUltimaAvaliacao(int versaoUltimaAvaliacao) {
		this.versaoUltimaAvaliacao = versaoUltimaAvaliacao;
	}
	public String dataUltimaAvaliacao() {
		return dataUltimaAvaliacao;
	}
	public void dataUltimaAvaliacao(String dataUltimaAvaliacao) {
		this.dataUltimaAvaliacao = dataUltimaAvaliacao;
	}
	
}
