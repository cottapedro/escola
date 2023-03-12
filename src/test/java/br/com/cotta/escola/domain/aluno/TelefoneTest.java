package br.com.cotta.escola.domain.aluno;

import br.com.cotta.escola.domain.aluno.Telefone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TelefoneTest {

    @Test
    void naoDeveriaAceitarTelefoneComDDDInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("","123456789"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone(null,"123456789"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("aa","123456789"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("321","123456789"));
    }

    @Test
    void naoDeveriaAceitarTelefoneComNumeroInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("31",""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("31",null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("31","1234567890"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Telefone("31","1234567"));
    }

    @Test
    void deveriaAceitarTelefoneValido(){
        String ddd ="31";
        String numero = "12345678";
        Telefone telefone = new Telefone(ddd,numero);
        Assertions.assertEquals(ddd,telefone.getDdd());
        Assertions.assertEquals(numero, telefone.getNumero());
    }
}
