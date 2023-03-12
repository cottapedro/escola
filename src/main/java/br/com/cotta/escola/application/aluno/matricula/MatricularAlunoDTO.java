package br.com.cotta.escola.application.aluno.matricula;

import br.com.cotta.escola.domain.aluno.Aluno;
import br.com.cotta.escola.domain.aluno.CPF;
import br.com.cotta.escola.domain.aluno.Email;

public class MatricularAlunoDTO {

    private String nomeAluno;


    private String cpfAluno;
    private String emailAluno;

    public MatricularAlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }
    public Aluno criarAluno() {
        return new Aluno(new CPF(cpfAluno),nomeAluno,new Email(emailAluno));
    }
}
