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
	//private String avaliacaoAnotacoesGerais;

	private String metas1 = "5";
    private String metas2 = "5";
    private String metas3 = "5";
    private String metas4 = "5";
    private String metas5 = "5";

    private String entregas1 = "5";
    private String entregas2 = "5";
    private String entregas3 = "5";
    private String entregas4 = "5";
    private String entregas5 = "5";

    private String habilidadesPessoais1 = "5";
    private String habilidadesPessoais2 = "5";
    private String habilidadesPessoais3 = "5";
    private String habilidadesPessoais4 = "5";
    private String habilidadesPessoais5 = "5";

    private String habilidadesSociais1 = "5";
    private String habilidadesSociais2 = "5";
    private String habilidadesSociais3 = "5";
    private String habilidadesSociais4 = "5";
    private String habilidadesSociais5 = "";

    private String proatividade1 = "5";
    private String proatividade2 = "5";
    private String proatividade3 = "5";
    private String proatividade4 = "5";
    private String proatividade5 = "5";

    private String adequacaoAsRegras1 = "5";
    private String adequacaoAsRegras2 = "5";
    private String adequacaoAsRegras3 = "5";
    private String adequacaoAsRegras4 = "5";
    private String adequacaoAsRegras5 = "5";
    
    private String anotacoesGerais;
    
    public Funcionario() {
    	//String anotacoesGerais = "Sem anotações gerais para o funcionário";
    	
		this.avaliacaoEntrega = new ArrayList<Integer>();
		this.avaliacaoMetas = new ArrayList<Integer>();
		this.avaliacaoHabilidadesPessoais = new ArrayList<Integer>();
		this.avaliacaoHabilidadesSociais = new ArrayList<Integer>();
		this.avaliacaoProatividade = new ArrayList<Integer>();
		this.avaliacaoAdequacaoAsRegras = new ArrayList<Integer>();
	}
    
    public void atualizaStrings() {
        this.metas1 = "" + avaliacaoMetas.get(0);
        this.metas2 = "" + avaliacaoMetas.get(1);
        this.metas3 = "" + avaliacaoMetas.get(2);
        this.metas4 = "" + avaliacaoMetas.get(3);
        this.metas5 = "" + avaliacaoMetas.get(4);

        this.entregas1 = "" + avaliacaoEntrega.get(0);
        this.entregas2 = "" + avaliacaoEntrega.get(1);
        this.entregas3 = "" + avaliacaoEntrega.get(2);
        this.entregas4 = "" + avaliacaoEntrega.get(3);
        this.entregas5 = "" + avaliacaoEntrega.get(4);

        this.habilidadesPessoais1 = "" + avaliacaoHabilidadesPessoais.get(0);
        this.habilidadesPessoais2 = "" + avaliacaoHabilidadesPessoais.get(1);
        this.habilidadesPessoais3 = "" + avaliacaoHabilidadesPessoais.get(2);
        this.habilidadesPessoais4 = "" + avaliacaoHabilidadesPessoais.get(3);
        this.habilidadesPessoais5 = "" + avaliacaoHabilidadesPessoais.get(4);

        this.habilidadesSociais1 = "" + avaliacaoHabilidadesSociais.get(0);
        this.habilidadesSociais2 = "" + avaliacaoHabilidadesSociais.get(1);
        this.habilidadesSociais3 = "" + avaliacaoHabilidadesSociais.get(2);
        this.habilidadesSociais4 = "" + avaliacaoHabilidadesSociais.get(3);
        this.habilidadesSociais5 = "" + avaliacaoHabilidadesSociais.get(4);

        this.proatividade1 = "" + avaliacaoProatividade.get(0);
        this.proatividade2 = "" + avaliacaoProatividade.get(1);
        this.proatividade3 = "" + avaliacaoProatividade.get(2);
        this.proatividade4 = "" + avaliacaoProatividade.get(3);
        this.proatividade5 = "" + avaliacaoProatividade.get(4);

        this.adequacaoAsRegras1 = "" + avaliacaoAdequacaoAsRegras.get(0);
        this.adequacaoAsRegras2 = "" + avaliacaoAdequacaoAsRegras.get(1);
        this.adequacaoAsRegras3 = "" + avaliacaoAdequacaoAsRegras.get(2);
        this.adequacaoAsRegras4 = "" + avaliacaoAdequacaoAsRegras.get(3);
        this.adequacaoAsRegras5 = "" + avaliacaoAdequacaoAsRegras.get(4);
        
        this.anotacoesGerais = "" + getAnotacoesGerais();
    }
    
  //Anotacoes
    public void setAnotacoesGerais(String anotacoesGerais) {
    	this.anotacoesGerais = anotacoesGerais; 
    }
    public String getAnotacoesGerais() {
    	return this.anotacoesGerais;
    }
    //Entregas
    public void setEntregas1(String entregas1) {
        this.entregas1 = entregas1; 
    }
    public String getEntregas1() {
    	return this.entregas1;
    }
    
    public void setEntregas2(String entregas2) {
        this.entregas2 = entregas2; 
    }
	public String getEntregas2() {
	    return this.entregas2;
	}
	
	public void setEntregas3(String entregas3) {
        this.entregas3 = entregas3; 
    }
	public String getEntregas3() {
		return this.entregas3;
	}
    
	public void setEntregas4(String entregas4) {
        this.entregas4 = entregas4; 
    }
	public String getEntregas4() {
	    return this.entregas4;
	}
	
	public void setEntregas5(String entregas5) {
        this.entregas5 = entregas5; 
    }
	public String getEntregas5() {
		return this.entregas5;
	}
    
    //Metas
    public void setMetas1(String metas1) {
        this.metas1 = metas1; 
    }
    public String getMetas1() {
    	return this.metas1;
    }
    
    public void setMetas2(String metas2) {
        this.metas2 = metas2; 
    }
	public String getMetas2() {
	    return this.metas2;
	}
	
	public void setMetas3(String metas3) {
        this.metas3 = metas3; 
    }
	public String getMetas3() {
		return this.metas3;
	}
    
	public void setMetas4(String metas4) {
        this.metas4 = metas4; 
    }
	public String getMetas4() {
	    return this.metas4;
	}
	
	public void setMetas5(String metas5) {
        this.metas5 = metas5; 
    }
	public String getMetas5() {
		return this.metas5;
	}
    
    //Habilidades Pessoais
    public void setHabilidadesPessoais1(String habilidadesPessoais1) {
        this.habilidadesPessoais1 = habilidadesPessoais1; 
    }
    public String getHabilidadesPessoais1() {
    	return this.habilidadesPessoais1;
    }
    
    public void setHabilidadesPessoais2(String habilidadesPessoais2) {
        this.habilidadesPessoais2 = habilidadesPessoais2; 
    }
	public String getHabilidadesPessoais2() {
	    return this.habilidadesPessoais2;
	}
	
	public void setHabilidadesPessoais3(String habilidadesPessoais3) {
        this.habilidadesPessoais3 = habilidadesPessoais3; 
    }
	public String getHabilidadesPessoais3() {
		return this.habilidadesPessoais3;
	}
    
	public void setHabilidadesPessoais4(String habilidadesPessoais4) {
        this.habilidadesPessoais4 = habilidadesPessoais4; 
    }
	public String getHabilidadesPessoais4() {
	    return this.habilidadesPessoais4;
	}
	
	public void setHabilidadesPessoais5(String habilidadesPessoais5) {
        this.habilidadesPessoais5 = habilidadesPessoais5; 
    }
	public String getHabilidadesPessoais5() {
		return this.habilidadesPessoais5;
	}
    
    //Habilidades Sociais
    public void setHabilidadesSociais1(String habilidadesSociais1) {
        this.habilidadesSociais1 = habilidadesSociais1; 
    }
    public String getHabilidadesSociais1() {
    	return this.habilidadesSociais1;
    }
    
    public void setHabilidadesSociais2(String habilidadesSociais2) {
        this.habilidadesSociais2 = habilidadesSociais2; 
    }
	public String getHabilidadesSociais2() {
	    return this.habilidadesSociais2;
	}
	
	public void setHabilidadesSociais3(String habilidadesSociais3) {
        this.habilidadesSociais3 = habilidadesSociais3; 
    }
	public String getHabilidadesSociais3() {
		return this.habilidadesSociais3;
	}
    
	public void setHabilidadesSociais4(String habilidadesSociais4) {
        this.habilidadesSociais4 = habilidadesSociais4; 
    }
	public String getHabilidadesSociais4() {
	    return this.habilidadesSociais4;
	}
	
	public void setHabilidadesSociais5(String habilidadesSociais5) {
        this.habilidadesSociais5 = habilidadesSociais5; 
    }
	public String getHabilidadesSociais5() {
		return this.habilidadesSociais5;
	}
    
    //Proatividade
    public void setProatividade1(String proatividade1) {
        this.proatividade1 = proatividade1; 
    }
    public String getProatividade1() {
    	return this.proatividade1;
    }
    
    public void setProatividade2(String proatividade2) {
        this.proatividade2 = proatividade2; 
    }
	public String getProatividade2() {
	    return this.proatividade2;
	}
	
	public void setProatividade3(String proatividade3) {
        this.proatividade3 = proatividade3; 
    }
	public String getProatividade3() {
		return this.proatividade3;
	}
    
	public void setProatividade4(String proatividade4) {
        this.proatividade4 = proatividade4; 
    }
	public String getProatividade4() {
	    return this.proatividade4;
	}
	
	public void setProatividade5(String proatividade5) {
        this.proatividade5 = proatividade5; 
    }
	public String getProatividade5() {
		return this.proatividade5;
	}
	
    //Adequacao a regras
    public void setAdequacaoAsRegras1(String adequacaoAsRegras1) {
        this.adequacaoAsRegras1 = adequacaoAsRegras1; 
    }
    public String getAdequacaoAsRegras1() {
    	return this.adequacaoAsRegras1;
    }
    
    public void setAdequacaoAsRegras2(String adequacaoAsRegras2) {
        this.adequacaoAsRegras2 = adequacaoAsRegras2; 
    }
	public String getAdequacaoAsRegras2() {
	    return this.adequacaoAsRegras2;
	}
	
	public void setAdequacaoAsRegras3(String adequacaoAsRegras3) {
        this.adequacaoAsRegras3 = adequacaoAsRegras3; 
    }
	public String getAdequacaoAsRegras3() {
		return this.adequacaoAsRegras3;
	}
    
	public void setAdequacaoAsRegras4(String adequacaoAsRegras4) {
        this.adequacaoAsRegras4 = adequacaoAsRegras4; 
    }
	public String getAdequacaoAsRegras4() {
	    return this.adequacaoAsRegras4;
	}
	
	public void setAdequacaoAsRegras5(String adequacaoAsRegras5) {
        this.adequacaoAsRegras5 = adequacaoAsRegras5; 
    }
	public String getAdequacaoAsRegras5() {
		return this.adequacaoAsRegras5;
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
