package dao;

import model.Estado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadoDao extends AbstractDao<Estado> {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public EstadoDao() {
        super.getConexao();
    }

    @Override
    public Estado insert(Estado estado) {
        Estado estadoSalvo = new Estado();
        try {
            if (estado != null) {
                preparedStatement = super.connection.prepareStatement("INSERT INTO estado (uf) values (?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, estado.getUf());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    estadoSalvo.setId(resultSet.getLong("id"));
                    estadoSalvo.setUf(resultSet.getString("uf"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estadoSalvo;
    }

    @Override
    public List<Estado> findAll() {
        List<Estado> estados = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select * from estado f");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Estado estado = new Estado();
                estado.setId(resultSet.getLong("id"));
                estado.setUf(resultSet.getString("uf"));
                estados.add(estado);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return estados;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Estado findById(int id) {
        return null;
    }

    @Override
    public boolean update(Estado object) {
        return false;
    }
}
