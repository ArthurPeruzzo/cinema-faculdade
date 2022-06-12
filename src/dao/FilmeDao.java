package dao;

import model.Filme;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FilmeDao extends AbstractDao<Filme> {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    public FilmeDao() {
        super.getConexao();
    }

    @Override
    public boolean insert(Filme filme) {
        try {
            if (filme != null) {
                preparedStatement = super.connection.prepareStatement("INSERT INTO filme (nome, estreia, preestreia) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, filme.getNome());
                preparedStatement.setTimestamp(2, Timestamp.valueOf(dateTimeFormatter.format(filme.getDataHoraEstreia())));
                preparedStatement.setTimestamp(3, Timestamp.valueOf(dateTimeFormatter.format(filme.getDataHoraPreEstreia())));
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    Filme filmeSalvo = new Filme();
                    filmeSalvo.setId(resultSet.getLong("id"));
                    filmeSalvo.setNome(resultSet.getString("nome"));
                    filmeSalvo.setDataHoraEstreia(resultSet.getTimestamp("estreia").toLocalDateTime());
                    filmeSalvo.setDataHoraPreEstreia(resultSet.getTimestamp("preestreia").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Filme> findAll() {
        List<Filme> filmes = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select * from filme f");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Filme filme = new Filme();
                filme.setId(resultSet.getLong("id"));
                filme.setNome(resultSet.getString("nome"));
                filme.setDataHoraEstreia(resultSet.getTimestamp("estreia").toLocalDateTime());
                filme.setDataHoraPreEstreia(resultSet.getTimestamp("preestreia").toLocalDateTime());
                filmes.add(filme);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return filmes;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Filme findById(int id) {
        return null;
    }

    @Override
    public boolean update(Filme object) {
        return false;
    }
}
