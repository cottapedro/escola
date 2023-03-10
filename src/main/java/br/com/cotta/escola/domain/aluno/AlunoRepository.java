package br.com.cotta.escola.domain.aluno;

import java.util.List;

public interface AlunoRepository {
    void matricular(Aluno aluno);
    Aluno findByCPF(CPF cpf);
    List<Aluno> listAlunosMatriculados();
}
