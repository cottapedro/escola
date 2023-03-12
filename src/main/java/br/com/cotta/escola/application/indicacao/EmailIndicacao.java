package br.com.cotta.escola.application.indicacao;

import br.com.cotta.escola.domain.aluno.Aluno;

public interface EmailIndicacao {

    void sendTo(Aluno indicado);
}
