package br.com.cotta.escola;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void naoDeveriaCriarEmailComEnderecoInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
    }

    @Test
    void deveriaCriarEmailValido(){
        String emailValido = "email@valido.com";
        Assertions.assertEquals(emailValido, new Email(emailValido).getEndereco());
    }
}
