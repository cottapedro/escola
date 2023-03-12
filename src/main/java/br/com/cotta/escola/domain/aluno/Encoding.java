package br.com.cotta.escola.domain.aluno;

public interface Encoding {

    String encondig(String password);

    boolean validEncondig(String passwordEncodig, String password);
}
