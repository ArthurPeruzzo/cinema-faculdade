package dao;

import conexao.Conexao;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractDao<T> {

    protected Connection connection;

    public abstract boolean insert(T object);

    public abstract List<T> findAll();

    public abstract boolean delete(int id);

    public abstract T findById(int id);

    public abstract boolean update(T object);

    public Connection getConexao()  {
        Conexao conexao = Conexao.getConexao();
        connection = conexao.getConnection();
        return connection;
    }

}
