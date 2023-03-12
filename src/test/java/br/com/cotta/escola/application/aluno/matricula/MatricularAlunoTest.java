package br.com.cotta.escola.application.aluno.matricula;

import br.com.cotta.escola.domain.aluno.Aluno;
import br.com.cotta.escola.domain.aluno.AlunoRepository;
import br.com.cotta.escola.domain.aluno.CPF;
import br.com.cotta.escola.infra.aluno.AlunoRepositoryMemory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido(){
        AlunoRepositoryMemory repository = new AlunoRepositoryMemory();
        MatricularAluno useCase = new MatricularAluno(repository);
        String nome = "Nome Aluno";
        String cpfAluno = "234.432.222-02";
        String emailAluno = "email@aluno.com";
        MatricularAlunoDTO dados = new MatricularAlunoDTO(nome, cpfAluno, emailAluno);
        useCase.execute(dados);
        Aluno encontrado = repository.findByCPF(new CPF(cpfAluno));
        Assertions.assertEquals(nome, encontrado.getNome());
        Assertions.assertEquals(cpfAluno,encontrado.getCpf());
        Assertions.assertEquals(emailAluno,encontrado.getEmail());
    }
}
