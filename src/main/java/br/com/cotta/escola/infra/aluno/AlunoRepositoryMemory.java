package br.com.cotta.escola.infra.aluno;

import br.com.cotta.escola.domain.aluno.Aluno;
import br.com.cotta.escola.domain.aluno.AlunoNaoEncontrado;
import br.com.cotta.escola.domain.aluno.AlunoRepository;
import br.com.cotta.escola.domain.aluno.CPF;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryMemory implements AlunoRepository {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno findByCPF(CPF cpf) {
        return this.matriculados.stream()
                .filter(a -> a.getCpf().equals(cpf.getNumero()))
                .findFirst().orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listAlunosMatriculados() {
        return this.matriculados;
    }
}
