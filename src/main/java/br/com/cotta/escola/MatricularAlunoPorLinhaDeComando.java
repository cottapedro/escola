package br.com.cotta.escola;

import br.com.cotta.escola.application.aluno.matricula.MatricularAluno;
import br.com.cotta.escola.application.aluno.matricula.MatricularAlunoDTO;
import br.com.cotta.escola.infra.aluno.AlunoRepositoryMemory;

public class MatricularAlunoPorLinhaDeComando {
    public static void main(String[] args) {
        String nome = "Zezinho";
        String cpf = "112.222.526-08";
        String email = "zezinho@gmail.com";

        MatricularAluno matricularAluno = new MatricularAluno(new AlunoRepositoryMemory());
        matricularAluno.execute(new MatricularAlunoDTO(nome,cpf,email));
    }
}