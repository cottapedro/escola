package br.com.cotta.escola.infra.aluno;

import br.com.cotta.escola.domain.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlunoRepostoryJDBC implements AlunoRepository {

    private final Connection connection;

    public AlunoRepostoryJDBC(Connection connection){
        this.connection = connection;

    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO ALUNO VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONE VALUES (?,?)";
            for(Telefone telefone : aluno.getTelefones()){
                ps.setString(1, aluno.getCpf());
                ps.setString(2, aluno.getNome());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno findByCPF(CPF cpf) {
        try {
            String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());
            ResultSet result = ps.executeQuery();
            if (!result.next()) throw new AlunoNaoEncontrado(cpf);
            Email email = new Email(result.getString("email"));
            String nome = result.getString("nome");
            return new Aluno(cpf, nome, email);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listAlunosMatriculados() {
        return null;
    }

}
