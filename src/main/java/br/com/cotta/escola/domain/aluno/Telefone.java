package br.com.cotta.escola.domain.aluno;

public class Telefone {
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        if(ddd == null|| numero == null) throw new IllegalArgumentException("Numero e DDD são obrigatorios");
        if(!ddd.matches("\\d{2}")) throw new IllegalArgumentException("DDD Invalido");
        if(!numero.matches("\\d{8}|\\d{9}")) throw new IllegalArgumentException("Numero invalido");
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
