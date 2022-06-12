package dao;

import model.Filme;
import model.Horario;
import model.Sala;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HorarioDao extends AbstractDao<Horario> {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    public HorarioDao() {
        super.getConexao();
    }

    @Override
    public Horario insert(Horario horario) {
        Horario horarioSalvo = new Horario();
        try {
            if (horario != null) {
                preparedStatement = super.connection.prepareStatement("INSERT INTO horario (salaid, filmeid, datahora) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setLong(1, horario.getSala().getId());
                preparedStatement.setLong(2, horario.getFilme().getId());
                preparedStatement.setTimestamp(3, Timestamp.valueOf(dateTimeFormatter.format(horario.getDataHora())));
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();

                while (resultSet.next()) {
                    horarioSalvo.setSala(new Sala(resultSet.getLong("salaid")));
                    horarioSalvo.setFilme(new Filme(resultSet.getLong("filmeid")));
                    horarioSalvo.setDataHora(resultSet.getTimestamp("datahora").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horarioSalvo;
    }

    @Override
    public List<Horario> findAll() {
        List<Horario> horarios = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select * from horario f");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Horario horario = new Horario();
                horario.setSala(new Sala(resultSet.getLong("salaid")));
                horario.setFilme(new Filme(resultSet.getLong("filmeid")));
                horario.setDataHora(resultSet.getTimestamp("datahora").toLocalDateTime());
                horarios.add(horario);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return horarios;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Horario findById(int id) {
        return null;
    }

    @Override
    public boolean update(Horario object) {
        return false;
    }
}
