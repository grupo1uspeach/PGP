var nome = {
    value: "Antonio Orácio",

    get nome(){
        return this.nome;
    },
    
    set nome(nome){
        this.nome.value = nome;
    }
};

function enviarDadosPessoais(cod,nome){
    this.nome = nome;
}

alert("OI");
