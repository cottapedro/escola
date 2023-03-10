package br.com.cotta.escola;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CPFTest {

    @Test
    void naoDeveriaAceitarCPFInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("asd"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("110123123"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("110.123.123-000"));
    }

    @Test
    void deveriaAceitarCPFValido(){
        String cpfValido = "110.626.222-01";
        Assertions.assertEquals(cpfValido, new CPF(cpfValido).getNumero());
    }
}
