package br.com.cotta.escola.infra.aluno;

import br.com.cotta.escola.domain.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            Aluno encontrado = new Aluno(cpf, nome, email);

            Long id = result.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            result = ps.executeQuery();
            while (result.next()) {
                String numero = result.getString("numero");
                String ddd = result.getString("ddd");
                encontrado.adicionarTelefone(ddd, numero);
            }

            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listAlunosMatriculados() {
        try {
            String sql = "SELECT id, cpf, nome, email FROM ALUNO";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String nome = rs.getString("nome");
                Email email = new Email(rs.getString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);

                Long id = rs.getLong("id");
                sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                PreparedStatement psTelefone = connection.prepareStatement(sql);
                psTelefone.setLong(1, id);
                ResultSet rsTelefone = psTelefone.executeQuery();
                while (rsTelefone.next()) {
                    String numero = rsTelefone.getString("numero");
                    String ddd = rsTelefone.getString("ddd");
                    aluno.adicionarTelefone(ddd, numero);
                }

                alunos.add(aluno);
            }

            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
