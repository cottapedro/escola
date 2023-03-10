package br.com.cotta.escola;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones  = new ArrayList<Telefone>();

    public void adicionarTelefone(String ddd, String numero){
        telefones.add(new Telefone(ddd,numero));
    }

}
