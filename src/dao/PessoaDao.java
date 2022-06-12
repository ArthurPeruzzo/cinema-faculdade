package dao;

import model.Pessoa;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao extends AbstractDao<Pessoa> {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    public PessoaDao() {
        super.getConexao();
    }

    @Override
    public boolean insert(Pessoa pessoa) {
        try {
            if (pessoa != null) {
                preparedStatement = super.connection.prepareStatement("INSERT INTO pessoa (nome, email, senha, cpf) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, pessoa.getNome());
                preparedStatement.setString(2, pessoa.getEmail());
                preparedStatement.setString(3, pessoa.getSenha());
                preparedStatement.setString(4, pessoa.getCpf());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    Pessoa pessoaSalva = new Pessoa();

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select * from pessoa f");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pessoa pessoa = new Pessoa();
                pessoas.add(pessoa);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Pessoa findById(int id) {
        return null;
    }

    @Override
    public boolean update(Pessoa object) {
        return false;
    }
}
