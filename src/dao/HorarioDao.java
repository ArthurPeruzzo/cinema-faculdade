package dao;

import model.Filme;
import model.HorarioSessao;
import model.Sala;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HorarioDao extends AbstractDao<HorarioSessao> {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    public HorarioDao() {
        super.getConexao();
    }

    @Override
    public HorarioSessao insert(HorarioSessao horarioSessao) {
        HorarioSessao horarioSessaoSalvo = new HorarioSessao();
        try {
            if (horarioSessao != null) {
                preparedStatement = super.connection.prepareStatement("INSERT INTO horario (salaid, filmeid, datahora) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setLong(1, horarioSessao.getSala().getId());
                preparedStatement.setLong(2, horarioSessao.getFilme().getId());
                preparedStatement.setTimestamp(3, Timestamp.valueOf(dateTimeFormatter.format(horarioSessao.getDataHora())));
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();

                while (resultSet.next()) {
                    horarioSessaoSalvo.setSala(new Sala(resultSet.getLong("salaid")));
                    horarioSessaoSalvo.setFilme(new Filme(resultSet.getLong("filmeid")));
                    horarioSessaoSalvo.setDataHora(resultSet.getTimestamp("datahora").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horarioSessaoSalvo;
    }

    @Override
    public List<HorarioSessao> findAll() {
        List<HorarioSessao> horarioSessaos = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select * from horario f");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HorarioSessao horarioSessao = new HorarioSessao();
                horarioSessao.setSala(new Sala(resultSet.getLong("salaid")));
                horarioSessao.setFilme(new Filme(resultSet.getLong("filmeid")));
                horarioSessao.setDataHora(resultSet.getTimestamp("datahora").toLocalDateTime());
                horarioSessaos.add(horarioSessao);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return horarioSessaos;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public HorarioSessao findById(int id) {
        return null;
    }

    @Override
    public boolean update(HorarioSessao object) {
        return false;
    }
}
