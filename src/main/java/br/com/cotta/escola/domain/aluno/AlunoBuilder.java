package br.com.cotta.escola.domain.aluno;

public class AlunoBuilder {

    private Aluno aluno;


    public AlunoBuilder withCpfNomeEmail(String nome, String cpf, String email){
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public AlunoBuilder withTelefone(String ddd, String telefone){
        this.aluno.adicionarTelefone(ddd,telefone);
        return this;
    }

    public Aluno build(){
        return this.aluno;
    }
}
