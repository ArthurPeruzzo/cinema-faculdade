package dao;

import model.Cidade;
import model.Estado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CidadeDao extends AbstractDao<Cidade> {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CidadeDao() {
        super.getConexao();
    }

    @Override
    public Cidade insert(Cidade cidade) {
        Cidade cidadeSalva = new Cidade();
        try {
            if (cidade != null) {
                preparedStatement = super.connection.prepareStatement("INSERT INTO cidade (nome, estadoid) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, cidade.getNome());
                preparedStatement.setLong(2, cidade.getEstado().getId());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    cidadeSalva.setId(resultSet.getLong("id"));
                    cidadeSalva.setNome(resultSet.getString("nome"));
                    cidadeSalva.setEstado(new Estado(resultSet.getLong("estadoid")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cidadeSalva;
    }

    @Override
    public List<Cidade> findAll() {
        List<Cidade> cidades = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select * from cidade f");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(resultSet.getLong("id"));
                cidade.setNome(resultSet.getString("nome"));
                cidade.setEstado(new Estado(resultSet.getLong("estadoid")));
                cidades.add(cidade);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cidades;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Cidade findById(int id) {
        return null;
    }

    @Override
    public boolean update(Cidade object) {
        return false;
    }
}
