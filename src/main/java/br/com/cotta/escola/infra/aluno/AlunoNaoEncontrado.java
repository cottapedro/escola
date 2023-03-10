package br.com.cotta.escola.infra.aluno;

import br.com.cotta.escola.domain.aluno.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno não encontrado com o CPF: " + cpf.getNumero());
    }
}
