package beans;

import java.util.ArrayList;
import java.util.Date;

public class Funcionario {

	private String codigoFuncional;
	private String nome;
	private String sobrenome;
	private String departamento;
	private String idade;
	private String sexo;
	
	private String dataDeCadastro;
	private String dataAlteracaoCadastro;
	
	//Variavel para versionamento de avaliacao
	private int versaoUltimaAvaliacao;
	
	//Data das ultimas avaliacoes feitas quando o programa fechou
	private String dataAntePenultimaAvaliacao;
	private String dataPenultimaAvaliacao;
	private String dataUltimaAvaliacao;
	
	//Tres ultimas versoes da avaliacao para que a pessoa possa dar uma especie de ctrl + z
	private String dataAntePenultimaVersao;
	private String dataPenultimaVersao;
	private String dataUltimaVersao;
	
	//Listas de respostas para salvar
	public ArrayList<Integer> avaliacaoEntrega;
	public ArrayList<Integer> avaliacaoMetas;
	public ArrayList<Integer> avaliacaoHabilidadesPessoais;
	public ArrayList<Integer> avaliacaoHabilidadesSociais;
	public ArrayList<Integer> avaliacaoProatividade;
	public ArrayList<Integer> avaliacaoAdequacaoAsRegras;

	String entregas1 = "1";
	String entregas2 = "1";
	String entregas3 = "1";
	String entregas4 = "1";
	String entregas5 = "1";
	
	String metas1 = "1";
	String metas2 = "1";
	String metas3 = "1";
	String metas4 = "1";
	String metas5 = "1";

	String habilidadesPessoais1 = "1";
	String habilidadesPessoais2 = "1";
	String habilidadesPessoais3 = "1";
	String habilidadesPessoais4 = "1";
	String habilidadesPessoais5 = "1";

	String habilidadesSociais1 = "1";
	String habilidadesSociais2 = "1";
	String habilidadesSociais3 = "1";
	String habilidadesSociais4 = "1";
	String habilidadesSociais5 = "1";

	String proatividade1 = "1";
	String proatividade2 = "1";
	String proatividade3 = "1";
	String proatividade4 = "1";
	String proatividade5 = "1";

	String adequacaoAsRegras1 = "1";
	String adequacaoAsRegras2 = "1";
	String adequacaoAsRegras3 = "1";
	String adequacaoAsRegras4 = "1";
	String adequacaoAsRegras5 = "1";
	
	
	public Funcionario() {
		this.avaliacaoEntrega = new ArrayList<Integer>();
		this.avaliacaoMetas = new ArrayList<Integer>();
		this.avaliacaoHabilidadesPessoais = new ArrayList<Integer>();
		this.avaliacaoHabilidadesSociais = new ArrayList<Integer>();
		this.avaliacaoProatividade = new ArrayList<Integer>();
		this.avaliacaoAdequacaoAsRegras = new ArrayList<Integer>();
	}
	
	public String getCodigoFuncional() {
		return codigoFuncional;
	}
	public void setCodigoFuncional(String funcional) {
		this.codigoFuncional = funcional;
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
	public String getDataAntePenultimaAvaliacao() {
		return dataAntePenultimaAvaliacao;
	}
	public void setDataAntePenultimaAvaliacao(String dataPenultimaAvaliacao) {
		this.dataAntePenultimaAvaliacao = dataPenultimaAvaliacao;
	}
	public String getDataPenultimaAvaliacao() {
		return dataPenultimaAvaliacao;
	}
	public void setDataPenultimaAvaliacao(String dataPenultimaAvaliacao) {
		this.dataPenultimaAvaliacao = dataPenultimaAvaliacao;
	}
	public String getDataUltimaAvaliacao() {
		return dataUltimaAvaliacao;
	}
	public void setDataUltimaAvaliacao(String dataUltimaAvaliacao) {
		this.dataUltimaAvaliacao = dataUltimaAvaliacao;
	}
	public String getDataAntePenultimaVersao() {
		return dataAntePenultimaVersao;
	}
	public void setDataAntePenultimaVersao(String dataPenultimaVersao) {
		this.dataAntePenultimaVersao = dataPenultimaVersao;
	}
	public String getDataPenultimaVersao() {
		return dataPenultimaVersao;
	}
	public void setDataPenultimaVersao(String dataPenultimaVersao) {
		this.dataPenultimaVersao = dataPenultimaVersao;
	}
	public String getDataUltimaVersao() {
		return dataUltimaVersao;
	}
	public void setDataUltimaVersao(String dataUltimaVersao) {
		this.dataUltimaVersao = dataUltimaVersao;
	}
	public String getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(String dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public String getDataAlteracaoCadastro() {
		return dataAlteracaoCadastro;
	}
	public void setDataAlteracaoCadastro(String dataAlteracaoCadastro) {
		this.dataAlteracaoCadastro = dataAlteracaoCadastro;
	}
	
}
