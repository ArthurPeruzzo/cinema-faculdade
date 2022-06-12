package dao;

import model.Cidade;
import model.Sala;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalaDao extends AbstractDao<Sala> {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public SalaDao() {
        super.getConexao();
    }

    @Override
    public Sala insert(Sala sala) {
        Sala salaSalva = new Sala();
        try {
            if (sala != null) {
                preparedStatement = super.connection.prepareStatement("INSERT INTO sala (codigo, cidadeid) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, sala.getCodigo());
                preparedStatement.setLong(2, sala.getCidade().getId());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {

                    salaSalva.setId(resultSet.getLong("id"));
                    salaSalva.setCodigo(resultSet.getString("codigo"));
                    salaSalva.setCidade(new Cidade(resultSet.getLong("cidadeid")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salaSalva;
    }

    @Override
    public List<Sala> findAll() {
        List<Sala> salas = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select * from sala f");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sala sala = new Sala();
                sala.setId(resultSet.getLong("id"));
                sala.setCodigo(resultSet.getString("codigo"));
                sala.setCidade(new Cidade(resultSet.getLong("cidadeid")));
                salas.add(sala);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return salas;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Sala findById(int id) {
        return null;
    }

    @Override
    public boolean update(Sala object) {
        return false;
    }
}
