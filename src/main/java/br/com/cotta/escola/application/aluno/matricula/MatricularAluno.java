package br.com.cotta.escola.application.aluno.matricula;

import br.com.cotta.escola.domain.aluno.Aluno;
import br.com.cotta.escola.domain.aluno.AlunoRepository;

public class MatricularAluno {
    private final AlunoRepository repository;

    public MatricularAluno(AlunoRepository repository){
        this.repository = repository;
    }

    public void execute(MatricularAlunoDTO dados){
        Aluno aluno = dados.criarAluno();
        repository.matricular(aluno);
    }
}
